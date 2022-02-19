package uteq.freelancer_mvc.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

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
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "year", nullable = false)
    private Date year;

    //Todo: relacion con la entidad pais
    @ManyToOne
    @JoinColumn(name="id_country")
    private Country country;
}
