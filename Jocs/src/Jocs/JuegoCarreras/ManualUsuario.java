package Jocs.JuegoCarreras;

public class ManualUsuario {
	
	public static void carrera() {
		
		ElementosIU.mostrarSaltoLinea();
		ElementosIU.mostrarSeparador2();
		ElementosIU.mostrarSaltoLinea();
		System.out.println(" SOBRE LA CARRERA\n");
		System.out.println("");
		
	}

	public static void vehiculos() {

		ElementosIU.mostrarSaltoLinea();
		ElementosIU.mostrarSeparador2();
		ElementosIU.mostrarSaltoLinea();
		System.out.println(ElementosIU.TEXTO_NEGRITA + " SOBRE LOS VEHÍCULOS\n" + ElementosIU.RESET);
		System.out.println(" Existen varios tipos de vehículos, cada uno con características únicas.\n");
		System.out.println(" Cada vehículo posee un total de seis atributos, de los cuales 3 se verán");
		System.out.println(" potenciados, mientras que los demás obtendrán valores promedio.\n");
		System.out.println(" Los atributos son:\n");
		System.out.println(" 1. " + ElementosIU.TEXTO_SUBRAYADO + "Velocidad:" + ElementosIU.RESET);
		System.out.println("     - Define que tan rápido es tu vehículo.");
		System.out.println("     - Afecta a la distancia que puedes recorrer en un tiempo determiando.\n");
		System.out.println(" 2. " + ElementosIU.TEXTO_SUBRAYADO + "Aceleración:" + ElementosIU.RESET);
		System.out.println("     - Determina la rapidez de aceleración de tu vehículo.");
		System.out.println("     - Define el tiempo de espera entre cada jugada.\n");
		System.out.println(" 3. " + ElementosIU.TEXTO_SUBRAYADO + "Peso:" + ElementosIU.RESET);
		System.out.println("     - Controla la resistencia al aire. Con un peso mayor te aseguras de no");
		System.out.println("     - salir volando.");
		System.out.println("     - Añade una penalización de movimiento en condiciones extremas.\n");
		System.out.println(" 4. " + ElementosIU.TEXTO_SUBRAYADO + "Manejo:" + ElementosIU.RESET);
		System.out.println("     - Define la habilidad del conductor para manejarse por la pista.");
		System.out.println("     - Determina la capacidad controlar el vehículo en situaciones, etc.");
		System.out.println("     - Un buen manejo ayudará a disminuir los efectos de deslizamientos");
		System.out.println("       y reducirá las probabilidades de perderse al coger un atajo.\n");
		System.out.println(" 5. " + ElementosIU.TEXTO_SUBRAYADO + "Agarre:" + ElementosIU.RESET);
		System.out.println("     - Indica cuánto se adhiere tu vehículo al suelo.");
		System.out.println("     - Un buen agarre evita problemas en terrenos difíciles, pero un agarre");
		System.out.println("       bajo puede provocar que el vehículo derrape y dificulte el avance.\n");
		System.out.println(" 6. " + ElementosIU.TEXTO_SUBRAYADO + "Turbo:" + ElementosIU.RESET);
		System.out.println("     - Determina la potencia del impulso de velocidad.");
		System.out.println("     - La probabilidad de utilizar el turbo dependerá del atributo turbo.\n");
		System.out.println(System.lineSeparator());
		System.out.println(" Estos atributos definen el rendimiento del vehículo durante la carrera.");
		System.out.println(" Cuanto más alto sea el valor del atributo, mejor rendirá, y viceversa.");
		System.out.println(" Dependiendo del tipo de vehículo, tres de estos atributos se destacarán");
		System.out.println(" como principales, mientras que los dos restantes tendrán valores promedio.\n");

	}

	public static void circuito() {

		ElementosIU.mostrarSaltoLinea();
		ElementosIU.mostrarSeparador2();
		ElementosIU.mostrarSaltoLinea();
		System.out.println(ElementosIU.TEXTO_NEGRITA + " SOBRE EL CIRCUITO\n" + ElementosIU.RESET);
		System.out.println(" En cada partida, los circuitos se generarán automáticamente con los");
		System.out.println(" siguientes elementos:\n");
		System.out.println(" 1. " + ElementosIU.TEXTO_SUBRAYADO + "Tipo de Circuito:" + ElementosIU.RESET);
		System.out.println("     - " + ElementosIU.TEXTO_NEGRITA + "Permanente: " + ElementosIU.RESET + "Diseñados para proporcionar tramos");
		System.out.println("       más fluidos y con menos curvas, ideales para alcanzar alta velocidad.");
		System.out.println("     - " + ElementosIU.TEXTO_NEGRITA + "Callejero: " + ElementosIU.RESET + "Más enfocados a las carreras underground. Poseen un gran");
		System.out.println("       número de curvas, atajos y otros obstáculos.\n");
		System.out.println(" 2. " + ElementosIU.TEXTO_SUBRAYADO + "Tipo de Pavimento:" + ElementosIU.RESET);
		System.out.println("     - " + ElementosIU.TEXTO_NEGRITA + "Asfalto: " + ElementosIU.RESET + "Cuentan con una superfície lisa y pulida, ideal para todo");
		System.out.println("       tipo de vehículos.");
		System.out.println("     - " + ElementosIU.TEXTO_NEGRITA + "Tierra: " + ElementosIU.RESET + "Dificultan el avance, especialmente para vehículos con un");
		System.out.println("       agarre bajo.");
		System.out.println("     - " + ElementosIU.TEXTO_NEGRITA + "Grava: " + ElementosIU.RESET + "Requiere de un gran agarre, ya que este terreno puede generar");
		System.out.println("       deslizamientos durante el avance.\n");
		System.out.println(" 3. " + ElementosIU.TEXTO_SUBRAYADO + "Distancia del circuito:" + ElementosIU.RESET);
		System.out.println("     - Indica la longitud total del circuito que los vehículos deberán");
		System.out.println("       superar para poder alcanzar la meta.");

	}

	public static void clima() {

		ElementosIU.mostrarSaltoLinea();
		ElementosIU.mostrarSeparador2();
		ElementosIU.mostrarSaltoLinea();
		System.out.println(ElementosIU.TEXTO_NEGRITA + " SOBRE EL CLIMA\n" + ElementosIU.RESET);
		System.out.println(" El clima y el viento son factores determinantes durante la carrera:\n");
		System.out.println(" 1. " + ElementosIU.TEXTO_SUBRAYADO + "Tipo de Clima:" + ElementosIU.RESET);
		System.out.println("     - " + ElementosIU.TEXTO_NEGRITA + "Soleado: " + ElementosIU.RESET + "Condición ideal para cualquier carrera, ofreciendo buena");
		System.out.println("       tracción sin ningún tipo de penalización (por clima).");
		System.out.println("     - " + ElementosIU.TEXTO_NEGRITA + "Lluvia: " + ElementosIU.RESET + "La pista estará mojada, lo que requerirá de buen manejo del");
		System.out.println("       vehículo para una buena estabilización.");
		System.out.println("     - " + ElementosIU.TEXTO_NEGRITA + "Lluvia Intensa: " + ElementosIU.RESET + "Todo estará encharcado. Aumenta todavía más la dificultad");
		System.out.println("       de manejarse por la pista durante la carrera.");
		System.out.println("     - " + ElementosIU.TEXTO_NEGRITA + "Tormenta Eléctrica: " + ElementosIU.RESET + "La pesadilla de todo vehículo. Provocará fallos");
		System.out.println("       electrónicos en los vehículos de manera inesperada.\n");
		System.out.println(" 2. " + ElementosIU.TEXTO_SUBRAYADO + "Tipo Viento:" + ElementosIU.RESET);
		System.out.println("     - " + ElementosIU.TEXTO_NEGRITA + "Calma: " + ElementosIU.RESET + "Sin viento o con viento mínimo.");
		System.out.println("     - " + ElementosIU.TEXTO_NEGRITA + "Brisa: " + ElementosIU.RESET + "Brisa suave que empieza a notarse.");
		System.out.println("     - " + ElementosIU.TEXTO_NEGRITA + "Moderado: " + ElementosIU.RESET + "Viento perceptible pero que no afecta a la conducción.");
		System.out.println("     - " + ElementosIU.TEXTO_NEGRITA + "Fuerte: " + ElementosIU.RESET + "Viento fuerte que puede afectar al rendimiento.");
		System.out.println("     - " + ElementosIU.TEXTO_NEGRITA + "Muy Fuerte: " + ElementosIU.RESET + "Vientos extremos que afectan gravemente al rendimiento.");

	}

}

















