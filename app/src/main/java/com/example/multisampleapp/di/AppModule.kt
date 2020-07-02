package com.example.multisampleapp.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.multisampleapp.MainActivity
import com.example.multisampleapp.MainViewModel
import com.example.multisampleapp.repository.SomeRepository
import com.example.multisampleapp.repository.SomeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
interface AppModule {

    @Binds
    fun bindViewModelFactory(impl: DaggerViewModelFactory): ViewModelProvider.Factory

    @Binds
    fun bindSomeRepository(impl: SomeRepositoryImpl) : SomeRepository

    @ContributesAndroidInjector
    fun contributeMainActivity() : MainActivity

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(impl: MainViewModel) : ViewModel
}
