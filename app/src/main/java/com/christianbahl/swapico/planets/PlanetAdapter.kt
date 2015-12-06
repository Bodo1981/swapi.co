package com.christianbahl.swapico.planets

import android.content.Context
import com.christianbahl.swapico.base.BaseAdapter
import com.christianbahl.swapico.base.delegates.LoadMoreDelegate
import com.christianbahl.swapico.films.delegates.PlanetDelegate
import com.christianbahl.swapico.planets.model.IPlanetResponseData

/**
 * @author Christian Bahl
 */
class PlanetAdapter(val context: Context) : BaseAdapter<IPlanetResponseData>() {

  companion object {
    private val VIEW_TYPE_PLANET = 0
    private val VIEW_TYPE_LOAD_MORE = 1
  }

  init {
    delegatesManager.addDelegate(PlanetDelegate(VIEW_TYPE_PLANET, context))
    delegatesManager.addDelegate(LoadMoreDelegate<IPlanetResponseData>(VIEW_TYPE_LOAD_MORE, context))
  }
}