package principal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import entidades.*;
import utils.*;
import validaciones.Validaciones;

public class Principal4 {

	public static void main(String[] args) {
		Datos.cerrarResultados();
		System.out.println("INICIO");

		Scanner in;
		int elecc = -1;
		Rol rol; // Examen 4 Ejercicio 3A
		boolean correcto = false;
		while (true) {
			System.out.println("Bienvenido al programa de gestión de la FEDERACIÓN DEPORTIVA:");
			do {
				System.out.println("Seleccione el id del tipo de usuario o pulse 0 para SALIR:");
				int i = 1;
				for (Rol r : Rol.values()) {
					System.out.println(i + " " + r.getNombre());
					i++;
				}
				in = new Scanner(System.in);
				elecc = in.nextInt();
				if (elecc == 0) {
					System.out.println("¿Está seguro de que desea SALIR?");
					if (Utilidades.leerBoolean()) {
						System.out.println("¡ADIOS!");
						return;
					}
				}
				if (elecc >= 1 && elecc <= Rol.values().length)
					correcto = true;
				else
					System.out.println("¡Valor invalido para el ROL seleccionado!");
			} while (!correcto);
			rol = Rol.values()[elecc - 1];

			Credenciales cred; // Examen 4 Ejericicio 3B
			boolean login = false;
			switch (rol.ordinal()) {
			case 0: // Rol.DIRECTIVA;
			case 1: // Rol.MANAGER
			case 2: // Rol.ATLETA;
			case 3: // Rol.COLEGIADO;
			case 4: // Rol.ADMIN;
				do {
					System.out.println("Introduzca sus credenciales de acceso.");
					System.out.println("Introduzca su nombre de usuario:");
					String usuario, password;
					usuario = in.next();
					System.out.println("Introduzca su contraseña:");
					password = in.next();
					cred = new Credenciales(usuario, password);
					login = login(cred);
					if (!login)
						System.out.println("ERROR: Usuario o password incorrectos.");
					else
						System.out.println("Login correcto con rol " + rol.getNombre());
				} while (!login);
				break;
			case 5: // Rol.INVITADO;
				System.out.println("Ha ingresado con el rol " + rol.getNombre());
			}

			mostrarMenu(rol);
		}

	} // Final del main

	// Examen 3 Ejercicio 2 - Examen 4 Ejercicio 3C
	private static void mostrarMenu(Rol rol) {
		int elecc = -1;
		Scanner in = new Scanner(System.in);
		boolean valido = false;

		switch (rol.ordinal()) {
		case 0: // Rol.DIRECTIVA;
			do {
				mostrarMenuDirectiva();
				System.out.println("Seleccione una de las opciones anteriores.");
				in = new Scanner(System.in);
				elecc = in.nextInt();
				if (elecc >= 0 && elecc <= 2) {
					valido = true;
					mostrarSubmenuDirectiva(elecc);
				} else
					System.out.println("¡Valor seleccionado no válido!\n");
			} while (!valido || elecc != 0);
			System.out.println("Ha elegido VOLVER.");
			break;
		case 1: // Rol.MANAGER;
			do {
				mostrarMenuManager();
				System.out.println("Seleccione una de las opciones anteriores.");
				in = new Scanner(System.in);
				elecc = in.nextInt();
				if (elecc >= 0 && elecc <= 2) {
					valido = true;
					mostrarSubmenuManager(elecc);
				} else
					System.out.println("¡Valor seleccionado no válido!\n");
			} while (!valido || elecc != 0);
			System.out.println("Ha elegido VOLVER");
			break;
		case 2: // Rol.ATLETA
			do {
				mostrarMenuAtleta();
				System.out.println("Seleccione una de las opciones anteriores.");
				in = new Scanner(System.in);
				elecc = in.nextInt();
				if (elecc >= 0 && elecc <= 2) {
					valido = true;
					mostrarSubmenuAtleta(elecc);
				} else
					System.out.println("¡Valor seleccionado no válido!\n");
			} while (!valido || elecc != 0);
			System.out.println("Ha elegido VOLVER.");
			break;
		case 3: // Rol.COLEGIADO;
			do {
				mostrarMenuColegiado();
				System.out.println("Seleccione una de las opciones anteriores.");
				in = new Scanner(System.in);
				elecc = in.nextInt();
				if (elecc >= 0 && elecc <= 2) {
					valido = true;
					mostrarSubmenuColegiado(elecc);
				} else
					System.out.println("¡Valor seleccionado no válido!\n");
			} while (!valido || elecc != 0);
			System.out.println("Ha elegido VOLVER.");
			break;
		case 4: // Rol.ADMIN;
			do {
				mostrarMenuAdmin();
				System.out.println("Seleccione una de las opciones anteriores.");
				in = new Scanner(System.in);
				elecc = in.nextInt();
				if (elecc >= 0 && elecc <= 4) {
					valido = true;
					mostrarSubmenuAdmin(elecc);
				} else
					System.out.println("¡Valor seleccionado no válido!\n");
			} while (!valido || elecc != 0);
			System.out.println("Ha elegido VOLVER.");
			break;
		case 5: // Rol.INVITADO;
			do {
				mostrarMenuInvitado();
				System.out.println("Seleccione una de las opciones anteriores.");
				in = new Scanner(System.in);
				elecc = in.nextInt();
				if (elecc >= 0 && elecc <= 2) {
					valido = true;
					mostrarSubmenuInvitado(elecc);
				} else
					System.out.println("¡Valor seleccionado no válido!\n");
			} while (!valido || elecc != 0);
			System.out.println("Ha elegido VOLVER.");
			break;
		default:
		}

	}

	private static void mostrarSubmenuDirectiva(int elecc) {
		Scanner in = new Scanner(System.in);
		int subelecc = -1;
		boolean valido = false;
		System.out.println("SUBMenús de la DIRECTIVA.");
		switch (elecc) {
		case 1:
			System.out.println("Ha seleccionado GESTIÓN de MEDALLAS.");
			do {
				mostrarMenuGestionMedallas();
				System.out.println("Seleccione una de las opciones anteriores.");
				in = new Scanner(System.in);
				subelecc = in.nextInt();
				if (subelecc >= 0 && subelecc <= 1) {
					valido = true;
					mostrarSubmenuGestionMedallas(subelecc);
				} else
					System.out.println("¡Valor seleccionado no válido!\n");
			} while (!valido || subelecc != 0);
			System.out.println("Ha elegido VOLVER.");
			break;
		case 2:
			System.out.println("Ha seleccionado GESTIÓN de COMPETICIONES y de PRUEBAS.");
			break;
		default:
		}

		System.out.println("Volviendo al menú de la DIRECTIVA...");
	}

	private static void mostrarMenuGestionMedallas() {
		System.out.println("Menú de GESTIÓN de MEDALLAS.");
		System.out.println("Seleccione una de las siguientes opciones:");
		System.out.println("1. Nueva Medalla\n" + "0. Volver");
	}

	private static void mostrarSubmenuGestionMedallas(int elecc) {
		Scanner in = new Scanner(System.in);
		int subelecc = -1;
		boolean valido = false;
		System.out.println("\nGESTIÓN de MEDALLAS.");
		switch (elecc) {
		case 1: // opción 1.1.1
			do {
				System.out.println("Ha seleccionado Nueva MEDALLA.");
				System.out.println("Seleccione 1 para ORO, 2 para PLATA o 3 para BRONCE.");
				subelecc = in.nextInt();
				if (subelecc != 1 && subelecc != 2 && subelecc != 3)
					System.out.println("¡Valor seleccionado no válido!\n");
				else
					valido = true;
			} while (!valido);
			Metal nuevo;
			if (subelecc == 1) {
				System.out.println("Ha seleccionado Nuevo ORO");
				nuevo = Oro.nuevoOro();
			} else if (subelecc == 2) {
				System.out.println("Ha seleccionado Nueva PLATA");
				nuevo = (Plata) Plata.nuevoPlata();
			} else {
				System.out.println("Ha seleccionado Nuevo BRONCE");
				nuevo = (Bronce) Bronce.nuevoBronce();
			}
			System.out.println("Se ha introducido una nueva medalla correctamente.");
			System.out.println(nuevo);
			break;
//Exam 5 ejercicio 6
//		case 2: // opción 1.1.2
		// do {
//			System.out.println("Ha seleccionado el valor de la pureza");
//          System.out.printnl("Seleccione un valor entre 88.55% y 90.1%");
//			subelecc = in.nextInt();
//			if (pureza.length() <= 90.1 && >=88.55)
//			System.out.println("¡Valor seleccionado válido!\n");
//			else
//				valido = !false;
//		} while (!valido);
//			break;
		default:
		}
		System.out.println("Volviendo al menú principal de gestión de medallas...");

	}

	private static void mostrarSubmenuManager(int elecc) {
		Scanner in = new Scanner(System.in);
		int subelecc = -1;
		boolean valido = false;
		switch (elecc) {
		case 1: // opción 2.1
			System.out.println("Ha seleccionado CONFORMAR EQUIPO.");
			break;
		case 2: // opción 2.2
			System.out.println("Ha seleccionado INSCRIPCIÓN de EQUIPO en PRUEBA.");
			break;
		default:
		}
		System.out.println("Volviendo al menú de MÁNAGERS...\n\n");
	}

	private static void mostrarSubmenuAtleta(int elecc) {
		Scanner in = new Scanner(System.in);
		int subelecc = -1;
		boolean valido = false;
		switch (elecc) {
		case 1: //// opción 3.1
			System.out.println("Ha seleccionado FEDERARSE (Nuevo ATLETA).");
			break;
		case 2: // opción 3.2
			System.out.println("Ha seleccionado INSCRIPCIÓN de ATLETA en PRUEBA..");
			break;
		default:
		}
		System.out.println("Volviendo al menú de ATLETAS...\n\n");
	}

	private static void mostrarSubmenuColegiado(int elecc) {
		Scanner in = new Scanner(System.in);
		int subelecc = -1;
		boolean valido = false;
		switch (elecc) {
		case 1: //// opción 4.1
			System.out.println("Ha seleccionado Nuevo COLEGIADO.");
			Colegiado nuevo = Colegiado.nuevoColegiado();
			System.out.println("Se ha creado correctamente el nuevo colegiado:" + nuevo);
			break;
		case 2: //// opción 4.2
			System.out.println("Ha seleccionado INTRODUCIR RESULTADOS de PRUEBA..");
			break;
		default:
		}
		System.out.println("Volviendo al menú de COLEGIADOS...\n\n");
	}

	private static void mostrarSubmenuAdmin(int elecc) {
		Scanner in = new Scanner(System.in);
		int subelecc = -1;
		boolean valido = false;
		switch (elecc) {
		case 1:
			System.out.println("Ha seleccionado Gestión de medallas, de competiciones y de pruebas.");
			break;
		case 2:
			System.out.println("Ha seleccionado Gestión de equipos.");
			break;
		case 3:
			System.out.println("Ha seleccionado Gestión de atletas.");
			break;
		case 4:
			System.out.println("Ha seleccionado Gestión de arbitrajes y resultados.");
			break;
		default:
		}
		System.out.println("Volviendo al menú de ADMINISTRADORES...\n\n");
	}

	private static void mostrarSubmenuInvitado(int elecc) {
		Scanner in = new Scanner(System.in);
		int subelecc = -1;
		boolean valido = false;
		System.out.println("SUBMenús para INVITADOS.");
		System.out.println("Volviendo al menú principal...\n\n");
	}

	private static void mostrarMenuDirectiva() {
		System.out.println("Menú de la DIRECTIVA.");
		System.out.println("Seleccione una de las siguientes opciones:");
		System.out.println("1. Gestión de medallas\n" + "2. Gestión de competiciones y pruebas.\n" + "0. Volver");
	}

	private static void mostrarMenuManager() {
		System.out.println("Menú para los MÁNAGERS.");
		System.out.println("Seleccione una de las siguientes opciones:");
		System.out.println("1. Conformar equipo\n" + "2. Inscripcion de equipo en prueba.\n" + "0. Volver");
	}

	private static void mostrarMenuAtleta() {
		System.out.println("Menú para los ATLETAS.");
		System.out.println("Seleccione una de las siguientes opciones:");
		System.out.println("1. Federarse (nuevo Atleta)\n" + "2. Inscrcipcion de atleta en prueba.\n" + "0. Volver");

	}

	private static void mostrarMenuColegiado() {
		System.out.println("Menú para los COLEGIADOS.");
		System.out.println("Seleccione una de las siguientes opciones:");
		System.out.println("1. Nuevo Colegiado\n" + "2. Introducir resultados de prueba.\n" + "0. Volver");
	}

	private static void mostrarMenuAdmin() {
		System.out.println("Menú para los ADMINISTRADORES.");
		System.out.println("Seleccione una de las siguientes opciones:");
		System.out.println("1. Gestión de medallas, de competiciones y de pruebas\n" + "2. Gestión de equipos.\n"
				+ "3. Gestión de atletas.\n" + "4. Gestión de arbitrajes y resultados.\n" + "0. Volver");
	}

	private static void mostrarMenuInvitado() {
		System.out.println("Menú para los INVITADOS.");
		System.out.println("Seleccione una de las siguientes opciones:");
		System.out.println("" + "0. Volver");
	}

	// Ejercicio 1 de la prueba 6
	/**
	 * Para validar el login es necesario validar por separado el nombre de usuario
	 * y el password
	 * 
	 * @param cred
	 * @return
	 */

	private static boolean login(Credenciales cred) {
//			boolean login= true;
//			if (usuario!= null) {
//			/* 1. Condicion: que la letra inicial sea mayuscula */
//			boolean letraMayuscula = Character.isUpperCase(usuario.charAt(0));
//
//			/* 2. Condicion: que el tamanio sea >= 3 y <= 25 */
//			int largoUsuario = usuario.length();
//			boolean tamValido = (largoUsuario >= 3 && largoUsuario <= 25);
//
//			/* Verificamos que las dos condiciones son verdaderas */
//			checkStatusUsuario = ((letraMayuscula == true) && (letraMayuscula && tamValido));
//		}
//
//		return checkStatusUsuario;
//		
////		  1.Condición: no debe de tener mas de 5 numeros
////		  2.Condicion: el password debe estar formado unicamente por numeros
//			boolean ret = false;
//
//			if (password.length()!= 5)
//				return false;
//			if (password.trim().chars().allMatch(Character::isDigit))
//				return false;
//		// Por el momento siempre devolverá true
		return true;
	}

	// Examen 7-Ejercicio 1
	/**
	 * Funcion para tipo de prueba (en este caso, es de tipo individual)
	 */
	private static boolean individual(Prueba ind) {
		long id = -1;
		DatosPersona dp = null;
		Scanner in;
		boolean valido = false;
		do {
			System.out.println("Introduzca los datos personales:");
			in = new Scanner(System.in);
			id = in.nextInt();
			if (id > 0)
				valido = true;
			else
				System.out.println("Valor incorrecto para el identificador.");
		} while (!valido);

		valido = false;

		FileReader lector = null;
		BufferedReader buffer = null;
		String path = "pruebas.txt";
		File fichero = new File(path);

		FileWriter escritor = null;

		PrintWriter buffer = null;
		try {
			try {

				escritor = new FileWriter(fichero, false);

				buffer = new PrintWriter(escritor);

				for (Prueba p : Datos.PRUEBAS) {

					buffer.println(p.data());

				}

			} finally {

				if (buffer != null) {

					buffer.close();

				}

				if (escritor != null) {

					escritor.close();

				}

			}

			System.out.println("¿Son correctos los datos?");
			System.out.println("Introduzca 's' en caso afirmativo y 'n' en caso contrario:");
			return false;

		} finally {
		}
	}
}
