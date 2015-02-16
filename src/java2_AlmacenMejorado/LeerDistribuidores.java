package java2_AlmacenMejorado;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeerDistribuidores {
	
	private ArrayList <Distribuidor> arrayDistribuidor = new ArrayList <Distribuidor> ();
	
	final ArrayList<Distribuidor> leerDistribuidores() {
	
		// Leer "distribuidores.txt"
		try {
	
			File archivo = new File("/home/zubiri/ProyectosJava/java2_AlmacenMejorado/ficheros/distribuidores.txt");
			BufferedReader br = new BufferedReader(new FileReader(archivo));
	
			String linea = br.readLine();
	
			// Creamos un array de tipo String para separar los campos del fichero
			String [] camposSeparados = null;
	
			while (linea != null) {
	
				// Creamos los objetos que participan en el fichero "distribuidores.txt"
				Distribuidor distribuidor = new Distribuidor ();
				Direccion direccion = new Direccion ();
				Contacto contacto = new Contacto ();
	
				// Separamos las lineas obtenidas (linea) mediante ", " y lo guardamos en "camposSeparados"
				camposSeparados = linea.split(", ");
	
				// Introducimos los valores capturados del fichero en los objetos creados
				distribuidor.setNombre(camposSeparados[0]);
				distribuidor.setCif(camposSeparados[1]);
	
				direccion.setPais(camposSeparados[2]);
				direccion.setProvincia(camposSeparados[3]);
				direccion.setCiudad(camposSeparados[4]);
				direccion.setCalle(camposSeparados[5]);
				direccion.setPiso(Integer.parseInt(camposSeparados[6]));
				direccion.setLetra(camposSeparados[7].charAt(0));
				direccion.setCodigoPostal(Integer.parseInt(camposSeparados[8]));
	
				contacto.setDni(camposSeparados[9]);
				contacto.setNombre(camposSeparados[10]);
				contacto.setApellido(camposSeparados[11]);
				contacto.setEdad(Integer.parseInt(camposSeparados[12]));
				contacto.setNacionalidad(camposSeparados[13]);
				contacto.setNacimiento(camposSeparados[14]);
				contacto.setSexo(camposSeparados[15]);
				contacto.setTelefono(Integer.parseInt(camposSeparados[16]));
				contacto.setEmail(camposSeparados[17]);
	
				// Introducimos los valores(objetos) de "direccion" y "contacto" en "distribuidor"
				distribuidor.setDireccion(direccion);
				distribuidor.setPersonaContacto(contacto);
	
				// Añadimos el objeto "distribuidor" al ArrayList "arrayDistribuidor"
				arrayDistribuidor.add(distribuidor);
	
				linea = br.readLine();
			}
			br.close();
	
		} catch(IOException e) {
			System.out.println("Error E/S: "+e);
		}
		return arrayDistribuidor;
	}
	
	final void mostrarDistribuidores() {
		
		for(int i=0; i<arrayDistribuidor.size(); i++) {

			System.out.println();
			System.out.println("      ------ DATOS DISTRIBUIDOR " + (i+1) + " ------ \n");

			System.out.println("Nombre Distribuidor: " + arrayDistribuidor.get(i).getNombre());
			System.out.println("C.I.F.: " + arrayDistribuidor.get(i).getCif());

			System.out.println("Dirección: ");
			System.out.println("   País: " + arrayDistribuidor.get(i).getDireccion().getPais());
			System.out.println("   Provincia: " + arrayDistribuidor.get(i).getDireccion().getProvincia());
			System.out.println("   Ciudad: " + arrayDistribuidor.get(i).getDireccion().getCiudad());
			System.out.println("   Calle: " + arrayDistribuidor.get(i).getDireccion().getCalle());
			System.out.println("   Piso: " + arrayDistribuidor.get(i).getDireccion().getPiso());
			System.out.println("   Letra: " + arrayDistribuidor.get(i).getDireccion().getLetra());
			System.out.println("   Código Postal: " + arrayDistribuidor.get(i).getDireccion().getCodigoPostal());

			System.out.println("Contacto de Persona: ");
			System.out.println("   DNI: " + arrayDistribuidor.get(i).getPersonaContacto().getDni());
			System.out.println("   Nombre: " + arrayDistribuidor.get(i).getPersonaContacto().getNombre());
			System.out.println("   Apellido: " + arrayDistribuidor.get(i).getPersonaContacto().getApellido());
			System.out.println("   Edad: " + arrayDistribuidor.get(i).getPersonaContacto().getEdad());
			System.out.println("   Nacionalidad: " + arrayDistribuidor.get(i).getPersonaContacto().getNacionalidad());
			System.out.println("   Fecha de Nacimiento: " + arrayDistribuidor.get(i).getPersonaContacto().getNacimiento());
			System.out.println("   Sexo: " + arrayDistribuidor.get(i).getPersonaContacto().getSexo());
			System.out.println("   Telefono: " + arrayDistribuidor.get(i).getPersonaContacto().getTelefono());
			System.out.println("   E-mail: " + arrayDistribuidor.get(i).getPersonaContacto().getEmail());
			System.out.println("--------------------------------");
			System.out.print("");
		}
	}
}