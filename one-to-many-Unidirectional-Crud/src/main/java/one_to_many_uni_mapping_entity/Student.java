package one_to_many_uni_mapping_entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Student {
	
	@Id
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY) // for unique key don,t pass value automatically generate start no from 1 
	
	private int id ;
	private String name ;
	private String email ;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name ="student-subject",
	
			joinColumns = @JoinColumns(name = "student-id"),
			inverseJoinColumns = @JoinColumn(name = "subject-id"))
	
	private List<Subject>subject ;

	public Student(String name, String email, List<Subject> subject) {
		super();
		this.name = name;
		this.email = email;
		this.subject = subject;
	}

	
	
	
	

}
