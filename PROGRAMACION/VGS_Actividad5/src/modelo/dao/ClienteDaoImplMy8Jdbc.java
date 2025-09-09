package modelo.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.javabean.Cliente;

public class ClienteDaoImplMy8Jdbc extends AbsGenericoDaoImpl implements ClienteDao {

	// HELPERS
	private Cliente map() throws SQLException {
		return new Cliente(rs.getString("cif"), rs.getString("nombre"), rs.getString("apellidos"),
				rs.getString("domicilio"), rs.getDouble("facturacion_anual"), rs.getInt("numero_empleados"));
	}

	@Override
	public List<Cliente> findAll() {
		sql = "SELECT * FROM clientes";
		List<Cliente> lista = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next())
				lista.add(map());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Cliente findById(String cif) {
		sql = "SELECT * FROM clientes WHERE cif = ?";
		Cliente cli = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cif);
			rs = ps.executeQuery();
			if (rs.next())
				cli = map();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cli;
	}

	@Override
	public int insertOne(Cliente c) {
		sql = """
				INSERT INTO clientes
				(cif,nombre,apellidos,domicilio,facturacion_anual,numero_empleados)
				VALUES (?,?,?,?,?,?)
				""";
		filas = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, c.getCif());
			ps.setString(2, c.getNombre());
			ps.setString(3, c.getApellidos());
			ps.setString(4, c.getDomicilio());
			ps.setDouble(5, c.getFacturacionAnual());
			ps.setInt(6, c.getNumeroEmpleados());
			filas = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			filas = 0;
		}
		return filas;
	}

	@Override
	public int deleteOne(String cif) {
		sql = "DELETE FROM clientes WHERE cif = ?";
		filas = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cif);
			filas = ps.executeUpdate();
		} catch (SQLException e) {
			filas = -1;
		}
		return filas;
	}

	/*------------------------------------------------
	 *        EXPORTAR  /  IMPORTAR 
	 *------------------------------------------------*/

	@Override
	public String exportar(String rutaFichero) {

		File fichero;
		if (rutaFichero == null || rutaFichero.isBlank()) {
			String desktop = System.getProperty("user.home") + "\\Desktop";
			fichero = new File(desktop, "clientes.csv");
		} else {
			fichero = new File(rutaFichero);
		}

		try {
			if (!fichero.exists()) {
				if (!fichero.createNewFile())
					return "No se pudo crear el fichero destino";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "No se pudo crear el fichero destino";
		}

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero))) {

			for (Cliente c : findAll()) {
				bw.write(String.join(";", c.getCif(), c.getNombre(), c.getApellidos(), c.getDomicilio(),
						String.valueOf(c.getFacturacionAnual()), String.valueOf(c.getNumeroEmpleados())));
				bw.newLine();
			}
			return "Clientes exportados en: " + fichero.getAbsolutePath();

		} catch (Exception e) {
			e.printStackTrace();
			return "Error al exportar";
		}
	}

	@Override
	public List<Cliente> importar(String rutaFichero) {

		File fichero = (rutaFichero == null || rutaFichero.isBlank())
				? new File(System.getProperty("user.home") + "\\Desktop", "clientes.csv")
				: new File(rutaFichero);

		List<Cliente> lista = new ArrayList<>();

		if (!fichero.exists()) {
			System.err.println("Fichero no existe: " + fichero.getAbsolutePath());
			return lista;
		}

		try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] d = linea.split(";");
				Cliente c = new Cliente(d[0], d[1], d[2], d[3], Double.parseDouble(d[4]), Integer.parseInt(d[5]));
				lista.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

}