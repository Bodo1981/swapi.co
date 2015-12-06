package com.christianbahl.swapico.species.delegates

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.christianbahl.swapico.R
import com.christianbahl.swapico.base.BaseDelegate
import com.christianbahl.swapico.species.model.ISpeciesResponseData
import com.christianbahl.swapico.species.model.SpeciesResponse
import kotlinx.android.synthetic.main.row_single_text.view.*

/**
 * @author Christian Bahl
 */
class SpeciesDelegate(viewType: Int, context: Context) : BaseDelegate<List<ISpeciesResponseData>>(viewType,
    context) {

  override fun onCreateViewHolder(parent: ViewGroup?) =
      SpeciesViewHolder(inflater.inflate(R.layout.row_single_text, parent, false))

  override fun isForViewType(items: List<ISpeciesResponseData>?, position: Int) = items?.get(
      position) is SpeciesResponse

  override fun onBindViewHolder(items: List<ISpeciesResponseData>?, position: Int,
                                viewHolder: RecyclerView.ViewHolder?) {
    (viewHolder as SpeciesViewHolder).bindView(items?.get(position) as SpeciesResponse)
  }

  class SpeciesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    public fun bindView(species: SpeciesResponse) {
      itemView.row_single_text_text.text = species.name
    }
  }
}