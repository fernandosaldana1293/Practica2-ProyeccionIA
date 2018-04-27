package edu.usmp.ProyeccionIA.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Person implements Serializable{

	@Id
	@GeneratedValue
	private Integer id;
	
	@NotNull
	@Min(10000000)
	@Max(99999999)
	private Integer dni;
	
	@NotNull
	@Size(min=2, max=30)
	private String nombre;
	
	@NotNull
	@Min(0)	
	private Double ingresoDependiente;
	private Double ingresoIndependiente;
	private Double ingresoAnual;
	private Double impuestoTotal;	
	private Double ingresoTotal;
	private Double rentaGravable;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public Double getIngresoDependiente() {
		return ingresoDependiente;
	}
	public void setIngresoDependiente(Double ingresoDependiente) {
		this.ingresoDependiente = ingresoDependiente;
	}
	public Double getIngresoIndependiente() {
		return ingresoIndependiente;
	}
	public void setIngresoIndependiente(Double ingresoIndependiente) {
		this.ingresoIndependiente = ingresoIndependiente;
	}
	public Double getIngresoAnual() {
		return ingresoAnual;
	}
	public void setIngresoAnual(Double ingresoAnual) {
		this.ingresoAnual = ingresoAnual;
	}
	public Double getImpuestoTotal() {
		return impuestoTotal;
	}
	public void setImpuestoTotal(Double impuestoTotal) {
		this.impuestoTotal = impuestoTotal;
	}
	public Double getIngresoTotal() {
		return ingresoTotal;
	}
	public void setIngresoTotal(Double ingresoTotal) {
		this.ingresoTotal = ingresoTotal;
	}
	public Double getRentaGravable() {
		return rentaGravable;
	}
	public void setRentaGravable(Double rentaGravable) {
		this.rentaGravable = rentaGravable;
	}
			
}
