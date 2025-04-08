package com.phantandat.example16;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.carousel.CarouselLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView recViewSaleProducts, recViewNewProducts, recCover;
    private ProductAdapter newProductAdapter, saleProductAdapter;
    private CoverAdapter coverAdapter;
    private List<Product> newProductList, saleProductList;
    private List<Cover> coverList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recViewNewProducts = view.findViewById(R.id.newRecView);
        recViewSaleProducts = view.findViewById(R.id.saleRedView);
        recCover = view.findViewById(R.id.coverRecView);

        newProductList = new ArrayList<>();
        saleProductList = new ArrayList<>();
        coverList = new ArrayList<>();

        newProductList.add(new Product("iPhone 14 Pro Max", "Iphone", "30,000,000", R.drawable.ip_14prm));
        newProductList.add(new Product("Samsung Galaxy S23+", "Samsung", "23,000,000", R.drawable.galaxy_s23));
        newProductList.add(new Product("MacBook Pro M2", "Iphone", "40,000,000", R.drawable.ip_14));
        newProductList.add(new Product("Asus ROG Laptop", "Asus", "35,000,000", R.drawable.asus_rog));
        newProductList.add(new Product("Apple Watch Series 8", "Iphone", "12,000,000", R.drawable.apple_watch));

        newProductAdapter = new ProductAdapter(newProductList);
        recViewNewProducts.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recViewNewProducts.setAdapter(newProductAdapter);

        saleProductList.add(new Product("iPhone 14 Pro Max", "Iphone", "30,000,000", R.drawable.ip_14prm));
        saleProductList.add(new Product("Samsung Galaxy S23+", "Samsung", "23,000,000", R.drawable.galaxy_s23));
        saleProductList.add(new Product("MacBook Pro M2", "Iphone", "40,000,000", R.drawable.ip_14));
        saleProductList.add(new Product("Asus ROG Laptop", "Asus", "35,000,000", R.drawable.asus_rog));
        saleProductList.add(new Product("Apple Watch Series 8", "Iphone", "12,000,000", R.drawable.apple_watch));

        saleProductAdapter = new ProductAdapter(saleProductList);
        recViewSaleProducts.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recViewSaleProducts.setAdapter(saleProductAdapter);

        coverList.add(new Cover(R.drawable.ip_14prm));

        coverAdapter = new CoverAdapter(coverList);
        recCover.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recCover.setAdapter(coverAdapter);

        return view;
    }
}
