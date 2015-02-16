package java2_AlmacenMejorado;

import java.util.Scanner;

public class Almacen {

	public static void main (String args[]) {

		Scanner sc = new Scanner (System.in);

		System.out.println("          MENU:");
		System.out.println("1. Mostrar distribuidores");
		System.out.println("2. Introducir Manzanas");
		System.out.println("3. Introducir Lechuga");
		System.out.println("4. Introducir Leches");
		System.out.println("5. Mostrar clientes");
		System.out.println("6. Cesta");
		System.out.println("66. SALIR");

		System.out.print("\nIntroduce una opcion: ");
		int opcion = sc.nextInt();
		
		switch (opcion) {

			case 1: {
				
				/*LeerDistribuidores ld = new LeerDistribuidores();
				ld.leerDistribuidores();
				ld.mostrarDistribuidores();*/
				Distribuidor distribuidor = new Distribuidor();
				distribuidor.leerDistribuidores();
				distribuidor.mostrarDistribuidores();
				break;
			}

			// ---------------- 3.12 ----------------

			// Manzanas

			case 2: {

				LoteManzana manzanas = new LoteManzana();
				manzanas.pedirManzanas();
				manzanas.mostrarManzanas();
				break;
			}

			// Lechuga

			case 3: {

				LoteLechuga lechugas = new LoteLechuga();
				lechugas.pedirLechugas();
				lechugas.mostrarLechugas();
				break;
			}

			// Leche

			case 4: {

				LoteLeche leches = new LoteLeche();
				leches.pedirLeches();
				leches.mostrarLeches();
				break;
			}

			// ---------------- 3.13 ----------------

			case 5: {
				
				/*LeerClientes lc = new LeerClientes();
				lc.leerClientes();
				lc.mostrarClientes();*/
				Cliente cliente = new Cliente();
				cliente.leerClientes();
				cliente.mostrarClientes();
				break;
			}
			
			case 6: {
				
				PedirCesta pc = new PedirCesta();
				pc.pedirCesta();
				/*Cesta cesta = new Cesta();
				cesta.pedirCesta();*/
			}

			case 66: {

				System.out.println();
				System.out.println("Has decidido salir.");
				break;
			}

			default: {

				System.out.println();
				System.out.println("No has seleccionado una opción válida.");
			}
		}
		sc.close();
	}
}