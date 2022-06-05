package ru.JavaPersistenceAPI;

import java.util.List;

public interface ProductDao {

    List<Product> findAllExample();

    Product findByIdExample(Long id);
    void saveExample(Product product);
    void deleteExample(Long id);
}
