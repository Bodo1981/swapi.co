package com.christianbahl.swapico.list.delegates

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.christianbahl.swapico.R
import com.christianbahl.swapico.base.BaseDelegate
import com.christianbahl.swapico.list.model.ListItem
import com.christianbahl.swapico.list.model.ListItemType
import kotlinx.android.synthetic.main.row_single_text.view.*
import org.jetbrains.anko.onClick

/**
 * @author Christian Bahl
 */
class TextDelegate(viewType: Int, context: Context, val callback: (url: String) -> Unit) : BaseDelegate<List<ListItem>>(viewType,
    context) {

  override fun onCreateViewHolder(parent: ViewGroup?) =
      FilmViewHolder(inflater.inflate(R.layout.row_single_text, parent, false), callback)

  override fun isForViewType(items: List<ListItem>?, position: Int) =
      items?.get(position)?.type == ListItemType.TEXT

  override fun onBindViewHolder(items: List<ListItem>?, position: Int, viewHolder: RecyclerView.ViewHolder?) {
    (viewHolder as FilmViewHolder).bindView(items?.get(position))
  }

  class FilmViewHolder(itemView: View, val callback: (url: String) -> Unit) : RecyclerView.ViewHolder(itemView) {

    public fun bindView(listItem: ListItem?) {
      itemView.row_single_text_text.text = listItem?.text

      if (listItem != null && listItem.url.isNotBlank()) {
        itemView.onClick { callback(listItem.url) }
      }
    }
  }
}