package tr.com.jowl.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "banco")
public class Banco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBanco;

	@NotEmpty(message = "Ingresa el nombre comercial del banco")
	@Column(name = "nombreBanco", nullable = false, length = 70)
	private String nombreBanco;

	@Min(0)
	@Max(100)
	@Column(name = "tasaBanco", nullable = false)
	private float tasaBanco;

	@Size(min = 11, max = 11, message = "EL RUC tiene que ser de 11 d\u00edgitos")
	@NotEmpty(message = "Ingresar RUC")
	@Column(name = "rucBanco", nullable = false, length = 12, unique = true)
	private String rucBanco;

	@Min(0)
	@Column(name = "gastosIBanco", nullable = false)
	private int gastosIBanco;

	@Min(0)
	@Column(name = "gastosFBanco", nullable = false)
	private int gastosFBanco;

	private String foto;

	public Banco() {
		super();
	}

	public Banco(int idBanco, @NotEmpty(message = "Ingresa el nombre comercial del banco") String nombreBanco,
			@Min(0) @Max(100) float tasaBanco,
			@Size(min = 11, max = 11, message = "EL RUC tiene que ser de 11 dígitos") @NotEmpty(message = "Ingresar RUC") String rucBanco,
			@Min(0) int gastosIBanco, @Min(0) int gastosFBanco, String foto) {
		super();
		this.idBanco = idBanco;
		this.nombreBanco = nombreBanco;
		this.tasaBanco = tasaBanco;
		this.rucBanco = rucBanco;
		this.gastosIBanco = gastosIBanco;
		this.gastosFBanco = gastosFBanco;
		this.foto = foto;
	}

	@PrePersist
	public void prePersist() {
		gastosIBanco = 0;
		gastosFBanco = 0;
	}

	public int getIdBanco() {
		return idBanco;
	}

	public void setIdBanco(int idBanco) {
		this.idBanco = idBanco;
	}

	public String getNombreBanco() {
		return nombreBanco;
	}

	public void setNombreBanco(String nombreBanco) {
		this.nombreBanco = nombreBanco;
	}

	public float getTasaBanco() {
		return tasaBanco;
	}

	public void setTasaBanco(float tasaBanco) {
		this.tasaBanco = tasaBanco;
	}

	public String getRucBanco() {
		return rucBanco;
	}

	public void setRucBanco(String rucBanco) {
		this.rucBanco = rucBanco;
	}

	public int getGastosIBanco() {
		return gastosIBanco;
	}

	public void setGastosIBanco(int gastosIBanco) {
		this.gastosIBanco = gastosIBanco;
	}

	public int getGastosFBanco() {
		return gastosFBanco;
	}

	public void setGastosFBanco(int gastosFBanco) {
		this.gastosFBanco = gastosFBanco;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idBanco;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Banco other = (Banco) obj;
		if (idBanco != other.idBanco)
			return false;
		return true;
	}

}
