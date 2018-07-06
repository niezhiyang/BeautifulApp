package cn.nzy.beautifulapp.Bean.VedioBean;

import java.util.List;

/**
 * on 2018/6/19 by nzy
 */
public class VedioBean {


    /**
     * result : [{"id":"6771","title":"口红印引出意外收获","url":"http://fun.shiwan.com/videos/34cdf2d8910213e789b753416b1a444a.mp4","screenshot_url":"http://fun.shiwan.com/images/screenshot_6771_7_1506590253.jpg","video_width":1280,"video_height":720},{"id":"6772","title":"老爸也太狠了吧","url":"http://fun.shiwan.com/videos/e274cc586179507222bff28cf86f6b3e.mp4","screenshot_url":"http://fun.shiwan.com/images/screenshot_6772_10_1506590253.jpg","video_width":856,"video_height":480},{"id":"6775","title":"怕是离离婚不远了","url":"http://fun.shiwan.com/videos/3b80136a3d378e75e2e763aa2a0b342f.mp4","screenshot_url":"http://fun.shiwan.com/images/screenshot_6775_10_1506590254.jpg","video_width":1280,"video_height":720},{"id":"6784","title":"我们分手吧","url":"http://fun.shiwan.com/videos/5168789c4d595f3f8ae2b2747b6760cb.mp4","screenshot_url":"http://fun.shiwan.com/images/screenshot_6784_10_1506590257.jpg","video_width":1280,"video_height":720},{"id":"6790","title":"爸爸让我打的","url":"http://fun.shiwan.com/videos/3c986ff6bb711e0e0f602025f0ff6a2a.mp4","screenshot_url":"http://fun.shiwan.com/images/screenshot_6790_10_1506590260.jpg","video_width":272,"video_height":368},{"id":"6803","title":"美女带伞了吗","url":"http://fun.shiwan.com/videos/f8d7cb024dd1692e6525563ecdbb1089.mp4","screenshot_url":"http://fun.shiwan.com/images/screenshot_6803_10_1506590262.jpg","video_width":1280,"video_height":720},{"id":"6825","title":"丈夫上演自杀场面","url":"http://fun.shiwan.com/videos/ffbc8774d3ccea87616b27306548c56f.mp4","screenshot_url":"http://fun.shiwan.com/images/screenshot_6825_10_1506590265.jpg","video_width":1280,"video_height":718},{"id":"6936","title":"爆笑合辑：搞笑我们是认真的","url":"http://fun.shiwan.com/videos/679bf9b0e3d0011c10ae326bbcb0cc58.mp4","screenshot_url":"http://fun.shiwan.com/images/screenshot_6936_10_1506590283.jpg","video_width":480,"video_height":480},{"id":"7021","title":"丈夫出去玩怕妻子出轨，做出这事令人哭笑不得，这招太狠了","url":"http://fun.shiwan.com/videos/11bfac36c23fa085692d6e3ff3cc6c67.mp4","screenshot_url":"http://fun.shiwan.com/images/screenshot_7021_10_1506590312.jpg","video_width":720,"video_height":960},{"id":"7022","title":"丈母娘，这样的媳妇给我来一打","url":"http://fun.shiwan.com/videos/8a735d372196712d3935f45cc570e153.mp4","screenshot_url":"http://fun.shiwan.com/images/screenshot_7022_10_1506590312.jpg","video_width":1280,"video_height":720}]
     * error_code : 0
     * end_page : 0
     */

    private int error_code;
    private int end_page;
    private List<ResultBean> result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public int getEnd_page() {
        return end_page;
    }

    public void setEnd_page(int end_page) {
        this.end_page = end_page;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * id : 6771
         * title : 口红印引出意外收获
         * url : http://fun.shiwan.com/videos/34cdf2d8910213e789b753416b1a444a.mp4
         * screenshot_url : http://fun.shiwan.com/images/screenshot_6771_7_1506590253.jpg
         * video_width : 1280
         * video_height : 720
         */

        private String id;
        private String title;
        private String url;
        private String screenshot_url;
        private int video_width;
        private int video_height;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getScreenshot_url() {
            return screenshot_url;
        }

        public void setScreenshot_url(String screenshot_url) {
            this.screenshot_url = screenshot_url;
        }

        public int getVideo_width() {
            return video_width;
        }

        public void setVideo_width(int video_width) {
            this.video_width = video_width;
        }

        public int getVideo_height() {
            return video_height;
        }

        public void setVideo_height(int video_height) {
            this.video_height = video_height;
        }
    }
}
