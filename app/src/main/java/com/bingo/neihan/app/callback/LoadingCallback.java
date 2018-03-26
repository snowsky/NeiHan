package com.bingo.neihan.app.callback;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.ImageView;

import com.bingo.neihan.R;
import com.kingja.loadsir.callback.Callback;

/**
 * <请描述这个类是干什么的>
 * Created by adou on 2018/3/26:22:31.
 *
 * @Email:634051075@qq.com
 */

public class LoadingCallback extends Callback
{
    private ImageView img_progress;
    private AnimationDrawable mAnimationDrawable;

    @Override
    protected int onCreateView()
    {
        return R.layout.loadingpage_state_loading;
    }

    @Override
    public boolean getSuccessVisible()
    {
        return super.getSuccessVisible();
    }

    @Override
    protected boolean onReloadEvent(Context context, View view)
    {
        return true;
    }


    @Override
    public void onAttach(Context context, View view)
    {
        super.onAttach(context, view);
        img_progress = view.getRootView().findViewById(R.id.img_progress);
        // 加载动画 这边也可以直接用progressbar
        mAnimationDrawable = (AnimationDrawable) img_progress.getDrawable();
        // 默认进入页面就开启动画
        startAnimation();
    }


    @Override
    public void onDetach()
    {
        super.onDetach();
        stopAnimation();
    }


    private void startAnimation()
    {
        if (!mAnimationDrawable.isRunning())
        {
            mAnimationDrawable.start();
        }
    }

    private void stopAnimation()
    {
        if (mAnimationDrawable != null && mAnimationDrawable.isRunning())
        {
            mAnimationDrawable.stop();
        }
    }

}
