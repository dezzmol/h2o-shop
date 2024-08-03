package com.h20.shop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("HardDrive")
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class HardDrive extends Product {
    @Column
    private Integer capacity;
}
