package com.christianbahl.swapico.base

import com.christianbahl.appkit.rx.presenter.CBLceRxPresenter
import com.christianbahl.swapico.api.SwapiApi
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView
import uy.kohesive.injekt.injectLazy

/**
 * @author Christian Bahl
 */
open class BaseLceRxPresenter<V : MvpLceView<M>, M> : CBLceRxPresenter<V, M>() {

  protected val swapiApi by injectLazy<SwapiApi>()
}