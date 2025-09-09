package testactividad;

import java.util.List;
import java.util.Scanner;

import javabean.Location;
import negocio.ILocationDao;
import negocio.LocationDaoImplList;

public class TestLocationDao {

	private static ILocationDao dao = new LocationDaoImplList();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		menuPrincipal();
		System.out.println("Fin del programa LocationDao.");
	}

	private static void menuPrincipal() {
		int opcion;
		do {
			System.out.println("\n======================================");
			System.out.println("   MENU LOCATION DAO  ");
			System.out.println("======================================");
			System.out.println("1) Listar todas las Locations");
			System.out.println("2) Buscar Location por ID");
			System.out.println("3) Buscar por City");
			System.out.println("4) Buscar por PostalCode");
			System.out.println("5) Buscar por Pais (countryId)");
			System.out.println("6) Insertar nueva Location");
			System.out.println("7) Eliminar Location por ID");
			System.out.println("0) Salir");
			System.out.print("Elige opción: ");

			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			case 1:
				listarTodas();
				break;
			case 2:
				buscarPorId();
				break;
			case 3:
				buscarPorCity();
				break;
			case 4:
				buscarPorPostalCode();
				break;
			case 5:
				buscarPorPais();
				break;
			case 6:
				insertar();
				break;
			case 7:
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

	private static void listarTodas() {
		List<Location> lista = dao.findAll();
		
		for (Location loc : lista) {
			System.out.println(loc);
		}
	}

	private static void buscarPorId() {
		System.out.println("Introduce ID de la Location: ");
		int id = sc.nextInt();
		sc.nextLine();
		Location loc = dao.findById(id);

		System.out.println(loc);
	}

	private static void buscarPorCity() {
		System.out.println("Introduce City: ");
		String city = sc.nextLine();
		List<Location> aux = dao.buscarPorCity(city);
		for (Location loc : aux) {
			System.out.println(loc);
		}
	}

	private static void buscarPorPostalCode() {
		System.out.println("Introduce PostalCode: ");
		String cp = sc.nextLine();
		List<Location> aux = dao.buscarPorPostalCode(cp);
		for (Location loc : aux) {
			System.out.println(loc);
		}
	}

	private static void buscarPorPais() {
		System.out.println("Introduce CountryId: ");
		String pais = sc.nextLine();
		List<Location> aux = dao.buscarPorPais(pais);
		for (Location loc : aux) {
			System.out.println(loc);
		}
	}

	private static void insertar() {
		System.out.println("ID para la nueva Location: ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Street Address: ");
		String street = sc.nextLine();

		Location loc = new Location();
		loc.setLocationId(id);
		loc.setStreetAddress(street);

		int r = dao.insertOne(loc);
		if(r == 1) {
			System.out.println("Location insertada con éxito.");
		} else {
			System.out.println("No se pudo insertar.");
		}
	}

	private static void eliminar() {
		System.out.println("ID de la Location a eliminar: ");
		int id = sc.nextInt();
		sc.nextLine();

		int r = dao.deleteById(id);
		if(r == 1) {
			System.out.println("Location eliminada.");
		} else {
			System.out.println("No se encontró Location con ese ID.");
		}
	}
}
