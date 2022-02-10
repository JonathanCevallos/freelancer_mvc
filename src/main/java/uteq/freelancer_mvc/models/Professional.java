package uteq.freelancer_mvc.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "professional")
public class Professional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_professional")
    private Long idProfessional;

    @Column(name = "url_sitio_web", length = 100)
    private String urlSitioWeb;

    @Column(name = "url_linkedin", length = 100)
    private String urlLinkedin;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "registration_Date", nullable = false)
    private Date registrationDate;

    //todo: relacion con la entidad usuario
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_people")
    private People people;

    //todo: relacion con la entidad usuario
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_occupation")
    private Occupation occupation;

    //todo: relacion con la entidad skill
    @OneToMany(cascade = {CascadeType.ALL}, targetEntity = Skill.class)
    @JoinColumn(name = "id_professional", referencedColumnName = "id_professional")
    private Set<Skill> skill;

    //todo: relacion con la entidad education
    @OneToMany(cascade = {CascadeType.ALL}, targetEntity = Education.class)
    @JoinColumn(name = "id_professional", referencedColumnName = "id_professional")
    private Set<Education> education;

}