package com.christianbahl.swapico.films.delegates

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.christianbahl.swapico.R
import com.christianbahl.swapico.base.BaseDelegate
import com.christianbahl.swapico.planets.model.IPlanetResponseData
import com.christianbahl.swapico.planets.model.PlanetResponse
import kotlinx.android.synthetic.main.row_single_text.view.*

/**
 * @author Christian Bahl
 */
class PlanetDelegate(viewType: Int, context: Context) : BaseDelegate<List<IPlanetResponseData>>(viewType,
    context) {

  override fun onCreateViewHolder(parent: ViewGroup?) =
      PlanetViewHolder(inflater.inflate(R.layout.row_single_text, parent, false))

  override fun isForViewType(items: List<IPlanetResponseData>?, position: Int) = items?.get(
      position) is PlanetResponse

  override fun onBindViewHolder(items: List<IPlanetResponseData>?, position: Int,
                                viewHolder: RecyclerView.ViewHolder?) {
    (viewHolder as PlanetViewHolder).bindView(items?.get(position) as PlanetResponse)
  }

  class PlanetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    public fun bindView(planet: PlanetResponse) {
      itemView.row_single_text_text.text = planet.name
    }
  }
}