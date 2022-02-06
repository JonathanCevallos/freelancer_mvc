package uteq.freelancer_mvc.models;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "publication")

public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_publication")
    private Long idPublication;

    @NotEmpty
    @Column(name = "name", length = 150)
    private String name;

    @NotEmpty
    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "document", length = 50)
    private String document;

    @Column(name = "title", length = 200)
    private String title;


    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "fecha_plublicacion")
    private Date fechaPublicacion;

    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "id_sub_categoria")
    private SubCategoria subCategoria;

    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "id_profesional")
    private Profesional profesional;

    @OneToMany(cascade = {CascadeType.ALL}, targetEntity = Plan.class)
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio")
    private Set<Plan> planes;

    @OneToMany(cascade = {CascadeType.ALL}, targetEntity = Plan.class)
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio")
    private Set<Calificacion> calificaciones;
}
