package com.aplication.rest.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "floracion")

public class Floracion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "opcion", length = 3)
    private String option;
    @Column(name = "id_Floracion")
    private Integer idFloracion;

}
