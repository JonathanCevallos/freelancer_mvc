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
    @Column(name = "name", length = 150, nullable = false)
    private String name;

    @NotEmpty
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "document", length = 50)
    private String document;

    @Column(name = "title", length = 200, nullable = false)
    private String title;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "publication_date")
    private Date publicationDate;

    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "id_sub_category")
    private SubCategory subCategory;

    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "id_professional")
    private Professional professional;

    @OneToMany(cascade = {CascadeType.ALL}, targetEntity = Plan.class)
    @JoinColumn(name = "id_publication", referencedColumnName = "id_publication")
    private Set<Plan> plan;

    @OneToMany(cascade = {CascadeType.ALL}, targetEntity = Plan.class)
    @JoinColumn(name = "id_publication", referencedColumnName = "id_publication")
    private Set<Qualification> qualification;
}
