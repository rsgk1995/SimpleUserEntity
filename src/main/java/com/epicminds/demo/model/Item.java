package com.epicminds.demo.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author Sidharth
 */

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column (name = "name")
    String name;
    @Column (name = "price")
    Double price;
    @Column(name = "quantity")
    Integer quantity;
}
