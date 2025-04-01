package com.phantandat.example10;

import static java.security.AccessController.getContext;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewProducts;
    private ProductAdapter productAdapter;
    private List<Product> productList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_detail);

        recyclerViewProducts = findViewById(R.id.rv_Recommend);

        productList = new ArrayList<>();

        productList.add(new Product("iPhone 14 Pro", "Apple", "30,000,000", R.drawable.iphone14p));
        productList.add(new Product("iPhone 12", "Apple", "20,000,000", R.drawable.iphone12));
        productList.add(new Product("iPhone 11", "Apple", "10,000,000", R.drawable.iphone11));

        productAdapter = new ProductAdapter(productList);
        recyclerViewProducts.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewProducts.setAdapter(productAdapter);


    }
}