package prob1;
import java.util.*;
public class Admin {
	public static HashMap<Key, Student> processStudents(List<Student> students) {
		//implement
		HashMap<Key, Student> hm= new HashMap<>();
		for(Student s:students){
			Key k = new Key(s.getFirstName(),s.getLastName());
		hm.put(k, s);
		}
		return hm;
	}
}
