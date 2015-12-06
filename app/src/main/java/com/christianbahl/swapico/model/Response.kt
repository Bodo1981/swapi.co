package com.christianbahl.swapico.model

/**
 * @author Christian Bahl
 */
interface IListData {
  val name: String
  val url: String
}

open class Result<M : IListData>(val count: Int,
                                 val next: String?,
                                 val previous: String?,
                                 val results: MutableList<M>)