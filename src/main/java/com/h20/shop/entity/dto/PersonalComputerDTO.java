package com.h20.shop.entity.dto;

import com.h20.shop.entity.enums.PCFormFactors;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PersonalComputerDTO extends ProductDTO {
    private PCFormFactors formFactor;
}
