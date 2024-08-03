package com.h20.shop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("Laptop")
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Laptop extends Product {
    @Column
    private Integer size;
}
