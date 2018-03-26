package com.bingo.neihan.app.callback;

import com.bingo.neihan.R;
import com.kingja.loadsir.callback.Callback;

/**
 * <请描述这个类是干什么的>
 * Created by adou on 2018/3/26:22:37.
 *
 * @Email:634051075@qq.com
 */

public class EmptyCallback extends Callback
{
    @Override
    protected int onCreateView()
    {
        return R.layout.loadingpage_state_empty;
    }
}
