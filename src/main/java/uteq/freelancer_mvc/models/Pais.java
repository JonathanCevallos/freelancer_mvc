package uteq.freelancer_mvc.models;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "paises")

public class Pais {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_pais")
    private int idPais;

    @NotEmpty
	@Column(name="nombre", length = 50)
    private String nombre;
}
