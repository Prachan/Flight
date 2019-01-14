package com.fb.model;

public class PaymentInfo {
private String name;
private String card_number;
private String balance;
private Integer no_of_passengers;


public PaymentInfo(String name, String card_number, String balance, Integer no_of_passengers) {
	super();
	this.name = name;
	this.card_number = card_number;
	this.balance = balance;
	this.no_of_passengers = no_of_passengers;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getCard_number() {
	return card_number;
}

public void setCard_number(String card_number) {
	this.card_number = card_number;
}

public String getBalance() {
	return balance;
}

public void setBalance(String balance) {
	this.balance = balance;
}

public Integer getNo_of_passengers() {
	return no_of_passengers;
}

public void setNo_of_passengers(Integer no_of_passengers) {
	this.no_of_passengers = no_of_passengers;
}
}
