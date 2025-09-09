package testactividad;

import java.util.List;
import java.util.Scanner;

import javabean.Employee;

import negocio.EmployeeDaoImplList;

import negocio.IEmployeeDao;

public class TestEmployeeDaoConMenu {

	private static IEmployeeDao dao = new EmployeeDaoImplList();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		menuPrincipal();
		System.out.println("Fin del programa.");

	}

	private static void menuPrincipal() {
		int opcion;
		do {
			System.out.println("\n======================================");
			System.out.println("   MENU EMPLOYEE DAO ");
			System.out.println("======================================");
			System.out.println("1) Listar todos los empleados");
			System.out.println("2) Buscar empleado por ID");
			System.out.println("3) Empleados por departamento");
			System.out.println("4) Empleados por trabajo (jobId)");
			System.out.println("5) Calcular masa salarial total");
			System.out.println("6) Masa salarial por departamento");
			System.out.println("7) Empleados fuera de rango salarial");
			System.out.println("8) Insertar un nuevo empleado (básico)");
			System.out.println("9) Eliminar un empleado por ID");
			System.out.println("0) Salir");
			System.out.print("Elige opción: ");

			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			case 1:
				listarTodos();
				break;
			case 2:
				buscarPorId();
				break;
			case 3:
				porDepartamento();
				break;
			case 4:
				porTrabajo();
				break;
			case 5:
				masaSalarial();
				break;
			case 6:
				masaSalarialDep();
				break;
			case 7:
				fueraSalario();
				break;
			case 8:
				insertar();
				break;
			case 9:
				eliminar();
				break;
			case 0:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opción no válida.");
			}
		} while (opcion != 0);
	}

	private static void listarTodos() {
		List<Employee> lista = dao.findAll();
		for (Employee e : lista) {
			System.out.println(e);
		}
	}

	private static void buscarPorId() {
		System.out.println("Introduce ID de empleado: ");
		int id = sc.nextInt();
		sc.nextLine();
		Employee emp = dao.findById(id);
		System.out.println(emp);
	}

	private static void porDepartamento() {
		System.out.println("Introduce ID de departamento: ");
		int depId = sc.nextInt();
		sc.nextLine();
		List<Employee> lista = dao.porDepartamento(depId);
		for (Employee e : lista) {
			System.out.println(e);
		}
	}
	
	/*private static void opcionPorDepartamento() {
        System.out.println("\nLISTADO DE UN DEPARTAMENTO");
        System.out.print("Introduce ID de departamento: ");
        int depId = sc.nextInt();
        sc.nextLine(); 

        if (iDepartmentDao.findById(depId) == null) {
            System.out.println("El departamento " + depId + " no existe");
        } else {
            List<Employee> listaEmp = dao.porDepartamento(depId);
            if(listaEmp.isEmpty()) {
                System.out.println("No hay empleados para este departamento");
            } else {
                for(Employee e : listaEmp) {
                    System.out.println(e);
                }
            }
        }
    } METODO MEJORADO*/

	private static void porTrabajo() {
		System.out.println("Introduce jobId: ");
		String jobId = sc.nextLine();
		List<Employee> lista = dao.porTrabajo(jobId);
		for (Employee e : lista) {
			System.out.println(e);
		}
	}

	private static void masaSalarial() {
		double total = dao.calcularMasaSalarial();
		System.out.println("Masa salarial total: " + total);
	}

	private static void masaSalarialDep() {
		System.out.println("Introduce ID de departamento: ");
		int depId = sc.nextInt();
		sc.nextLine();
		double total = dao.masaSalarialPorDep(depId);
		System.out.println("Masa salarial del dept " + depId + ": " + total);
	}

	private static void fueraSalario() {
        System.out.println("\nEMPLEADOS FUERA DE SU RANGO SALARIAL:");
        List<Employee> lista = dao.fueraSalario();
        if(lista.isEmpty()) {
            System.out.println("Ningún empleado fuera de su rango salarial.");
        } else {
            for(Employee e : lista) {
                System.out.println(e);
            }
        }
    }
	private static void insertar() {
		System.out.println("ID del nuevo empleado: ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Nombre: ");
		String nombre = sc.nextLine();

		System.out.println("Apellido: ");
		String apellido = sc.nextLine();

		Employee emp = new Employee();
		emp.setEmployeeId(id);
		emp.setFirstName(nombre);
		emp.setLastName(apellido);

		int r = dao.insertOne(emp);
		if(r == 1) {
			System.out.println("Empleado insertado correctamente.");
		} else {
			System.out.println("No se pudo insertar (quizá ya existe).");
		}
	}

	private static void eliminar() {
		System.out.println("ID de empleado a eliminar: ");
		int id = sc.nextInt();
		sc.nextLine();

		int r = dao.deleteById(id);
		if(r == 1) {
			System.out.println("Empleado eliminado.");
		} else {
			System.out.println("No se encontró empleado con ese ID.");
		}
	}
}