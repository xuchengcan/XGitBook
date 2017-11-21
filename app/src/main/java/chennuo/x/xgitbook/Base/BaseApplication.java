package chennuo.x.xgitbook.Base;

import android.app.Application;
import android.content.Context;

/**
 * Created by Chen on 2017/11/20.
 */

public class BaseApplication extends Application {

    static Context mContext;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();

    }

    public static Context getAppContext() {
        return mContext;
    }

}
