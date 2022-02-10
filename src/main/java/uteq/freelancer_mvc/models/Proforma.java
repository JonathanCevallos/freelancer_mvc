package uteq.freelancer_mvc.models;

import lombok.AllArgsConstructor;
import lombok.*;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "proforma")
public class Proforma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proforma")
    private int idProforma;

    @NotEmpty
    @Column(name = "description")
    private String description;

    @NotEmpty
    @Column(name = "price")
    private Double price;

    @NotEmpty
    @Column(name = "delivery_day")
    private Short deliveryDay;

    @Column(name = "proforma_date")
    private Date quoteDate;

    @Column(name = "document", length = 50)
    private String document;

    @OneToOne(cascade = {CascadeType.PERSIST})
    private Publication publication;
}