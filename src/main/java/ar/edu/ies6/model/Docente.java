package ar.edu.ies6.model;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Component
@Entity

public class Docente {
	@Column
	private String name;
	@Column
	private String lastname;
	@Column
	private String addressStreet;
	@Column
	private Integer addressNumber;
	@Column
	private String addressCity;
	@Column
	@DateTimeFormat (pattern = "yyyy-MM-dd")
	private LocalDate fechaNac;
	@Id
	private Integer dni;
	@Column
	private Boolean estado;
	
	public Docente() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddressStreet() {
		return addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	public Integer getAddressNumber() {
		return addressNumber;
	}

	public void setAddressNumber(Integer addressNumber) {
		this.addressNumber = addressNumber;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	public Integer getEdad() {
		int edad = 0;
		LocalDate fechaActual = LocalDate.now();
		Period periodo = Period.between(fechaNac, fechaActual);
		edad= periodo.getYears();
		return edad;
	}

}
