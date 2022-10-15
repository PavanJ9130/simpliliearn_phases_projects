package com.FlyAway.layers.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Flight_Details")
public class Flights {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "Flight_date")
	private String date;

	@Column(name = "Flight_time")
	private String time;

	@Column(name = "Flight_source")
	private String source;

	@Column(name = "Flight_destination")
	private String destination;

	@Column(name = "Flight_price")
	private Double ticketprice;

	@Column(name = "Flight_limit")
	private Integer passengerlimit;

	@ManyToOne()
	private Airlines airlines;

	public Flights() {
	}

	public Flights(Integer id, String date, String source, String destination, Double ticketprice,
			Integer passengerlimit) {
		super();
		this.id = id;
		this.date = date;
		this.source = source;
		this.destination = destination;
		this.ticketprice = ticketprice;
		this.passengerlimit = passengerlimit;
	}

	public Flights(String date, String time, String source, String destination, Double ticketprice,
			Integer passengerlimit, Airlines airlines) {
		super();
		this.date = date;
		this.time = time;
		this.source = source;
		this.destination = destination;
		this.ticketprice = ticketprice;
		this.passengerlimit = passengerlimit;
		this.airlines = airlines;
	}

	public Flights(Integer id, String date, String source, String destination, Double ticketprice, Airlines airlines) {
		super();
		this.id = id;
		this.date = date;
		this.source = source;
		this.destination = destination;
		this.ticketprice = ticketprice;
		this.airlines = airlines;
	}

	public Integer getId() {
		return id;
	}

	public String getDate() {
		return date;
	}

	public String getSource() {
		return source;
	}

	public String getDestination() {
		return destination;
	}

	public Double getTicketprice() {
		return ticketprice;
	}

	public Integer getPassengerlimit() {
		return passengerlimit;
	}

	public Airlines getAirlines() {
		return airlines;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setTicketprice(Double ticketprice) {
		this.ticketprice = ticketprice;
	}

	public void setPassengerlimit(Integer passengerlimit) {
		this.passengerlimit = passengerlimit;
	}

	public void setAirlines(Airlines airlines) {
		this.airlines = airlines;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
