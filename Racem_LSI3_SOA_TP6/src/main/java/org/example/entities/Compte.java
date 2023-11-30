package org.example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   Long id ;
    @Column
    Double solde ;
    @Column
    Date dateCreation;
    @Column
     TypeCompte type ;
    @Column
   EtatCompte etat ;
}
