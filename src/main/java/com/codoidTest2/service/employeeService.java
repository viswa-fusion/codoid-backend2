package com.codoidTest2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codoidTest2.Codoid_employee.Employee;

@Service
public class employeeService {
	
	private static long id=0;
	private static List<Employee> employee=new ArrayList<>(); 
    static {
    	employee.add(new Employee(++id,"viswa","viswa@codoid.com"));
    }

	public void addList(Employee employee1) {
		employee.add(new Employee(++id,employee1.getName(),employee1.getEmail()));
	}

	public List<Employee> listAll() {
		return employee;
	}

	public List<?> getById(long id) {
		List<Employee> result=new ArrayList<>();
		for(int i=0;i<employee.size();i++) {
			Employee member=employee.get(i);
			long check=member.getId();
			if(check==id) {
				result.add(member);
				break;
			}
		}
		if(result.size()==0) {
			List<String> error=new ArrayList<>();
			error.add("not found!");
			return error;
		}
		return result;
	}

	public String deleteById(long id) {
		for(int i=0;i<employee.size();i++) {
			Employee member=employee.get(i);
			long check=member.getId();
			if(check==id) {
				employee.remove(i);
				return "successfully deleted!";
			}
		}
		return "id not in list!";
		
	}

	public String updateById(long id,Employee employee1) {
		for(int i=0;i<employee.size();i++) {
			Employee member=employee.get(i);
			long check=member.getId();
			if(check==id) {
				member.setName(employee1.getName());
				member.setEmail(employee1.getEmail());
				employee.add(i, member);
				return "successfully updated!";
			}
		}
		return "id not in list!";
	}
	
	
}
