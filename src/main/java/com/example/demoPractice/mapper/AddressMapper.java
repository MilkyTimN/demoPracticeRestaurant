package com.example.demoPractice.mapper;

import com.example.demoPractice.model.dto.AddressDto;
import com.example.demoPractice.model.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper extends BaseMapper<Address, AddressDto>{

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);
}
