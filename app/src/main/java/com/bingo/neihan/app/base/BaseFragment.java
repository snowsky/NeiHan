package com.bingo.neihan.app.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;

/**
 * <Fragment基类，封装了懒加载的实现>
 * Created by WangWB on 2018/03/23  15:40.
 * <p>
 * Viewpager + Fragment情况下，fragment的生命周期因Viewpager的缓存机制而失去了具体意义
 * 该抽象类自定义新的回调方法，
 * 方法1、当fragment可见状态改变时会触发的回调方法
 * 方法2、fragment第一次可见时会回调的方法(避免重复加载数据)
 */

public abstract class BaseFragment extends Fragment
{

    protected final String TAG = this.getClass().getSimpleName();

    private boolean isViewCreated;  //Fragment的View加载完毕的标记
    private boolean isVisibleToUser;//fragment是否显示了
    private boolean isDataInitiated;//是否已经数据初始化

    protected LoadService mBaseLoadService;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View rootView = View.inflate(getActivity(), getContentViewID(), null);

        mBaseLoadService = LoadSir.getDefault().register(rootView,
                (Callback.OnReloadListener) this::onNetReload);

        return mBaseLoadService.getLoadLayout();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        isViewCreated = true;
        lazyLoad();
    }

    /**
     * Description:
     * 该方法在fragment创建的时候(未显示的时候)会先被调用一次(在OnCreateView方法之前)，
     * 此时方法的形参isVisibleToUser = false
     * 当前Fragment可见时，该方法会再次被调用一次(还是在OnCreateView方法之前)，
     * 此时方法的形参isVisibleToUser = true
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser)
    {
        super.setUserVisibleHint(isVisibleToUser);

        Log.d("TAG", TAG + " setUserVisibleHint() --> isVisibleToUser = " + isVisibleToUser);

        this.isVisibleToUser = isVisibleToUser;
        lazyLoad();
    }

    public boolean lazyLoad()
    {
        return lazyLoad(false);
    }

    /**
     * Description:
     * forceUpdate为强制更新数据使用,避免只执行一次
     */
    public boolean lazyLoad(boolean forceUpdate)
    {
        if (isVisibleToUser && isViewCreated && (!isDataInitiated || forceUpdate))
        {
            lazyInitData();
            isDataInitiated = true;
            return true;
        }
        return false;
    }


    protected abstract int getContentViewID();

    protected abstract void onNetReload(View v);

    protected abstract void lazyInitData();

}
