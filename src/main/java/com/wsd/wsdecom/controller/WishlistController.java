package com.wsd.wsdecom.controller;

import com.wsd.wsdecom.service.WishlistService;
import com.wsd.wsdecom.util.response.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class WishlistController {
    private final WishlistService wishlistService;

    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @GetMapping("/wishlist/{customerId}")
    public ResponseEntity<?> getCustomerWishlist(@PathVariable("customerId") Long customerId) {
        return ResponseUtil.response(wishlistService.getCustomerWishlist(customerId));
    }

}
