package com.rnd.recyclerviewmvvm.controller;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by CIPL0224 on 5/10/2017.
 */

public abstract class DataBindActivity<V extends ViewDataBinding> extends AppCompatActivity {

    public abstract int getLayoutResourceId();
    private V viewDataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this,getLayoutResourceId());
    }

    public V getBindView(){
        return viewDataBinding;
    }
}
