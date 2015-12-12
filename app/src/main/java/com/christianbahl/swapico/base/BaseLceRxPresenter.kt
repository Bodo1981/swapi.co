package com.christianbahl.swapico.base

import com.christianbahl.appkit.rx.presenter.CBLceRxPresenter
import com.christianbahl.swapico.api.SwapiApi
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView

/**
 * @author Christian Bahl
 */
abstract class BaseLceRxPresenter<V : MvpLceView<M>, M>(protected val swapiApi: SwapiApi) : CBLceRxPresenter<V, M>() {

}