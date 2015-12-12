package com.christianbahl.swapico.list

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.christianbahl.appkit.viewstate.fragment.CBFragmentMvpListRecyclerViewViewState
import com.christianbahl.swapico.App
import com.christianbahl.swapico.base.loadmore.LoadMoreScrollListener
import com.christianbahl.swapico.list.model.ListItem
import com.christianbahl.swapico.list.model.ListType
import com.hannesdorfmann.fragmentargs.FragmentArgs
import com.hannesdorfmann.fragmentargs.annotation.Arg
import com.hannesdorfmann.fragmentargs.annotation.FragmentWithArgs
import com.hannesdorfmann.mosby.mvp.viewstate.lce.LceViewState
import com.hannesdorfmann.mosby.mvp.viewstate.lce.data.RetainingLceViewState

/**
 * @author Christian Bahl
 */
@FragmentWithArgs
class ListFragment : CBFragmentMvpListRecyclerViewViewState<ListItem, ListView, ListPresenter, ListAdapter>(), ListView {

  lateinit private var loadMoreScrollListener: LoadMoreScrollListener
  lateinit private var listComponent: ListComponent

  private var listToRestore: MutableList<ListItem>? = null
  private var hasNextPage: Boolean = false;
  private var nextPage: Int = 1;

  @Arg lateinit var listType: ListType

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    retainInstance = true

    FragmentArgs.inject(this)

    val app = activity.applicationContext as App
    listComponent = DaggerListComponent.builder()
        .listModule(ListModule(listType))
        .netComponent(app.netComponent()).build()
  }

  override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    loadMoreScrollListener = LoadMoreScrollListener(contentView.layoutManager as LinearLayoutManager) {
      if (hasNextPage) {
        presenter.loadData(++nextPage, true)
      }
    }
    contentView.addOnScrollListener(loadMoreScrollListener);
  }

  override fun createViewState(): LceViewState<MutableList<ListItem>, ListView>? = RetainingLceViewState()

  override fun getData(): MutableList<ListItem>? = listToRestore

  override fun createPresenter(): ListPresenter? = listComponent.listPresenter()

  override fun createAdapter(): ListAdapter? = ListAdapter(activity) {
    Toast.makeText(activity, it, Toast.LENGTH_LONG).show()
  }

  override fun loadData(pullToRefresh: Boolean) = presenter.loadData(nextPage, pullToRefresh)

  override fun setData(data: MutableList<ListItem>?) {
    val itemsAlreadyInListCount = adapter.itemCount

    adapter.addNewDataList(data, itemsAlreadyInListCount > 0)
    this.listToRestore = adapter.getItems() as MutableList<ListItem>
    var newItemsCount = data?.size ?: 0

    if (itemsAlreadyInListCount == 0) {
      adapter.notifyDataSetChanged()
    } else {
      adapter.notifyItemRangeInserted(itemsAlreadyInListCount, newItemsCount)
    }

    loadMoreScrollListener.isLoading = false
  }

  override fun setHasNextPage(hasNextPage: Boolean) {
    this.hasNextPage = hasNextPage
  }
}