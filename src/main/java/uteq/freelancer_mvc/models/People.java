package uteq.freelancer_mvc.models;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "people")
public class People {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_people")
    private Long idPeople;
	
	@NotEmpty
	@Column(name="name", length = 100, nullable = false)
    private String name;

	@NotEmpty
	@Column(name="last_name", length = 100, nullable = false)
    private String lastName;
	
	@Column(name="phone", length = 15, nullable = false, unique = false)
    private String phone;

	@NotEmpty
	@Column(name="direction")
    private String direction;
	
	@Column(name="profile_pic", length=50)
    private String profilePic;
	
	@Column(name="description")
    private String description;

	@Column(name="password", nullable = false)
    private String password;

	@NotEmpty
	@Column(name="dni", length = 15, nullable = false, unique = true)
	private String dni;

	@Email
	@Column(name="email", length = 50, nullable = false, unique = true)
	private String email;

	@OneToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name="id_country")
	private Country country;
}
