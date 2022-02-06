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
@Table(name = "education")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_education")
    private Long idEducation;

    @NotEmpty
    @Column(name = "name_institution", length = 80, nullable = false)
    private String nameInstitution;

    @NotEmpty
    @Column(name = "description", length = 50, nullable = false)
    private String description;

    @NotEmpty
    @Column(name = "year", nullable = false)
    private String year;

    //Todo: relacion con la entidad pais
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_country")
    private Country country;
}
