package com.wsd.wsdecom.service;

import com.wsd.wsdecom.dto.ItemDto;
import com.wsd.wsdecom.dto.WishlistDto;
import com.wsd.wsdecom.dto.WishlistResponseDto;
import com.wsd.wsdecom.entity.Item;
import com.wsd.wsdecom.entity.Wishlist;
import com.wsd.wsdecom.mapper.ItemMapper;
import com.wsd.wsdecom.mapper.WishlistMapper;
import com.wsd.wsdecom.repository.WishlistRepository;
import com.wsd.wsdecom.util.response.ResponseCode;
import com.wsd.wsdecom.util.response.ResponseDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class IWishlistServiceImpl implements IWishlistService {

  private final WishlistRepository wishlistRepository;

  public IWishlistServiceImpl(WishlistRepository wishlistRepository) {
    this.wishlistRepository = wishlistRepository;
  }

  @Override
  public ResponseDto<Object> getCustomerWishlist(Long customerId) {
    ResponseDto<Object> response = new ResponseDto<>();

    List<Wishlist> wishlists = wishlistRepository.findAllByCustomerId(customerId);
    if (wishlists.isEmpty()) {
      response.setCode(ResponseCode.NOT_FOUND.getCode());
      response.setMessage(ResponseCode.NOT_FOUND.getMessage());
      response.setSuccess(true);

      return response;
    }

    List<WishlistResponseDto> wishlistItems = new ArrayList<>();
    List<WishlistResponseDto.WishlistItemDto> wishlistItemDtos = new ArrayList<>();

    WishlistResponseDto wishlistResponseDto = new WishlistResponseDto();
    wishlistResponseDto.setCustomerId(customerId);

    for (Wishlist wishlist : wishlists) {
      WishlistResponseDto.WishlistItemDto wishlistItemDto = new WishlistResponseDto.WishlistItemDto();
      wishlistItemDto.setItem(wishlist.getItem());
      wishlistItemDto.setAddedAt(wishlist.getAddedAt());

      wishlistItemDtos.add(wishlistItemDto);
    }
    wishlistResponseDto.setItems(wishlistItemDtos);
    wishlistItems.add(wishlistResponseDto);

    response.setData(wishlistItems);
    response.setCode(ResponseCode.SUCCESS.getCode());
    response.setMessage(ResponseCode.SUCCESS.getMessage());
    response.setSuccess(true);

    return response;
  }
}
