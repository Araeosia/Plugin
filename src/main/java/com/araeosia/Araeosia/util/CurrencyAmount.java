package com.araeosia.Araeosia.util;

import org.apache.commons.lang.Validate;

public class CurrencyAmount {
	private Integer dollars;
	private Byte cents;

	public CurrencyAmount(){
		this.dollars = 0;
		this.cents = 0;
	}

	public CurrencyAmount(Integer dollars, Byte cents){
		Validate.isTrue(dollars>=0, "Dollars cannot be negative!");
		this.dollars = dollars;
		Validate.isTrue((cents>=0 && cents <100), "Cents must be between 0 and 99!");
		this.cents = cents;
	}
	public CurrencyAmount(Number number){
		this.dollars = ((Double)Math.floor(number.doubleValue())).intValue();
		Double cents = number.doubleValue()%1;
		cents= cents*100;
		Validate.isTrue((cents>=0 && cents <100), "Cents must be between 0 and 99!");
		this.cents = cents.byteValue();
	}

	public Integer getDollars() {
		return dollars;
	}

	public void setDollars(Integer dollars) {
		Validate.isTrue(dollars>=0, "Dollars cannot be negative!");
		this.dollars = dollars;
	}

	public Byte getCents() {
		return cents;
	}

	public void setCents(Byte cents) {
		Validate.isTrue((cents>=0 && cents <100), "Cents must be between 0 and 99!");
		this.cents = cents;
	}

	@Override
	public String toString(){
		if(cents<10){
			return "$"+dollars+".0"+cents;
		}
		return "$"+dollars+"."+cents;
	}
}
