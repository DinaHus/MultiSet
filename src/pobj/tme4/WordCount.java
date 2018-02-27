package pobj.tme4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class WordCount {
	
	public WordCount(){
	
		
	}
	
	public static void wordcount(MultiSet<String> ms) throws IOException{
		int nbMots = 10;
		
		String file = "MonFichier.txt";
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		while((line = br.readLine()) != null){
			for( String word : line.split("\\P{L}+") ){
				if (word.equals("")) continue;
				ms.add(word);
			}
		}
		List<String> lt = ms.elements(); //renvoie liste des elem de ms avec les mots de File
		
		Collections.sort(lt);
		
		for(int i = 0; i<nbMots; i++){
			System.out.println(lt.get(i)); 	//
		}
		
		br.close();
	}
	
	public class testWordCount{
		
		public static void main(String[] args){
			
			HashMultiSet hms = new HashMultiSet<T>();
		}
	}
	
}
