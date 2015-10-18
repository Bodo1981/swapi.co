package com.christianbahl.swapico.films

import android.os.Bundle
import com.christianbahl.appkit.core.common.view.CBMvpView
import com.christianbahl.appkit.viewstate.fragment.CBFragmentMvpListRecyclerViewViewState
import com.christianbahl.swapico.films.model.FilmResponse
import com.hannesdorfmann.mosby.mvp.viewstate.lce.LceViewState
import com.hannesdorfmann.mosby.mvp.viewstate.lce.data.RetainingLceViewState

/**
 * @author Christian Bahl
 */
class FilmsFragment : CBFragmentMvpListRecyclerViewViewState<FilmResponse, CBMvpView<FilmResponse>, FilmsPresenter, FilmsAdapter>() {

  private val data: MutableList<FilmResponse>? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    retainInstance = true
  }

  override fun createViewState(): LceViewState<MutableList<FilmResponse>, CBMvpView<FilmResponse>>? = RetainingLceViewState()

  override fun createPresenter(): FilmsPresenter? = FilmsPresenter()

  override fun createAdapter(): FilmsAdapter? = FilmsAdapter(activity)

  override fun loadData(pullToRefresh: Boolean) {
    presenter.loadFilms(pullToRefresh)
  }

  override fun setData(data: MutableList<FilmResponse>?) {
    adapter.setItems(data)
    adapter.notifyDataSetChanged()
  }

  override fun getData(): MutableList<FilmResponse>? = data

  override fun getErrorMessage(throwable: Throwable?, isContentVisible: Boolean): String? {
    return super.getErrorMessage(throwable, isContentVisible)
  }

}