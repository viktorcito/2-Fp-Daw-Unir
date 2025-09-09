package negocio;

import java.util.ArrayList;
import java.util.List;

import javabean.Country;
import javabean.Location;

public class LocationDaoImplList implements ILocationDao {

	private List<Location> lista;

	private ICountryDao iCountryDao;

	public LocationDaoImplList() {
		lista = new ArrayList<Location>();
		iCountryDao = new CountryDaoImplList();
		cargarDatos();
	}

	private void cargarDatos() {
		lista.add(new Location(1500, "pez 3", "28008", "Madrid", "Madrid", iCountryDao.findById("ES")));
		lista.add(new Location(1600, "nuez 3", "28016", "Madrid", "Madrid", iCountryDao.findById("ES")));
		lista.add(new Location(1700, "rosa 34", "19002", "Guadalajara", "Guadalajara", iCountryDao.findById("ES")));

	}

	@Override
	public Location findById(Integer atributoPk) {
		for (Location ele : lista) {
			if (ele.getLocationId() == atributoPk)
				return ele;
		}

		return null;
	}

	@Override
	public int insertOne(Location objeto) {
		if (lista.contains(objeto)) {
			return 0;
		} else {
			lista.add(objeto);
			return 1;
		}
	}

	@Override
	public int updateOne(Location objeto) {
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
	public int deleteObj(Location objeto) {
		return lista.remove(objeto) ? 1 : 0;
	}

	@Override
	public List<Location> findAll() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public List<Location> buscarPorCity(String city) {
		List<Location> aux = new ArrayList<Location>();
		for (Location loc : lista) {
			if (loc.getCity().equalsIgnoreCase(city)) {
				aux.add(loc);
			}
		}
		return aux;
	}

	@Override
	public List<Location> buscarPorPostalCode(String postalCode) {
		List<Location> aux = new ArrayList<Location>();
		for (Location loc : lista) {
			if (loc.getPostalCode().equalsIgnoreCase(postalCode)) {
				aux.add(loc);
			}
		}
		return aux;
	}

	@Override
	public List<Location> buscarPorPais(String countryId) {
		List<Location> aux = new ArrayList<Location>();
		for (Location loc : lista) {
			if (loc.getCountry().getCountryId().equalsIgnoreCase(countryId)) {
				aux.add(loc);
			}
		}
		return aux;
	}

}
