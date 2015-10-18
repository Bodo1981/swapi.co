package com.christianbahl.swapico

import com.christianbahl.appkit.core.activity.CBActivityMvpToolbarTabs
import com.christianbahl.appkit.core.common.view.CBMvpView
import com.christianbahl.swapico.model.TabData

class MainActivity : CBActivityMvpToolbarTabs<List<TabData>, CBMvpView<TabData>, MainPresenter, MainAdapter>(), CBMvpView<TabData> {

  override fun createPresenter(): MainPresenter? {
    return MainPresenter(this)
  }

  override fun createAdapter(): MainAdapter? {
    return MainAdapter(supportFragmentManager)
  }

  override fun loadData(pullToRefresh: Boolean) {
    presenter.loadData(pullToRefresh)
  }

  override fun setData(data: List<TabData>?) {
    adapter.items = data
    adapter.notifyDataSetChanged()
    tabs.setTabsFromPagerAdapter(adapter)
  }
}
