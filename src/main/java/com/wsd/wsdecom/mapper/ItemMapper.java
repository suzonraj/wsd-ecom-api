package com.wsd.wsdecom.mapper;

import com.wsd.wsdecom.dto.ItemDto;
import com.wsd.wsdecom.entity.Item;
import org.mapstruct.*;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = ComponentModel.SPRING)
public interface ItemMapper {
    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

    Item toEntity(ItemDto itemDto);

    ItemDto toDto(Item category);
}
