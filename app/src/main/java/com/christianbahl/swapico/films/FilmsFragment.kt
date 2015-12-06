package com.christianbahl.swapico.films

import android.os.Bundle
import com.christianbahl.swapico.base.loadmore.BaseFragmentLoadMore
import com.christianbahl.swapico.films.model.IFilmResponseData
import com.github.salomonbrys.kodein.android.appKodein
import com.hannesdorfmann.mosby.mvp.viewstate.lce.LceViewState
import com.hannesdorfmann.mosby.mvp.viewstate.lce.data.RetainingLceViewState

/**
 * @author Christian Bahl
 */
class FilmsFragment : BaseFragmentLoadMore<IFilmResponseData, FilmsView, FilmsPresenter, FilmsAdapter>() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    retainInstance = true
  }

  override fun createViewState(): LceViewState<MutableList<IFilmResponseData>, FilmsView>? = RetainingLceViewState()

  override fun createPresenter(): FilmsPresenter? = FilmsPresenter(appKodein())

  override fun createAdapter(): FilmsAdapter? = FilmsAdapter(activity)

  override fun loadData(pullToRefresh: Boolean) = presenter.loadFilms(pullToRefresh)

  override fun loadMore(loadMoreUrl: String?)  = presenter.loadMoreFilms(loadMoreUrlString, true)

}