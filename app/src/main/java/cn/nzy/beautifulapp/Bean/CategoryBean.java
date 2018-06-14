package cn.nzy.beautifulapp.Bean;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

@Entity
public class CategoryBean implements Parcelable {

    @Property(nameInDb = "icon_gray")
    private String icon_gray;

    @Property(nameInDb = "icon_image")
    private String icon_image;
    @Property(nameInDb = "icon_red")
    private String icon_red;
    @Id
    private Long id;
    @Property(nameInDb = "is_default")
    private int is_default;
    @Property(nameInDb = "name")
    private String name;
    @Property(nameInDb = "screen")
    private int screen;
    @Property(nameInDb = "slug")
    private String slug;
    @Property(nameInDb = "sort")
    private int sort;
    @Property(nameInDb = "type")
    private int type;
    @Generated(hash = 517268046)
    public CategoryBean(String icon_gray, String icon_image, String icon_red,
            Long id, int is_default, String name, int screen, String slug, int sort,
            int type) {
        this.icon_gray = icon_gray;
        this.icon_image = icon_image;
        this.icon_red = icon_red;
        this.id = id;
        this.is_default = is_default;
        this.name = name;
        this.screen = screen;
        this.slug = slug;
        this.sort = sort;
        this.type = type;
    }
    @Generated(hash = 1870435730)
    public CategoryBean() {
    }
    public String getIcon_gray() {
        return this.icon_gray;
    }
    public void setIcon_gray(String icon_gray) {
        this.icon_gray = icon_gray;
    }
    public String getIcon_image() {
        return this.icon_image;
    }
    public void setIcon_image(String icon_image) {
        this.icon_image = icon_image;
    }
    public String getIcon_red() {
        return this.icon_red;
    }
    public void setIcon_red(String icon_red) {
        this.icon_red = icon_red;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getIs_default() {
        return this.is_default;
    }
    public void setIs_default(int is_default) {
        this.is_default = is_default;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getScreen() {
        return this.screen;
    }
    public void setScreen(int screen) {
        this.screen = screen;
    }
    public String getSlug() {
        return this.slug;
    }
    public void setSlug(String slug) {
        this.slug = slug;
    }
    public int getSort() {
        return this.sort;
    }
    public void setSort(int sort) {
        this.sort = sort;
    }
    public int getType() {
        return this.type;
    }
    public void setType(int type) {
        this.type = type;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.icon_gray);
        dest.writeString(this.icon_image);
        dest.writeString(this.icon_red);
        dest.writeValue(this.id);
        dest.writeInt(this.is_default);
        dest.writeString(this.name);
        dest.writeInt(this.screen);
        dest.writeString(this.slug);
        dest.writeInt(this.sort);
        dest.writeInt(this.type);
    }

    protected CategoryBean(Parcel in) {
        this.icon_gray = in.readString();
        this.icon_image = in.readString();
        this.icon_red = in.readString();
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.is_default = in.readInt();
        this.name = in.readString();
        this.screen = in.readInt();
        this.slug = in.readString();
        this.sort = in.readInt();
        this.type = in.readInt();
    }

    public static final Parcelable.Creator<CategoryBean> CREATOR = new Parcelable.Creator<CategoryBean>() {
        @Override
        public CategoryBean createFromParcel(Parcel source) {
            return new CategoryBean(source);
        }

        @Override
        public CategoryBean[] newArray(int size) {
            return new CategoryBean[size];
        }
    };

    @Override
    public String toString() {
        return "CategoryBean{" +
                "icon_gray='" + icon_gray + '\'' +
                ", icon_image='" + icon_image + '\'' +
                ", icon_red='" + icon_red + '\'' +
                ", id=" + id +
                ", is_default=" + is_default +
                ", name='" + name + '\'' +
                ", screen=" + screen +
                ", slug='" + slug + '\'' +
                ", sort=" + sort +
                ", type=" + type +
                '}';
    }
}