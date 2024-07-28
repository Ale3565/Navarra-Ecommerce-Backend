package com.alexislevano.projectspring.controller;

import java.nio.file.Files;
import java.nio.file.Paths;

import com.alexislevano.projectspring.dao.ProductRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alexislevano.projectspring.entities.Product;

@CrossOrigin("*")
@RestController
public class ImagesController {
    private final ProductRepository productRepository;

    public ImagesController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(path = "/photoProduct/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception {
        Product p = productRepository.findById(id).get();
         return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/SpringAngAssets/products/"+p.getImgURL()));
    }

    @PostMapping(path = "/uploadPhoto/{id}")
    public void uploadPhoto(MultipartFile file, @PathVariable Long id) throws Exception {
        Product p = productRepository.findById(id).get();
        p.setImgURL(file.getOriginalFilename());
        Files.write(Paths.get(System.getProperty("user.home") + "/SpringAngAssets/products/" + p.getImgURL()), file.getBytes());
        productRepository.save(p);
    }
}
