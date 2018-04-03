package com.bingo.neihan.di.component;

import android.app.Application;

import com.bingo.neihan.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 *
 * Created by WangWB on 2018/04/03  10:11.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    Application application();

}
