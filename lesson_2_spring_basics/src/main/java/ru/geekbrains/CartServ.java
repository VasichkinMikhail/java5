package ru.geekbrains;

import ru.geekbrains.persist.Product;

import java.util.List;

public interface CartServ {
    List<Product> findAll();

    void addToCart(Product product);

    void removeFromCart(long id);
}
