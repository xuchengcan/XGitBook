package chennuo.x.xgitbook.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.ViewGroup
import android.widget.TextView
import chennuo.x.xgitbook.Activity.Main2Activity
import chennuo.x.xgitbook.domain.ForecastList
import org.jetbrains.anko.startActivity

/**
 * Created by Chen on 2017/11/2.
 */
class ForecastListAdapter(val context:Context, val weekForecast: ForecastList) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder? {
        return ViewHolder(TextView(parent.getContext()))
    }

    override fun onBindViewHolder(holder: ViewHolder,
                                  position: Int) {
        with(weekForecast.dailyForecast[position]) {
            holder.textView.text = "$date - $description - $high/$low"
            holder.textView.setOnClickListener {
                Log.i("tag",position.toString())
                context.startActivity<Main2Activity>()
            }
        }
    }
    override fun getItemCount(): Int = weekForecast.dailyForecast.size

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}
