package com.christianbahl.swapico.films

import com.christianbahl.appkit.core.common.view.CBMvpView
import com.christianbahl.swapico.base.BaseLceRxPresenter
import com.christianbahl.swapico.films.model.FilmResponse

/**
 * @author Christian Bahl
 */
class FilmsPresenter : BaseLceRxPresenter<CBMvpView<FilmResponse>, List<FilmResponse>>() {

  public fun loadFilms(pullToRefresh: Boolean) {
    subscribe(swapiApi.films().map { it.results }, pullToRefresh);
  }
  
}