package uteq.freelancer_mvc.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "profesionales")
public class Profesional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesional")
    private Long idProfesional;

    @Column(name = "url_sitio_web", length = 100)
    private String urlSitioWeb;

    @Column(name = "url_linkedin", length = 100)
    private String urlLinkedin;


    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    //todo: relacion con la entidad usuario
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_usuario")
    private User user;
}