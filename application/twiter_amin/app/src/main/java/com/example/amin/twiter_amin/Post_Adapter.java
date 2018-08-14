package com.example.amin.twiter_amin;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Post_Adapter extends RecyclerView.Adapter<Post_Adapter.Post_viewHolder>
{

    private List<POSTS> postsList=new ArrayList<>();
    private Context context;


    public Post_Adapter(Context context, List<POSTS> articles1)
    {
        this.postsList =articles1;
        this.context = context;
    }

    @Override
    public Post_viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_post, parent, false);

        return new Post_viewHolder(view);
    }

    @Override
    public void onBindViewHolder(Post_viewHolder holder, int position) {
        holder.bindtextview(postsList.get(position));
    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }


    public class Post_viewHolder extends RecyclerView.ViewHolder
    {
        private TextView author;
        private TextView post;


        public Post_viewHolder(View itemView) {
            super(itemView);

            author=itemView.findViewById(R.id.txtv_author_item_post);
            post=itemView.findViewById(R.id.txtv_post_item_post);
        }

        public void bindtextview(POSTS posts)
        {
            author.setText(posts.getAuthor());
            post.setText(posts.getPost());

        }
    }
}
