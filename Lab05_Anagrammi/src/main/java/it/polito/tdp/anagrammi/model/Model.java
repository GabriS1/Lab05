package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.anagrammi.DAO.DizionarioDAO;


public class Model {
	
	DizionarioDAO dizionario = new DizionarioDAO();

	private List<String> soluzione;
	
	private List<Parola> solCompleta;
	

	/**
	 * Genera tutti gli anagrammi della parola specificata in ingresso.
	 * 
	 * @param parola parola da anagrammare
	 * @return elenco di tutti gli anagrammi della parola data
	 */
	public List<Parola> anagrammi(String parola) {
		this.soluzione = new ArrayList<>();
		this.solCompleta= new ArrayList<>();
		
		
		parola = parola.toUpperCase();

		List<Character> disponibili = new ArrayList<>();
		for (int i = 0; i < parola.length(); i++) {
			disponibili.add(parola.charAt(i));
		}

		// avvia la ricorsione
		cerca("", 0, disponibili);
		
		
		for(String si: soluzione) {
			if(!this.dizionario.isCorrect(si)) {
				Parola p= new Parola(si, false);
				this.solCompleta.add(p);
			}else {
				Parola p= new Parola(si, true);
				this.solCompleta.add(p);
			}
		}
		
		return solCompleta;
		
	}

	/**
	 * Procedura ricorsiva per il calcolo dell'anagramma.
	 * 
	 * @param parziale    parte iniziale dell'anagramma costruito finora
	 * @param livello     livello della ricorsione, sempre uguale a
	 *                    parziale.length()
	 * @param disponibili insieme delle lettere non ancora utilizzate
	 */
	private void cerca(String parziale, int livello, List<Character> disponibili) {
		if (disponibili.size() == 0) { // livello==parola.length(), parziale.length()==parola.length()
			// caso terminale

			// if(parziale è nel dizionario--> nel caso in cui voglio inserire solo parole
			// sensate)
			// if( parziale non è presente nella soluzione--> nel caso in cui non voglio
			// inserire doppioni)
			if (!this.soluzione.contains(parziale)) {
				this.soluzione.add(parziale);
			}
		}

		// caso normale
		// provare ad aggiungere a 'parziale' tutti i caratteri presenti tra
		// i 'disponibili'
		for (Character ch : disponibili) {
			String tentativo = parziale + ch;

			// if(nel dizionario esistono delle parole che iniziano con 'tentativo'?--> ex.
			// vedere se esistono parole che iniziano con "dg")

			List<Character> rimanenti = new ArrayList<>(disponibili);
			rimanenti.remove(ch);

			cerca(tentativo, livello + 1, rimanenti);
		}
	}
}


/*
 * Dato di partenza: parola da anagrammare, di lunghezza N Soluzione parziale:
 * una parte dell'anagramma già costruito (i primi caratteri)--> ex "Do" in
 * "dog", "Od" in "Odg". Livello: numero di lettere di cui è composta la
 * soluzione parziale. Soluzione finale: soluzione di lunghezza N -> caso
 * terminale Caso terminale: salvare la soluzione trovate (quando livello==N)
 * Generazione delle nuove soluzioni: provare a aggiungere una lettera,
 * scegliendola tra quelle che non sono ancora state utilizzate all'interno
 * della soluzione parziale.
 */



