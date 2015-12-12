package com.christianbahl.swapico

import android.app.Application
import android.content.Context
import com.christianbahl.swapico.api.SwapiApi
import com.squareup.okhttp.Cache
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.logging.HttpLoggingInterceptor
import dagger.Module
import dagger.Provides
import retrofit.GsonConverterFactory
import retrofit.Retrofit
import retrofit.RxJavaCallAdapterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * @author Christian Bahl
 */
@Module class AppModule(private val application: Application) {

  companion object {
    val HTTP_RESPONSE_DISK_CACHE_MAX_SIZE: Long = 10 * 1024 * 1024
    val DEFAULT_CONNECT_TIMEOUT_MILLIS: Long = 15 * 1000
    val DEFAULT_READ_TIMEOUT_MILLIS: Long = 20 * 1000
    val DEFAULT_WRITE_TIMEOUT_MILLIS: Long = 20 * 1000
  }

  @Provides @Singleton fun provideApplicationContext() = application

  @Provides @Singleton fun provideContext(): Context = application

  @Provides @Singleton fun provideSwapiApi(okHttpClient: OkHttpClient) =
      Retrofit.Builder().baseUrl("http://swapi.co/api/").addConverterFactory(
          GsonConverterFactory.create()).addCallAdapterFactory(
          RxJavaCallAdapterFactory.create()).client(okHttpClient).build().create(SwapiApi::class.java)

  @Provides @Singleton fun provideOkHttpClient(context: Context): OkHttpClient {
    val logging = HttpLoggingInterceptor()
    logging.setLevel(HttpLoggingInterceptor.Level.BODY)

    val okHttpClient = OkHttpClient()
    okHttpClient.setConnectTimeout(DEFAULT_CONNECT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
    okHttpClient.setReadTimeout(DEFAULT_READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
    okHttpClient.setWriteTimeout(DEFAULT_WRITE_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
    okHttpClient.interceptors().add(logging)

    val baseDir = context.cacheDir;
    if (baseDir != null) {
      val cacheDir = File(baseDir, "HttpResponseCache")
      okHttpClient.setCache(Cache(cacheDir, HTTP_RESPONSE_DISK_CACHE_MAX_SIZE))
    }

    return okHttpClient;
  }
}