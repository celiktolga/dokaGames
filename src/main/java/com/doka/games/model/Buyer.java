package com.doka.games.model;

import com.doka.games.model.BaseEntity;
import com.doka.games.model.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Setter
@Getter
@Entity
public class Buyer extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "buyer_id")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "buyer", fetch = FetchType.EAGER)
    private List<Product> productList = new ArrayList<>();
}
