package negocio;

import java.util.List;

import javabean.Employee;

public interface IEmployeeDao extends ICrudGenerico<Employee, Integer>{
	
	List<Employee> porDepartamento(int departmentId);

    List<Employee> porTrabajo(String jobId);
    
    double calcularMasaSalarial();
    
    double masaSalarialPorDep(int departmentId);
    
    List<Employee> fueraSalario();


}
