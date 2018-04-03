package com.bingo.neihan.di.module;

import android.app.Application;

import com.bingo.neihan.app.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 *
 * Created by WangWB on 2018/04/03  10:09.
 */
@Module
public class AppModule {

    private App mApp;

    public AppModule(App mApp) {
        this.mApp = mApp;
    }

    @Provides
    @Singleton
    public App provideApp() {
        return mApp;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return mApp;
    }
}
