package com.bingo.neihan.app;

import android.app.Application;
import android.content.Context;

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
}
