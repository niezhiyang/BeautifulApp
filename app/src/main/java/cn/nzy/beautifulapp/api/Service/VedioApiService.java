package cn.nzy.beautifulapp.api.Service;


import cn.nzy.beautifulapp.Bean.VedioBean.VedioBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface VedioApiService {


    /**
     *  获取vedio
     * @return
     */

    @GET("{page}/{uid}")
    Observable<VedioBean> getVedio(@Path("page") String slug,@Path("uid")String uid);
    @GET()
    Observable<VedioBean> getVedios();

}
