package com.christianbahl.swapico.films

import android.content.Context
import com.christianbahl.swapico.films.delegates.FilmDelegate
import com.christianbahl.swapico.films.model.FilmResponse
import com.hannesdorfmann.adapterdelegates.ListDelegationAdapter

/**
 * @author Christian Bahl
 */
class FilmsAdapter(val context: Context) : ListDelegationAdapter<List<FilmResponse>>() {

  companion object {
    private val VIEW_TYPE_FILM = 0
  }

  init {
    delegatesManager.addDelegate(FilmDelegate(VIEW_TYPE_FILM, context))
  }
}