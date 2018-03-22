package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {

	private List<Word> dictionary = new LinkedList<>();

	public void addWord(String alienWord, String translation) {

		Word newWord = new Word(alienWord, translation);

		for (Word w : dictionary) {
			if (w.getAlienWord().toLowerCase().compareTo(alienWord.toLowerCase()) == 0) {
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

}
