package com.rnd.recyclerviewmvvm.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rnd.recyclerviewmvvm.BR;
import com.rnd.recyclerviewmvvm.ViewModel;
import com.rnd.recyclerviewmvvm.listener.OnDataBindListener;

import java.util.List;

/**
 * Created by CIPL0224 on 5/10/2017.
 */

public class AppRecyclerViewAdapter<T extends ViewModel> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<T>  items;
    private OnDataBindListener onDataBindListener;

    public AppRecyclerViewAdapter(List<T> items){
        this.items = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AppViewHolder<>(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),viewType,parent,false),onDataBindListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((AppViewHolder)holder).viewDataBinding.setVariable(BR.model,getItem(position));
        ((AppViewHolder)holder).viewDataBinding.executePendingBindings();
    }

    @Override
    public int getItemViewType(int position) {
         super.getItemViewType(position);
        return getItem(position).getLayoutResourceId();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public T getItem(int position){
        return  items.get(position);
    }

    public void setOnDataBindListener(OnDataBindListener onDataBindListener) {
        this.onDataBindListener = onDataBindListener;
    }

    private static class AppViewHolder<V extends ViewDataBinding> extends RecyclerView.ViewHolder implements View.OnClickListener{

        private V viewDataBinding;
        private OnDataBindListener onDataBindListener;

        public AppViewHolder(V viewDataBinding,OnDataBindListener onDataBindListener) {
            super(viewDataBinding.getRoot());

            this.viewDataBinding = viewDataBinding;
            this.onDataBindListener = onDataBindListener;

            if(onDataBindListener!=null){
                onDataBindListener.onDataBind(viewDataBinding,getAdapterPosition());
            }

            viewDataBinding.getRoot().setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(onDataBindListener!=null){
                onDataBindListener.onItemClick(getAdapterPosition());
            }
        }
    }
}
