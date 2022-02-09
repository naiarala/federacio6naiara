package entidades;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import utils.Datos;

public class Atleta extends Participante {
	private long idAtleta;
	private float altura;
	private float peso;
	LocalDate fechaNac;

	private DatosPersona persona;
	//Examen 5 ejercicio 4: implementar el submenu
	public static Atleta nuevoAtleta() {
		Atleta ret = nuevoAtleta();
		Scanner in;
		long id = -1;
		float altura = 'F';
		float peso ='F';
		boolean valido = false;
		do {
			System.out.println("Introduzca el id del nuevo atleta:");
			in = new Scanner(System.in);
			id = in.nextInt();
			if (id > 0)
				valido = true;
		} while (!valido);
		valido = false;
		return ret;
	}

	public Atleta(long id, int dorsal, char calle, long idAtleta, float altura, float peso) {
		super(id, dorsal, calle);
		this.idAtleta = idAtleta;
		this.altura = altura;
		this.peso = peso;
		this.persona = Datos.buscarPersonaPorId(id);
	}

	public Atleta(long id, int dorsal, char calle, long idAtleta, float altura, float peso, DatosPersona dp) {
		super(idAtleta, dorsal, calle);
		this.idAtleta = idAtleta;
		this.altura = altura;
		this.peso = peso;
		this.persona = dp;
	}

	public Atleta(long idAtleta, float altura, float peso, DatosPersona dp) {
		super();
		this.idAtleta = idAtleta;
		this.altura = altura;
		this.peso = peso;
		this.persona = dp;
	}

	public Atleta(long idParticipante, Atleta a, int dorsal, char calle) {
		super(idParticipante, dorsal, calle);
		this.idAtleta = a.idAtleta;
		this.altura = a.altura;
		this.peso = a.peso;
		this.persona = Datos.buscarPersonaPorId(a.idAtleta);
	}

	@Override
	public long getId() {
		return idAtleta;
	}

	@Override
	public void setId(long id) {
		this.idAtleta = id;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public DatosPersona getPersona() {
		return this.persona;
	}
	//Examen 5 ejercicio 5
	@Override
	public String toString() {
		return "" + persona.getNombre() + " (" + persona.getNifnie().mostrar() + ") del año "
				+ persona.getFechaNac().getYear() + "\t" + peso + "Kgs. " + altura + "m.";
	}


}
