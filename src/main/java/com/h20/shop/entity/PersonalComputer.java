package com.h20.shop.entity;

import com.h20.shop.entity.enums.PCFormFactors;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("PersonalComputer")
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class PersonalComputer extends Product {
    @Column
    private PCFormFactors formFactor;
}
