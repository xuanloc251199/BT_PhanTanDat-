package com.phantandat.example16;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private List<Product> products;

    public ProductAdapter(List<Product> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = products.get(position);
        holder.txtProductName.setText(product.getName());
        holder.txtProductBrand.setText(product.getBrand());
        holder.txtProductPrice.setText(product.getPrice());
        holder.imgProduct.setImageResource(product.getImageResId());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgProduct;
        TextView txtProductName, txtProductPrice, txtProductBrand;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.productImage_singleProduct);
            txtProductName = itemView.findViewById(R.id.productName_singleProduct);
            txtProductBrand = itemView.findViewById(R.id.productBrandName_singleProduct);
            txtProductPrice = itemView.findViewById(R.id.productPrice_singleProduct);
        }
    }
}
