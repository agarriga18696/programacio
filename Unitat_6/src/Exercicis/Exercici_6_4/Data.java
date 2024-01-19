package Exercicis.Exercici_6_4;

public class Data {

	int darrerDiaMes[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	String[] mesos = {"Gener", "Febrer", "Març", "Abril", "Maig", "Juny", "Juliol", "Agost", "Setembre", "Octubre", "Novembre", "Desembre"};
	String[] esAnyTraspas = {"és de traspàs", "no és de traspàs"};
	String[] acdc = {"AC", "DC"};

	// Atributs.
	int dia;
	int mes;
	int any;

	public Data(int dia, int mes, int any) {
		this.dia = dia;
		this.mes = mes;
		this.any = any;
	}

	// Mètode per validar que la data existeixi.
	public boolean dataValida() {
		// Validar any 0.
		if(any == 0) { 
			return false;
		}
		// Controlar que en any de traspàs tingui en compte que febrer acaba en 29.
		if(((any % 4 == 0 && any / 100 != 0) && mes == 2 && dia == 29) || ((any % 100 == 0 && any % 400 == 0) && mes == 2 && dia == 29)) {
			return true;
		} else if(mes > 12 || mes < 1 || dia > darrerDiaMes[mes-1] || dia < 1) { // Validar que no introdueixi un mes o dia fora de rang.
			return false;
		} else { // La data és correcta.
			return true;
		}
	}

	// Mètode per mostrar l'endemà.
	public void dema() {
		int darrerDia = darrerDiaMes[mes-1];

		// Si el dia és l'últim del mes, passarà a ser dia 1.
		if(dia == darrerDia) {
			dia = 1;
			// Si és cap d'any, el mes passarà a ser Gener (1) i l'any s'incrementarà en 1.
			if(mes == 12) {
				mes = 1;
				any++;
				// Validar any 0.
				if(any == 0) {
					any = 1; // Passarà a ser l'any 1, ja que l'any 0 no existeix.
				}
			} else { // Si no és el darrer mes de l'any, el mes incrementarà en 1.
				mes++;
			}

		} else { // Si no és el darrer dia del mes, el dia incrementarà en 1.
			// Controlar dia 29 de febrer en cas que sigui traspàs.
			if(mes == 2 && dia == 29) {
				dia = 1;
				mes++;
			} else {
				dia++;
			}
		}

		if(any < 0) { // AC
			System.out.println("L'endemà serà: " + dia + "/" + mes + "/" + (-any) + " " + acdc[0] + ".");
		} else { // DC
			System.out.println("L'endemà serà: " + dia + "/" + mes + "/" + any + " " + acdc[1] + ".");
		}

	}

	// Mètode per comprovar si l'any és de traspàs o no.
	public void anyTraspas(int dia, int mes, int any) {
		// Comprovar si l'any és de traspàs.
		if((any % 4 == 0 && any / 100 != 0) || (any % 100 == 0 && any % 400 == 0)) {
			// si l'any és d.C
			if(any > 0) {
				System.out.println("\nEl dia " + dia + " de " + mesos[--mes].toLowerCase() + " de l'any " + any + " " + acdc[1] + " " + esAnyTraspas[0] + ".\n");
			} 
			// si l'any és a.C
			else if(any < 0) {
				System.out.println("\nEl dia " + dia + " de " + mesos[--mes].toLowerCase() + " de l'any " + (-any) + " " + acdc[0] + " " + esAnyTraspas[0] + ".\n");
			}
		} else {
			// si l'any és d.C
			if(any > 0) {
				System.out.println("\nEl dia " + dia + " de " + mesos[--mes].toLowerCase() + " de l'any " + any + " " + acdc[1] + " " + esAnyTraspas[1] + ".\n");
			} 
			// si l'any és a.C
			else if(any < 0) {
				System.out.println("\nEl dia " + dia + " de " + mesos[--mes].toLowerCase() + " de l'any " + (-any) + " " + acdc[0] + " " + esAnyTraspas[0] + ".\n");
			}
		}
	}
	
	public void easterEgg() {
		if(mes == 1) {
			if(dia == 1) {
				System.out.println("Feliç any nou!");
			} else if(dia == 6) {
				System.out.println("Ja venen els reis! T'has portat bé?");
			}	
		} else if(mes == 12) {
			if(dia == 25) {
				System.out.println("Bon Nadal!");
			} else if(dia == 28) {
				System.out.println("Feliç dia dels Sants Innocents! Ja has fet alguna broma?");
			}
		} else if(mes == 10) {
			if(dia == 12) {
				System.out.println("En Colón acaba de descobrir Amèrica!");
			}
		}
	}

	// Getters i Setters.
	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAny() {
		return any;
	}

	public void setAny(int any) {
		this.any = any;
	}


}
