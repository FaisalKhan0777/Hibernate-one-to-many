package one_to_many_uni_mapping_controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import one_to_many_uni_mapping_dao.StudentSubjectDao;
import one_to_many_uni_mapping_entity.Student;
import one_to_many_uni_mapping_entity.Subject;

public class InsertStudentSubjectController {

	public static void main(String[] args) {

		StudentSubjectDao dao = new StudentSubjectDao() ;
		
		Subject subject1  = new Subject("JAVA" ,"jAMES" ) ;
		Subject subject2  = new Subject("SQL" ,"Raymond") ;
		//Subject subject3  = new Subject("JS" ,"Brenden" ) ;
		//Subject subject4 = new Subject("Python" ,"Anaconda") ;
		//Subject subject5 = new Subject("JDBC" ,"SUN") ;
		
		//List<Subject> subjects = new ArrayList<Subject>(Arrays.asList(subject1,subject2,subject3 ,subject4,subject5)) ;
		
		List<Subject> subjects = new ArrayList<Subject>(Arrays.asList(subject1,subject2)) ;

		
		Student student1 = new Student("Ritik" ,"ritu@gmail.com",subjects);
			dao.saveStudentDao(student1, subjects) ;

		
		
		//dao.saveSubjectDao(subjects,1);
		
		//boolean  b = dao.deleteSubjectBySubjectIdDao(new ArrayList<Integer>(Arrays.asList(1,3)));
		
			//String msg = b?"Deleted" :"Error Check Your Code" ;
			
			//System.out.println(msg);
		
		
	
	}

}
