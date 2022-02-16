package entidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import utils.Datos;

public class Manager {
	private long id;
	private String telefono;
	private String direccion;
	LocalDate fechaNac;

	// Ejercicio 3 de la prueba 6
//	public static void main (String [] args) {
//		ArrayList<Atleta> atletas = atletas.convertir(Datos.ATLETAS);

//	}

	private DatosPersona persona;

	public Manager(long id, String telefono, String direccion) {
		super();
		this.id = id;
		this.telefono = telefono;
		this.direccion = direccion;
		this.persona = Datos.buscarPersonaPorId(id);
	}

	public Manager(long id, String telefono, String direccion, DatosPersona dp) {
		super();
		this.id = id;
		this.telefono = telefono;
		this.direccion = direccion;
		this.persona = dp;
	}

	// Examen 5 ejercicio 4: implementar funcion nuevoManager
	public static Manager newManager() {
		Manager ret = newManager();
		Scanner in;
		long id = -1;
		String tfn = "";
		String direccion = "";
		boolean valido = false;
		do {
			System.out.println("Introduzca el id del nuevo Manager:");
			in = new Scanner(System.in);
			id = in.nextInt();
			if (id > 0)
				valido = true;
		} while (!valido);
		valido = false;

		do {
			System.out.println("Introduzca el telefono del nuevo Manager:");
			in = new Scanner(System.in);
			tfn = in.nextLine();
			if (tfn.length() > 3)
				valido = true;
		} while (!valido);

		do {
			System.out.println("Introduzca la direccion del nuevo Manager:");
			in = new Scanner(System.in);
			direccion = in.nextLine();
			if (direccion.length() > 3)
				valido = true;
		} while (!valido);
		return ret;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public DatosPersona getPersona() {
		return this.persona;
	}

	@Override
	public String toString() {
		String ret = "";
		return ret += "idManager" + id + "nombre" + "documentacion" + " Tfn1:" + telefono + " ("
				+ fechaNac.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ")" + " Tfn2:" + telefono
				+ "DatosPersona.telefono";
	}

	// Examen 7-Ejercicio 3
	/**
	 * Funcion para importar el fichero de manager
	 * 
	 * @param <BufferReader>
	 * @return true si el id manager coincide con alguno de los contenidos en el
	 *         fichero de caracteres manager.txt o false en caso contrario
	 */
	public static <BufferReader> boolean Manager(Manager m) {
		File fichero = new File("managers.txt");
		FileReader lector = null;
		BufferedReader buffer = null;
		try {
			try {
				lector = new FileReader(fichero);

				buffer = new BufferedReader(lector);

				String linea;

				while ((linea = buffer.readLine()) != null) {

					String[] campos = linea.split("\\|");

					String id = campos[0];

					String nombre = campos[1];

					String documentacion = campos[2];

					String fechaNac = campos[3];

					String telefono = campos[4];

					String managerid = campos[5];

					String direccion = campos[6];
					if (managerid.equals(m.getNombreEquipo()))
						return true;// Si devuelve true, mostrar el siguiente mensaje
//					String data() {
//						return= D./Dña. + manager.getNombre() +  con NIF:NIE + manager.getDocumentacion() + nacido el + manager.getFechaNac().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+ representa al equipo + manager.getNombreEquipo() + de id + equipo.getId() + durante el año + equipo.getAnioinscripcion() + "\t! + Atleta.toString() + "\n";

				}
				for (Equipo e : Datos.EQUIPOS) {
					if (e.getManager() != null) {
						escritor.writeObject((Equipo) e);
						escritor.flush();
					}
					escritor.close();
				}
//				}
			} finally {

				if (buffer != null) {

					buffer.close();

				}

				if (lector != null) {

					lector.close();

				}
			}

		} catch (

		FileNotFoundException e) {

			System.out.println("Se ha producido una FileNotFoundException" + e.getMessage());

		} catch (IOException e) {

			System.out.println("Se ha producido una IOException" + e.getMessage());

		} catch (Exception e) {

			System.out.println("Se ha producido una Exception" + e.getMessage());

		}

	}

	private Object getNombreEquipo() {
		return null;
	}

}
