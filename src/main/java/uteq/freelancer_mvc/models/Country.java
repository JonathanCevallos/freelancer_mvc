package uteq.freelancer_mvc.models;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "country")
public class Country {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_country")
    private int idCountry;

    @NotEmpty
	@Column(name="name", length = 50, nullable = true)
    private String name;
}
