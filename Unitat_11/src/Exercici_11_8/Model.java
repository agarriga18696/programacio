package Exercici_11_8;

public class Model {

	protected double conversioCelsiusAFahrenheit(double celsius) {
		return (celsius * 9/5) + 32;
	}
	
	protected double conversioFahrenheitACelsius(double fahrenheit) {
		return (fahrenheit - 32) * 5/9;
	}

}
