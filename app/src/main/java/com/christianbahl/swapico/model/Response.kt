package com.christianbahl.swapico.model

import com.christianbahl.swapico.base.loadmore.ILoadMoreResult

/**
 * @author Christian Bahl
 */
data class Result<M>(val count: Int,
                         val next: String?,
                         val previous: String?,
                         val results: MutableList<M>) : ILoadMoreResult {

  override val loadMore: Boolean
    get() = next?.isNotBlank() ?: false

  override val adapterList: MutableList<Any>?
    get() = results as MutableList<Any>

}