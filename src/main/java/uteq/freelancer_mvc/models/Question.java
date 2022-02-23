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
@Table(name = "questions")

public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_question")
    private Long idQuestion;


    @NotEmpty
    @Column(name = "question", nullable = false)
    private String question;

    @NotEmpty
    @Column(name = "answer", nullable = false)
    private String answer;

}
