package com.example.demo;

public class Product {
    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    private Rating rating;

    // Default constructor
    public Product() {
    }

    // Constructor with all fields
    public Product(int id, String title, double price, String description,
                   String category, String image, Rating rating) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.category = category;
        this.image = image;
        this.rating = rating;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getImage() {
        return image;
    }

    public Rating getRating() {
        return rating;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    // toString method
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", image='" + image + '\'' +
                ", rating=" + rating +
                '}';
    }

    // equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return id == product.id;
    }

    // hashCode method
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    // Nested Rating class
    public static class Rating {
        private double rate;
        private int count;

        // Default constructor
        public Rating() {
        }

        // Constructor with fields
        public Rating(double rate, int count) {
            this.rate = rate;
            this.count = count;
        }

        // Getters
        public double getRate() {
            return rate;
        }

        public int getCount() {
            return count;
        }

        // Setters
        public void setRate(double rate) {
            this.rate = rate;
        }

        public void setCount(int count) {
            this.count = count;
        }

        // toString method
        @Override
        public String toString() {
            return "Rating{" +
                    "rate=" + rate +
                    ", count=" + count +
                    '}';
        }

        // equals method
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Rating rating = (Rating) obj;
            return Double.compare(rating.rate, rate) == 0 && count == rating.count;
        }

        // hashCode method
        @Override
        public int hashCode() {
            return Double.hashCode(rate) * 31 + Integer.hashCode(count);
        }
    }
}