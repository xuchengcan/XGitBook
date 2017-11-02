package chennuo.x.xgitbook.Network

import android.util.Log
import java.net.URL

/**
 * Created by Chen on 2017/11/2.
 */
public class Request(val url:String) {

    public fun run(){
        var forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName, forecastJsonStr)
    }

}