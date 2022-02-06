package uteq.freelancer_mvc.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "servicios")

public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private Long idServicio;

    @NotEmpty
    @Column(name = "nombre", length = 150)
    private String nombre;

    @NotEmpty
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado")
    private Boolean estado;

    @Column(name = "documento", length = 50)
    private String documento;

    @Column(name = "titulo", length = 200)
    private String titulo;


    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "fecha_plublicacion")
    private Date fechaPublicacion;

    //todo: relacion con la entidad categoria
    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "id_sub_categoria")
    private SubCategoria subCategoria;

    //todo: relacion con la entidad profesional
    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "id_profesional")
    private Profesional profesional;

    //todo: lista de planes
    @OneToMany(cascade = {CascadeType.ALL}, targetEntity = Plan.class)
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio")
    private Set<Plan> planes;

    //todo: lista de calificaciones
    @OneToMany(cascade = {CascadeType.ALL}, targetEntity = Plan.class)
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio")
    private Set<Calificacion> calificaciones;
}
