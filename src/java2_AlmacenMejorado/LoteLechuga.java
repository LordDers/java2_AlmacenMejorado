package java2_AlmacenMejorado;

import java.util.Scanner;
import java.util.ArrayList;

public class LoteLechuga {
	
	private ArrayList <Lechuga> arrayLechuga = new ArrayList <Lechuga> ();
	private ArrayList <Distribuidor> arrayDistribuidor = new ArrayList <Distribuidor> ();
	private Scanner sc = new Scanner(System.in);
	
	public void pedirLechugas() {

		System.out.println("\n      ------ LECHUGA ------ \n");
		System.out.print("Introduce el número de lechugas a introducir: ");
		int num = sc.nextInt();

		for (int l=0; l<num; l++) {

			Lechuga lechuga = new Lechuga ();
			// Para enviar el nombre del distribuidor
			Distribuidor distribuidor = new Distribuidor();

			System.out.print("Introduce el tipo de Lechuga: ");
			lechuga.setTipo(sc.next());

			System.out.print("Procedencia: ");
			lechuga.setProcedencia(sc.next());

			System.out.print("Color: ");
			lechuga.setColor(sc.next());

			System.out.print("Introduce el precio por unidad: ");
			lechuga.setEurosUnidad(sc.nextDouble());

			System.out.print("Introduce el distribuidor de la Lechuga: ");
			String distribuidorl = sc.next();
			distribuidor.setNombre(distribuidorl);
			
			arrayDistribuidor = distribuidor.leerDistribuidores();

			for (int q=0; q<arrayDistribuidor.size(); q++) {

				// Si el nombre del distribuidor introducido coincide con uno del arraylist (distribuidores.txt)
				if (distribuidorl.equalsIgnoreCase(arrayDistribuidor.get(q).getNombre())) {

					// Asignamos el valor del distribuidor al objeto lechuga
					lechuga.setDistribuidor(arrayDistribuidor.get(q));
				}
			}

			// Añadimos el objeto "lechuga" al ArrayList "arrayLechuga"
			arrayLechuga.add(lechuga);

			System.out.println();
		}
	}
	
	public final void mostrarLechugas() {
		
		for(int ll=0; ll<arrayLechuga.size(); ll++) {

			System.out.println();
			System.out.println("      ------ DATOS LECHUGA " + (ll+1) + " Y DISTRIBUIDOR ------ \n");

			System.out.println("Tipo de lechuga: " + arrayLechuga.get(ll).getTipo() );
			System.out.println("Procedencia: " + arrayLechuga.get(ll).getProcedencia());
			System.out.println("Color : " + arrayLechuga.get(ll).getColor() );
			System.out.println("Euros Unidad: " + arrayLechuga.get(ll).getEurosUnidad());

			System.out.println();

			// Lechuga.java (Distribuidor) -- Distribuidor.java (Nombre)
			System.out.println("Nombre Distribuidor: " + arrayLechuga.get(ll).getDistribuidor().getNombre());
			System.out.println("C.I.F.: " + arrayLechuga.get(ll).getDistribuidor().getCif());

			System.out.println("Dirección: ");
			// Lechuga.java (Distribuidor) -- Distribuidor.java (Nombre, Direccion) -- Direccion.java (Pais)
			System.out.println("   País: " + arrayLechuga.get(ll).getDistribuidor().getDireccion().getPais());
			System.out.println("   Provincia: " + arrayLechuga.get(ll).getDistribuidor().getDireccion().getProvincia());
			System.out.println("   Ciudad: " + arrayLechuga.get(ll).getDistribuidor().getDireccion().getCiudad());
			System.out.println("   Calle: " + arrayLechuga.get(ll).getDistribuidor().getDireccion().getCalle());
			System.out.println("   Piso: " + arrayLechuga.get(ll).getDistribuidor().getDireccion().getPiso());
			System.out.println("   Letra: " + arrayLechuga.get(ll).getDistribuidor().getDireccion().getLetra());
			System.out.println("   Código Postal: " + arrayLechuga.get(ll).getDistribuidor().getDireccion().getCodigoPostal());

			System.out.println("Contacto de Persona: ");
			// Lechuga.java (Distribuidor) -- Distribuidor.java (Nombre, PersonaContacto) -- Contacto.java (Dni)
			System.out.println("   DNI: " + arrayLechuga.get(ll).getDistribuidor().getPersonaContacto().getDni());
			System.out.println("   Nombre: " + arrayLechuga.get(ll).getDistribuidor().getPersonaContacto().getNombre());
			System.out.println("   Apellido: " + arrayLechuga.get(ll).getDistribuidor().getPersonaContacto().getApellido());
			System.out.println("   Edad: " + arrayLechuga.get(ll).getDistribuidor().getPersonaContacto().getEdad());
			System.out.println("   Nacionalidad: " + arrayLechuga.get(ll).getDistribuidor().getPersonaContacto().getNacionalidad());
			System.out.println("   Fecha de Nacimiento: " + arrayLechuga.get(ll).getDistribuidor().getPersonaContacto().getNacimiento());
			System.out.println("   Sexo: " + arrayLechuga.get(ll).getDistribuidor().getPersonaContacto().getSexo());
			System.out.println("   Telefono: " + arrayLechuga.get(ll).getDistribuidor().getPersonaContacto().getTelefono());
			System.out.println("   E-mail: " + arrayLechuga.get(ll).getDistribuidor().getPersonaContacto().getEmail());
			System.out.println("--------------------------------");
			System.out.print("");
		}
	}
}