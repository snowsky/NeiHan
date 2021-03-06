package com.bingo.neihan.app;

import android.app.Application;
import android.content.Context;

import com.bingo.neihan.app.callback.EmptyCallback;
import com.bingo.neihan.app.callback.ErrorCallback;
import com.bingo.neihan.app.callback.LoadingCallback;
import com.kingja.loadsir.core.LoadSir;

/**
 * <请描述这个类是干什么的>
 * Created by WangWB on 2018/03/23  15:39.
 */

public class App extends Application
{

    @Override
    public void onCreate()
    {
        super.onCreate();
        initLoadingPage();
    }


    @Override
    protected void attachBaseContext(Context base)
    {
        super.attachBaseContext(base);
    }

    @Override
    public void onTerminate()
    {
        super.onTerminate();
    }


    private void initLoadingPage()
        {
            LoadSir.beginBuilder()
                    .addCallback(new ErrorCallback())
                    .addCallback(new EmptyCallback())
                    .addCallback(new LoadingCallback())
                    .setDefaultCallback(LoadingCallback.class)
                    .commit();
        }

}
