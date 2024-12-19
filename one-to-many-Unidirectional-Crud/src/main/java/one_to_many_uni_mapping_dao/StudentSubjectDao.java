package one_to_many_uni_mapping_dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import one_to_many_uni_mapping_entity.Student;
import one_to_many_uni_mapping_entity.Subject;

public class StudentSubjectDao {

	EntityManager em = Persistence.createEntityManagerFactory("hibernate").createEntityManager();
	EntityTransaction et = em.getTransaction();

	// public Student saveStudentDao( Student student ,List<Subject> subjects)
	
	
	public List<Subject> saveSubjectDao(List<Subject> subjects, int studentId)

	{

		try {
			et.begin();

			for (Subject subject : subjects) //
			{
				em.persist(subject);
				Query query = em.createNativeQuery("insert into student_subject(Student_id,subject_id) values(?,?)");
				query.setParameter(1, studentId);
				query.setParameter(2, subject.getId());
				query.executeUpdate();
			}
			
			et.commit();
			return subjects;
		  }

		catch (Exception e) {
			e.printStackTrace();
			return null;

		}

	}
	
	
	/// DELETE NATIVE QUERY  FOR SUBJECT DELETE

	public boolean deleteSubjectBySubjectIdDao(List<Integer> subjectId) {

		String deleteSubjectQuery = "DELETE FROM  student_subject where subjects_id=?";
		et.begin();

		boolean b = false;

		for (Integer integer : subjectId) {

			Query query = em.createNativeQuery(deleteSubjectQuery).setParameter(1, integer);

			query.executeUpdate();

			Subject subject = em.find(Subject.class, integer);

			if (subject != null) {
				em.remove(subject);
				b = true;

			} else {
				b = false;
			}

		}
		et.commit();
		return b;

	}
	
	
	public List<Student> getAllStudentsDao()
	{
		
		return em.createQuery("from Student").getResultList() ;
		
	}
	
	
	
	///FILTER THE SUBJECT STUDENT DATA 
	
	public List<Student> filterStudentBySubjectName(String subjectName)
	{
		
		List<Student> students = getAllStudentsDao() ;

		
		   return students
				.stream()
				.filter(a->a.getSubject().stream()
				.anyMatch(a1->a1.getName()
				.equalsIgnoreCase( subjectName))).collect(Collectors.toList());

}

}