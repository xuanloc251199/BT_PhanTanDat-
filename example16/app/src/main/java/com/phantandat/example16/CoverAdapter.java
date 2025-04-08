package com.phantandat.example16;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CoverAdapter extends RecyclerView.Adapter<CoverAdapter.ViewHolder> {
    private List<Cover> covers;

    public CoverAdapter(List<Cover> products) {
        this.covers = products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cover_single, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Cover product = covers.get(position);
        holder.imgProduct.setImageResource(product.getImageResId());
    }

    @Override
    public int getItemCount() {
        return covers.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgProduct;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.productImage_coverPage);
        }
    }
}
