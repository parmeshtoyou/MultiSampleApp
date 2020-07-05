package com.example.multisampleapp.di

import com.example.multisampleapp.repository.SomeRepository
import com.example.multisampleapp.repository.SomeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
interface AppModule {

    /*@Binds
    fun bindViewModelFactory(impl: DaggerViewModelFactory): ViewModelProvider.Factory*/

    @Binds
    fun bindSomeRepository(impl: SomeRepositoryImpl) : SomeRepository

   /* @ContributesAndroidInjector
    fun contributeMainActivity() : MainActivity

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(impl: MainViewModel) : ViewModel*/
}
