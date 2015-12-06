package com.christianbahl.swapico.list.model

/**
 * @author Christian Bahl
 */
enum class ListItemType {
  TEXT, LOAD_MORE
}

enum class ListType {
  FILMS, PEOPLE, PLANETS, SPECIES, STARSHIPS, VEHICLES
}

data class ListModel(val listData: List<ListItem>,
                     val loadMoreUrl: String?) : ILoadMoreList {
  override val loadMore: Boolean
    get() = loadMoreUrl?.isNotBlank() ?: false

  override val adapterList: MutableList<ListItem>
    get() = listData as MutableList<ListItem>
}

data class ListItem(val text: String = "",
                    val detailsUrl: String = "",
                    val type: ListItemType = ListItemType.TEXT)