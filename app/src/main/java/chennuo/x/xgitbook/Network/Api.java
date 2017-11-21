package chennuo.x.xgitbook.Network;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Chen on 2017/11/20.
 */

public interface Api {

    @GET("users/{user}/repos")
    Observable<List<String>> listRepos(@Path("user") String user);

}
