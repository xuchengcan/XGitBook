package chennuo.x.xgitbook.Base

import android.app.Application
import com.antonioleiva.weatherapp.extensions.DelegatesExt

/**
 * Created by sunshine on 2017/11/4.
 */
class App : Application() {

    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}