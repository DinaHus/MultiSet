package pobj.tme5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MultiSetParser {

	public MultiSetParser() {
		
	}
	
	@SuppressWarnings("resource")
	public static MultiSet<String> parse (String fileName) throws InvalidMultiSetFormat{
		String file = fileName;
		String line;
		String[] tab;
		BufferedReader br;
		Integer j;
		MultiSet<String> ms = new HashMultiSet<String>();
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new InvalidMultiSetFormat("Fichier non existant.");
		}
		
		try {
			while((line = br.readLine())!=null) {
				for(String word : line.split("\\P{L}+")) {
					tab = word.split(":");
					try{
						j = Integer.decode(tab[1]);
					} catch(NumberFormatException nfe){
						nfe.printStackTrace();
						throw new InvalidMultiSetFormat("apres le delimiteur la chaine n'est pas un nombre", nfe);
					}
					for(int i = 0; i < tab[0].length(); i++)
						if(tab[1] == null) 
							throw new InvalidMultiSetFormat("Delimiteur introuvable");
					ms.add(word,j);
				} 
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new InvalidMultiSetFormat("IOException pb.");
		}
		
		return ms;
	}
}
