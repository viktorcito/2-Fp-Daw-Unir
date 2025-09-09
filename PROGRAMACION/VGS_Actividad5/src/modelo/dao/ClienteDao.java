package modelo.dao;

import java.util.List;
import modelo.javabean.Cliente;

public interface ClienteDao {

	List<Cliente> findAll();

	Cliente findById(String cif);

	int insertOne(Cliente c);

	int deleteOne(String cif);

	String exportar(String rutaFichero);

	List<Cliente> importar(String rutaFichero);
}