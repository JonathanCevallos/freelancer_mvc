package uteq.freelancer_mvc.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;

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

    @Column(name = "description")
    private String description;

  /*  @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "registration_Date")
    private Date registrationDate;*/

    //todo: relacion con la entidad people
    @OneToOne(cascade = {ALL})
    @JoinColumn(name = "id_people")
    private People people;

    //todo: relacion con la entidad occupation
    @ManyToOne
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

    //todo: relacion con la entidad languaje
    @OneToMany(cascade = {CascadeType.ALL}, targetEntity = Languaje.class)
    @JoinColumn(name = "id_professional", referencedColumnName = "id_professional")
    private Set<Languaje> languaje;

    //todo: relacion con la entidad certification
    @OneToMany(cascade = {CascadeType.ALL}, targetEntity = Certification.class)
    @JoinColumn(name = "id_professional", referencedColumnName = "id_professional")
    private Set<Certification> certification;


}