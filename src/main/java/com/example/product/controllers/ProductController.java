package com.example.product.controllers;

import com.example.product.models.Product;
import com.example.product.models.template.RequestBodyModel;
import com.example.product.models.template.ResponseBodyModel;
import com.example.product.services.ProductService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired @Setter
    private ProductService productService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<ResponseBodyModel<List<Product>>> get(RequestBodyModel<Product> request) {
        ResponseBodyModel<List<Product>> response = new ResponseBodyModel<>();

        List<Product> list = productService.findAll();

        response.setStatus(true);
        response.setObjectValue(list);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<ResponseBodyModel<Product>> save(RequestBodyModel<Product> request) {
        ResponseBodyModel<Product> response = new ResponseBodyModel<>();

        Product requestObject = request.getObjectValue();
        Product list = productService.save(requestObject);

        response.setStatus(true);
        response.setObjectValue(list);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
