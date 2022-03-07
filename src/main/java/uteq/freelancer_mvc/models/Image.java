package uteq.freelancer_mvc.models;

import lombok.AllArgsConstructor;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "images")

public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_image")
    private Long idImage;

    @Column(name = "image", length = 50)
    private String image;
}