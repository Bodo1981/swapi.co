package com.christianbahl.swapico.starships.delegates

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.christianbahl.swapico.R
import com.christianbahl.swapico.base.BaseDelegate
import com.christianbahl.swapico.starships.model.IStarshipsResponseData
import com.christianbahl.swapico.starships.model.StarshipsResponse
import kotlinx.android.synthetic.main.row_single_text.view.*

/**
 * @author Christian Bahl
 */
class StarshipsDelegate(viewType: Int, context: Context) : BaseDelegate<List<IStarshipsResponseData>>(viewType,
    context) {

  override fun onCreateViewHolder(parent: ViewGroup?) =
      StarshipsViewHolder(inflater.inflate(R.layout.row_single_text, parent, false))

  override fun isForViewType(items: List<IStarshipsResponseData>?, position: Int) = items?.get(
      position) is StarshipsResponse

  override fun onBindViewHolder(items: List<IStarshipsResponseData>?, position: Int,
                                viewHolder: RecyclerView.ViewHolder?) {
    (viewHolder as StarshipsViewHolder).bindView(items?.get(position) as StarshipsResponse)
  }

  class StarshipsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    public fun bindView(starships: StarshipsResponse) {
      itemView.row_single_text_text.text = starships.name
    }
  }
}