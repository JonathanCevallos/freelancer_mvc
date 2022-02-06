package uteq.freelancer_mvc.models;

import lombok.*;

import javax.persistence.*;


import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "sub_category")
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sub_category")
    private int idSubCategory;

    @NotEmpty
    @Column(name = "name", length = 50)
    private String name;

}