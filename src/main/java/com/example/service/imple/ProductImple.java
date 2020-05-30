package com.example.service.imple;

import com.example.dao.ProductDao;
import com.example.entity.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
/*
只用autowired是会报错的，一般我们要调用哪个service接口时需要加上autowired没错，但前提是得再这个service的实现类上加上service注解，也就是告诉spring，我这个service接口的实现类是这个，你帮我在spring容器里创建它。
这个注解是写在类上面的，标注将这个类交给Spring容器管理，spring容器要为他创建对象
*/
public class ProductImple implements ProductService {
    @Autowired
    /*
    @Autowired 是一个注释，它可以对类成员变量、方法及构造函数进行标注，让 spring 完成 bean 自动装配的工作。
    @Autowired 默认是按照类去匹配，配合 @Qualifier 指定按照名称去装配 bean。
     */
    private ProductDao productDao;
    @Override
    public List<Product> findAllProduct() {
        return productDao.findAllProduct();
    }
}
