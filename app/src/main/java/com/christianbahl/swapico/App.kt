package com.christianbahl.swapico

import android.app.Application
import com.christianbahl.swapico.api.SwapiApi
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.android.KodeinApplication
import com.github.salomonbrys.kodein.singleton
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.logging.HttpLoggingInterceptor
import retrofit.GsonConverterFactory
import retrofit.Retrofit
import retrofit.RxJavaCallAdapterFactory

/**
 * @author Christian Bahl
 */
class App : Application(), KodeinApplication {

  val appModule = Kodein.Module {
    bind<SwapiApi>() with singleton {
      val logging = HttpLoggingInterceptor()
      logging.setLevel(HttpLoggingInterceptor.Level.BODY)

      val httpClient = OkHttpClient()
      httpClient.interceptors().add(logging)

      Retrofit.Builder().baseUrl("http://swapi.co/api/").addConverterFactory(
          GsonConverterFactory.create()).addCallAdapterFactory(
          RxJavaCallAdapterFactory.create()).client(httpClient).build().create(SwapiApi::class.java)
    }
  }

  override val kodein = Kodein {
    import(appModule)
  }
}