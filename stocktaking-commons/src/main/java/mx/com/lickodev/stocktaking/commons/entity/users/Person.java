package mx.com.lickodev.stocktaking.commons.entity.users;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "persons")
@EqualsAndHashCode(of = { "id", "email" })
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
