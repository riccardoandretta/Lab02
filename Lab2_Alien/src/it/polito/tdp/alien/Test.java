package it.polito.tdp.alien;


public class Test {

	public static void main(String[] args) {

		AlienDictionary ad = new AlienDictionary();

		String alienWord = "Alber0";
		
		ad.addWord(alienWord, "Albero");
		String ris = ad.translateWord(alienWord);
		
		String ris2 = ad.translateWord("000");
		
		if (!alienWord.matches("[a-zA-Z]*")) {
			System.out.println("Insert only alfabethic expression");
    		
    	}
		System.out.println(ris);
		System.out.println(ris2);
	}
}
