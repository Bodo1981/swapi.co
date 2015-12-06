package com.christianbahl.swapico.base

import com.christianbahl.appkit.rx.presenter.CBLceRxPresenter
import com.christianbahl.swapico.api.SwapiApi
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.lazyInstance
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView

/**
 * @author Christian Bahl
 */
abstract class BaseLceRxPresenter<V : MvpLceView<M>, M>(protected val kodein: Kodein) : CBLceRxPresenter<V, M>() {

  protected val swapiApi by kodein.lazyInstance<SwapiApi>()

}