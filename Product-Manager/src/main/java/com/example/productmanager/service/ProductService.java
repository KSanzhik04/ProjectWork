package com.example.productmanager.service;


import com.example.productmanager.entity.Product;
import com.example.productmanager.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    private final String UPlOAD_DIR="uploads/";

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
        new File(UPlOAD_DIR).mkdirs();
    }
    public Product createProduct(String name, String description, MultipartFile image) throws  IOException{
        String imagePath = saveImage(image);
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setImagePath(imagePath);

        return productRepository.save(product);
    }
    public Optional<Product> getProduct(Long id){
        return productRepository.findById(id);
    }
    public Product updateProduct(Long id, String name, String description,  MultipartFile image) throws  IOException {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));

        if(name != null)product.setName(name);
        if(description != null) product.setDescription(description);
        if(image != null) product.setImagePath(saveImage(image));

        return  productRepository.save(product);
    }
    public  void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
    private String saveImage(MultipartFile image) throws  IOException{
        if(image.isEmpty()) return  null;

        String filename = System.currentTimeMillis() + "_"+ image.getOriginalFilename();
        Path filepath = Paths.get(UPlOAD_DIR, filename);
        Files.write(filepath, image.getBytes());

        return filepath.toString();

    }
}
