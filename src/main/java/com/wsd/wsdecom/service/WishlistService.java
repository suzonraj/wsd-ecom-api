package com.wsd.wsdecom.service;

import com.wsd.wsdecom.util.response.ResponseDto;

public interface WishlistService {
  ResponseDto<Object> getCustomerWishlist(Long customerId);
}
