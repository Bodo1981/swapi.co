package com.christianbahl.swapico.base

import android.content.Context
import android.view.LayoutInflater
import com.hannesdorfmann.adapterdelegates.AbsAdapterDelegate

/**
 * @author Christian Bahl
 */
abstract class BaseDelegate<T>(viewType: Int, val context: Context) : AbsAdapterDelegate<T>(viewType) {

  protected val inflater: LayoutInflater

  init {
    inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
  }
}