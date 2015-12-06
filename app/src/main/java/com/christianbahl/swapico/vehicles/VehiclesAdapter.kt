package com.christianbahl.swapico.vehicles

import android.content.Context
import com.christianbahl.swapico.base.BaseAdapter
import com.christianbahl.swapico.base.delegates.LoadMoreDelegate
import com.christianbahl.swapico.vehicles.delegates.VehiclesDelegate
import com.christianbahl.swapico.vehicles.model.IVehiclesResponseData

/**
 * @author Christian Bahl
 */
class VehiclesAdapter(val context: Context) : BaseAdapter<IVehiclesResponseData>() {

  companion object {
    private val VIEW_TYPE_VEHICLES = 0
    private val VIEW_TYPE_LOAD_MORE = 1
  }

  init {
    delegatesManager.addDelegate(VehiclesDelegate(VIEW_TYPE_VEHICLES, context))
    delegatesManager.addDelegate(LoadMoreDelegate<IVehiclesResponseData>(VIEW_TYPE_LOAD_MORE, context))
  }
}