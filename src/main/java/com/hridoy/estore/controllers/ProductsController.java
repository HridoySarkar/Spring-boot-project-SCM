package com.hridoy.estore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hridoy.estore.models.product;
import com.hridoy.estore.services.ProductsRepository;

@Controller
@RequestMapping("/products")
public class ProductsController {
    
    @Autowired
    private ProductsRepository repo;
    
    @GetMapping({"","/"})
    public String showProductList(Model model) {
        List<product> products = repo.findAll(Sort.by(Sort.Direction.DESC,"id"));
        model.addAttribute("products",products);
        return "/product/index";
    }
}
