package com.christianbahl.swapico.list

import android.content.Context
import com.christianbahl.swapico.base.BaseAdapter
import com.christianbahl.swapico.list.delegates.LoadMoreDelegate
import com.christianbahl.swapico.list.delegates.TextDelegate
import com.christianbahl.swapico.list.model.ListItem

/**
 * @author Christian Bahl
 */
class ListAdapter(val context: Context) : BaseAdapter<ListItem>() {

  companion object {
    private val VIEW_TYPE_TEXT = 0
    private val VIEW_TYPE_LOAD_MORE = 1
  }

  init {
    delegatesManager.addDelegate(TextDelegate(VIEW_TYPE_TEXT, context))
    delegatesManager.addDelegate(LoadMoreDelegate(VIEW_TYPE_LOAD_MORE, context))
  }
}