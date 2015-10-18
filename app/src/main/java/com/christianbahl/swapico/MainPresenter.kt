package com.christianbahl.swapico

import android.content.Context
import com.christianbahl.appkit.core.common.view.CBMvpView
import com.christianbahl.swapico.model.TabData
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter

/**
 * @author Christian Bahl
 */
class MainPresenter(val context: Context) : MvpBasePresenter<CBMvpView<TabData>>() {

  public fun loadData(contentPresent: Boolean) {
    view?.showLoading(contentPresent)

    view.setData(getTabData())
    view.showContent()
  }

  private fun getTabData(): List<TabData> {
    return listOf(TabData(TabData.Type.FILMS, context.getString(R.string.tab_films)),
                  TabData(TabData.Type.PEOPLE, context.getString(R.string.tab_people)),
                  TabData(TabData.Type.PLANETS, context.getString(R.string.tab_planets)),
                  TabData(TabData.Type.SPECIES, context.getString(R.string.tab_species)),
                  TabData(TabData.Type.STARSHIPS, context.getString(R.string.tab_starships)),
                  TabData(TabData.Type.VEHICLES, context.getString(R.string.tab_vehicles)))
  }
}