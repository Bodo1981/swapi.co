package com.christianbahl.swapico

import android.app.Application
import com.christianbahl.swapico.injekt.AppModule
import uy.kohesive.injekt.Injekt

/**
 * @author Christian Bahl
 */
class App : Application() {

  override fun onCreate() {
    super.onCreate()

    Injekt.importModule(AppModule(this))
  }
}