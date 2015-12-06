package com.christianbahl.swapico

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.christianbahl.swapico.films.FilmsFragment
import com.christianbahl.swapico.model.TabData
import com.christianbahl.swapico.people.PeopleFragment
import com.christianbahl.swapico.planets.PlanetFragment
import com.christianbahl.swapico.species.SpeciesFragment
import com.christianbahl.swapico.vehicles.VehiclesFragment

/**
 * @author Christian Bahl
 */
class MainAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

  var items: List<TabData>? = null

  override fun getCount() = items?.size ?: 0

  override fun getItem(position: Int): Fragment? {
    when(position) {
      0 -> return FilmsFragment()
      1 -> return PeopleFragment()
      2 -> return PlanetFragment()
      3 -> return SpeciesFragment()
      5 -> return VehiclesFragment()
      else -> return FilmsFragment()
    }
  }

  override fun getPageTitle(position: Int) = items?.get(position)?.title
}