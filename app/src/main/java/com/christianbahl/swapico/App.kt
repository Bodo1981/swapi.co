package com.christianbahl.swapico

import android.app.Application
import com.christianbahl.swapico.dagger.DaggerNetComponent
import com.christianbahl.swapico.dagger.NetComponent

/**
 * @author Christian Bahl
 */
class App : Application() {

  lateinit private var netComponent: NetComponent

  override fun onCreate() {
    super.onCreate()

    netComponent = DaggerNetComponent.builder().appModule(AppModule(this)).build()
  }

  fun netComponent() = netComponent
}