package entidades;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import utils.Datos;

public class Colegiado {
	private long id;
	private Categoria categoria; // Examen 3 Ejercicio 3
	private DatosPersona persona;

	public Colegiado(long id, Categoria categoria) {
		super();
		this.id = id;
		this.categoria = categoria;
		this.persona = Datos.buscarPersonaPorId(id);
	}

	public Colegiado(long id, Categoria categoria, DatosPersona dp) {
		super();
		this.id = id;
		this.categoria = categoria;
		this.persona = dp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getPersona() {
		return this.persona.toString();
	}

//Examen 5 Ejercicio 2

//	@Override
//	public String toString() {
//		return "Colegiado [id= + id + ",nombre=" + nombre + ",documentacion=" + documentacion + ,nacido el + "fechaNac.año=" + fechaNac.año
//+ ",tfno:" + telefono + ",CAT=" + categoria + "]";
//	}

	// Examen 3 Ejercicio 3
	public static Colegiado nuevoColegiado() {
		Colegiado ret = null;
		long id = -1;
		Categoria cat;
		int elecc = -1;
		DatosPersona dp = null;
		Scanner in;
		boolean valido = false;
		do {
			System.out.println("Introduzca el id del nuevo colegiado:");
			in = new Scanner(System.in);
			id = in.nextInt();
			if (id > 0)
				valido = true;
			else
				System.out.println("Valor incorrecto para el identificador.");
		} while (!valido);

		valido = false;
		do {
			System.out.println("Introduzca la categoria del nuevo colegiado:");
			System.out.println("Seleccione el id de entre las siguientes categorias:");
			Categoria.mostrarTodos();
			in = new Scanner(System.in);
			elecc = in.nextInt();
			if (elecc >= 1 && elecc <= Categoria.values().length)
				valido = true;
		} while (!valido);
		cat = Categoria.values()[elecc - 1];

		System.out.println("Introduzca ahora los datos personales:");
		in = new Scanner(System.in);
		dp = DatosPersona.nuevaPersona();

		ret = new Colegiado(id, cat, dp);
		return ret;
	}

	// Examen 7-Ejercicio 2
	/**
	 * Funcion para importar los ficheros de colegiados
	 */
	public static void Colegiados() {
		String path = "colegiadosjunior.dat, colegiadossenior.dat, colegiadosespecial.dat";
		try {

			FileOutputStream fichero = new FileOutputStream(path, false);

			ObjectOutputStream escritor = new ObjectOutputStream(fichero);

			for (Colegiado c : Datos.COLEGIADOS) {

				if (c.getPersona().getId().getCategoria) {

					escritor.writeObject((Colegiado) c);

					escritor.flush();

				}
				escritor.close();

			}
		} catch (FileNotFoundException e) {

			System.out.println("Se ha producido una FileNotFoundException" + e.getMessage());

		} catch (IOException e) {

			System.out.println("Se ha producido una IOException" + e.getMessage());

		} catch (Exception e) {

			System.out.println("Se ha producido una Exception" + e.getMessage());

		}

	}
}