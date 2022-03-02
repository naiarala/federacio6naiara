package entidades;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

import utils.Datos;
//examen 8_ejercicio2
public class ComparadorMedallas implements Comparator<Metal>{
	

	@Override
	public int compare(Metal o1, Metal o2) {
		// TODO Auto-generated method stub
		return ((int)( o1.getPureza() - o2.getPureza()));
	}
	public void mostrarMedallasOrdenadas() {
		LinkedList<Metal>lista=new LinkedList <Metal>();
		
		for(Oro m : Datos.OROS)
			lista.add(m);
		for(Plata p : Datos.PLATAS)
			lista.add(p);
		for(Bronce b : Datos.BRONCES)
			lista.add(b);
	}
//	void imprimir(){
//		Iterator<T> it = Metal.iterator();
//		while (it.hasNext())
//		System.out.println(it.next());
//		}
}
