package cn.nzy.beautifulapp.Bean;

import java.io.Serializable;
import java.util.List;


/**
 * on 2017/12/12.
 * 类的描述:
 */

public class TextBean    implements Serializable {

    /**
     * count : 30
     * err : 0
     * items : [{"allow_comment":true,"comments_count":19,"content":"\u2026\u2026跟我妈逛街，路过一新开的宠物店，，站在门口发传 单的女孩拦住我们问我妈\u201c阿姨，你家有狗狗吗，\u201d 我妈看看我说\u201c有，喂了两只呢\u201d 那个女孩拿出一包狗粮递给我妈\u201c阿姨，我们店新开张，，这是免费送您的，您回去喂狗试试，狗狗爱吃了您再来。。\u201d 我妈接过去，撕开袋子递给我说\u201c你尝尝，好吃多买点儿，，\u201d 我\u2026\u2026","created_at":1513214849,"format":"word","id":119839037,"image":"","published_at":1513218003,"share_count":3,"state":"publish","tag":"","type":"fresh","user":{"age":19,"astrology":"处女座","avatar_updated_at":1512538248,"created_at":1436268691,"gender":"F","icon":"2017120613304834.JPEG","id":29314260,"last_device":"","last_visited_at":0,"login":"贝格格*","medium":"//pic.qiushibaike.com/system/avtnew/2931/29314260/medium/2017120613304834.JPEG","role":"n","state":"active","thumb":"//pic.qiushibaike.com/system/avtnew/2931/29314260/thumb/2017120613304834.JPEG","uid":29314260,"updated_at":1513160440},"votes":{"down":-1,"up":173}}]
     */

    private int count;
    private int err;
    private List<ItemsBean> items;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getErr() {
        return err;
    }

    public void setErr(int err) {
        this.err = err;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean implements Serializable{
        /**
         * allow_comment : true
         * comments_count : 19
         * content : ……跟我妈逛街，路过一新开的宠物店，，站在门口发传 单的女孩拦住我们问我妈“阿姨，你家有狗狗吗，” 我妈看看我说“有，喂了两只呢” 那个女孩拿出一包狗粮递给我妈“阿姨，我们店新开张，，这是免费送您的，您回去喂狗试试，狗狗爱吃了您再来。。” 我妈接过去，撕开袋子递给我说“你尝尝，好吃多买点儿，，” 我……
         * created_at : 1513214849
         * format : word
         * id : 119839037
         * image :
         * published_at : 1513218003
         * share_count : 3
         * state : publish
         * tag :
         * type : fresh
         * user : {"age":19,"astrology":"处女座","avatar_updated_at":1512538248,"created_at":1436268691,"gender":"F","icon":"2017120613304834.JPEG","id":29314260,"last_device":"","last_visited_at":0,"login":"贝格格*","medium":"//pic.qiushibaike.com/system/avtnew/2931/29314260/medium/2017120613304834.JPEG","role":"n","state":"active","thumb":"//pic.qiushibaike.com/system/avtnew/2931/29314260/thumb/2017120613304834.JPEG","uid":29314260,"updated_at":1513160440}
         * votes : {"down":-1,"up":173}
         */

        private boolean allow_comment;
        private int comments_count;
        private String content;
        private int created_at;
        private String format;
        private int id;
        private String image;
        private int published_at;
        private int share_count;
        private String state;
        private String tag;
        private String type;
        private UserBean user;
        private VotesBean votes;

        public boolean isAllow_comment() {
            return allow_comment;
        }

        public void setAllow_comment(boolean allow_comment) {
            this.allow_comment = allow_comment;
        }

        public int getComments_count() {
            return comments_count;
        }

        public void setComments_count(int comments_count) {
            this.comments_count = comments_count;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getCreated_at() {
            return created_at;
        }

        public void setCreated_at(int created_at) {
            this.created_at = created_at;
        }

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getPublished_at() {
            return published_at;
        }

        public void setPublished_at(int published_at) {
            this.published_at = published_at;
        }

        public int getShare_count() {
            return share_count;
        }

        public void setShare_count(int share_count) {
            this.share_count = share_count;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public VotesBean getVotes() {
            return votes;
        }

        public void setVotes(VotesBean votes) {
            this.votes = votes;
        }

        public static class UserBean implements Serializable{
            /**
             * age : 19
             * astrology : 处女座
             * avatar_updated_at : 1512538248
             * created_at : 1436268691
             * gender : F
             * icon : 2017120613304834.JPEG
             * id : 29314260
             * last_device :
             * last_visited_at : 0
             * login : 贝格格*
             * medium : //pic.qiushibaike.com/system/avtnew/2931/29314260/medium/2017120613304834.JPEG
             * role : n
             * state : active
             * thumb : //pic.qiushibaike.com/system/avtnew/2931/29314260/thumb/2017120613304834.JPEG
             * uid : 29314260
             * updated_at : 1513160440
             */

            private int age;
            private String astrology;
            private int avatar_updated_at;
            private int created_at;
            private String gender;
            private String icon;
            private int id;
            private String last_device;
            private int last_visited_at;
            private String login;
            private String medium;
            private String role;
            private String state;
            private String thumb;
            private int uid;
            private int updated_at;

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }

            public String getAstrology() {
                return astrology;
            }

            public void setAstrology(String astrology) {
                this.astrology = astrology;
            }

            public int getAvatar_updated_at() {
                return avatar_updated_at;
            }

            public void setAvatar_updated_at(int avatar_updated_at) {
                this.avatar_updated_at = avatar_updated_at;
            }

            public int getCreated_at() {
                return created_at;
            }

            public void setCreated_at(int created_at) {
                this.created_at = created_at;
            }

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getLast_device() {
                return last_device;
            }

            public void setLast_device(String last_device) {
                this.last_device = last_device;
            }

            public int getLast_visited_at() {
                return last_visited_at;
            }

            public void setLast_visited_at(int last_visited_at) {
                this.last_visited_at = last_visited_at;
            }

            public String getLogin() {
                return login;
            }

            public void setLogin(String login) {
                this.login = login;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public int getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(int updated_at) {
                this.updated_at = updated_at;
            }
        }

        public static class VotesBean implements Serializable {
            /**
             * down : -1
             * up : 173
             */

            private int down;
            private int up;

            public int getDown() {
                return down;
            }

            public void setDown(int down) {
                this.down = down;
            }

            public int getUp() {
                return up;
            }

            public void setUp(int up) {
                this.up = up;
            }
        }
    }
}
