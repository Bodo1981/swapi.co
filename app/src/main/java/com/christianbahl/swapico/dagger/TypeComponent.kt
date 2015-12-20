package com.christianbahl.swapico.list

import com.christianbahl.swapico.dagger.Activity
import com.christianbahl.swapico.dagger.NetComponent
import com.christianbahl.swapico.details.DetailsPresenter
import dagger.Component

/**
 * @author Christian Bahl
 */
@Activity @Component(dependencies = arrayOf(NetComponent::class), modules = arrayOf(TypeModule::class)) interface TypeComponent {

  fun listPresenter(): ListPresenter
  fun detailsPresenter(): DetailsPresenter

}