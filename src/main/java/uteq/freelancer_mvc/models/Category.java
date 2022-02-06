package uteq.freelancer_mvc.models;

import lombok.AllArgsConstructor;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private int idcategory;

    @NotEmpty
    @Column(name = "name", length = 50)
    private String name;

    //todo: lista de formaciones
    @OneToMany(cascade = {CascadeType.ALL}, targetEntity = SubCategory.class)
    @JoinColumn(name = "id_category", referencedColumnName = "id_category")
    private Set<SubCategory> subCategory;
}
