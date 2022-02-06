package uteq.freelancer_mvc.models;

import lombok.Data;

import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name = "preguntas")

public class Pregunta {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_pregunta")
    private Long idPregunta;
	

    @NotEmpty
	@Column(name="descripcion")
    private String descripcion;

    @NotEmpty
	@Column(name="respuesta")
    private String respuesta;
    
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "fecha")
    private Date fecha;
}
