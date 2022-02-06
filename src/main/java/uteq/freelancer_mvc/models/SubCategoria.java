package uteq.freelancer_mvc.models;

import lombok.Data;

import javax.persistence.*;


import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "sub_categorias")
public class SubCategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sub_categoria")
    private int idSubCategoria;

    @NotEmpty
    @Column(name = "nombre", length = 50)
    private String nombre;

}