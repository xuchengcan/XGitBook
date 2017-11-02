package chennuo.x.xgitbook.Activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import chennuo.x.xgitbook.Adapter.ForecastListAdapter
import chennuo.x.xgitbook.Network.ForecastRequest
import chennuo.x.xgitbook.R
import chennuo.x.xgitbook.domain.Command
import chennuo.x.xgitbook.domain.ForecastDataMapper
import chennuo.x.xgitbook.domain.ForecastList
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    private val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forecastList: RecyclerView = find(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)

        val url = "http://www.baidu.com"
        doAsync() {
            val result = RequestForecastCommand("94043").execute()
            uiThread{
                forecastList.adapter = ForecastListAdapter(this@MainActivity,result)
            }
        }
    }

    class click(){
        
    }


    class RequestForecastCommand(val zipCode: String) :
            Command<ForecastList> {
        override fun execute(): ForecastList {
            val forecastRequest = ForecastRequest(zipCode)
            return ForecastDataMapper().convertFromDataModel(
                    forecastRequest.execute())
        }
    }
}
