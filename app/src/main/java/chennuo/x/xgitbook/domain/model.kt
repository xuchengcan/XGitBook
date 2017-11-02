package chennuo.x.xgitbook.domain

/**
 * Created by Chen on 2017/11/2.
 */
public interface Command<T> {
    fun execute() :T
}

data class ForecastList(val city: String, val country: String,
                        val dailyForecast:List<Forecast>)

data class Forecast(val date: String, val description: String, val high: Int,
                    val low: Int)