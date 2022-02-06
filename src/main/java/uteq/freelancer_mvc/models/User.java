package uteq.freelancer_mvc.models;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "user")

public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_usser")
    private Long idUser;
	
	@NotEmpty
	@Column(name="name", length = 100)
    private String name;

	@NotEmpty
	@Column(name="last_name", length = 100)
    private String lastName;
	
	@Column(name="phone", length = 15)
    private String phone;

	@NotEmpty
	@Column(name="address")
    private String address;
	
	@Column(name="profile_pic", length=50)
    private String profilePic;
	
	@Column(name="description")
    private String description;

	@Column(name="password")
    private String password;

	@NotEmpty
	@Column(name="dni", length = 15)
	private String dni;

	@Email
	@Column(name="email", length = 50)
	private String email;

	@OneToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name="id_country")
	private Country country;
}
