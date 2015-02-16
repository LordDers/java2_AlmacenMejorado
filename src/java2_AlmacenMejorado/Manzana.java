package java2_AlmacenMejorado;
/*import java.util.Scanner;
import java.util.ArrayList;*/

public class Manzana extends Producto {

	//propiedades
	private String color;
	private Double eurosKilo;	
	
	/*ArrayList <Manzana> arrayManzana = new ArrayList <Manzana> ();
	ArrayList <Distribuidor> arrayDistribuidor = new ArrayList <Distribuidor> ();
	Scanner sc = new Scanner(System.in);*/

	//métodos getter y setter
	public Manzana() {
		super();
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public Double getEurosKilo() {
		return eurosKilo;
	}
	
	public void setEurosKilo(Double eurosKilo) {
		this.eurosKilo = eurosKilo;
	}	
	
	/*public void pedirManzanas() {
		
		System.out.println();
		System.out.println("      ------ MANZANAS ------ \n");
		System.out.println("A continuación, introduciremos dos manzanas.");

		for (int m=1; m<=2; m++) {

			Manzana manzana = new Manzana ();
			// Para enviar el nombre del distribuidor
			Distribuidor distribuidor = new Distribuidor();

			System.out.print("Introduce el tipo de manzana: ");
			manzana.setTipoManzana(sc.next());
			
			System.out.print("Procedencia: ");
			manzana.setProcedencia(sc.next());
			
			System.out.print("Color: ");
			manzana.setColor(sc.next());
			
			System.out.print("Introduce el precio por kilo: ");
			manzana.setEurosKilo(sc.nextDouble());

			System.out.print("Introduce el distribuidor de la manzana: ");
			//manzana.setDistribuidor(sc.next());
			String distribuidorm = sc.next();
			distribuidor.setNombre(distribuidorm);

			for(int q=0; q<arrayDistribuidor.size(); q++) {

				// Si el nombre del distribuidor introducido coincide con uno del arraylist (distribuidores.txt)
				if (distribuidorm.equalsIgnoreCase(arrayDistribuidor.get(q).getNombre())) {

					// Asignamos el valor del distribuidor al objeto manzana
					manzana.setDistribuidor(arrayDistribuidor.get(q));
				}
			}

			// Añadimos el objeto "manzana" al ArrayList "arrayManzana"
			arrayManzana.add(manzana);

			System.out.println();
		}
	}
	
	public final void mostrarManzanas() {
		
		for(int mm=0; mm<arrayManzana.size(); mm++) {

			System.out.println();
			System.out.println("      ------ DATOS MANZANA " + (mm+1) + " Y DISTRIBUIDOR ------ \n");

			System.out.println("Tipo de manzana: " + arrayManzana.get(mm).getTipoManzana() );
			System.out.println("Procedencia: " + arrayManzana.get(mm).getProcedencia());
			System.out.println("Color : " + arrayManzana.get(mm).getColor() );
			System.out.println("Euros Kilo: " + arrayManzana.get(mm).getEurosKilo());

			System.out.println();

			// Manzana.java (Distribuidor) -- Distribuidor.java (Nombre)
			System.out.println("Nombre Distribuidor: " + arrayManzana.get(mm).getDistribuidor().getNombre());
			System.out.println("C.I.F.: " + arrayManzana.get(mm).getDistribuidor().getCif());

			System.out.println("Dirección: ");
			// Manzana.java (Distribuidor) -- Distribuidor.java (Nombre, Direccion) -- Direccion.java (Pais)
			System.out.println("   País: " + arrayManzana.get(mm).getDistribuidor().getDireccion().getPais());
			System.out.println("   Provincia: " + arrayManzana.get(mm).getDistribuidor().getDireccion().getProvincia());
			System.out.println("   Ciudad: " + arrayManzana.get(mm).getDistribuidor().getDireccion().getCiudad());
			System.out.println("   Calle: " + arrayManzana.get(mm).getDistribuidor().getDireccion().getCalle());
			System.out.println("   Piso: " + arrayManzana.get(mm).getDistribuidor().getDireccion().getPiso());
			System.out.println("   Letra: " + arrayManzana.get(mm).getDistribuidor().getDireccion().getLetra());
			System.out.println("   Código Postal: " + arrayManzana.get(mm).getDistribuidor().getDireccion().getCodigoPostal());

			System.out.println("Contacto de Persona: ");
			// Manzana.java (Distribuidor) -- Distribuidor.java (Nombre, PersonaContacto) -- Contacto.java (Dni)
			System.out.println("   DNI: " + arrayManzana.get(mm).getDistribuidor().getPersonaContacto().getDni());
			System.out.println("   Nombre: " + arrayManzana.get(mm).getDistribuidor().getPersonaContacto().getNombre());
			System.out.println("   Apellido: " + arrayManzana.get(mm).getDistribuidor().getPersonaContacto().getApellido());
			System.out.println("   Edad: " + arrayManzana.get(mm).getDistribuidor().getPersonaContacto().getEdad());
			System.out.println("   Nacionalidad: " + arrayManzana.get(mm).getDistribuidor().getPersonaContacto().getNacionalidad());
			System.out.println("   Fecha de Nacimiento: " + arrayManzana.get(mm).getDistribuidor().getPersonaContacto().getNacimiento());
			System.out.println("   Sexo: " + arrayManzana.get(mm).getDistribuidor().getPersonaContacto().getSexo());
			System.out.println("   Telefono: " + arrayManzana.get(mm).getDistribuidor().getPersonaContacto().getTelefono());
			System.out.println("   E-mail: " + arrayManzana.get(mm).getDistribuidor().getPersonaContacto().getEmail());
			System.out.println("--------------------------------");
			System.out.print("");
		}
	}*/
}