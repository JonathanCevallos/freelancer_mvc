package uteq.freelancer_mvc.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name ="formaciones")
public class Formacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_formacion")
    private Long idFormacion;

    @NotEmpty
    @Column(name ="nombre_institucion", length = 80)
    private String nombreInstitucion;

    @NotEmpty
    @Column(name ="descripcion", length = 50)
    private String descripcion;

    @NotEmpty
    @Column(name="year")
    private String year;

    //Todo: relacion con la entidad pais
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_pais")
    private Country country;
}
