package tr.com.jowl.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "user", schema = "tododb")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true)
	private int id;

	@Column(name = "username")
	private String username;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "password")
	private String password;

	@Transient
	@Column(name = "password_2")
	private String password_2;

	@Column(name = "email")
	private String email;

	@Size(min = 11, max = 11)
	@Column(name = "dni")
	private String dni;

	@Column(name = "gender")
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
