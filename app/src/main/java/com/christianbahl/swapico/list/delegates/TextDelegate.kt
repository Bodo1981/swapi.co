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

/**
 * @author Christian Bahl
 */
class TextDelegate(viewType: Int, context: Context) : BaseDelegate<List<ListItem>>(viewType,
    context) {

  override fun onCreateViewHolder(parent: ViewGroup?) =
      FilmViewHolder(inflater.inflate(R.layout.row_single_text, parent, false))

  override fun isForViewType(items: List<ListItem>?, position: Int) =
      items?.get(position)?.type == ListItemType.TEXT

  override fun onBindViewHolder(items: List<ListItem>?, position: Int,
                                viewHolder: RecyclerView.ViewHolder?) {
    (viewHolder as FilmViewHolder).bindView(items?.get(position)?.text)
  }

  class FilmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    public fun bindView(text: String?) {
      itemView.row_single_text_text.text = text ?: ""
    }
  }
}