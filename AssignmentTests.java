package com.itsmdsh.assignment;

import com.itsmdsh.assignment.service.ConfigService;
import com.itsmdsh.assignment.service.PriceService;
// These are the standard JUnit 5 imports for Spring Boot 2.7
import org.junit.jupiter.api.Test; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest
class AssignmentTests {

    @Autowired
    private ConfigService configService;

    @Autowired
    private PriceService priceService;

    @Test
    void testConfigService() {
        // Test if the "Order Service" section is parsed correctly
        assertNotNull(configService.getConfig("Order Service"), "Config should not be null");
    }

    @Test
    void testPriceServiceLogic() {
        // Test the exact scenario that gave you "99"
        String price = priceService.findPrice("u00006541", "10:05");
        assertEquals("99", price, "The price at 10:05 should be 99");
        
        // Test a time where no price exists
        String noPrice = priceService.findPrice("u00006541", "01:00");
        assertEquals("NOT SET", noPrice);
    }
}