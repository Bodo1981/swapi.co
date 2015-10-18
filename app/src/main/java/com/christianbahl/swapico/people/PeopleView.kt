package com.christianbahl.swapico.people

import com.christianbahl.appkit.core.common.view.CBMvpView
import com.christianbahl.swapico.people.model.PeopleResponse

/**
 * @author Christian Bahl
 */
interface PeopleView : CBMvpView<PeopleResponse> {

  fun setLoadMoreUrl(loadMoreUrl: String)
}