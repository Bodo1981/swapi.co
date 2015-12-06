package com.christianbahl.swapico.films

import com.christianbahl.swapico.base.BaseLceRxPresenter
import com.christianbahl.swapico.base.loadmore.AddLoadMore
import com.christianbahl.swapico.films.model.FilmResponse
import com.christianbahl.swapico.films.model.IFilmResponseData
import com.christianbahl.swapico.model.Result
import com.github.salomonbrys.kodein.Kodein

/**
 * @author Christian Bahl
 */
class FilmsPresenter(kodein: Kodein) : BaseLceRxPresenter<FilmsView, List<IFilmResponseData>>(kodein) {

  public fun loadFilms(pullToRefresh: Boolean) {
    subscribe(swapiApi.films().map(AddLoadMore<Result<FilmResponse>>()).map { it.results }, pullToRefresh);
  }

  public fun loadMoreFilms(url: String?, pullToRefresh: Boolean) {
    if (url != null) {
      subscribe(swapiApi.loadMoreFilms(url).map(AddLoadMore<Result<FilmResponse>>()).doOnNext {
        view?.setLoadMoreUrl(it.next)
      }.map { it.results },
          pullToRefresh)
    }
  }
}