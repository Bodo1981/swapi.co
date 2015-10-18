package com.christianbahl.swapico.people

import android.content.Context
import com.christianbahl.swapico.films.delegates.PeopleDelegate
import com.christianbahl.swapico.people.model.PeopleResponse
import com.hannesdorfmann.adapterdelegates.ListDelegationAdapter

/**
 * @author Christian Bahl
 */
class PeopleAdapter(val context: Context) : ListDelegationAdapter<List<PeopleResponse>>() {

  companion object {
    private val VIEW_TYPE_PEOPLE = 1
  }
  
  init {
    delegatesManager.addDelegate(PeopleDelegate(VIEW_TYPE_PEOPLE, context))
  }
}