package com.h20.shop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("Monitor")
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Monitor extends Product {
    @Column
    private Double diagonal;
}
