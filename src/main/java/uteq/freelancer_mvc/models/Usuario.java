package uteq.freelancer_mvc.models;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "usuarios")

public class Usuario {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_usuario")
    private Long idUsuario;
	

	@NotEmpty
	@Column(name="nombre", length = 100)
    private String nombre;

	@NotEmpty
	@Column(name="apellido", length = 100)
    private String apellido;
	
	@Column(name="telefono", length = 15)
    private String telefono;

	@NotEmpty
	@Column(name="direccion")
    private String direccion;
	
	@Column(name="foto_perfil", length=50)
    private String foto_perfil;
	
	@Column(name="descripcion")
    private String descripcion;

	@Column(name="clave")
    private String clave;

	@NotEmpty
	@Column(name="dni", length = 15)
	private String dni;

	@Email
	@Column(name="email", length = 50)
	private String email;

	@OneToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name="id_pais")
	private Pais pais;
}
