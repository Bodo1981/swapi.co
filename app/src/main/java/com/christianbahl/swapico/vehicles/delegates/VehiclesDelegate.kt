package com.christianbahl.swapico.vehicles.delegates

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.christianbahl.swapico.R
import com.christianbahl.swapico.base.BaseDelegate
import com.christianbahl.swapico.vehicles.model.IVehiclesResponseData
import com.christianbahl.swapico.vehicles.model.VehiclesResponse
import kotlinx.android.synthetic.main.row_single_text.view.*

/**
 * @author Christian Bahl
 */
class VehiclesDelegate(viewType: Int, context: Context) : BaseDelegate<List<IVehiclesResponseData>>(viewType,
    context) {

  override fun onCreateViewHolder(parent: ViewGroup?) =
      VehiclesViewHolder(inflater.inflate(R.layout.row_single_text, parent, false))

  override fun isForViewType(items: List<IVehiclesResponseData>?, position: Int) = items?.get(
      position) is VehiclesResponse

  override fun onBindViewHolder(items: List<IVehiclesResponseData>?, position: Int,
                                viewHolder: RecyclerView.ViewHolder?) {
    (viewHolder as VehiclesViewHolder).bindView(items?.get(position) as VehiclesResponse)
  }

  class VehiclesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    public fun bindView(vehicles: VehiclesResponse) {
      itemView.row_single_text_text.text = vehicles.name
    }
  }
}