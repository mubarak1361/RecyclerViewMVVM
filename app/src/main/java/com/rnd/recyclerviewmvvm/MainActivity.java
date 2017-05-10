package com.rnd.recyclerviewmvvm;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.rnd.recyclerviewmvvm.adapter.AppRecyclerViewAdapter;
import com.rnd.recyclerviewmvvm.databinding.ActivityMainBinding;
import com.rnd.recyclerviewmvvm.databinding.ListItemPostBinding;
import com.rnd.recyclerviewmvvm.controller.DataBindActivity;
import com.rnd.recyclerviewmvvm.listener.OnDataBindListener;
import com.rnd.recyclerviewmvvm.model.Post;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends DataBindActivity<ActivityMainBinding> implements OnDataBindListener<ListItemPostBinding> {

    private Context context;
    private AppRecyclerViewAdapter<Post> postAppRecyclerViewAdapter;

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        List<Post> postList = new ArrayList<>();
        Post post = new Post();
        post.setTitle("New Ttile");
        post.setBody("New Body");
        postList.add(post);
        postAppRecyclerViewAdapter = new AppRecyclerViewAdapter<>(postList);
        postAppRecyclerViewAdapter.setOnDataBindListener(this);
        getBindView().recyclerViewPost.setAdapter(postAppRecyclerViewAdapter);

    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(this, "Item "+ position +" Clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDataBind(ListItemPostBinding listItemPostBinding,final int position) {
        listItemPostBinding.textViewTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, postAppRecyclerViewAdapter.getItem(position).getTitle() +" Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        listItemPostBinding.textViewBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, postAppRecyclerViewAdapter.getItem(position).getBody() +" Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
