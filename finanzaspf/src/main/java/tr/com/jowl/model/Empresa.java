package tr.com.jowl.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEmpresa;

	@NotEmpty(message = "Ingresa el nombre de la empresa")
	@Column(name = "nombreEmpresa", nullable = false, length = 20)
	private String nombreEmpresa;

	@NotEmpty(message = "Ingrese el prestigio de la empresa")
	@Column(name = "prestigioEmpresa", nullable = false, length = 10)
	private String prestigioEmpresa;

	@Size(min = 11, max = 11, message = "EL RUC tiene que ser de 11 d\u00edgitos")
	@NotEmpty(message = "Ingresar RUC")
	@Column(name = "rucEmpresa", nullable = false, length = 11, unique = true)
	private String rucEmpresa;

	public Empresa(int idEmpresa, String nombreEmpresa, String prestigioEmpresa, String rucEmpresa) {
		super();
		this.idEmpresa = idEmpresa;
		this.nombreEmpresa = nombreEmpresa;
		this.prestigioEmpresa = prestigioEmpresa;
		this.rucEmpresa = rucEmpresa;
	}

	public Empresa() {
		super();
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getPrestigioEmpresa() {
		return prestigioEmpresa;
	}

	public void setPrestigioEmpresa(String prestigioEmpresa) {
		this.prestigioEmpresa = prestigioEmpresa;
	}

	public String getRucEmpresa() {
		return rucEmpresa;
	}

	public void setRucEmpresa(String rucEmpresa) {
		this.rucEmpresa = rucEmpresa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEmpresa;
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
		Empresa other = (Empresa) obj;
		if (idEmpresa != other.idEmpresa)
			return false;
		return true;
	}

}
