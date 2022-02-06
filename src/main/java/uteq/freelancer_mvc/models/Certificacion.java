package uteq.freelancer_mvc.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "certificaciones")
public class Certificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_certificacion")
    private int idCertificacion;

    @NotEmpty
    @Column(name = "nombre", length = 80)
    private String nombre;

    @NotEmpty
    @Column(name="year")
    private String year;

}