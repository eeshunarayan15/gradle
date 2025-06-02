package com.example.demo;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import java.io.IOException;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private final OkHttpClient client = new OkHttpClient();
	private final String url = "https://fakestoreapi.com/products";

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		fetchProducts();
	}

	private void fetchProducts() {
		Request request = new Request.Builder()
				.url(url)
				.build();

		try (Response response = client.newCall(request).execute()) {
			if (response.isSuccessful() && response.body() != null) {
				String responseBody = response.body().string();
				System.out.println("API Response: " + responseBody);
			} else {
				System.err.println("Request failed: " + response.code());
			}
		} catch (IOException ex) {
			System.err.println("Error making HTTP request: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}