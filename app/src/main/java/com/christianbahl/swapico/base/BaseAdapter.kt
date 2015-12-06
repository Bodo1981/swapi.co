package com.christianbahl.swapico.base

import com.hannesdorfmann.adapterdelegates.ListDelegationAdapter

/**
 * @author Christian Bahl
 */
abstract class BaseAdapter<M> : ListDelegationAdapter<List<M>>() {

  public fun addNewData(newData: M) {
    if (items == null) {
      items = arrayListOf()
    }

    (items as MutableList).add(newData)
  }

  public fun addNewDataList(newDataList: List<M>?, removeLoadMore: Boolean) {
    if (newDataList == null) {
      return
    }

    if (items == null) {
      items = arrayListOf()
    }

    if (removeLoadMore) {
      (items as MutableList).removeAt(items.size - 1)
    }

    (items as MutableList).addAll(newDataList)
  }

  public fun removeDataAtIndex(index: Int) {
    if (items != null) {
      (items as MutableList).removeAt(index)
    }
  }
}