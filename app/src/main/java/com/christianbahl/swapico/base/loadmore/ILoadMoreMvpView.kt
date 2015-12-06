package com.christianbahl.swapico.base.loadmore

import com.christianbahl.appkit.core.common.view.CBMvpView

/**
 * @author Christian Bahl
 */
interface ILoadMoreMvpView<M> : CBMvpView<M> {

  fun setLoadMoreUrl(loadMoreUrl: String?)

}