package main.java.com.example.travel_agency.controllers;

import main.java.com.example.travel_agency.services.CheckoutService;
import main.java.com.example.travel_agency.services.PurchaseData;
import main.java.com.example.travel_agency.services.PurchaseResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkout")
@CrossOrigin("http://localhost:4200")
public class CheckoutController {

    private CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody PurchaseData purchaseData) {
        return checkoutService.placeOrder(purchaseData);
    }
}
