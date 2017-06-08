package com.rnd.recyclerviewmvvm.listener;

import android.view.View;

/**
 * Created by CIPL0224 on 5/10/2017.
 */

public interface OnDataBindListener<V> {

    public void onItemClick(View view,int position);
    public void onDataBind(V v, View.OnClickListener onClickListener);
}
