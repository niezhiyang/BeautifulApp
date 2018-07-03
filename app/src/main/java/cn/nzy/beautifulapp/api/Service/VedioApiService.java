package cn.nzy.beautifulapp.api.Service;


import cn.nzy.beautifulapp.Bean.VedioBean.VedioBean;
import cn.nzy.beautifulapp.Bean.livingBean.PlayRoom;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface VedioApiService {


    /**
     *  获取vedio
     * @param maxBehotTime  最新事件  10
     * @return
     */

    @GET("?iid=5034850950&device_id=6096495334&refer=1&count=20&aid=13&category=video")
    Observable<VedioBean> getVedio(@Query("max_behot_time") String maxBehotTime);

    /**
     * 获取评论
     * @param baseUrl
     * @param groupId 新闻ID
     * @param offset  偏移量
     * @return
     */
    @GET()
    Observable<PlayRoom> getVedioCommon(@Url String baseUrl, @Query("group_id") String groupId,@Query("offset") int offset);

}
