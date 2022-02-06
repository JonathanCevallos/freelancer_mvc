package uteq.freelancer_mvc.models;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "pay")

public class Pay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pay")
    private Long idPay;

    @NotEmpty
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "date")
    private Date date;

    @Column(name = "total")
    private Double total;

    @Column(name = "status")
    private Boolean status;

    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "id_people")
    private People people;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_publication")
    private Publication publication;
}
