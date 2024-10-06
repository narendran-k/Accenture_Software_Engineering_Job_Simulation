import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private ProductItemRepository productItemRepository;

    @GetMapping
    public ResponseEntity<List<ProductItem>> search(@RequestParam("query") String query) {
        // TODO: Implement the search functionality here
        if (query == null || query.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        
        List<ProductItem> productItems = productItemRepository.findByNameContainingIgnoreCase(query);
        if (productItems.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(productItems);
    }
}
