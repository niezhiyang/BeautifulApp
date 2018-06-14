package cn.nzy.beautifulapp.api.Service;


import cn.nzy.beautifulapp.Bean.imgBean.DynamicImgBean;
import cn.nzy.beautifulapp.Bean.imgBean.DynamicCateGoryBean;
import cn.nzy.beautifulapp.Bean.imgBean.StaticCategoryBean;
import cn.nzy.beautifulapp.Bean.livingBean.PlayRoom;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;



public interface ImgApiService {



    /**
     * 获取类别,分类 静态的分类
     */
    @GET("v1/vertical/category?adult=false&first=1")
    Observable<StaticCategoryBean> getStaticCategory();

    /**
     *不分频道 , 默认的静态
     * @param categoryid  分类id
     * @param imgId      要跳过的id 用于分页的
     * @return
     */
    @GET("v1/vertical?limit=30&adult=false&first=0&order=hot")
    Observable<PlayRoom> getImgByDefault(@Part("categoryid") String categoryid,@Query("skip") String  imgId);

    /**
     *某个频道下的静态
     * @param categoryid  分类id
     * @param size      要跳过的id 用于分页的
     * @return
     */
    @GET("v1/vertical/category/{categoryid}?limit=30&adult=false&first=0&order=hot")
    Observable<PlayRoom> getStaticImgByCategory(@Part("categoryid") String categoryid,@Query("skip") int  size);



    /**
     *
     * @param imgId      获取评论的id
     * @return
     */
    @POST("v2/vertical/vertical/{imgId}/comment")
    Observable<PlayRoom> getComment(@Part("imgId") String imgId,@Query("skip") int size);

    //http://img5.adesk.com/ + 壁纸ID



    // 动态api https://service.videowp.adesk.com
    /**
     *某个频道下的 动态 评论
     * @param imgId  分类id
     * @param size      要跳过的id 用于分页的
     * @return
     */
    @POST("v2/vertical/vertical/imgId}/comment")
    Observable<DynamicImgBean> getDynamicComment(@Part("imgId") String imgId, @Query("skip") int size);

    /**
     * 获取类别,分类 动态的分类
     */
    @GET("v1/videowp/category?adult=false&first=1")
    Observable<DynamicCateGoryBean> getDynamicCategory();

    /**
     *某个频道下的 动态
     * @param categoryid  分类id
     * @param size      要跳过的id 用于分页的
     * @return
     */
    @GET("v1/videowp/category/{categoryid}?order=new&adult=false&first=0&limit=30")
    Observable<DynamicImgBean> getDynamicImgByCategory(@Part("categoryid") String categoryid, @Query("skip") int  size);



}
