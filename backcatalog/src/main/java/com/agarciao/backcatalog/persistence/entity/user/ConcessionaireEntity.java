package com.agarciao.backcatalog.persistence.entity.user;

import com.agarciao.backcatalog.persistence.entity.vehicle.BrandEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "concessionaire")
public class ConcessionaireEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "concessionaire_brand",
            joinColumns = @JoinColumn(name = "brand_id"),
            inverseJoinColumns = @JoinColumn(name = "concessionaire_id")
    )
    private Set<BrandEntity> brand;
}
