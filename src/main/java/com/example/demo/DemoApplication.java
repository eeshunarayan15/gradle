package com.example.demo;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private final OkHttpClient client = new OkHttpClient();
	private final String url = "https://fakestoreapi.com/products";
	private final String baseUrl = "https://fakestoreapi.com/"; // Added trailing slash

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		fetchProducts();
		fetchProductsWithRetrofit();
		fetchSingleProduct(1); // Fetch product with ID 1
	}

	private void fetchProducts() {
		Request request = new Request.Builder()
				.url(url)
				.build();

		try (Response response = client.newCall(request).execute()) {
			if (response.isSuccessful() && response.body() != null) {
				String responseBody = response.body().string();
				System.out.println("OkHttp - Products fetched successfully");
				// Uncomment to see full response
				// System.out.println("API Response: " + responseBody);
			} else {
				System.err.println("Request failed: " + response.code());
			}
		} catch (IOException ex) {
			System.err.println("Error making HTTP request: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	private void fetchProductsWithRetrofit() throws IOException {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(baseUrl) // Must end with /
				.addConverterFactory(GsonConverterFactory.create())
				.build();

		ProductService service = retrofit.create(ProductService.class);

		// Fetch all products
		List<Product> products = service.getAllProducts().execute().body();

		if (products != null && !products.isEmpty()) {
			System.out.println("Retrofit - Found " + products.size() + " products");
			System.out.println("First product: " + products.get(0).toString());
		} else {
			System.out.println("No products found");
		}
	}

	private void fetchSingleProduct(int id) throws IOException {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(baseUrl)
				.addConverterFactory(GsonConverterFactory.create())
				.build();

		ProductService service = retrofit.create(ProductService.class);

		// Fetch single product by ID
		Product product = service.getProductById(id).execute().body();

		if (product != null) {
			System.out.println("Single product with ID " + id + ": " + product.toString());
		} else {
			System.out.println("No product found with ID: " + id);
		}
	}
}
