package com.mk.shop.domain;

import com.mk.shop.domain.enumeration.View;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@Table(name = "ITEM")
@Data
@RequiredArgsConstructor
public class Item implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    @NonNull
    private String title;

    @Column(name = "DESCRIPTION", nullable = false)
    @NonNull
    private String description;

    @Enumerated(EnumType.STRING)
    @NonNull
    @Column(name = "VIEW", nullable = false)
    private View view;

    @Column(name = "PRICE")
    @NonNull
    private BigDecimal price;

}
