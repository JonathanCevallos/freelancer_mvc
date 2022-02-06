package uteq.freelancer_mvc.models;

import lombok.AllArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "habilidades")
public class Habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_habilidad")
    private int idHabilidad;

    @NotEmpty
    @Column(name ="nombre")
    private String nombre;


    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name ="fecha_desde")
    private String fechaDesde;

    @Column(name ="descripcion")
    private String descripcion;
}