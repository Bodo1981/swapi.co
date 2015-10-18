package com.christianbahl.swapico.injekt

import android.app.Application
import android.content.Context
import com.christianbahl.swapico.api.SwapiApi
import retrofit.GsonConverterFactory
import retrofit.Retrofit
import retrofit.RxJavaCallAdapterFactory
import uy.kohesive.injekt.api.InjektModule
import uy.kohesive.injekt.api.InjektRegistrar
import uy.kohesive.injekt.api.addSingleton
import uy.kohesive.injekt.api.addSingletonFactory

/**
 * @author Christian Bahl
 */
class AppModule(val app: Application) : InjektModule {

  override fun InjektRegistrar.registerInjectables() {
    addSingletonFactory<SwapiApi> {
      Retrofit.Builder().baseUrl("http://swapi.co/api/").addConverterFactory(
          GsonConverterFactory.create()).addCallAdapterFactory(
          RxJavaCallAdapterFactory.create()).build().create(SwapiApi::class.java)
    }

    addSingleton<Context>(app)
  }

}