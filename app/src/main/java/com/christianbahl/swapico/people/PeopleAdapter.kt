package com.christianbahl.swapico.people

import android.content.Context
import com.christianbahl.swapico.base.BaseAdapter
import com.christianbahl.swapico.base.delegates.LoadMoreDelegate
import com.christianbahl.swapico.films.delegates.PeopleDelegate
import com.christianbahl.swapico.people.model.IPeopleResponseData

/**
 * @author Christian Bahl
 */
class PeopleAdapter(val context: Context) : BaseAdapter<IPeopleResponseData>() {

  companion object {
    private val VIEW_TYPE_PEOPLE = 0
    private val VIEW_TYPE_LOAD_MORE = 1
  }

  init {
    delegatesManager.addDelegate(PeopleDelegate(VIEW_TYPE_PEOPLE, context))
    delegatesManager.addDelegate(LoadMoreDelegate<IPeopleResponseData>(VIEW_TYPE_LOAD_MORE, context))
  }
}