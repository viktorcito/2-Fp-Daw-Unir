package testing;

import java.util.ArrayList;

import javabean.Country;
import javabean.Region;

public class TestMuchosRegion {

	public static void main(String[] args) {
		Region region1 = new Region(1, "Europa");
		
		Country c1 = new Country("SP", "España", region1);
		Country c2 = new Country("AL", "Alemania", region1);
		Country c3 = new Country("FR", "Francia", region1);
		
		ArrayList<Country> lista = new ArrayList<Country>();
		lista.add(c1);
		lista.add(c2);
		lista.add(c3);
		
		region1.setCountries(lista);
		
		
		for (Country country: region1.getCountries()) {
			System.out.println("El pais es : " + country.getCountryName());
		}
		
		region1.addCountry(new Country("BL", "Belgica",region1));
		System.out.println("LISTADO AL AÑADIR BELGICA");
		for (Country country: region1.getCountries()) {
			System.out.println("El pais es : " + country.getCountryName());
		}
		
		region1.removeCountry(c2);
		
		System.out.println("LISTADO AL eliminar  a ALEMANIA");
		for (Country country: region1.getCountries()) {
			System.out.println("El pais es : " + country.getCountryName());
		}
		
		System.out.println(region1);
		
		
		
		
		
		

	}

}
