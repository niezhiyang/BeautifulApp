package cn.nzy.beautifulapp;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;

import com.bilibili.magicasakura.utils.ThemeUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.Utils;
import com.facebook.stetho.Stetho;
import com.google.gson.Gson;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;

import java.util.List;

import cn.nzy.beautifulapp.Bean.CategoryBean;
import cn.nzy.beautifulapp.Bean.DaoMaster;
import cn.nzy.beautifulapp.Bean.DaoSession;
import cn.nzy.beautifulapp.Bean.livingBean.CategoriesBean;
import cn.nzy.beautifulapp.Bean.livingBean.CategoryBeanString;
import cn.nzy.beautifulapp.constant.SpConstant;
import cn.nzy.beautifulapp.util.ThemeHelper;


public class MyApplication extends Application implements ThemeUtils.switchColor{
    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    public static MyApplication instances;
    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化第三方需要的初始化的
        instances= this;
        initOther();
    }
    public static MyApplication getInstances() {
        return instances;
    }
    private void initOther() {
        // 初始化LeakCanary
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
        //初始化Stetho
        Stetho.initializeWithDefaults(this);
        Utils.init(this);
        Logger.addLogAdapter(new AndroidLogAdapter());
        // 多主题
        ThemeUtils.setSwitchColor(this);

        // 设置greenDao
        setGreenDao();
        // 把 默认的分类写入数据库  如果写过 就不需要再写了

        if (!SPUtils.getInstance().getBoolean(SpConstant.IS_DB_COPY)) {
            putCateGoryToDb();
        }
    }



    @Override
    public int replaceColorById(Context context, @ColorRes int colorId) {
        if (ThemeHelper.isDefaultTheme(context)) {
            return context.getResources().getColor(colorId);
        }
        String theme = getTheme(context);
        if (theme != null) {
            colorId = getThemeColorId(context, colorId, theme);
        }
        return context.getResources().getColor(colorId);
    }

    @Override
    public int replaceColor(Context context, @ColorInt int originColor) {
        if (ThemeHelper.isDefaultTheme(context)) {
            return originColor;
        }
        String theme = getTheme(context);
        int colorId = -1;

        if (theme != null) {
            colorId = getThemeColor(context, originColor, theme);
        }
        return colorId != -1 ? getResources().getColor(colorId) : originColor;
    }

    private String getTheme(Context context) {
        if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_STORM) {
            return "blue";
        } else if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_HOPE) {
            return "purple";
        } else if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_WOOD) {
            return "green";
        } else if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_LIGHT) {
            return "green_light";
        } else if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_THUNDER) {
            return "yellow";
        } else if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_SAND) {
            return "orange";
        } else if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_FIREY) {
            return "red";
        }
        return null;
    }

    private
    @ColorRes
    int getThemeColorId(Context context, int colorId, String theme) {
        switch (colorId) {
            case R.color.theme_color_primary:
                return context.getResources().getIdentifier(theme, "color", getPackageName());
            case R.color.theme_color_primary_dark:
                return context.getResources().getIdentifier(theme + "_dark", "color", getPackageName());
            case R.color.theme_color_primary_trans:
                return context.getResources().getIdentifier(theme + "_trans", "color", getPackageName());
            case R.color.theme_color_primary_text:
                return context.getResources().getIdentifier(theme + "_text", "color", getPackageName());
            case R.color.theme_color_primary_font_title:
                return context.getResources().getIdentifier(theme + "_font_title", "color", getPackageName());
            case R.color.theme_color_primary_card_bg:
                return context.getResources().getIdentifier(theme + "_card_bg", "color", getPackageName());
            case R.color.theme_color_primary_window_bg:
                return context.getResources().getIdentifier(theme + "_window_bg", "color", getPackageName());
            case R.color.theme_color_primary_tab_bg:
                return context.getResources().getIdentifier(theme + "_tab_bg", "color", getPackageName());
        }
        return colorId;
    }

    private
    @ColorRes
    int getThemeColor(Context context, int color, String theme) {
        switch (color) {
            case 0xfffb7299:
                return context.getResources().getIdentifier(theme, "color", getPackageName());
            case 0xffb85671:
                return context.getResources().getIdentifier(theme + "_dark", "color", getPackageName());
            case 0x99f0486c:
                return context.getResources().getIdentifier(theme + "_trans", "color", getPackageName());
        }
        return -1;
    }
    /**
     * 设置greenDao
     */
    private void setGreenDao() {
        mHelper = new DaoMaster.DevOpenHelper(this, "category-db", null);
        db = mHelper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }
    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }
    private void putCateGoryToDb() {
        Gson gson = new Gson();
        CategoriesBean categoriesBean =   gson.fromJson(CategoryBeanString.TAB_STRING, CategoriesBean.class);
        List<CategoriesBean.DataBean> list = categoriesBean.getData();
        for (int i = 0; i < list.size(); i++) {
            CategoriesBean.DataBean dataBean = list.get(i);
            CategoryBean categoryBean = changCategoryBean(dataBean);
            mDaoSession.getCategoryBeanDao().insert(categoryBean);
        }
        SPUtils.getInstance().put(SpConstant.IS_DB_COPY,true);
    }
    private CategoryBean changCategoryBean(CategoriesBean.DataBean dataBean) {
        CategoryBean categoryBean = new CategoryBean();
        categoryBean.setName(dataBean.getName());
        categoryBean.setSlug(dataBean.getSlug());
        categoryBean.setId(dataBean.getId());
        categoryBean.setSort(dataBean.getSort());
        categoryBean.setScreen(dataBean.getScreen());
        categoryBean.setIcon_gray(dataBean.getIcon_gray());
        categoryBean.setIcon_image(dataBean.getIcon_image());
        categoryBean.setIcon_red(dataBean.getIcon_red());
        categoryBean.setType(dataBean.getType());

        return categoryBean;
    }
}
