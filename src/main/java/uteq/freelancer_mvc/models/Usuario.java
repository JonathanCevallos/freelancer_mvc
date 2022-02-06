package uteq.freelancer_mvc.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

//La anotación @Data proporciona los métodos de obtención y configuración de
//de las propiedades de la clase
@Data

//La anotacion @Entity define que la clase se puede asignar a una tabla
@Entity

//La anotación @Table permite especificar el nombre de la tabla donde se
//persistirá la entidad
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

	//todo: relacion con la entidad pais
	@OneToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name="id_pais")
	private Pais pais;
}
