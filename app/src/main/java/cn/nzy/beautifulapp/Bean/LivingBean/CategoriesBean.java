package cn.nzy.beautifulapp.Bean.LivingBean;

import java.util.List;

/**
 * on 2018/5/21. created by nzy
 */

public class CategoriesBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * icon_gray : http://uimg.quanmin.tv/1480649995/48e55.png
         * icon_image : http://uimg.quanmin.tv/1480650006/e9cbb.png
         * icon_red : http://uimg.quanmin.tv/1480650000/64cf4.png
         * id : 4
         * is_default : 1
         * name : 全民星秀
         * screen : 0
         * slug : beauty
         * sort : 990
         * type : 2
         */

        private String icon_gray;
        private String icon_image;
        private String icon_red;
        private int id;
        private int is_default;
        private String name;
        private int screen;
        private String slug;
        private int sort;
        private int type;

        public String getIcon_gray() {
            return icon_gray;
        }

        public void setIcon_gray(String icon_gray) {
            this.icon_gray = icon_gray;
        }

        public String getIcon_image() {
            return icon_image;
        }

        public void setIcon_image(String icon_image) {
            this.icon_image = icon_image;
        }

        public String getIcon_red() {
            return icon_red;
        }

        public void setIcon_red(String icon_red) {
            this.icon_red = icon_red;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getIs_default() {
            return is_default;
        }

        public void setIs_default(int is_default) {
            this.is_default = is_default;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getScreen() {
            return screen;
        }

        public void setScreen(int screen) {
            this.screen = screen;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
