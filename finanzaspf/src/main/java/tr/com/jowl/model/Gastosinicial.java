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
@Table(name = "gastosiniciales")
public class Gastosinicial implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idGastosinicial;

	@NotEmpty(message = "Ingresa el nombre del gasto inicial")
	@Column(name = "nombreGastosinicial", nullable = false, length = 30)
	private String nombreGastosinicial;

	@Min(1)
	@Max(1000)
	@Column(name = "montoGastosinicial", nullable = false)
	private int montoGastosinicial;

	@ManyToOne
	@JoinColumn(name = "idBanco")
	private Banco bancoGastosinicial;

	public Gastosinicial(int idGastosinicial, String nombreGastosinicial, int montoGastosinicial) {
		super();
		this.idGastosinicial = idGastosinicial;
		this.nombreGastosinicial = nombreGastosinicial;
		this.montoGastosinicial = montoGastosinicial;
	}

	public Gastosinicial() {
		super();
	}

	public int getIdGastosinicial() {
		return idGastosinicial;
	}

	public void setIdGastosinicial(int idGastosinicial) {
		this.idGastosinicial = idGastosinicial;
	}

	public String getNombreGastosinicial() {
		return nombreGastosinicial;
	}

	public void setNombreGastosinicial(String nombreGastosinicial) {
		this.nombreGastosinicial = nombreGastosinicial;
	}

	public int getMontoGastosinicial() {
		return montoGastosinicial;
	}

	public void setMontoGastosinicial(int montoGastosinicial) {
		this.montoGastosinicial = montoGastosinicial;
	}

}
