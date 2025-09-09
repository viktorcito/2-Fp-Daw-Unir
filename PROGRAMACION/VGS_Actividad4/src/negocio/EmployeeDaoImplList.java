package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javabean.Department;
import javabean.Employee;
import javabean.Job;

public class EmployeeDaoImplList implements IEmployeeDao {

	private List<Employee> lista;
	private IDepartmentDao iDepartmentDao;
	private IJobDao iJobDao;

	public EmployeeDaoImplList() {
		lista = new ArrayList<Employee>();
		iDepartmentDao = new DepartmentDaoImplList();
		iJobDao = new JobDaoImplList();

		cargarDatos();

	}

	private void cargarDatos() {
		lista.add(new Employee(114, "Esteban", "Raphaelly", "est@fp.com", "678678678", LocalDate.of(1996, 7, 7),
				iJobDao.findById("IT_PROG"), 35_000, 0.2, iDepartmentDao.findById(30)));
		lista.add(new Employee(115, "Ana", "Koo", "ana@fp.com", "678678678", LocalDate.of(1996, 7, 7),
				iJobDao.findById("IT_PROG"), 35_000, 0.2, iDepartmentDao.findById(30)));
		lista.add(new Employee(116, "carlos", "Colmenares", "carlos@fp.com", "678678678", LocalDate.of(1996, 7, 7),
				iJobDao.findById("AD_PRESS"), 135_000, 0.2, iDepartmentDao.findById(20)));

	}

	@Override
	public Employee findById(Integer atributoPk) {
		for (Employee ele : lista) {
			if (ele.getEmployeeId() == atributoPk)
				return ele;
		}

		return null;
	}

	@Override
	public int insertOne(Employee objeto) {
		if (lista.contains(objeto)) {
			return 0;
		} else {
			lista.add(objeto);
			return 1;
		}
	}

	@Override
	public int updateOne(Employee objeto) {
		int posicion = lista.indexOf(objeto);
		if (posicion != -1) {
			lista.set(posicion, objeto);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteById(Integer atributoPk) {
		return deleteObj(findById(atributoPk));
	}

	@Override
	public int deleteObj(Employee objeto) {
		return lista.remove(objeto) ? 1 : 0;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public List<Employee> porDepartamento(int departmentId) {
		List<Employee> aux = new ArrayList<Employee>();
		for (Employee e : lista) {
			if (e.getDepartment().getDepartmentId() == departmentId) {
				aux.add(e);
			}
		}
		return aux;
	}

	@Override
	public List<Employee> porTrabajo(String jobId) {
		List<Employee> aux = new ArrayList<Employee>();
		for (Employee e : lista) {
			if (e.getJob().getJobId().equalsIgnoreCase(jobId)) {
				aux.add(e);
			}
		}
		return aux;
	}

	@Override
	public double calcularMasaSalarial() {
		double total = 0;
		for (Employee e : lista) {
			total += e.getSalary();
		}
		return total;
	}

	@Override
	public double masaSalarialPorDep(int departmentId) {
		double total = 0;
		for (Employee e : lista) {
			if (e.getDepartment().getDepartmentId() == departmentId) {
				total += e.getSalary();
			}
		}
		return total;
	}

	@Override
	public List<Employee> fueraSalario() {
		List<Employee> aux = new ArrayList<>();
		for (Employee e : lista) {
			double min = e.getJob().getMinSalary();
			double max = e.getJob().getMaxSalary();
			double actual = e.getSalary();
			if (actual < min || actual > max) {
				aux.add(e);
			}
		}
		return aux;
	}

}
