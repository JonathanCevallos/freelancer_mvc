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
@Table(name = "ability")
public class Ability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ability")
    private int idAbility;

    @NotEmpty
    @Column(name = "name")
    private String name;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "date_from")
    private String dateFrom;

    @Column(name = "description")
    private String description;
}