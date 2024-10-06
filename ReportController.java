package com.example.mockcompanywebapp.controllers;

import com.example.mockcompanywebapp.models.ProductItem;
import com.example.mockcompanywebapp.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/search")
    public ResponseEntity<List<ProductItem>> reportSearch(@RequestParam("query") String query) {
        List<ProductItem> productItems = searchService.searchProducts(query);
        
        if (productItems.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(productItems);
    }
}
