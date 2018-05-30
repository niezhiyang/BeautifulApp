package cn.nzy.beautifulapp.api;


import cn.nzy.beautifulapp.Bean.LivingBean.LivingBean;
import cn.nzy.beautifulapp.Bean.Room;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * on 2017/12/21.
 * 类的描述:
 */

public interface ApiService {



    /**
     * 获取某个频道下面的内容列表
     * @param slug
     * @return
     */
    @GET("json/categories/{slug}/list.json")
    Observable<LivingBean> getLiveListResultByCategories(@Path("slug") String slug);

    /**
     * 进入房间
     * @param uid
     * @return
     */
    @GET("json/rooms/{uid}/info.json")
    Observable<Room> enterRoom(@Path("uid")String uid);

}
