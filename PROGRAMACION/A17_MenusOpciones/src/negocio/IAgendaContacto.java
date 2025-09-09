package negocio;

import java.util.List;

import javabean.Contacto;

public interface IAgendaContacto {
	
	List<Contacto> buscarTodos();
	Contacto buscarUno(String nombre);
	boolean alta(Contacto contacto);
	

}
