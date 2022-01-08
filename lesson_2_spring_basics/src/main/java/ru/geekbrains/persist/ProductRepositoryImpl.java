package ru.geekbrains.persist;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> products = new ArrayList<>();

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public void delete(long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                products.remove(product);
            }
        }
    }
}
