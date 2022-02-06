package uteq.freelancer_mvc.models;

import lombok.*;
import javax.persistence.*;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name ="plane")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_plan")
    private int idPlan;

    @NotEmpty
    @Column(name ="name", length = 50)
    private String name;

    @NotEmpty
    @Column(name="description")
    private String description;

    @NotEmpty
    @Column(name="delivery_day")
    private Short deliveryDay;

    @NotEmpty
    @Column(name="price")
    private Double price;

}