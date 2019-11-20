package tr.com.jowl.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "user", schema = "tododb")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true)
	private int id;

	@NotEmpty(message = "Ingrese el nombre de usuario.")
	@Column(name = "username", nullable = false, length = 20, unique = true)
	private String username;

	@NotEmpty(message = "Ingrese sus nombres.")
	@Column(name = "firstName", nullable = false, length = 25)
	private String firstName;

	@NotEmpty(message = "Ingrese sus apellidos completos.")
	@Column(name = "lastName", nullable = false, length = 25)
	private String lastName;

	@NotEmpty(message = "Ingrese una contraseña entre 8 a 16 caracteres.")
	@Column(name = "password", nullable = false, length = 16)
	private String password;

	@Transient
	@NotEmpty(message = "La contraseña debe ser igual a la ingresada anteriormente.")
	@Column(name = "password_2", nullable = false, length = 16)
	private String password_2;

	@Email
	@NotEmpty(message = "Ingrese un correo electrónico válido.")
	@Column(name = "email", nullable = false, length = 30, unique = true)
	private String email;

	@Size(min = 8, max = 8, message = "El DNI tiene que contener 8 d\u00edgitos")

	@Column(name = "dni", nullable = false, length = 8, unique = true)
	private String dni;


	@Column(name = "gender", nullable = false, length = 15)
	private String gender;

	@Column(name = "role")
	private int role;

	public User() {
	}

	public User(String username, String password, String email, int role) {
		this.setUsername(username);
		this.setPassword(password);
		this.setEmail(email);
		this.setRole(role);

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword_2() {
		return password_2;
	}

	public void setPassword_2(String password_2) {
		this.password_2 = password_2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		User user = (User) o;
		return id == user.id && role == user.role && Objects.equals(username, user.username)
				&& Objects.equals(password, user.password) && Objects.equals(password_2, user.password_2)
				&& Objects.equals(email, user.email);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, username, firstName, lastName, dni, gender, password, password_2, email, role);
	}
}
