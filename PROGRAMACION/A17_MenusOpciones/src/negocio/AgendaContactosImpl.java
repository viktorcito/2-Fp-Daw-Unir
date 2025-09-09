package negocio;

import java.util.ArrayList;
import java.util.List;

import javabean.Contacto;

public class AgendaContactosImpl implements IAgendaContacto{
	
	private List<Contacto> lista;
	
	public AgendaContactosImpl() {
		lista = new ArrayList<Contacto>();
		cargarDatos();
	}
	
	private void cargarDatos() {
		lista.add(new Contacto("eva", "678678678"));
		lista.add(new Contacto("carlos", "678678555"));
		lista.add(new Contacto("sara", "678678333"));
		
	}

	@Override
	public List<Contacto> buscarTodos() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Contacto buscarUno(String nombre) {
		for (Contacto contacto: lista) {
			if (contacto.getNombre().equals(nombre))
				return contacto;
		}
		
		return null;
	}

	@Override
	public boolean alta(Contacto contacto) {
		if (contacto == null)
			return false;
		if (lista.contains(contacto))
			return false;
		else
			return lista.add(contacto);
	}

}
