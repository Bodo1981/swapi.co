package com.christianbahl.swapico.films.delegates

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.christianbahl.swapico.R
import com.christianbahl.swapico.base.BaseDelegate
import com.christianbahl.swapico.films.model.FilmResponse
import kotlinx.android.synthetic.row_single_text.view.row_single_text_text

/**
 * @author Christian Bahl
 */
class FilmDelegate(viewType: Int, context: Context) : BaseDelegate<List<FilmResponse>>(viewType,
                                                                                       context) {

  override fun onCreateViewHolder(parent: ViewGroup?) =
      FilmViewHolder(inflater.inflate(R.layout.row_single_text, parent, false))

  override fun isForViewType(items: List<FilmResponse>?, position: Int) = items?.get(
      position) is FilmResponse

  override fun onBindViewHolder(items: List<FilmResponse>?, position: Int,
                                viewHolder: RecyclerView.ViewHolder?) {
    (viewHolder as FilmViewHolder).bindView(items?.get(position) as FilmResponse)
  }

  class FilmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    public fun bindView(film: FilmResponse) {
      itemView.row_single_text_text.text = film.title
    }
  }
}