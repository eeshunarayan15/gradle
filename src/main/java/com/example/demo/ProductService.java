package com.example.demo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import java.util.List;

public interface ProductService {

    // Get all products
    @GET("products")
    Call<List<Product>> getAllProducts();

    // Get single product by ID
    @GET("products/{id}")
    Call<Product> getProductById(@Path("id") int id);

    // Get products by category
    @GET("products/category/{category}")
    Call<List<Product>> getProductsByCategory(@Path("category") String category);
}