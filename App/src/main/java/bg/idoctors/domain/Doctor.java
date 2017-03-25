package bg.idoctors.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
	private Set<DoctorEducation> doctorEducation;

	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
	private Set<DoctorWorkSchedule> doctorWorkSchedule;

	public Doctor() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<DoctorEducation> getDoctorEducation() {
		return doctorEducation;
	}

	public void setDoctorEducation(Set<DoctorEducation> doctorEducation) {
		this.doctorEducation = doctorEducation;
	}

	public Set<DoctorWorkSchedule> getDoctorWorkSchedule() {
		return doctorWorkSchedule;
	}

	public void setDoctorWorkSchedule(Set<DoctorWorkSchedule> doctorWorkSchedule) {
		this.doctorWorkSchedule = doctorWorkSchedule;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", doctorEducation=" + doctorEducation + ", doctorWorkSchedule=" + doctorWorkSchedule + "]";
	}
}
