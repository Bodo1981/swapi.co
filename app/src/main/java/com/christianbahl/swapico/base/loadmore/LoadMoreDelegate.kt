package com.christianbahl.swapico.base.loadmore

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.christianbahl.swapico.R
import com.christianbahl.swapico.base.BaseDelegate
import com.christianbahl.swapico.people.model.IPeopleResponseData

/**
 * @author Christian Bahl
 */
class LoadMoreDelegate(viewType: Int, context: Context) : BaseDelegate<List<IPeopleResponseData>>(viewType, context) {

  override fun onCreateViewHolder(parent: ViewGroup?) =
      LoadMoreViewHolder(inflater.inflate(R.layout.row_load_more, parent, false))

  override fun isForViewType(items: List<IPeopleResponseData>?, position: Int) = items?.get(
      position) is LoadMoreRow

  override fun onBindViewHolder(items: List<IPeopleResponseData>?, position: Int,
                                viewHolder: RecyclerView.ViewHolder?) {
    // nothing to do here
  }

  class LoadMoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

  }
}