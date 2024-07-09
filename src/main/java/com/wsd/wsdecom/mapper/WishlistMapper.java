package com.wsd.wsdecom.mapper;

import com.wsd.wsdecom.dto.WishlistDto;
import com.wsd.wsdecom.entity.Wishlist;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = ComponentModel.SPRING, uses = {
    ItemMapper.class, CustomerMapper.class})
public interface WishlistMapper {

    WishlistMapper INSTANCE = Mappers.getMapper(WishlistMapper.class);

    Wishlist toEntity(WishlistDto wishlistDto);

    WishlistDto toDto(Wishlist wishlist);
}
