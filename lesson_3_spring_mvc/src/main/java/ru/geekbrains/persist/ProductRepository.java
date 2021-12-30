package ru.geekbrains.persist;

import ru.geekbrains.persist.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> findAll();

    Optional<Product> findById(long id);

    void save(Product product);

    void delete(long id);
}
