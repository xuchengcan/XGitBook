package chennuo.x.xgitbook.Network;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Chen on 2017/11/20.
 */

public class RetrofitClient {

    public static Retrofit getClient(Context context) {
        return new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())//Gson 适配器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())// RxJava 适配器
                .build();
    }

}
