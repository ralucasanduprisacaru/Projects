package com.example.raluc.apicalltest.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.raluc.apicalltest.R;
import com.example.raluc.apicalltest.models.Album;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {
    private List<Album> albumList;


    public AlbumAdapter(List<Album> albumList) {
        this.albumList = albumList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.artist_detail, parent, false);


        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Album album = albumList.get(position);
        holder.tv_album_name.setText(album.getName());
    }

    @Override
    public int getItemCount() {return albumList.size();}


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_album_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_album_name = (TextView) itemView;
        }
    }
}
