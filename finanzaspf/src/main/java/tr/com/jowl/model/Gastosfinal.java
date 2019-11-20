package tr.com.jowl.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "gastosfinal")
public class Gastosfinal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idGastosfinal;

	@NotEmpty(message = "Ingresa el nombre del gasto final")
	@Column(name = "nombreGastosfinal", nullable = false, length = 30)
	private String nombreGastosfinal;

	@Min(1)
	@Max(9000)
	@Column(name = "montoGastosfinal", nullable = false)
	private int montoGastosfinal;

	@ManyToOne
	@JoinColumn(name = "idBanco")
	private Banco bancoGastosfinal;

	public Gastosfinal(int idGastosfinal, String nombreGastosfinal, int montoGastosfinal, Banco bancoGastosfinal) {
		super();
		this.idGastosfinal = idGastosfinal;
		this.nombreGastosfinal = nombreGastosfinal;
		this.montoGastosfinal = montoGastosfinal;
		this.bancoGastosfinal = bancoGastosfinal;
	}

	public Gastosfinal() {
		super();
	}

	public int getIdGastosfinal() {
		return idGastosfinal;
	}

	public void setIdGastosfinal(int idGastosfinal) {
		this.idGastosfinal = idGastosfinal;
	}

	public String getNombreGastosfinal() {
		return nombreGastosfinal;
	}

	public void setNombreGastosfinal(String nombreGastosfinal) {
		this.nombreGastosfinal = nombreGastosfinal;
	}

	public int getMontoGastosfinal() {
		return montoGastosfinal;
	}

	public void setMontoGastosfinal(int montoGastosfinal) {
		this.montoGastosfinal = montoGastosfinal;
	}

	public Banco getBancoGastosfinal() {
		return bancoGastosfinal;
	}

	public void setBancoGastosfinal(Banco bancoGastosfinal) {
		this.bancoGastosfinal = bancoGastosfinal;
	}

}
