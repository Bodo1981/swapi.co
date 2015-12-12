package com.christianbahl.swapico.dagger

import com.christianbahl.swapico.AppModule
import com.christianbahl.swapico.api.SwapiApi
import dagger.Component
import javax.inject.Singleton

/**
 * @author Christian Bahl
 */
@Singleton @Component(modules = arrayOf(AppModule::class)) interface NetComponent {

  fun swapiApi(): SwapiApi

}