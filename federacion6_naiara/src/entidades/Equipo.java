package entidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import utils.Datos;

public class Equipo extends Participante {
	private long idEquipo;
	private int anioinscripcion;
	private Manager manager;
	private Atleta[] atletas;

	public Equipo(long id, int anioinscripcion, Manager manager, Atleta[] atletas) {
		super();
		this.idEquipo = id;
		this.anioinscripcion = anioinscripcion;
		this.manager = manager;
		this.atletas = atletas;
	}

	public Equipo(long idParticipante, Equipo e, int dorsal, char calle) {
		super(idParticipante, dorsal, calle);
		this.idEquipo = e.idEquipo;
		this.anioinscripcion = e.anioinscripcion;
		this.manager = e.manager;
		this.atletas = e.atletas;
	}
	// examen 8_ejercicio1_apartado A
	public static Equipo nuevoEquipo() {
		Equipo ret = null;
		long idEquipo;
		int anioinscripcion;
		Manager[] manager;
		Atleta[] atletas;
		String nombre;
		DatosPersona dp = null;
		Scanner in;
		boolean valido = false;
		do {
			System.out.println("Introduzca el id del nuevo equipo:");
			in = new Scanner(System.in);
			idEquipo = in.nextInt();
			if (idEquipo > 0)
				valido = true;
			else
				System.out.println("Valor incorrecto para el identificador.");
		} while (!valido);

		valido = false;
		do {
			System.out.println("Introduzca el año de inscripcion:");
			anioinscripcion = in.nextInt();
			if (anioinscripcion > 0)
				valido = true;
			System.out.println("ERROR: El valor introducido para el año de inscripcion no es válido.");
		} while (!valido);

		valido = false;
		do {
			System.out.println("Introduzca el manager del nuevo equipo:");
			manager = Datos.MANAGERS;
			if (!valido)
				System.out.println("ERROR: El valor introducido para el manager no es válido.");
		} while (!valido);
		do {
			System.out.println("Introduzca el atleta:");
			atletas = Datos.ATLETAS;
			if (!valido)
				System.out.println("ERROR: El valor introducido para el atleta no es válido.");
		} while (!valido);

		System.out.println("Introduzca ahora los datos personales:");
		in = new Scanner(System.in);
		dp = DatosPersona.nuevaPersona();

//		ret = new Equipo(idEquipo, anioinscripcion, manager, atletas);
		return ret;
		//examen 8_ejercicio 1_apartadoB
		System.out.println("Cargando datos de pruebas.txt...");
		File fIn = new File("pruebas.txt");
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(fIn);
			br = new BufferedReader(fr);
			String c;

			for (int i = 0; i < 6; i++) {
				c = (String) br.readLine();
				System.out.println(c);
			}
			
			
			System.out.println("Cargando datos de pruebas.txt...");
			File fInb = new File("pruebas.txt");
			FileReader frb = new FileReader(fInb);
			BufferedReader brb = new BufferedReader(frb);
			ArrayList<Prueba> arrayList2 = new ArrayList<Prueba>();
			
			String linea;
			while ((linea = brb.readLine()) != null) {
				String [] args= linea.split("\\|");
			//long id, String nombre, LocalDate fecha, Lugar lugar, boolean ind
			arrayList2.add(new Prueba(Integer.toUnsignedLong(args[0]),(args[1]), LocalDate.parse(args[2]), args[4]));

			}
			for(Prueba prueba: arrayList2) {
				System.out.println(prueba.data());
			}

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

		System.out.println("Cargando datos de inscrip_<idPrueba>_<NIFNIE_MANAGER>.dat...");
		File ci;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			ci = new File("inscrip_<idPrueba>_<NIFNIE_MANAGER>.dat");
			fis = new FileInputStream(ci);
			ois = new ObjectInputStream(fis);

			for (int i = 0; i < 15; i++) { 
				Equipo e = (Equipo) ois.readObject();
				System.out.println(e.data());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null)
					ois.close();
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//examen 8_ejercicio 1_apartado C
	}

	@Override
	public long getId() {
		return idEquipo;
	}
	@Override
	public void setId(long id) {
		this.idEquipo = id;
	}
	public int getAnioinscripcion() {
		return anioinscripcion;
	}
	public void setAnioinscripcion(int anioinscripcion) {
		this.anioinscripcion = anioinscripcion;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public Atleta[] getAtletas() {
		return atletas;
	}
	public void setAtletas(Atleta[] atletas) {
		this.atletas = atletas;
	}

	//Ejercicio 3
	@Override
	public String toString() {
		String ret = "";
		ret+= "EQ"+idEquipo + ". de " + manager.getPersona().getNombre() + " (" + manager.getDireccion()+") " + atletas.length + " componentes en el equipo:\n";
		for(Atleta a: atletas) {
			ret += a.getId()+". " + a.getPersona().getNombre() + "(" + a.getPersona().getFechaNac().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+ ") "
					+ " Datos físicos:\t"+ a.getPeso()+ "Kgs.\t" + a.getAltura()+"m.\n";
		}
		ret += "Valido durante el " + anioinscripcion;
		return ret;
	}
	/***
	 * Método data()
	 * @return
	 * Método creado para poder hacer el ejercicio 1 apartado B del examen 8
	 */
	//long id, int anioinscripcion, Manager manager, Atleta[] atletas
	public String data() {
		String ret = "";
		ret = this.id + "|" + this.anioinscripcion + "|" + this.manager + "|" + this.atletas;
		return ret;
	}


}
