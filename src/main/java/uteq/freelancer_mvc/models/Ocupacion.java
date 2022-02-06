package uteq.freelancer_mvc.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "ocupaciones")
public class Ocupacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ocupacion")
    private int idOcupacion;

    @NotEmpty
    @Column(name = "nombre", length = 80)
    private String nombre;
}