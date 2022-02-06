package uteq.freelancer_mvc.models;

import lombok.AllArgsConstructor;
import lombok.*;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name= "imagenes")

public class Image {
	@Id
    @Column(name= "id_imagen")
    private Long idImagen;

    @Column(name= "imagen", length=50)
    private String imagen;
}