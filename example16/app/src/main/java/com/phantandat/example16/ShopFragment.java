package com.phantandat.example16;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ShopFragment extends Fragment {
    private RecyclerView recyclerViewCategory, recyclerViewProducts;
    private CategoryAdapter categoryAdapter;
    private ProductAdapter productAdapter;
    private List<Category> categoryList;
    private List<Product> productList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop, container, false);

        // Ánh xạ RecyclerView
        recyclerViewCategory = view.findViewById(R.id.categoriesRecView);
        recyclerViewProducts = view.findViewById(R.id.hotRecView_shopFrag);

        // Khởi tạo danh sách
        categoryList = new ArrayList<>();
        productList = new ArrayList<>();

        // Thêm dữ liệu danh mục
        categoryList.add(new Category("Điện thoại", R.drawable.ic_phone));
        categoryList.add(new Category("Laptop", R.drawable.ic_laptop));
        categoryList.add(new Category("Tablet", R.drawable.ic_tablet));
        categoryList.add(new Category("Đồng hồ", R.drawable.ic_watch));
        categoryList.add(new Category("PC-Máy in", R.drawable.ic_pc));
        categoryList.add(new Category("Phụ kiện", R.drawable.ic_headphone));

        // Thêm dữ liệu sản phẩm
        productList.add(new Product("iPhone 14 Pro Max", "Iphone", "30,000,000", R.drawable.ip_14prm));
        productList.add(new Product("Samsung Galaxy S23+", "Samsung", "23,000,000", R.drawable.galaxy_s23));
        productList.add(new Product("MacBook Pro M2", "Iphone", "40,000,000", R.drawable.ip_14));
        productList.add(new Product("Asus ROG Laptop", "Asus", "35,000,000", R.drawable.asus_rog));
        productList.add(new Product("Apple Watch Series 8", "Iphone", "12,000,000", R.drawable.apple_watch));

        // Cấu hình RecyclerView danh mục
        categoryAdapter = new CategoryAdapter(categoryList);
        recyclerViewCategory.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerViewCategory.setAdapter(categoryAdapter);

        // Cấu hình RecyclerView sản phẩm
        productAdapter = new ProductAdapter(productList);
        recyclerViewProducts.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerViewProducts.setAdapter(productAdapter);

        return view;
    }
}
