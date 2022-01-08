package ru.geekbrains;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepository;

import javax.annotation.PostConstruct;

@Service
public class ProductServise {

    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    public void init(){
        productRepository.save(new Product(1L,"Product 1",100F));
        productRepository.save(new Product(2L,"Product 2",150F));
        productRepository.save(new Product(3L,"Product 3",160F));
        productRepository.save(new Product(4L,"Product 4",220F));
        productRepository.save(new Product(5L,"Product 5",280F));

    }

    public long count(){
        return productRepository.findAll().size();

    }
}
