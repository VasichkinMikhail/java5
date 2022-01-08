package ru.geekbrains;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepository;
import ru.geekbrains.persist.ProductRepositoryImpl;

import java.util.*;

@Service
public class CartService implements CartServ {

    private List<Product> cartProducts = new ArrayList<>();

    ProductRepositoryImpl productRepository;

    @Autowired
    public CartService() {
        this.productRepository = productRepository;
    }

    public void addToCart(Product product) {
        cartProducts.add(product);
    }

    @Override
    public void removeFromCart(long id) {
        for (Product product : cartProducts) {
            if (product.getId().equals(id)) {
                cartProducts.remove(product);
            }
        }
    }
    @Override
    public List<Product> findAll() {
        return cartProducts;
    }

}
