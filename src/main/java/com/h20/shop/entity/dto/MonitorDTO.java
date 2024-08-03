package com.h20.shop.entity.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class MonitorDTO extends ProductDTO {
    private Double diagonal;
}
