package mx.com.lickodev.stocktaking.commons.entity.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "persons")
@EqualsAndHashCode(of = { "id", "email" })
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 60)
	private String firstName;

	@Column(length = 60)
	private String secondName;

	@Column(length = 60)
	private String firstSurname;

	@Column(length = 60)
	private String secondSurname;

	@Column(length = 560, unique = true, nullable = false)
	private String email;

}
