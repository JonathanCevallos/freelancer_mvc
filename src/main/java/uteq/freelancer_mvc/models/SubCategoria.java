package uteq.freelancer_mvc.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "subcategorias")
public class SubCategoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sub_categoria")
    private int idSubCategoria;

}