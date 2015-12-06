package com.christianbahl.swapico.species

import android.content.Context
import com.christianbahl.swapico.base.BaseAdapter
import com.christianbahl.swapico.base.delegates.LoadMoreDelegate
import com.christianbahl.swapico.species.delegates.SpeciesDelegate
import com.christianbahl.swapico.species.model.ISpeciesResponseData

/**
 * @author Christian Bahl
 */
class SpeciesAdapter(val context: Context) : BaseAdapter<ISpeciesResponseData>() {

  companion object {
    private val VIEW_TYPE_SPECIES = 0
    private val VIEW_TYPE_LOAD_MORE = 1
  }

  init {
    delegatesManager.addDelegate(SpeciesDelegate(VIEW_TYPE_SPECIES, context))
    delegatesManager.addDelegate(LoadMoreDelegate<ISpeciesResponseData>(VIEW_TYPE_LOAD_MORE, context))
  }
}