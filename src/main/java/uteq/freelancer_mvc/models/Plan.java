package uteq.freelancer_mvc.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "planes")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plan")
    private int idPlan;

}
