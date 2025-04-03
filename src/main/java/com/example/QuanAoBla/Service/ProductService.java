package com.example.QuanAoBla.Service;

import com.example.QuanAoBla.Entity.Product;
import com.example.QuanAoBla.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Lấy tất cả sản phẩm
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Lấy sản phẩm theo ID
    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    // Thêm sản phẩm
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    // Cập nhật sản phẩm
    public void updateProduct(Long id, Product product) {
        if (productRepository.existsById(id)) {
            product.setId(id);
            productRepository.save(product);
        }
    }

    // Xóa sản phẩm
    public void deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        }
    }

}
