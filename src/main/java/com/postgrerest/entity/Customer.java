package com.postgrerest.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name="musteri")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of={"id"})
public class Customer implements Serializable {
    @Id
    @SequenceGenerator(name="seq_customer",allocationSize = 1)
    @GeneratedValue(generator = "seq_customer",strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "musteri_ad")
    private String customerName;

    @Column(name = "musteri_soyad")
    private String customerSurname;

    @Column(name = "sehir")
    private String city;

    @Column(name = "cinsiyet")
    @Enumerated
    private Cinsiyet type;

    @OneToMany
    @JoinColumn(name="musteri_siparis_id")
    private List<Order> orderList;

    public enum Cinsiyet {
        BAY("E"),
        BAYAN("K");
        public final String label;

        Cinsiyet(String label) {
            this.label = label;
        }
    }
}
