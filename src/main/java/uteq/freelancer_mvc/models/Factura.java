package uteq.freelancer_mvc.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@Entity
@Table(name = "facturas")

public class Factura {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_factura")
    private Long idFactura;

	@NotEmpty
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name="fecha")
    private Date fecha;

	@Column(name="total")
    private Double total;

	@Column(name="estado")
    private Boolean estado;

	@OneToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="id_servicio")
	private Servicio Servicio;
}
