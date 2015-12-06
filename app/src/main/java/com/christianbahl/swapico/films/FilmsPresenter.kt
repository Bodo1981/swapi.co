package com.christianbahl.swapico.films

import com.christianbahl.appkit.core.common.view.CBMvpView
import com.christianbahl.swapico.base.BaseLceRxPresenter
import com.christianbahl.swapico.films.model.FilmResponse
import com.github.salomonbrys.kodein.Kodein

/**
 * @author Christian Bahl
 */
class FilmsPresenter(kodein: Kodein) : BaseLceRxPresenter<CBMvpView<FilmResponse>, List<FilmResponse>>(kodein) {

  public fun loadFilms(pullToRefresh: Boolean) {
    subscribe(swapiApi.films().map { it.results }, pullToRefresh);
  }

}