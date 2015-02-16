package java2_AlmacenMejorado;

public class Leche extends Producto {

	//propiedades
	private Double eurosLitro;

	//métodos getter y setter
	public Leche() {
		super();
	}
	
	public void setEurosLitro (Double eurolitros) {
		this.eurosLitro = eurolitros;
	}

	public Double getEurosLitro () {
		return eurosLitro;
	}
}