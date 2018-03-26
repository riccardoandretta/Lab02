package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {

	private List<Word> dictionary = new LinkedList<>(); // in questo caso è meglio un ArrayList perchè occupa meno
														// memoria, mentre le prestazioni sono pari, perchè non rimuovo
														// elementi

	public void addWord(String alienWord, String translation) {

		Word newWord = new Word(alienWord, translation);

		// Controllo se la parola è già stata inserita
		for (Word w : dictionary) {
			if (w.getAlienWord().toLowerCase().compareTo(alienWord.toLowerCase()) == 0) {
				// Aggiorno
				w.setTranslation(translation);
				return;
			}
		}
		dictionary.add(newWord);
	}

	public String translateWord(String alienWord) {
		for (Word w : dictionary) {
			if (w.getAlienWord().toLowerCase().compareTo(alienWord.toLowerCase()) == 0) {
				return w.getTranslation();
			}
		}
		return null;
	}
	// NB Nell'esercizio 2, con WordEnhanced, l'unica cosa che cambia è che posso
	// sfruttare contains() (grazie ad equals) e quindi il get() invece del foreach; mentre nella
	// classe WordEnhanced al posto della traduzione ho una lista di traduzioni
	
	
	public String translateWordWildCard(String alienWildCard) {
		//Utilizzo le regex. Sostituisco il punto interrogativo con il punto.
		//Il punto indica qualsiasi carattere (posso usare stringa.
		
		alienWildCard = alienWildCard.replaceAll("\\?", ".");
		
		int matchCounter = 0;
		StringBuilder sb = new StringBuilder();
		
		for (Word w : dictionary) {
			if (w.getTranslation().compareTo(alienWildCard) == 0) { //dovrei implementare un nuovo compare
				matchCounter++;
				sb.append(w.getTranslation()+"\n");
			}
		}
		
		if (matchCounter != 0)
			return sb.toString();
		else
			return null;
	}
}
