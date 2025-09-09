package negocio;

import java.util.List;
import java.util.prefs.AbstractPreferences;

import javabean.AbstractPersona;

public interface InstitutoDao {
	
	boolean altaPersona(AbstractPersona persona);
	boolean eliminarPersona(AbstractPersona persona);
	AbstractPersona buscarPorNif(String nif);
	List<AbstractPersona> buscarTodas();
	List<AbstractPersona> buscarPersonasPorTipo(String tipoPersona);

}
