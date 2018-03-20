package prob2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EmployeeAdmin {
	
	/**
		Returns a list of Employees whose social security number is on the input list socSecNums
		and whose salary is > 80000. The list must be ordered by social security number,
		from lowest to highest. To sort, you must use a Collections sorting method
		and you must define your own Comparator to be used to compare Employees by ssn. 
	*/
	public static List<Employee> prepareReport(HashMap<String, Employee> table, List<String> socSecNums) {
		//IMPLEMENT
List<Employee> temp= new ArrayList<Employee>();
		
		Set k= table.entrySet();
		Iterator it= k.iterator();
		
		while(it.hasNext()){
			Map.Entry m = (Map.Entry) it.next();
			String sr= (String)m.getKey();
			Employee x= (Employee)m.getValue();
			
			for(int i=0; i<socSecNums.size();i++){
				if(sr.equals(socSecNums.get(i)) && x.getSalary()>80000)
					temp.add(x);
			}
		
	}
	return temp;
	}
}
