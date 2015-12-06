package com.christianbahl.swapico.base.loadmore

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.christianbahl.appkit.viewstate.fragment.CBFragmentMvpListRecyclerViewViewState
import com.christianbahl.swapico.base.BaseAdapter
import com.hannesdorfmann.mosby.mvp.MvpPresenter

/**
 * @author Christian Bahl
 */
abstract class BaseFragmentLoadMore<M, V : ILoadMoreMvpView<M>, P : MvpPresenter<V>, A : BaseAdapter<M>> : CBFragmentMvpListRecyclerViewViewState<M, V, P, A>(), ILoadMoreMvpView<M> {

  protected var loadMoreUrlString: String? = null
  protected var listData: MutableList<M>? = null

  lateinit private var loadMoreScrollListener: LoadMoreScrollListener

  override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    loadMoreScrollListener = LoadMoreScrollListener(contentView.layoutManager as LinearLayoutManager) {
      if (loadMoreUrlString?.isNotBlank() ?: false) {
        loadMore(loadMoreUrlString)
      }
    }
    contentView.addOnScrollListener(loadMoreScrollListener);
  }

  override fun getData(): MutableList<M>? = listData

  override fun setData(data: MutableList<M>?) {
    val itemsAlreadyInListCount = adapter.itemCount

    adapter.addNewDataList(data, itemsAlreadyInListCount > 0)
    this.listData = adapter.getItems() as MutableList<M>;
    var newItemsCount = data?.size ?: 0

    if (itemsAlreadyInListCount == 0) {
      adapter.notifyDataSetChanged()
    } else {
      adapter.notifyItemRangeInserted(itemsAlreadyInListCount, newItemsCount)
    }

    loadMoreScrollListener.isLoading = false;
  }

  override fun setLoadMoreUrl(loadMoreUrl: String?) {
    this.loadMoreUrlString = loadMoreUrl
  }

  abstract fun loadMore(loadMoreUrl: String?)
}