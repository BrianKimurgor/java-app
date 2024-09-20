package edu.wgu.d288_backend.services;

import edu.wgu.d288_backend.entities.Cart;
import edu.wgu.d288_backend.entities.CartItem;
import edu.wgu.d288_backend.dao.CartRepository;
import edu.wgu.d288_backend.dao.CartItemRepository;
import edu.wgu.d288_backend.dao.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private static final Logger logger = LoggerFactory.getLogger(CheckoutServiceImpl.class);

    private final CustomerRepository customerRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository, CartItemRepository cartItemRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        if (purchase == null || purchase.getCart() == null || purchase.getCustomer() == null) {
            throw new IllegalArgumentException("Purchase, cart, and customer must not be null");
        }

        Cart cart = purchase.getCart();
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        // Save the customer to the database
        customerRepository.save(purchase.getCustomer());

        // Save the cart and cart items
        cartRepository.save(cart);
        for (CartItem cartItem : purchase.getCartItems()) {
            cartItem.setCart(cart); // Associate each cart item with the cart
            cartItemRepository.save(cartItem);
        }

        logger.info("Order placed successfully with tracking number: {}", orderTrackingNumber);
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
