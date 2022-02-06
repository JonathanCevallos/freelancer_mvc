package uteq.freelancer_mvc.models;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "idiomas")

public class Idioma {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_idioma")
    private int Idioma;
	
    @NotEmpty
	@Column(name="nombre", length = 30)
    private String nombre;
    
    @NotEmpty
	@Column(name="nivel", length = 20)
    private String nivel;
}
