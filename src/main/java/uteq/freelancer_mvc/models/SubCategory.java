package uteq.freelancer_mvc.models;

import lombok.*;

import javax.persistence.*;


import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "sub_categorias")
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sub_categoria")
    private int idSubCategoria;

    @NotEmpty
    @Column(name = "nombre", length = 50)
    private String nombre;

}