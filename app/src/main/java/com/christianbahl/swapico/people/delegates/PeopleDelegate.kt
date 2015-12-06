package com.christianbahl.swapico.films.delegates

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.christianbahl.swapico.R
import com.christianbahl.swapico.base.BaseDelegate
import com.christianbahl.swapico.people.model.IPeopleResponseData
import com.christianbahl.swapico.people.model.PeopleResponse
import kotlinx.android.synthetic.main.row_single_text.view.*

/**
 * @author Christian Bahl
 */
class PeopleDelegate(viewType: Int, context: Context) : BaseDelegate<List<IPeopleResponseData>>(viewType,
                                                                                           context) {

  override fun onCreateViewHolder(parent: ViewGroup?) =
      PeopleViewHolder(inflater.inflate(R.layout.row_single_text, parent, false))

  override fun isForViewType(items: List<IPeopleResponseData>?, position: Int) = items?.get(
      position) is PeopleResponse

  override fun onBindViewHolder(items: List<IPeopleResponseData>?, position: Int,
                                viewHolder: RecyclerView.ViewHolder?) {
    (viewHolder as PeopleViewHolder).bindView(items?.get(position) as PeopleResponse)
  }

  class PeopleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    public fun bindView(people: PeopleResponse) {
      itemView.row_single_text_text.text = people.name
    }
  }
}