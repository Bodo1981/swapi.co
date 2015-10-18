package com.christianbahl.swapico.model

/**
 * @author Christian Bahl
 */
data class TabData(val type: TabData.Type, val title: String) {

  enum class Type {
    FILMS, PEOPLE, PLANETS, SPECIES, STARSHIPS, VEHICLES
  }

}