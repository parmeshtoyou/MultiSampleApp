package com.example.multisampleapp.di

import com.example.multisampleapp.MultiSampleApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class])
interface AppComponent: AndroidInjector<MultiSampleApp> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: MultiSampleApp): AppComponent
    }
}