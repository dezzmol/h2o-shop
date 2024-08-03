package com.h20.shop.entity.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PersonalComputerDTO.class, name = "pc"),
        @JsonSubTypes.Type(value = LaptopDTO.class, name = "laptop"),
        @JsonSubTypes.Type(value = MonitorDTO.class, name = "monitor"),
        @JsonSubTypes.Type(value = HardDriveDTO.class, name = "harddrive")
})
@Data
public class ProductDTO {
    private Long seriesNumber;
    private String brand;
    private Double price;
    private Integer quantity;

    @Schema(description = "Type of the product", allowableValues = {"pc", "laptop", "monitor", "harddrive"})
    private String type;
}
