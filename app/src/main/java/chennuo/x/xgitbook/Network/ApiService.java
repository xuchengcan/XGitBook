package chennuo.x.xgitbook.Network;

import android.content.Context;

import chennuo.x.xgitbook.Base.BaseApplication;

/**
 * Created by Chen on 2017/11/20.
 */

public class ApiService {

    private Api mApi;
    private Context mContext;
    private static ApiService mInstance;

//-------- 存在内存泄漏的写法,如果传入 Activity 的 Context,会导致 Activity 无法被回收-------------------
//    private ApiService(Context mContext) {
//        this.mContext = mContext;
//        mApi = RetrofitClient.getClient(mContext).create(Api.class);
//    }
//
//    public static ApiService getInstance(Context mContext) {
//        if (mInstance == null) {
//            mInstance = new ApiService(mContext);
//        }
//        return mInstance;
//    }
//------------------------------------------------------------------------------------------------

    private ApiService() {
        this.mContext = BaseApplication.getAppContext();
        mApi = RetrofitClient.getClient(mContext).create(Api.class);
    }

    public static ApiService getInstance() {
        if (mInstance == null) {
            mInstance = new ApiService();
        }
        return mInstance;
    }

}
