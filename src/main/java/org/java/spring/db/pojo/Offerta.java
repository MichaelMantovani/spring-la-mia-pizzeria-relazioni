package org.java.spring.db.pojo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Offerta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 60, unique = true, nullable = false)
	private String name;

	@Column
	private LocalDate dataInizio;

	@Column
	private LocalDate dataFine;

	@ManyToOne
	private Pizza pizza;

	public Offerta() {
	}

	public Offerta(String name, LocalDate dataInzio, LocalDate dataFine, Pizza pizza) {
		setName(name);
		setDataInizio(dataInzio);
		setDataFine(dataFine);
		setPizza(pizza);

	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}

	public LocalDate getDataFine() {
		return dataFine;
	}

	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}

	@Override
	public String toString() {
		return "Offerta: " + this.name;
	}
}
