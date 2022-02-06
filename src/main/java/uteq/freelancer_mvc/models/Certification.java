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
@Table(name = "certification")
public class Certification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_certification")
    private int idCertification;

    @NotEmpty
    @Column(name = "name", length = 80, nullable = false)
    private String name;

    @NotEmpty
    @Column(name="year")
    private String year;

}