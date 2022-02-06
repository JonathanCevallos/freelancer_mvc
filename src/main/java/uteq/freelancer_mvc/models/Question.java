package uteq.freelancer_mvc.models;

import lombok.*;
import java.sql.Date;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "question")

public class Question {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_question")
    private Long idQuestion;
	

    @NotEmpty
	@Column(name="description")
    private String description;

    @NotEmpty
	@Column(name="answer")
    private String answer;
    
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "date")
    private Date date;
}