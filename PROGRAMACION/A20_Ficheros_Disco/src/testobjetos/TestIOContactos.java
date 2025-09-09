package testobjetos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

import javabean.Contacto;

public class TestIOContactos {

	public static void main(String[] args) {
	//	grabarContactos();
	 	leerContactos();
		
		System.out.println("FIN DE PROCESO");

	}
	
	public static void grabarContactos() {
		
		Contacto contacto = new Contacto(1, "Eva", "Goma", "678678678", LocalDate.of(1997, 4, 25));
		
		File fichero = new File("d:/ficheros/contactos.obj");
		FileOutputStream fos=null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(fichero);
			 
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(contacto);
			
			
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				oos.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	public static void leerContactos() {
		
		Contacto contacto = null;
		File fichero = new File("d:/ficheros/contactos.obj");
		FileInputStream fis=null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(fichero);
			ois = new ObjectInputStream(fis);
			
			contacto = (Contacto)ois.readObject();
			System.out.println(contacto);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	

}
