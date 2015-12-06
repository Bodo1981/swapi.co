package com.christianbahl.swapico.films

import android.content.Context
import com.christianbahl.swapico.base.BaseAdapter
import com.christianbahl.swapico.films.delegates.FilmDelegate
import com.christianbahl.swapico.films.model.FilmResponse

/**
 * @author Christian Bahl
 */
class FilmsAdapter(val context: Context) : BaseAdapter<FilmResponse>() {

  companion object {
    private val VIEW_TYPE_FILM = 0
  }

  init {
    delegatesManager.addDelegate(FilmDelegate(VIEW_TYPE_FILM, context))
  }
}