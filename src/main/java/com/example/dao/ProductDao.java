package com.example.dao;

import com.example.entity.Product;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface ProductDao {
    //@Select("select * from product")
    List<Product> findAllProduct();
}