package testing.dao;

import modelo.dao.RegionDao;
import modelo.dao.RegionDaoImplMy8Jdbc;
import modelo.javabean.Region;

public class TestRegionDao {
	private static RegionDao rdao;
	static {
		rdao= new RegionDaoImplMy8Jdbc();
	}
	public static void main(String[] args) {
		// todos();
		// una();
		// insert();
		//  update();
		  delete();
		

	}
	
	public static void delete() {
		
		switch(rdao.deleteOne(1)) {
		case 1: System.out.println("Borrado");
		break;
		case 0: System.out.println("No existe");
		break;
		default: System.out.println("No se puede eliminar, porque hay paises con este codigo");
		
		
		
		}
		
	}
	public static void update() {
		System.out.println("\nMODIFICAR  UNA REGION\n");
		
		Region reg = rdao.findById(15);
		if (reg != null) {
			reg.setRegionName("Castila la nueva");
			System.out.println("Region 5 modificada , espero 1 : " + rdao.updateOne(reg));
			todos();
		}else
			System.out.println("la region buscada no existe");
		
		Region region = new Region(15,"Atlantida");
		
		System.out.println("Region 15 NO EXISTE , espero 0 : " + rdao.updateOne(region));
		
	}
	
	public static void insert() {
		System.out.println("\nINSERTAR UNA REGION\n");
		Region region = new Region(5,"Atlantida");
		
		System.out.println("region insertada, me espero 1 : " + rdao.insertOne(region));
		
		Region region2 = new Region(1,"Europa");
		
		System.out.println("region NOOO insertada, me espero 0 : " + rdao.insertOne(region2));
	}
	
	public static void una() {
		
		System.out.println("MOSTRAR UNA REGION");
		
		System.out.println("la region 1 existe : " + rdao.findById(1));
		System.out.println("la region 12 NOO existe sale NULL : " + rdao.findById(12));
		
	}
	
	
	
	public static void todos() {
		System.out.println("\ntodos\n");
		for (Region ele: rdao.findAll())
			System.out.println(ele);
	}

}
