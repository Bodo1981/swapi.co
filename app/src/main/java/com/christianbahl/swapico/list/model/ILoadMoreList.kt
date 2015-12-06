package com.christianbahl.swapico.list.model

/**
 * @author Christian Bahl
 */
interface ILoadMoreList {

  val loadMore: Boolean
  val adapterList: MutableList<ListItem>

  fun addLoadMoreRow() {
    adapterList.add(ListItem(type = ListItemType.LOAD_MORE))
  }
}