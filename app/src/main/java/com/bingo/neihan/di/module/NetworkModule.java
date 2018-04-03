package com.bingo.neihan.di.module;


import com.bingo.neihan.app.App;

import dagger.Module;

/**
 *
 * Created by WangWB on 2018/04/03  10:14.
 */
@Module
public class NetworkModule {

    private App mApp;

    public NetworkModule(App app)
    {
        this.mApp = app;
    }




}
