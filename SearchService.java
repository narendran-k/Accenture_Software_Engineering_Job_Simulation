package com.example.mockcompanywebapp.services;

import com.example.mockcompanywebapp.repositories.ProductItemRepository;
import com.example.mockcompanywebapp.models.ProductItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    private ProductItemRepository productItemRepository;

    public List<ProductItem> searchProducts(String query) {
        if (query == null || query.trim().isEmpty()) {
            return List.of(); // Return an empty list if the query is invalid
        }

        return productItemRepository.findByNameContainingIgnoreCase(query);
    }
}
