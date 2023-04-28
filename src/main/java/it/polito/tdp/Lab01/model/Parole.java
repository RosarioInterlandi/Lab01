package it.polito.tdp.Lab01.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {
	LinkedList<String> listaParole;
	public Parole() {
		listaParole = new LinkedList<String>();
	}
	
	public void addParola(String p) {
		listaParole.add(p);
	}
	/**
	 * I have to create a function that return a list of string
	 * in alphabetical order
	 * @return Collection<String>
	 */
	public List<String> getElenco() {
		LinkedList<String> elenco = new LinkedList<String>(listaParole);
		Collections.sort(elenco, new comparatoreStringhe());
		return elenco;
	}
	
	public void reset() {
		listaParole.clear();
	}
	public void doCancel(String s) {
		if (listaParole.contains(s)) {
			listaParole.remove(s);
		}
	}

}