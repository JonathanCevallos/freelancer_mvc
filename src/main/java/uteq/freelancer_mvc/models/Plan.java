package uteq.freelancer_mvc.models;

import lombok.Data;

import javax.persistence.*;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name ="planes")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_plan")
    private int idPlan;

    @NotEmpty
    @Column(name ="nombre", length = 50)
    private String nombre;

    @NotEmpty
    @Column(name="descripcion")
    private String descripcion;

    @NotEmpty
    @Column(name="dias_delivery")
    private Short diasDeliviery;

    @NotEmpty
    @Column(name="precio")
    private Double precio;

}