package com.christianbahl.swapico.list

import android.content.Context
import com.christianbahl.swapico.base.BaseAdapter
import com.christianbahl.swapico.list.delegates.LoadMoreDelegate
import com.christianbahl.swapico.list.delegates.TextDelegate
import com.christianbahl.swapico.list.model.ListItem

/**
 * @author Christian Bahl
 */
class ListAdapter(val context: Context, val callback: (url: String) -> Unit) : BaseAdapter<ListItem>() {

  companion object {
    private val VIEW_TYPE_TEXT = 0
    private val VIEW_TYPE_LOAD_MORE = 1
  }

  interface ListAdapterCallback {
    fun onListItemClicked(url: String)
  }

  init {
    delegatesManager.addDelegate(TextDelegate(VIEW_TYPE_TEXT, context, callback))
    delegatesManager.addDelegate(LoadMoreDelegate(VIEW_TYPE_LOAD_MORE, context))
  }
}