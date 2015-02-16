package java2_AlmacenMejorado;

public class Lechuga extends Producto {

	//propiedades
	private String color;
	private Double eurosUnidad;

	//métodos getter y setter
	public Lechuga() {
		super();
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public Double getEurosUnidad() {
		return eurosUnidad;
	}
	
	public void setEurosUnidad(Double eurosUnidad) {
		this.eurosUnidad = eurosUnidad;
	}
}