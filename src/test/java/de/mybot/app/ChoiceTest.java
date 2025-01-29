package de.mybot.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import de.mybot.app.data.Issue;
import de.mybot.app.data.Product;
import de.mybot.app.service.GeneralService;
import de.mybot.app.service.ProductService;

public class ChoiceTest {
    private final GeneralService generalService = new GeneralService();
    private final ProductService productService = new ProductService();

    @Test
    void testGetIssueByChoice_validChoice() {
        Issue result = generalService.getIssueByChoice(2);

        assertNotNull(result, "The issue should not be null.");
        assertEquals(2, result.getId(), "The issue ID should be 2.");
        assertEquals("App-/Softwarefehler", result.getDescription(), "The issue name should be 'App-/Softwarefehler'.");
    }

    @Test
    void testGetIssueByChoice_invalidChoice() {
        Issue result = generalService.getIssueByChoice(999);

        assertNull(result, "The result should be null for an invalid choice.");
    }

    @Test
    void testGetProductByChoice_validChoice() {
        Product result = productService.getProductByChoice(2);

        assertNotNull(result, "The product should not be null.");
        assertEquals(2, result.getId(), "The product ID should be 2.");
        assertEquals("Windowfly", result.getName(), "The product name should be 'Windowfly'.");
    }

    @Test
    void testGetProductByChoice_invalidChoice() {
        Product result = productService.getProductByChoice(999);

        assertNull(result, "The result should be null for an invalid choice.");
    }
}
