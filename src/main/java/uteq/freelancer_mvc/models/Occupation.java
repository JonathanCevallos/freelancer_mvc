package uteq.freelancer_mvc.models;

import lombok.AllArgsConstructor;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "occupation")
public class Occupation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_occupation")
    private int idOccupation;

    @NotEmpty
    @Column(name = "name", length = 80, nullable = false)
    private String name;
}