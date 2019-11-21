package tr.com.jowl.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "factura")
public class Factura implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFactura;

	@ManyToOne
	@JoinColumn(name = "id")
	private User userFactura;

	@ManyToOne
	@JoinColumn(name = "idEmpresa")
	private Empresa empresaFactura;

	@ManyToOne
	@JoinColumn(name = "idBanco")
	private Banco bancoFactura;

	@Min(0)
	@Max(90000)
	@Column(name = "totalFactura", nullable = false)
	private int totalFactura;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaaFactura")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaaFactura;

	@NotNull(message = "La fecha de compra es obligatoria")
	@Past(message = "La fecha debe estar en el pasado")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaiFactura")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaiFactura;

	@NotNull(message = "La fecha de facturacion es obligatoria")
	@Future(message = "La fecha debe estar en el futuro")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechafFactura")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechafFactura;

	public Factura(int idFactura, User userFactura, Empresa empresaFactura, Banco bancoFactura, int totalFactura,
			Date fechaaFactura, Date fechaiFactura, Date fechafFactura) {
		super();
		this.idFactura = idFactura;
		this.userFactura = userFactura;
		this.empresaFactura = empresaFactura;
		this.bancoFactura = bancoFactura;
		this.totalFactura = totalFactura;
		this.fechaaFactura = fechaaFactura;
		this.fechaiFactura = fechaiFactura;
		this.fechafFactura = fechafFactura;
	}

	@PrePersist
	public void prePersist() {
		fechaaFactura = new Date();
	}

	public Factura() {
		super();
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public User getUserFactura() {
		return userFactura;
	}

	public void setUserFactura(User userFactura) {
		this.userFactura = userFactura;
	}

	public Empresa getEmpresaFactura() {
		return empresaFactura;
	}

	public void setEmpresaFactura(Empresa empresaFactura) {
		this.empresaFactura = empresaFactura;
	}

	public Banco getBancoFactura() {
		return bancoFactura;
	}

	public void setBancoFactura(Banco bancoFactura) {
		this.bancoFactura = bancoFactura;
	}

	public int getTotalFactura() {
		return totalFactura;
	}

	public void setTotalFactura(int totalFactura) {
		this.totalFactura = totalFactura;
	}

	public Date getFechaaFactura() {
		return fechaaFactura;
	}

	public void setFechaaFactura(Date fechaaFactura) {
		this.fechaaFactura = fechaaFactura;
	}

	public Date getFechaiFactura() {
		return fechaiFactura;
	}

	public void setFechaiFactura(Date fechaiFactura) {
		this.fechaiFactura = fechaiFactura;
	}

	public Date getFechafFactura() {
		return fechafFactura;
	}

	public void setFechafFactura(Date fechafFactura) {
		this.fechafFactura = fechafFactura;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idFactura;
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
		Factura other = (Factura) obj;
		if (idFactura != other.idFactura)
			return false;
		return true;
	}

}
