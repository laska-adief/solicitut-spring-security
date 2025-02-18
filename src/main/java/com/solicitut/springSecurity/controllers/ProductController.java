package com.solicitut.springSecurity.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {

  public record Product(String productId, String productName, double productPrice) {}

  List<Product> products = new ArrayList<>(
    List.of(
      new Product("1", "Laptop", 12000000),
      new Product("2", "Phone", 5000000)
    )
  );

  @GetMapping("list")
  public List<Product> getProducts() {
    return products;
  }

  @PostMapping("add")
  public Product addProduct(@RequestBody Product product) {
    products.add(product);
    return product;
  }

}
