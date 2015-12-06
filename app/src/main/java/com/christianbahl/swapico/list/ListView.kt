package com.christianbahl.swapico.list

import com.christianbahl.appkit.core.common.view.CBMvpView
import com.christianbahl.swapico.list.model.ListItem

/**
 * @author Christian Bahl
 */
interface ListView : CBMvpView<ListItem> {

  fun setHasNextPage(hasNextPage: Boolean)

}