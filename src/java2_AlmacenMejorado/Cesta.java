package java2_AlmacenMejorado;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Cesta {

	private Cliente vcliente;
	private ArrayList <Manzana> arrayManzanaCesta;
	private ArrayList <Lechuga> arrayLechugaCesta;
	private ArrayList <Leche> arrayLecheCesta;
	private Double vimporteCompra;

	public void setCliente (Cliente cliente) {
		this.vcliente = cliente;
	}

	public Cliente getCliente () {
		return vcliente;
	}

	public void setManzana (ArrayList <Manzana> manzana) {
		this.arrayManzanaCesta = manzana;
	}

	public ArrayList <Manzana> getManzada () {
		return arrayManzanaCesta;
	}

	public void setLechuga (ArrayList <Lechuga> lechuga) {
		this.arrayLechugaCesta = lechuga;
	}

	public ArrayList <Lechuga> getLechuga () {
		return arrayLechugaCesta;
	}

	public void setLeche (ArrayList <Leche> leche) {
		this.arrayLecheCesta = leche;
	}

	public ArrayList <Leche> getLeche () {
		return arrayLecheCesta;
	}

	public void setImporteCompra (Double euro, Double descuento) {
		this.vimporteCompra = euro - (euro * descuento) / 100;
	}

	public Double getImporteCompra () {
		return vimporteCompra;
	}
	
	private Scanner sc = new Scanner(System.in);
	private ArrayList <Cliente> arrayCliente = new ArrayList <Cliente> ();
	
	final void pedirCesta() {
		
		Cesta cesta = new Cesta ();
	
		System.out.println("\n      ------ CESTA ------ \n");
	
		// Variable para calcular el descuento
		double descuentocliente = 0.0;
	
		// Variable para saber si quiere pedir más productos
		char mas = 's';
	
		// Variable para comprobar si existe el número de socio
		boolean numsocio = false; 
	
		// Bucle para comprobar si el número de socio introducido es correcto
		do {
	
			System.out.print("Introduce el número de socio: ");
			int numeroSocio = sc.nextInt();
			
			LeerClientes lc = new LeerClientes();
			arrayCliente = lc.leerClientes();
	
			for (int cli=0; cli<arrayCliente.size(); cli++) {
	
				// Si el numero de socio introducido coincide con uno del arraylist (clientes.txt)
				if (numeroSocio == (arrayCliente.get(cli).getNumSocio())) {
	
					// Mostramos los datos del cliente
					System.out.println("Nombre: " + arrayCliente.get(cli).getNombre());
					System.out.println("Apellido: " + arrayCliente.get(cli).getApellido());
					System.out.println("DNI: " + arrayCliente.get(cli).getDni());
					System.out.println("Numero Socio: " + arrayCliente.get(cli).getNumSocio());
	
					// Asignamos a la variable "numsocio" el valor "true" para terminar el bucle, el número de socio coincide
					numsocio = true;
	
					// Asignamos a la variable "descuentocliente" el descuento que tiene
					descuentocliente = arrayCliente.get(cli).getDescuento();
					break;
				}
				else {
	
					// Asignamos a la variable "numsocio" el valor "false" para seguir en el bucle, puesto que no existe el número de socio
					numsocio = false;
				}
			}
		} while (numsocio == false);
	
		System.out.println();
	
		// Bucle para ver si quiere pedir mas, en caso de pulsar 'n', sale
		do {
	
			System.out.println("Introduce el producto a pedir, Manzana, Lechuga o Leche: ");
			String productopedir = sc.next();
	
			System.out.println("\nIntroduce el código de barras a pedir: ");
			int codbarrasp = sc.nextInt();
	
			// Variable para saber la cantidad del producto pedido
			int cantidad = 0;
	
			// Variable para asignar el valor del producto
			double euro = 0.0;
	
			// Variable para asignar el valor del producto por la cantidad
			double total = 0.0;
	
			// Variables para saber el tipo del producto
			String tipomanzana = null;
			String tipolechuga = null;
			String tipoleche = null;
	
			//ArrayList <Manzana> arrayManzanaCesta = new ArrayList <Manzana> ();
			arrayManzanaCesta = new ArrayList <Manzana> ();
			arrayLechugaCesta = new ArrayList <Lechuga> ();
			arrayLecheCesta = new ArrayList <Leche> ();
	
			try {
	
				// Leemos "pro.txt"
				File archivo = new File("/home/zubiri/ProyectosJava/java2_AlmacenMejorado/ficheros/productos.txt");
				BufferedReader br3 = new BufferedReader(new FileReader(archivo));
	
				String linea3 = br3.readLine();
	
				// Creamos un array de tipo String para separar los campos del fichero
				String [] camposSeparados3 = null;
	
				while (linea3 != null) {
	
					// Creamos los objetos que participan en el fichero "productos.txt"
					Distribuidor distribuidorCesta = new Distribuidor ();
					Direccion direccionCesta = new Direccion ();
	
					// Separamos las lineas obtenidas (linea3) mediante ", " y lo guardamos en "camposSeparados3"
					camposSeparados3 = linea3.split(", ");
	
					// Comprobamos si el codigo de barras introducido coincide con uno del fichero "pro.txt"
					if (codbarrasp == Integer.parseInt(camposSeparados3[1])) {
	
						// Comprobamos si el producto es igual al producto a pedir (Manzana)
						if ((camposSeparados3[0].equalsIgnoreCase(productopedir)) && productopedir.equalsIgnoreCase("Manzana")) {
	
							// Creamos el objeto "manzanaCesta"
							Manzana manzanaCesta = new Manzana ();
	
							System.out.println();
	
							// Enviamos valores recogidos del fichero "productos.txt" a cada objeto "manzanaCesta", "distribuidorCesta" y "direccionCesta"
							manzanaCesta.setTipo(camposSeparados3[2]);
							manzanaCesta.setProcedencia(camposSeparados3[3]);
							manzanaCesta.setColor(camposSeparados3[4]);
							manzanaCesta.setEurosKilo(Double.parseDouble(camposSeparados3[5]));
	
							distribuidorCesta.setNombre(camposSeparados3[6]);
							distribuidorCesta.setCif(camposSeparados3[7]);
	
							direccionCesta.setPais(camposSeparados3[8]);
							direccionCesta.setProvincia(camposSeparados3[9]);
							direccionCesta.setCiudad(camposSeparados3[10]);		
							direccionCesta.setCalle(camposSeparados3[11]);
							direccionCesta.setPiso(Integer.parseInt(camposSeparados3[12]));
							direccionCesta.setLetra(camposSeparados3[13].charAt(0));
							direccionCesta.setCodigoPostal(Integer.parseInt(camposSeparados3[14]));
	
							manzanaCesta.setCodigoBarras(Integer.parseInt(camposSeparados3[1]));
	
							// Mostramos la información respecto al producto introducido a través del código de barras
							System.out.println(" ------ Datos del producto deseado ------");
							System.out.println("Tipo Manzana: " + manzanaCesta.getTipo());
							// Asignamos en "tipomanzana" el valor del tipo de manzana recogido del objeto
							tipomanzana = manzanaCesta.getTipo();
							System.out.println("Procedencia: " + manzanaCesta.getProcedencia());
							System.out.println("Color: " + manzanaCesta.getColor());
							System.out.println("Euros Unidad: " + manzanaCesta.getEurosKilo());
	
							// Asignamos a la variable "euro" el valor que vale dicho producto
							euro = manzanaCesta.getEurosKilo();
	
							System.out.print("\n¿Cuántas deseas pedir? ");
							cantidad = sc.nextInt();
	
							System.out.println();
	
							// Asignamos a la variable "total" la multiplicación de la cantidad deseada por lo que vale
							total = (cantidad * euro);
	
							// Enviamos al objeto "cesta" los valores "euro" y "descuentocliente" para calcular el importe
							cesta.setImporteCompra(total, descuentocliente);
	
							// Introducimos los valores(objetos) de "distribuidorCesta"  en "manzanaCesta"
							manzanaCesta.setDistribuidor(distribuidorCesta);
	
							// Añadimos el objeto "manzanaCesta" al ArrayList "arrayManzanaCesta"
							arrayManzanaCesta.add(manzanaCesta);
	
							for (int mc=0; mc<arrayManzanaCesta.size(); mc++) {
	
								// Mostramos los datos de lo pedido con el descuento
								System.out.println(" ------ Has pedido ------");
								System.out.println("Tipo Manzana: " + arrayManzanaCesta.get(mc).getTipo());
								System.out.println("Distribuidor: " + arrayManzanaCesta.get(mc).getDistribuidor().getNombre());
								System.out.println("Cantidad pedida: " + cantidad);
								System.out.println("Euro por Unidad: " + arrayManzanaCesta.get(mc).getEurosKilo() + "€");
								System.out.println("Total: " + total + "€");
								System.out.println("Descuento: " + descuentocliente + "%");
								// Recogemos el importe a pagar "cesta.getImporteCompra()"
								System.out.println("Total a pagar por " + tipomanzana + ": " + cesta.getImporteCompra() + "€");
							}
						}
	
						// Comprobamos si el producto es igual al producto a pedir (Lechuga)
						else if ((camposSeparados3[0].equalsIgnoreCase(productopedir)) && productopedir.equalsIgnoreCase("Lechuga")) {
	
							// Creamos el objeto "lehugaCesta"
							Lechuga lechugaCesta = new Lechuga ();
	
							System.out.println();
	
							// Enviamos valores recogidos del fichero "productos.txt" a cada objeto "lechugaCesta", "distribuidorCesta" y "direccionCesta"
							lechugaCesta.setTipo(camposSeparados3[2]);
							lechugaCesta.setProcedencia(camposSeparados3[3]);
							lechugaCesta.setColor(camposSeparados3[4]);
							lechugaCesta.setEurosUnidad(Double.parseDouble(camposSeparados3[5]));
	
							distribuidorCesta.setNombre(camposSeparados3[6]);
							distribuidorCesta.setCif(camposSeparados3[7]);
	
							direccionCesta.setPais(camposSeparados3[8]);
							direccionCesta.setProvincia(camposSeparados3[9]);
							direccionCesta.setCiudad(camposSeparados3[10]);		
							direccionCesta.setCalle(camposSeparados3[11]);
							direccionCesta.setPiso(Integer.parseInt(camposSeparados3[12]));
							direccionCesta.setLetra(camposSeparados3[13].charAt(0));
							direccionCesta.setCodigoPostal(Integer.parseInt(camposSeparados3[14]));
	
							lechugaCesta.setCodigoBarras(Integer.parseInt(camposSeparados3[1]));
	
							// Mostramos la información respecto al producto introducido a través del código de barras
							System.out.println(" ------ Datos del producto deseado ------");
							System.out.println("Tipo Lechuga: " + lechugaCesta.getTipo());
							// Guardamos en "tipolechuga"  el valor del tipo de lechuga recogido del objeto
							tipolechuga = lechugaCesta.getTipo();
							System.out.println("Procedencia: " + lechugaCesta.getProcedencia());
							System.out.println("Color: " + lechugaCesta.getColor());
							System.out.println("Euros Unidad: " + lechugaCesta.getEurosUnidad());
	
							// Asignamos a la variable "euro" el valor que vale dicho producto
							euro = lechugaCesta.getEurosUnidad();
	
							System.out.print("\n¿Cuántas deseas pedir? ");
							cantidad = sc.nextInt();
	
							System.out.println();
	
							// Asignamos a la variable "total" la multiplicación de la cantidad deseada por lo que vale
							total = (cantidad * euro);
	
							// Enviamos al objeto "cesta" los valores "euro" y "descuentocliente" para calcular el importe
							cesta.setImporteCompra(total, descuentocliente);
	
							// Introducimos los valores(objetos) de "distribuidorCesta"  en "lechugaCesta"
							lechugaCesta.setDistribuidor(distribuidorCesta);
	
							// Añadimos el objeto "lechugaCesta" al ArrayList "arrayLechugaCesta"
							arrayLechugaCesta.add(lechugaCesta);
	
							for (int mc=0; mc<arrayLechugaCesta.size(); mc++) {
	
								// Mostramos los datos de lo pedido con el descuento
								System.out.println(" ------ Has pedido ------");
								System.out.println("Tipo Lechuga: " + arrayLechugaCesta.get(mc).getTipo());
								System.out.println("Distribuidor: " + arrayLechugaCesta.get(mc).getDistribuidor().getNombre());
								System.out.println("Cantidad pedida: " + cantidad);
								System.out.println("Euro por Unidad: " + arrayLechugaCesta.get(mc).getEurosUnidad() + "€");
								System.out.println("Total: " + total + "€");
								System.out.println("Descuento: " + descuentocliente + "%");
								// Recogemos el importe a pagar "cesta.getImporteCompra()"
								System.out.println("Total a pagar por " + tipolechuga + ": " + cesta.getImporteCompra() + "€");
							}
						}
	
						// Comprobamos si el producto es igual al producto a pedir (Leche)
						else if ((camposSeparados3[0].equalsIgnoreCase(productopedir)) && productopedir.equalsIgnoreCase("Leche")) {
	
							// Creamos el objeto "manzanaCesta"
							Leche lecheCesta = new Leche ();
	
							System.out.println();
	
							// Enviamos valores recogidos del fichero "productos.txt" a cada objeto "lecheCesta", "distribuidorCesta" y "direccionCesta"
							lecheCesta.setTipo(camposSeparados3[2]);
							lecheCesta.setProcedencia(camposSeparados3[3]);
							lecheCesta.setEurosLitro(Double.parseDouble(camposSeparados3[4]));
	
							distribuidorCesta.setNombre(camposSeparados3[5]);
							distribuidorCesta.setCif(camposSeparados3[6]);
	
							direccionCesta.setPais(camposSeparados3[7]);
							direccionCesta.setProvincia(camposSeparados3[8]);
							direccionCesta.setCiudad(camposSeparados3[9]);		
							direccionCesta.setCalle(camposSeparados3[10]);
							direccionCesta.setPiso(Integer.parseInt(camposSeparados3[11]));
							direccionCesta.setLetra(camposSeparados3[12].charAt(0));
							direccionCesta.setCodigoPostal(Integer.parseInt(camposSeparados3[13]));
	
							lecheCesta.setCodigoBarras(Integer.parseInt(camposSeparados3[1]));
	
							// Mostramos la información respecto al producto introducido a través del código de barras
							System.out.println(" ------ Datos del producto deseado ------");
							System.out.println("Tipo Leche: " + lecheCesta.getTipo());
							// Guardamos en "tipoleche" el valor del tipo de lechuga recogido del objeto
							tipoleche = lecheCesta.getTipo();
							System.out.println("Procedencia: " + lecheCesta.getProcedencia());
							System.out.println("Euros Litro: " + lecheCesta.getEurosLitro());
	
							// Asignamos a la variable "euro" el valor que vale dicho producto
							euro = lecheCesta.getEurosLitro();
	
							System.out.print("\n¿Cuántas deseas pedir? ");
							cantidad = sc.nextInt();
	
							System.out.println();
	
							// Asignamos a la variable "total" la multiplicación de la cantidad deseada por lo que vale
							total = (cantidad * euro);
	
							// Enviamos al objeto "cesta" los valores "euro" y "descuentocliente" para calcular el importe
							cesta.setImporteCompra(total, descuentocliente);
	
							// Introducimos los valores(objetos) de "distribuidorCesta"  en "lecheCesta"
							lecheCesta.setDistribuidor(distribuidorCesta);
	
							// Añadimos el objeto "lecheCesta" al ArrayList "arrayLecheCesta"
							arrayLecheCesta.add(lecheCesta);
	
							for (int mc=0; mc<arrayLecheCesta.size(); mc++) {
	
								// Mostramos los datos de lo pedido con el descuento
								System.out.println(" ------ Has pedido ------");
								System.out.println("Tipo Leche: " + arrayLecheCesta.get(mc).getTipo());
								System.out.println("Distribuidor: " + arrayLecheCesta.get(mc).getDistribuidor().getNombre());
								System.out.println("Cantidad pedida: " + cantidad);
								System.out.println("Euro por Litro: " + arrayLecheCesta.get(mc).getEurosLitro() + "€");
								System.out.println("Total: " + total + "€");
								System.out.println("Descuento: " + descuentocliente + "%");
								// Recogemos el importe a pagar "cesta.getImporteCompra()"
								System.out.println("Total a pagar por " + tipoleche + ": " + cesta.getImporteCompra() + "€");
							}
						}
						else {
	
							System.out.println("El código de barras no pertenece al producto seleccionado");
						}
					}
					linea3 = br3.readLine();
				}
	
				System.out.println("\n ------ ------ ------ ------ ------ ------\n");
				System.out.print("¿Desea pedir algo más S/N? ");
				mas = sc.next().charAt(0);
	
				br3.close();
			} catch(IOException e) {
				System.out.println("Error E/S: "+e);
			}
		} while (mas == 'S' || mas == 's'); {
			System.out.println("\nGracias por su visita.");
		}
	}
}