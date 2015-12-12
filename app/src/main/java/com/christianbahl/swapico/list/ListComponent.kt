package com.christianbahl.swapico.list

import com.christianbahl.swapico.dagger.Activity
import com.christianbahl.swapico.dagger.NetComponent
import dagger.Component

/**
 * @author Christian Bahl
 */
@Activity @Component(dependencies = arrayOf(NetComponent::class), modules = arrayOf(ListModule::class)) interface ListComponent {

  fun listPresenter(): ListPresenter

}