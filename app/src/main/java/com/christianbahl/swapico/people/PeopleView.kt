package com.christianbahl.swapico.people

import com.christianbahl.appkit.core.common.view.CBMvpView
import com.christianbahl.swapico.people.model.IPeopleResponseData

/**
 * @author Christian Bahl
 */
interface PeopleView : CBMvpView<IPeopleResponseData> {

  fun setLoadMoreUrl(loadMoreUrl: String?)
}