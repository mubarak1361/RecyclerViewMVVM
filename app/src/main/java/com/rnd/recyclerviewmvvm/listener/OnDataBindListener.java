package com.rnd.recyclerviewmvvm.listener;

/**
 * Created by CIPL0224 on 5/10/2017.
 */

public interface OnDataBindListener<V> {

    public void onItemClick(int position);
    public void onDataBind(V v,int position);
}
