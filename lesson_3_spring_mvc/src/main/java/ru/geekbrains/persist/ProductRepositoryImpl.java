package ru.geekbrains.persist;

import org.springframework.stereotype.Repository;
import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final Map<Long, Product> productMap = new ConcurrentHashMap<>();

    private final AtomicLong identity = new AtomicLong(0);

    @PostConstruct
    public void init(){
        this.save(new Product(1L,"Product 1",150F,""));
        this.save(new Product(2L,"Product 2",220F,""));
        this.save(new Product(3L,"Product 3",340F,""));
        this.save(new Product(4L,"Product 4",540F,""));
        this.save(new Product(5L,"Product 5",760F,""));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public Optional<Product> findById(long id) {
        return Optional.ofNullable(productMap.get(id));
    }

    @Override
    public void save(Product product) {
        if (product.getId() == null) {
            long id = identity.incrementAndGet();
            product.setId(id);
        }
        productMap.put(product.getId(), product);
    }

    @Override
    public void delete(long id) {
        productMap.remove(id);
    }
}
