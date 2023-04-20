package com.postgrerest.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="siparis")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of={"id"})
public class Order {
    @Id
    @SequenceGenerator(name="seq_siparis",allocationSize = 1)
    @GeneratedValue(generator = "seq_siparis",strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "siparis_ad")
    private String orderName;

    @Column(name = "miktar")
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name="musteri_siparis_id")
    private Customer customer;

}
