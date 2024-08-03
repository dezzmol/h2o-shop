package com.h20.shop.entity.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class HardDriveDTO extends ProductDTO {
    private Integer capacity;
}
