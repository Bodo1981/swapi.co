package com.christianbahl.swapico

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.christianbahl.swapico.list.ListFragmentBuilder
import com.christianbahl.swapico.list.model.ListType
import com.christianbahl.swapico.model.TabData

/**
 * @author Christian Bahl
 */
class MainAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

  var items: List<TabData>? = null

  override fun getCount() = items?.size ?: 0

  override fun getItem(position: Int): Fragment? {
    when(position) {
      0 -> return ListFragmentBuilder(ListType.FILMS).build()
      1 -> return ListFragmentBuilder(ListType.PEOPLE).build()
      2 -> return ListFragmentBuilder(ListType.PLANETS).build()
      3 -> return ListFragmentBuilder(ListType.SPECIES).build()
      4 -> return ListFragmentBuilder(ListType.STARSHIPS).build()
      else -> return ListFragmentBuilder(ListType.VEHICLES).build()
    }
  }

  override fun getPageTitle(position: Int) = items?.get(position)?.title
}