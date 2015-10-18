package com.christianbahl.swapico.base.recyclerview

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log

/**
 * @author Christian Bahl
 */
class LoadMoreScrollListener(val layoutManager: LinearLayoutManager, val onLoadMore: () -> Unit) : RecyclerView.OnScrollListener() {

  companion object {
    private val ITEMS_BEFORE_LAST_ITEM = 5
    private val TAG = LoadMoreScrollListener::class.javaClass.canonicalName
  }

  private var isLoading: Boolean = false

  override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
    super.onScrolled(recyclerView, dx, dy)

    val lastVisibleItem = layoutManager.findLastVisibleItemPosition() + 1 // +1 because position starts at 0
    val totalItems = layoutManager.itemCount

    if (!isLoading) {
      if (lastVisibleItem + ITEMS_BEFORE_LAST_ITEM >= totalItems) {
        onLoadMore()
      }
    }
    Log.d(TAG, "$totalItems -> $lastVisibleItem")
  }
}