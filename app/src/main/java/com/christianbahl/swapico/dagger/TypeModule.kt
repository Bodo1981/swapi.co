package com.christianbahl.swapico.list

import com.christianbahl.swapico.dagger.Activity
import com.christianbahl.swapico.list.model.ListType
import dagger.Module
import dagger.Provides

/**
 * @author Christian Bahl
 */
@Module class TypeModule(val listType: ListType) {

  @Provides @Activity fun provideListType() = listType
}