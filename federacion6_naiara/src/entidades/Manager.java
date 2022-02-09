package entidades;

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
	
	//Ejercicio 3 de la prueba 6
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

}
