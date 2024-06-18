package ar.edu.utn.frc.tup.lc.iii.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "matches")
public class MatchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
