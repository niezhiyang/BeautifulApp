package cn.nzy.beautifulapp.api.Service;


import cn.nzy.beautifulapp.Bean.livingBean.LivingBean;
import cn.nzy.beautifulapp.Bean.livingBean.PlayRoom;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface LivingApiService {



    /**
     */
    @GET("json/categories/{slug}/list.json")
    Observable<LivingBean> getLiveListByCategory(@Path("slug") String slug);

    /**
     * 进入房间
     * @param uid
     * @return
     */
    @GET("json/rooms/{uid}/info.json")
    Observable<PlayRoom> getPlayRoom(@Path("uid")String uid);

}
