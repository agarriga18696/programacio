package principal;

import instrumento.Guitarra;
import instrumento.InstrumentoMusical;
import instrumento.Piano;
import utilidad.IU;
import utilidad.Mensaje;
import utilidad.Validar;

public class Tienda {

	private static InstrumentoMusical[] listaInstrumentos = new InstrumentoMusical[20];
	private static int contadorInstrumentos = 0;
	private static final long tiempoEspera = 2000; // para Thread.Sleep

	public static void main(String[] args) {
		opcionesMenu();
	}

	/*
	 * MENU PRINCIPAL
	 * 
	 */
	private static void menu() {
		IU.saltoLinea();
		System.out.println(" TIENDA");
		IU.separador();
		System.out.println(" (1) Crear guitarra");
		System.out.println(" (2) Crear piano");
		System.out.println(" (3) Mostrar instrumentos");
		System.out.println(" (4) Tocar un instrumento");
		System.out.println(" (5) Afinar un instrumento");
		System.out.println(" (6) Transportar un instrumento");
		System.out.println(" (7) Salir\n");
	}

	private static void opcionesMenu() {
		int opcion = 0;

		while(opcion != 7) {
			menu();
			opcion = Validar.entero("Opción");

			switch(opcion) {
			case 1:
				crearGuitarra();
				break;
			case 2:
				crearPiano();
				break;
			case 3:
				mostrarInstrumentos();
				break;
			case 4:
				tocarInstrumento();
				break;
			case 5:
				afinarInstrumento();
				break;
			case 6:
				transportarInstrumento();
				break;
			case 7:
				salir();
				return;
			default:
				Mensaje.error("Opción no válida");
				break;
			}
		}
	}

	/*
	 * CREAR GUITARRA
	 * 
	 */
	private static void crearGuitarra() {
		IU.saltoLinea();
		System.out.println(" CREAR GUITARRA 🎸");
		IU.separador();

		String nombre = null, material = null; 
		int anioFabricacion = 0, numeroCuerdas = 0;
		boolean guitarraValida = false;

		do {
			nombre = Validar.cadena("Nombre");
			material = Validar.cadena("Material");
			anioFabricacion = Validar.entero("Año fabricación");
			numeroCuerdas = Validar.entero("Número cuerdas");

			// Comprobar que los valores sean válidos.
			if(nombre == null || nombre.isEmpty() || material == null || material.isEmpty() || 
					anioFabricacion <= 0 || numeroCuerdas <= 0) {
				// Comprobar cada caso por separado y lanzar un mensaje de error único.
				if(nombre == null || nombre.isEmpty()) {
					Mensaje.error("El campo 'Nombre' no puede estar vacío");
				} else if(material == null || material.isEmpty()) {
					Mensaje.error("El campo 'Material' no puede estar vacío");
				} else if(anioFabricacion <= 0) {
					Mensaje.error("El campo 'Año fabricación' debe contener un valor positivo");
				} else if(numeroCuerdas <= 0) {
					Mensaje.error("El campo 'Número cuerdas' debe contener un valor positivo");
				}
				continue; // Repetir el bucle while.

			} else {
				guitarraValida = true;
				break; // Salir del bucle while.
			}
		} while(!guitarraValida);

		// Añadir guitarra a la lista de instrumentos.
		listaInstrumentos[contadorInstrumentos] = new Guitarra(nombre, material, anioFabricacion, numeroCuerdas);
		Mensaje.exito("Guitarra creada correctamente");

		// Incrementar contador de instrumentos.
		contadorInstrumentos++;
	}

	/*
	 * CREAR PIANO
	 * 
	 */
	private static void crearPiano() {
		IU.saltoLinea();
		System.out.println(" CREAR PIANO 🎹");
		IU.separador();

		String nombre = null, material = null, pianoDeColaString = null; 
		int anioFabricacion = 0;
		boolean esPianoDeCola = false, pianoValido = false;

		do {
			nombre = Validar.cadena("Nombre");
			material = Validar.cadena("Material");
			anioFabricacion = Validar.entero("Año fabricación");
			pianoDeColaString = Validar.cadena("Piano de cola (s/n)");

			// Comprobar que los valores sean válidos.
			if(nombre == null || nombre.isEmpty() || material == null || material.isEmpty() || 
					anioFabricacion <= 0 || pianoDeColaString == null || pianoDeColaString.isEmpty()) {
				// Comprobar cada caso por separado y lanzar un mensaje de error único.
				if(nombre == null || nombre.isEmpty()) {
					Mensaje.error("El campo 'Nombre' no puede estar vacío");
				} else if(material == null || material.isEmpty()) {
					Mensaje.error("El campo 'Material' no puede estar vacío");
				} else if(anioFabricacion <= 0) {
					Mensaje.error("El campo 'Año fabricación' debe contener un valor positivo");
				} else if(pianoDeColaString == null || pianoDeColaString.isEmpty()) {
					Mensaje.error("El campo 'Piano de cola' debe contener un valor 's' o 'n'");
				}
				continue; // Repetir el bucle while.

			} else {
				pianoValido = true;
				esPianoDeCola = pianoDeColaString.equalsIgnoreCase("s") ? true : false;
				break; // Salir del bucle while.
			}
		} while(!pianoValido);

		// Añadir piano a la lista de instrumentos.
		listaInstrumentos[contadorInstrumentos] = new Piano(nombre, material, anioFabricacion, esPianoDeCola);
		Mensaje.exito("Piano creado correctamente");

		// Incrementar contador de instrumentos.
		contadorInstrumentos++;
	}

	/*
	 * MOSTRAR INSTRUMENTOS
	 * 
	 */
	private static void mostrarInstrumentos() {
		IU.saltoLinea();
		System.out.println(" MOSTRAR INSTRUMENTOS 👁️");
		IU.separador();

		if(contadorInstrumentos > 0) {
			// Mostrar guitarras.
			for(int i = 0; i < contadorInstrumentos; i++) {
				InstrumentoMusical instrumento = listaInstrumentos[i];
				if(instrumento != null && instrumento instanceof Guitarra) {
					try {
						System.out.println(instrumento.toString());
						Thread.sleep(tiempoEspera / 2);
					}  catch (InterruptedException e) {
						Mensaje.error("Ha ocurrido un error inesperado");
						e.printStackTrace();
					}
				}
			}
			
			// Mostrar pianos.
			for(int i = 0; i < contadorInstrumentos; i++) {
				InstrumentoMusical instrumento = listaInstrumentos[i];
				if(instrumento != null && instrumento instanceof Piano) {
					try {
						System.out.println(instrumento.toString());
						Thread.sleep(tiempoEspera / 2);
					}  catch (InterruptedException e) {
						Mensaje.error("Ha ocurrido un error inesperado");
						e.printStackTrace();
					}
				}
			}
		} else {
			Mensaje.advertencia("No se ha creado ningún instrumento");
		}
	}

	/*
	 * TOCAR INSTRUMENTO
	 * 
	 */
	private static void tocarInstrumento() {
		IU.saltoLinea();
		System.out.println(" TOCAR INSTRUMENTO 🎵");
		IU.separador();

		if(contadorInstrumentos > 0 && listaInstrumentos != null) {
			boolean instrumentoEncontrado = false;
			String nombre = null;

			while(!instrumentoEncontrado) {
				nombre = Validar.cadena("Nombre");

				if(nombre != null && !nombre.isEmpty()) {
					// Verificar si es Guitarra.
					for(InstrumentoMusical instrumento : listaInstrumentos) {
						if(instrumento != null && nombre.equalsIgnoreCase(instrumento.getNombre()) && instrumento instanceof Guitarra) {
							Guitarra guitarra = (Guitarra) instrumento;
							try {
								System.out.println(guitarra.tocar());
								Thread.sleep(tiempoEspera); // hacer una pausa de 1 segundo
								Mensaje.exito("Se ha tocado la guitarra '" + guitarra.getNombre() + " exitosamente");
								Thread.sleep(tiempoEspera); // hacer una pausa de 1 segundo
							} catch (InterruptedException e) {
								Mensaje.error("Ha ocurrido un error inesperado");
								e.printStackTrace();
							}
							return; // Salir del método.

						} else if(instrumento != null && nombre.equalsIgnoreCase(instrumento.getNombre()) && instrumento instanceof Piano) {
							Piano piano = (Piano) instrumento;
							try {
								System.out.println(piano.tocar());
								Thread.sleep(tiempoEspera); // hacer una pausa de 1 segundo
								Mensaje.exito("Se ha tocado el piano '" + piano.getNombre() + " exitosamente");
								Thread.sleep(tiempoEspera); // hacer una pausa de 1 segundo
							} catch (InterruptedException e) {
								Mensaje.error("Ha ocurrido un error inesperado");
								e.printStackTrace();
							}
							return; // Salir del método.

						} else {
							Mensaje.error("No se ha encontrado el instrumento '" + nombre + "'");
							break;
						}
					}

				} else {
					Mensaje.error("El campo 'Nombre' no puede estar vacío");
					continue;
				}
			}
		} else {
			Mensaje.advertencia("No se ha encontrado ningún instrumento para tocar");
		}
	}

	/*
	 * AFINAR INSTRUMENTO
	 * 
	 */
	private static void afinarInstrumento() {
		IU.saltoLinea();
		System.out.println(" AFINAR INSTRUMENTO 🛠️");
		IU.separador();

		if(contadorInstrumentos > 0 && listaInstrumentos != null) {
			boolean instrumentoEncontrado = false;
			String nombre = null;

			while(!instrumentoEncontrado) {
				nombre = Validar.cadena("Nombre");

				if(nombre != null && !nombre.isEmpty()) {
					// Verificar si es Guitarra.
					for(InstrumentoMusical instrumento : listaInstrumentos) {
						if(instrumento != null && nombre.equalsIgnoreCase(instrumento.getNombre()) && instrumento instanceof Guitarra) {
							Guitarra guitarra = (Guitarra) instrumento;
							try {
								System.out.println(guitarra.afinar());
								Thread.sleep(tiempoEspera); // hacer una pausa de 1 segundo
								Mensaje.exito("Se ha afinado la guitarra '" + guitarra.getNombre() + " exitosamente");
								Thread.sleep(tiempoEspera); // hacer una pausa de 1 segundo
							} catch (InterruptedException e) {
								Mensaje.error("Ha ocurrido un error inesperado");
								e.printStackTrace();
							}
							return; // Salir del método.

						} else if(instrumento != null && nombre.equalsIgnoreCase(instrumento.getNombre()) && instrumento instanceof Piano) {
							Piano piano = (Piano) instrumento;
							try {
								System.out.println(piano.afinar());
								Thread.sleep(tiempoEspera); // hacer una pausa de 1 segundo
								Mensaje.exito("Se ha afinado el piano '" + piano.getNombre() + " exitosamente");
								Thread.sleep(tiempoEspera); // hacer una pausa de 1 segundo
							} catch (InterruptedException e) {
								Mensaje.error("Ha ocurrido un error inesperado");
								e.printStackTrace();
							}
							return; // Salir del método.

						} else {
							Mensaje.error("No se ha encontrado el instrumento '" + nombre + "'");
							break;
						}
					}

				} else {
					Mensaje.error("El campo 'Nombre' no puede estar vacío");
					continue;
				}
			}
		} else {
			Mensaje.advertencia("No se ha encontrado ningún instrumento para afinar");
		}		
	}

	/*
	 * TRANSPORTAR INSTRUMENTO
	 * 
	 */
	private static void transportarInstrumento() {
		IU.saltoLinea();
		System.out.println(" TRANSPORTAR INSTRUMENTO 📦");
		IU.separador();

		if(contadorInstrumentos > 0 && listaInstrumentos != null) {
			boolean instrumentoEncontrado = false;
			String nombre = null;

			while(!instrumentoEncontrado) {
				nombre = Validar.cadena("Nombre");

				if(nombre != null && !nombre.isEmpty()) {
					// Verificar si es Guitarra.
					for(InstrumentoMusical instrumento : listaInstrumentos) {
						if(instrumento != null && nombre.equalsIgnoreCase(instrumento.getNombre()) && instrumento instanceof Guitarra) {
							Guitarra guitarra = (Guitarra) instrumento;
							try {
								System.out.println(guitarra.empaquetar());
								Thread.sleep(tiempoEspera); // hacer una pausa de 1 segundo
								System.out.println(guitarra.desempaquetar());
								Thread.sleep(tiempoEspera); // hacer una pausa de 1 segundo
								Mensaje.exito("Se ha desempaquetado la guitarra '" + guitarra.getNombre() + " exitosamente");
								Thread.sleep(tiempoEspera); // hacer una pausa de 1 segundo
							} catch (InterruptedException e) {
								Mensaje.error("Ha ocurrido un error inesperado");
								e.printStackTrace();
							}
							return; // Salir del método.

						} else if(instrumento != null && nombre.equalsIgnoreCase(instrumento.getNombre()) && instrumento instanceof Piano) {
							Mensaje.error("No se puede transportar un piano");
							break; // Salir del método.

						} else {
							Mensaje.error("No se ha encontrado el instrumento '" + nombre + "'");
							break;
						}
					}

				} else {
					Mensaje.error("El campo 'Nombre' no puede estar vacío");
					continue;
				}
			}
		} else {
			Mensaje.advertencia("No se ha encontrado ningún instrumento para transportar");
		}	

	}

	/*
	 * SALIR
	 * 
	 */
	private static void salir() {
		System.out.println(System.lineSeparator());
		System.out.println(" ¡Hasta pronto! 👋");
	}

}
