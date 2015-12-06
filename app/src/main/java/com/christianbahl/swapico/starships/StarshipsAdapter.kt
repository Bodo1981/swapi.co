package com.christianbahl.swapico.starships

import android.content.Context
import com.christianbahl.swapico.base.BaseAdapter
import com.christianbahl.swapico.base.delegates.LoadMoreDelegate
import com.christianbahl.swapico.starships.delegates.StarshipsDelegate
import com.christianbahl.swapico.starships.model.IStarshipsResponseData

/**
 * @author Christian Bahl
 */
class StarshipsAdapter(val context: Context) : BaseAdapter<IStarshipsResponseData>() {

  companion object {
    private val VIEW_TYPE_STARSHIPS = 0
    private val VIEW_TYPE_LOAD_MORE = 1
  }

  init {
    delegatesManager.addDelegate(StarshipsDelegate(VIEW_TYPE_STARSHIPS, context))
    delegatesManager.addDelegate(LoadMoreDelegate<IStarshipsResponseData>(VIEW_TYPE_LOAD_MORE, context))
  }
}