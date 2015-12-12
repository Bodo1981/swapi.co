package com.christianbahl.swapico.list

import com.christianbahl.swapico.list.model.ListType
import dagger.Module
import dagger.Provides

/**
 * @author Christian Bahl
 */
@Module class ListModule(val listType: ListType) {

  @Provides fun provideListType() = listType
}