package com.christianbahl.swapico.people

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.christianbahl.appkit.viewstate.fragment.CBFragmentMvpListRecyclerViewViewState
import com.christianbahl.swapico.base.loadmore.LoadMoreScrollListener
import com.christianbahl.swapico.people.model.IPeopleResponseData
import com.christianbahl.swapico.people.model.PeopleResponse
import com.github.salomonbrys.kodein.android.appKodein
import com.hannesdorfmann.mosby.mvp.viewstate.lce.LceViewState
import com.hannesdorfmann.mosby.mvp.viewstate.lce.data.RetainingLceViewState

/**
 * @author Christian Bahl
 */
class PeopleFragment : CBFragmentMvpListRecyclerViewViewState<IPeopleResponseData, PeopleView, PeoplePresenter, PeopleAdapter>(), PeopleView {

  private val data: MutableList<PeopleResponse>? = null
  private var loadMoreUrl: String? = null
  lateinit private var loadMoreScrollListener: LoadMoreScrollListener

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    retainInstance = true
  }

  override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    loadMoreScrollListener = LoadMoreScrollListener(contentView.layoutManager as LinearLayoutManager) {
      if (loadMoreUrl != null) {
        presenter.loadMorePeople(loadMoreUrl, true)
      }
    }
    contentView.addOnScrollListener(loadMoreScrollListener);
  }

  override fun createPresenter(): PeoplePresenter? = PeoplePresenter(appKodein())

  override fun createAdapter(): PeopleAdapter? = PeopleAdapter(activity)

  override fun createViewState(): LceViewState<MutableList<IPeopleResponseData>, PeopleView>? = RetainingLceViewState()

  override fun getData(): MutableList<PeopleResponse>? = data

  override fun loadData(pullToRefresh: Boolean) = presenter.loadPeople(pullToRefresh)

  override fun setData(data: MutableList<IPeopleResponseData>?) {
    val itemsAlreadyInListCount = adapter.itemCount

    adapter.addNewDataList(data, itemsAlreadyInListCount > 0)
    var newItemsCount = data?.size ?: 0

    if (loadMoreUrl != null) {
      newItemsCount++
    }

    if (itemsAlreadyInListCount == 0) {
      adapter.notifyDataSetChanged()
    } else {
      adapter.notifyItemRangeInserted(itemsAlreadyInListCount, newItemsCount)
    }

    loadMoreScrollListener.isLoading = false;
  }

  override fun setLoadMoreUrl(loadMoreUrl: String?) {
    this.loadMoreUrl = loadMoreUrl
  }
}