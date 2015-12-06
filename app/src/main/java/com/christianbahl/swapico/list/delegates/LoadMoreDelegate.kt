package com.christianbahl.swapico.list.delegates

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.christianbahl.swapico.R
import com.christianbahl.swapico.base.BaseDelegate
import com.christianbahl.swapico.list.model.ListItem
import com.christianbahl.swapico.list.model.ListItemType

/**
 * @author Christian Bahl
 */
class LoadMoreDelegate(viewType: Int, context: Context) : BaseDelegate<List<ListItem>>(viewType, context) {

  override fun onCreateViewHolder(parent: ViewGroup?) =
      LoadMoreViewHolder(inflater.inflate(R.layout.row_load_more, parent, false))

  override fun isForViewType(items: List<ListItem>?, position: Int) =
      items?.get(position)?.type == ListItemType.LOAD_MORE

  override fun onBindViewHolder(items: List<ListItem>?, position: Int,
                                viewHolder: RecyclerView.ViewHolder?) {
    // nothing to do here
  }

  class LoadMoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

  }
}