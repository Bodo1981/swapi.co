package com.christianbahl.swapico.people

import android.content.Context
import com.christianbahl.swapico.base.BaseAdapter
import com.christianbahl.swapico.base.loadmore.LoadMoreDelegate
import com.christianbahl.swapico.films.delegates.PeopleDelegate
import com.christianbahl.swapico.people.model.IPeopleResponseData

/**
 * @author Christian Bahl
 */
class PeopleAdapter(val context: Context) : BaseAdapter<IPeopleResponseData>() {

  companion object {
    private val VIEW_TYPE_PEOPLE = 1
    private val VIEW_TYPE_LOAD_MORE = 2
  }

  init {
    delegatesManager.addDelegate(PeopleDelegate(VIEW_TYPE_PEOPLE, context))
    delegatesManager.addDelegate(LoadMoreDelegate(VIEW_TYPE_LOAD_MORE, context))
  }
}