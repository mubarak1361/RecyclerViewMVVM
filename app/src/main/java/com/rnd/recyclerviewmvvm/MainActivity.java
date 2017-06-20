package com.rnd.recyclerviewmvvm;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.rnd.recyclerviewmvvm.adapter.AppRecyclerViewAdapter;
import com.rnd.recyclerviewmvvm.databinding.ActivityMainBinding;
import com.rnd.recyclerviewmvvm.databinding.ListItemPostBinding;
import com.rnd.recyclerviewmvvm.controller.DataBindActivity;
import com.rnd.recyclerviewmvvm.listener.OnDataBindListener;
import com.rnd.recyclerviewmvvm.model.Post;
import com.yuva.bindingdata.Fonts;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends DataBindActivity<ActivityMainBinding> implements OnDataBindListener<ListItemPostBinding> {

    private Context context;
    private AppRecyclerViewAdapter<Post> postAppRecyclerViewAdapter;

    private List<Post> postList = new ArrayList<>();

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        addData();
        postAppRecyclerViewAdapter = new AppRecyclerViewAdapter<>(postList);
        postAppRecyclerViewAdapter.setOnDataBindListener(this);
        getBindView().recyclerViewPost.setLayoutManager(new LinearLayoutManager(this));
        getBindView().recyclerViewPost.setAdapter(postAppRecyclerViewAdapter);

    }

    @Override
    public void onItemClick(View view,int position) {
        switch (view.getId()){
            case R.id.text_view_title:
                Toast.makeText(context, postAppRecyclerViewAdapter.getItem(position).getTitle() +" Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.text_view_body:
                Toast.makeText(context, postAppRecyclerViewAdapter.getItem(position).getBody() +" Clicked", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "Item " + position + " Clicked", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    @Override
    public void onDataBind(ListItemPostBinding listItemPostBinding, View.OnClickListener onClickListener) {
        listItemPostBinding.textViewTitle.setOnClickListener(onClickListener);
        listItemPostBinding.textViewBody.setOnClickListener(onClickListener);
    }

    /*@BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        if (url == null) {
            imageView.setImageResource(R.drawable.ic_launcher);
        } else {
            Glide.with(imageView.getContext())
                    .load(url).crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageView);
        }
    }*/

    private void addData() {
        Fonts.getInstance(this).addFont("avenir", "Avenir-Next-Regular.ttf");
        Post post = new Post();
        post.setTitle("New Ttile 1");
        post.setBody("New Body 1");
        post.setImageUrl("https://wallpaperbrowse.com/media/images/Dubai-Photos-Images-Oicture-Dubai-Landmarks-800x600.jpg");
        postList.add(post);

        Post post1 = new Post();
        post1.setTitle("New Ttile 2");
        post1.setBody("New Body 2");
        post1.setImageUrl("https://www.w3schools.com/css/trolltunga.jpg");
        postList.add(post1);

        Post post2 = new Post();
        post2.setTitle("New Ttile 3");
        post2.setBody("New Body 3");
        post2.setImageUrl("http://www.nastol.com.ua/large/201406/101211.jpg");
        postList.add(post2);

        Post post3 = new Post();
        post3.setTitle("New Ttile 4");
        post3.setBody("New Body 4");
        post3.setImageUrl("http://mosaicon.hu/wallpapers/tigris/fullhd-hatterkep-tigris-52142619_largethumb.jpg");
        postList.add(post3);

        Post post4 = new Post();
        post4.setTitle("New Ttile 5");
        post4.setBody("New Body 5");
        post4.setImageUrl("http://www.thinkstockphotos.in/ts-resources/images/home/TS_AnonHP_462882495_01.jpg");
        postList.add(post4);
    }

}
