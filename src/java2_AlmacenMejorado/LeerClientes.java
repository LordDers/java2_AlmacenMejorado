package java2_AlmacenMejorado;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeerClientes {
	
	private ArrayList <Cliente> arrayCliente = new ArrayList <Cliente> ();
	
	final ArrayList<Cliente> leerClientes() {
		
		// Leer "clientes.txt"
		try {

			File archivo = new File("/home/zubiri/ProyectosJava/java2_AlmacenMejorado/ficheros/clientes.txt");
			BufferedReader br2 = new BufferedReader(new FileReader(archivo));

			String linea2 = br2.readLine();

			// Creamos un array de tipo String para separar los campos del fichero
			String [] camposSeparados2 = null;

			while (linea2 != null) {

				// Creamos los objetos que participan en el fichero "clientes.txt"
				Cliente cliente = new Cliente ();
				Direccion direccion2 = new Direccion ();

				// Separamos las lineas obtenidas (linea2) mediante ", " y lo guardamos en "camposSeparados2"
				camposSeparados2 = linea2.split(", ");

				// Introducimos los valores capturados del fichero en los objetos creados
				cliente.setNombre(camposSeparados2[0]);
				cliente.setApellido(camposSeparados2[1]);
				cliente.setDni(camposSeparados2[2]);

				direccion2.setPais(camposSeparados2[3]);
				direccion2.setProvincia(camposSeparados2[4]);
				direccion2.setCiudad(camposSeparados2[5]);
				direccion2.setCalle(camposSeparados2[6]);
				direccion2.setPiso(Integer.parseInt(camposSeparados2[7]));
				direccion2.setLetra(camposSeparados2[8].charAt(0));
				direccion2.setCodigoPostal(Integer.parseInt(camposSeparados2[9]));

				cliente.setNumSocio(Double.parseDouble(camposSeparados2[10]));
				cliente.setDescuento(Double.parseDouble(camposSeparados2[11]));

				// Introducimos los valores(objetos) de "direccion2" en "cliente"
				cliente.setDireccion(direccion2);

				// Añadimos el objeto "cliente" al ArrayList "arrayCliente"
				arrayCliente.add(cliente);

				linea2 = br2.readLine();
			}
			br2.close();
			
		} catch(IOException e) {
			System.out.println("Error E/S: "+e);
		}
		return arrayCliente;
	}
	
	final void mostrarClientes() {
		
		for(int c=0; c<arrayCliente.size(); c++) {

			System.out.println();
			System.out.println("      ------ DATOS CLIENTE " + (c+1) + " ------ \n");

			System.out.println("Nombre Cliente: " + arrayCliente.get(c).getNombre());
			System.out.println("Apellido Cliente: " + arrayCliente.get(c).getApellido());
			System.out.println("DNI: " + arrayCliente.get(c).getDni());

			System.out.println("Dirección: ");
			// Cliente.java (Direccion) -- Direccion.java (Pais)
			System.out.println("   País: " + arrayCliente.get(c).getDireccion().getPais());
			System.out.println("   Provincia: " + arrayCliente.get(c).getDireccion().getProvincia());
			System.out.println("   Ciudad: " + arrayCliente.get(c).getDireccion().getCiudad());
			System.out.println("   Calle: " + arrayCliente.get(c).getDireccion().getCalle());
			System.out.println("   Piso: " + arrayCliente.get(c).getDireccion().getPiso());
			System.out.println("   Letra: " + arrayCliente.get(c).getDireccion().getLetra());
			System.out.println("   Código Postal: " + arrayCliente.get(c).getDireccion().getCodigoPostal());

			System.out.println("Número de Socio: " + arrayCliente.get(c).getNumSocio());
			System.out.println("Descuento: " + arrayCliente.get(c).getDescuento() + "%");
			System.out.println("--------------------------------");
			System.out.print("");
		}
	}
}