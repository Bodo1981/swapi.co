package com.christianbahl.swapico.people

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.christianbahl.appkit.viewstate.fragment.CBFragmentMvpListRecyclerViewViewState
import com.christianbahl.swapico.base.recyclerview.LoadMoreScrollListener
import com.christianbahl.swapico.people.model.PeopleResponse
import com.hannesdorfmann.mosby.mvp.viewstate.lce.LceViewState
import com.hannesdorfmann.mosby.mvp.viewstate.lce.data.RetainingLceViewState

/**
 * @author Christian Bahl
 */
class PeopleFragment : CBFragmentMvpListRecyclerViewViewState<PeopleResponse, PeopleView, PeoplePresenter, PeopleAdapter>(), PeopleView {

  private val data: MutableList<PeopleResponse>? = null
  private var loadMoreUrl: String? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    retainInstance = true
  }

  override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    contentView.addOnScrollListener(
        LoadMoreScrollListener(contentView.layoutManager as LinearLayoutManager) {
          this@PeopleFragment.presenter.loadMorePeople("", true)
        })
  }

  override fun createPresenter(): PeoplePresenter? = PeoplePresenter()

  override fun createAdapter(): PeopleAdapter? = PeopleAdapter(activity)

  override fun createViewState(): LceViewState<MutableList<PeopleResponse>, PeopleView>? = RetainingLceViewState()

  override fun getData(): MutableList<PeopleResponse>? = data

  override fun loadData(pullToRefresh: Boolean) = presenter.loadPeople(pullToRefresh)

  override fun setData(data: MutableList<PeopleResponse>?) {
    adapter.setItems(data)
    adapter.notifyDataSetChanged()
  }

  override fun setLoadMoreUrl(loadMoreUrl: String) {
    this.loadMoreUrl = loadMoreUrl
  }
}