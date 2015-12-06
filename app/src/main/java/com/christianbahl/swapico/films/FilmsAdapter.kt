package com.christianbahl.swapico.films

import android.content.Context
import com.christianbahl.swapico.base.BaseAdapter
import com.christianbahl.swapico.base.delegates.LoadMoreDelegate
import com.christianbahl.swapico.films.delegates.FilmDelegate
import com.christianbahl.swapico.films.model.IFilmResponseData

/**
 * @author Christian Bahl
 */
class FilmsAdapter(val context: Context) : BaseAdapter<IFilmResponseData>() {

  companion object {
    private val VIEW_TYPE_FILM = 0
    private val VIEW_TYPE_LOAD_MORE = 1
  }

  init {
    delegatesManager.addDelegate(FilmDelegate(VIEW_TYPE_FILM, context))
    delegatesManager.addDelegate(LoadMoreDelegate<IFilmResponseData>(VIEW_TYPE_LOAD_MORE, context))
  }
}