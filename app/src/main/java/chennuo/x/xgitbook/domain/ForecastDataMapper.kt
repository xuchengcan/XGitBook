package chennuo.x.xgitbook.domain

import chennuo.x.xgitbook.domain.Forecast as ModelForecast
import chennuo.x.xgitbook.Network.ForecastResult

import java.text.DateFormat
import java.util.*

/**
 * Created by Chen on 2017/11/2.
 */
public class ForecastDataMapper {
    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(forecast.city.name, forecast.city.country,
                convertForecastListToDomain(forecast.list))

    }

    fun convertForecastListToDomain(list: List<chennuo.x.xgitbook.Network.Forecast>):
            List<ModelForecast> {
        return list.map { convertForecastItemToDomain(it) }
    }

    fun convertForecastItemToDomain(forecast: chennuo.x.xgitbook.Network.Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt),
                forecast.weather[0].description, forecast.temp.max.toInt(),
                forecast.temp.min.toInt())
    }

    fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }
}