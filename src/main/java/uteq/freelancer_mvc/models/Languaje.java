package uteq.freelancer_mvc.models;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "languaje")

public class Languaje {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_languaje")
    private int languaje;
	
    @NotEmpty
	@Column(name="name", length = 30, nullable = false)
    private String name;
    
    @NotEmpty
	@Column(name="level", length = 20, nullable = false)
    private String level;
}
