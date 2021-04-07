package mx.com.lickodev.stocktaking.commons.entity.users;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@EqualsAndHashCode(callSuper = false, of = { "userName", "id" })
public class User extends Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 60, unique = true)
	private String userName;

	@Column(length = 350)
	private String password;

	private boolean enabled;

	private boolean accountNonExpired;

	private boolean credentialsNonExpired;

	private boolean accountNonLocked;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles", 
	joinColumns = { @JoinColumn(name="user_id", referencedColumnName = "id") }, 
	inverseJoinColumns = { @JoinColumn(name="role_id", referencedColumnName = "id")},
	uniqueConstraints = { @UniqueConstraint(columnNames = { "user_id", "role_id"} ) })
	private List<Role> roles;

	
	
}
