package com.example.product.repositories;

import com.example.product.models.Product;
import com.example.product.repositories.rowmapper.ProductRowMapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {

    private static String TABLE;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ProductRowMapper rowMapper;

    public List<Product> findAll() {
        String sql = "SELECT * FROM " + TABLE + " ";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Transactional
    public Product save(Product entity) {
        String sql = "INSERT INTO " + TABLE + " (id, image, name, description, price, createdDate) ";
        sql += "VALUES (?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, entity.getId(), entity.getImage(), entity.getName(), entity.getDescription(), entity.getPrice(), entity.getCreatedDate());

        String query = "SELECT * FROM " + TABLE + " ";
        return jdbcTemplate.queryForObject(query, rowMapper);
    }
}
