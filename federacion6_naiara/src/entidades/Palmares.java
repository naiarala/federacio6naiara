package entidades;

public class Palmares<T, S> {

	// Examen 7-Ejercicio 4.
	/**
	 * Clase con DosGenericos con dos parametros de tipo: T y S
	 */
	private long id;
	T medalla;// declaro el objeto medalla
	S atleta;// declaro el objeto atleta
	private Prueba prueba;
	private String observaciones;
	private boolean esEquipo;

	// Constructor
	Palmares(long id, T medalla, S atleta, Prueba prueba, String observaciones) {
		this.id = id;
		this.medalla = medalla;
		this.atleta = atleta;
		this.prueba = prueba;
		this.observaciones = observaciones;
	}

	// Getters y Setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public T getMedalla() {
		return medalla;
	}

	public void setMedalla(T medalla) {
		this.medalla = medalla;
	}

	public S getAtleta() {
		return atleta;
	}

	public void setAtleta(S atleta) {
		this.atleta = atleta;
	}

	public Prueba getPrueba() {
		return prueba;
	}

	public void setPrueba(Prueba prueba) {
		this.prueba = prueba;
	}

	public String getEquipo() {
		return null;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	// Metodo toString

//	@Override
//	public String toString() {
//		return "Palmares [id=" + id + ", medalla=" + medalla + ", atleta=" + atleta + ", prueba=" + prueba
//				+ ", observaciones=" + observaciones + "]";
//	}

	// Mostrar el tipo de T y S
	public void mostrarTipo() {
		System.out.println("El tipo de T es: " + medalla.getClass().getName());
		System.out.println("El tipo de S es:" + atleta.getClass().getName());
	}

	// Metodo para mostrar datos

//	@Override
//	public String toString() {
//		observaciones += "" +id + "(" + medalla.getClass().getName()) + "en" + prueba.getNombre() + "(" +fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+ "en" + lugar.getNombre()+ "dorsal" + dorsal.getDorsal+ "donde" + calle.getCalle +"\n";
//		if(this.getAtleta()) {
//			Resultado res = this.getResultado(); 
//
//			Participante[] podio = res.getPodio(); 
//
//			observaciones += "Primer puesto:"+ podio[0].getId()+", con el dorsal" + podio[0].getDorsal()+" por la calle "+ podio[0].getCalle()+" Oro#"+ res.getPrimero().getId()+"\n"; 
//
//			observaciones += "Segundo puesto:"+ podio[1].getId()+", con el dorsal" + podio[1].getDorsal()+" por la calle "+ podio[1].getCalle()+" Oro#"+ res.getSegundo().getId()+"\n"; 
//
//			observaciones += "Tercer puesto:"+ podio[2].getId()+", con el dorsal" + podio[2].getDorsal()+" por la calle "+ podio[2].getCalle()+" Oro#"+ res.getTercero().getId()+"\n"; 
//
//			} 
//
//			return observaciones; 
//		
//		if(this.esEquipo) {
//			Resultado res = this.getResultado(); 
//
//			Participante[] podio = res.getPodio(); 
//
//			observaciones += "Primer puesto:"+ podio[0].getId()+", con el dorsal" + podio[0].getDorsal()+" por la calle "+ podio[0].getCalle()+" Oro#"+ res.getPrimero().getId()+"\n"; 
//
//			observaciones += "Segundo puesto:"+ podio[1].getId()+", con el dorsal" + podio[1].getDorsal()+" por la calle "+ podio[1].getCalle()+" Oro#"+ res.getSegundo().getId()+"\n"; 
//
//			observaciones += "Tercer puesto:"+ podio[2].getId()+", con el dorsal" + podio[2].getDorsal()+" por la calle "+ podio[2].getCalle()+" Oro#"+ res.getTercero().getId()+"\n"; 
//
//			} 
//
//			return observaciones; 
//			
//		}
}
