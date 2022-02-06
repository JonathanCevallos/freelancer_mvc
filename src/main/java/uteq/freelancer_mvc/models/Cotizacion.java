package uteq.freelancer_mvc.models;

import lombok.AllArgsConstructor;
import lombok.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "cotizaciones")
public class Cotizacion {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cotizar")
    private int idCotizar;

	@NotEmpty
	@Column(name="descripcion")
    private String descripcion;

	@NotEmpty
	@Column(name="precio")
    private Double precio;

	@NotEmpty
	@Column(name="dias_espera")
    private Short dias_espera;
	
	@Column(name="fecha_cotizacion")
    private Date fechaCotizacion;
	
	@Column(name="documento", length = 50)
    private String documento;

	@OneToOne(cascade = {CascadeType.PERSIST})
	private Servicio  servicio;
}