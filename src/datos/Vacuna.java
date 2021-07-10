package datos;

import java.time.LocalDate;

public class Vacuna {
	private int idVacuna;
	private long codigo;
	private String laboratorio;
	private LocalDate fechaElaboracion;
	
	public Vacuna() {}

	public Vacuna(long codigo, String laboratorio, LocalDate fechaElaboracion) {
		super();
		this.codigo = codigo;
		this.laboratorio = laboratorio;
		this.fechaElaboracion = fechaElaboracion;
	}

	public int getIdVacuna() {
		return idVacuna;
	}

	protected void setIdVacuna(int idVacuna) {
		this.idVacuna = idVacuna;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	public LocalDate getFechaElaboracion() {
		return fechaElaboracion;
	}

	public void setFechaElaboracion(LocalDate fechaElaboracion) {
		this.fechaElaboracion = fechaElaboracion;
	}

	@Override
	public String toString() {
		return "\nVacuna [idVacuna=" + idVacuna + ", codigo=" + codigo + ", laboratorio=" + laboratorio
				+ ", fechaElaboracion=" + fechaElaboracion + "]";
	}
	
	

}
