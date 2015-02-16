package java2_AlmacenMejorado;

import java.util.Scanner;
import java.util.ArrayList;

public class LoteLeche {
	
	private ArrayList <Leche> arrayLeche = new ArrayList <Leche> ();
	private ArrayList <Distribuidor> arrayDistribuidor = new ArrayList <Distribuidor> ();
	private Scanner sc = new Scanner(System.in);
	
	public void pedirLeches() {
		
		System.out.println("\n      ------ LECHES ------ \n");
		System.out.print("Introduce el número de leches a introducir: ");
		int num = sc.nextInt();

		for (int le=0; le<num; le++) {

			Leche leche = new Leche ();
			// Para enviar el nombre del distribuidor
			Distribuidor distribuidor = new Distribuidor ();

			System.out.print("Introduce el tipo de Leche: ");
			leche.setTipo(sc.next());

			System.out.print("Procedencia: ");
			leche.setProcedencia(sc.next());

			System.out.print("Introduce el precio por litro: ");
			leche.setEurosLitro(sc.nextDouble());

			System.out.print("Introduce el distribuidor de la Leche: ");
			String distribuidorle = sc.next();
			distribuidor.setNombre(distribuidorle);
			
			arrayDistribuidor = distribuidor.leerDistribuidores();

			for (int q=0; q<arrayDistribuidor.size(); q++) {

				// Si el nombre del distribuidor introducido coincide con uno del arraylist (distribuidores.txt)
				if (distribuidorle.equalsIgnoreCase(arrayDistribuidor.get(q).getNombre())) {

					// Asignamos el valor del distribuidor al objeto leche
					leche.setDistribuidor(arrayDistribuidor.get(q));
				}
			}

			// Añadimos el objeto "leche" al ArrayList "arrayLeche"
			arrayLeche.add(leche);

			System.out.println();
		}
	}
	
	public final void mostrarLeches() {
		
		for (int lee=0; lee<arrayLeche.size(); lee++) {

			System.out.println();
			System.out.println("      ------ DATOS LECHE " + (lee+1) + " Y DISTRIBUIDOR ------ \n");

			System.out.println("Tipo de leche: " + arrayLeche.get(lee).getTipo() );
			System.out.println("Procedencia: " + arrayLeche.get(lee).getProcedencia());
			System.out.println("Euros Unidad: " + arrayLeche.get(lee).getEurosLitro());

			System.out.println();

			// Leche.java (Distribuidor) -- Distribuidor.java (Nombre)
			System.out.println("Nombre Distribuidor: " + arrayLeche.get(lee).getDistribuidor().getNombre());
			System.out.println("C.I.F.: " + arrayLeche.get(lee).getDistribuidor().getCif());

			System.out.println("Dirección: ");
			// Leche.java (Distribuidor) -- Distribuidor.java (Nombre, Direccion) -- Direccion.java (Pais)
			System.out.println("   País: " + arrayLeche.get(lee).getDistribuidor().getDireccion().getPais());
			System.out.println("   Provincia: " + arrayLeche.get(lee).getDistribuidor().getDireccion().getProvincia());
			System.out.println("   Ciudad: " + arrayLeche.get(lee).getDistribuidor().getDireccion().getCiudad());
			System.out.println("   Calle: " + arrayLeche.get(lee).getDistribuidor().getDireccion().getCalle());
			System.out.println("   Piso: " + arrayLeche.get(lee).getDistribuidor().getDireccion().getPiso());
			System.out.println("   Letra: " + arrayLeche.get(lee).getDistribuidor().getDireccion().getLetra());
			System.out.println("   Código Postal: " + arrayLeche.get(lee).getDistribuidor().getDireccion().getCodigoPostal());

			System.out.println("Contacto de Persona: ");
			// Leche.java (Distribuidor) -- Distribuidor.java (Nombre, PersonaContacto) -- Contacto.java (Dni)
			System.out.println("   DNI: " + arrayLeche.get(lee).getDistribuidor().getPersonaContacto().getDni());
			System.out.println("   Nombre: " + arrayLeche.get(lee).getDistribuidor().getPersonaContacto().getNombre());
			System.out.println("   Apellido: " + arrayLeche.get(lee).getDistribuidor().getPersonaContacto().getApellido());
			System.out.println("   Edad: " + arrayLeche.get(lee).getDistribuidor().getPersonaContacto().getEdad());
			System.out.println("   Nacionalidad: " + arrayLeche.get(lee).getDistribuidor().getPersonaContacto().getNacionalidad());
			System.out.println("   Fecha de Nacimiento: " + arrayLeche.get(lee).getDistribuidor().getPersonaContacto().getNacimiento());
			System.out.println("   Sexo: " + arrayLeche.get(lee).getDistribuidor().getPersonaContacto().getSexo());
			System.out.println("   Telefono: " + arrayLeche.get(lee).getDistribuidor().getPersonaContacto().getTelefono());
			System.out.println("   E-mail: " + arrayLeche.get(lee).getDistribuidor().getPersonaContacto().getEmail());
			System.out.println("--------------------------------");
			System.out.print("");
		}
	}
}