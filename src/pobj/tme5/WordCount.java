package pobj.tme5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
//import java.util.List;
import java.util.List;
import java.util.Set;

import pobj.util.Chrono;

public class WordCount
{
	
	public static void main(String[] args) throws IOException{
		Chrono chrono = new Chrono(); 
		HashMultiSet<String> ms = new HashMultiSet<String>();
		wordcount(ms);
		chrono.stop();
		System.out.println(chrono);
/*		Chrono chrono2 = new Chrono(); 
		NaiveMultiSet<String> ms2 = new NaiveMultiSet<String>();
		wordcount(ms2);
		chrono2.stop();		
*/	}
	
public WordCount(){
	
		
	}
	
	public static void wordcount(MultiSet<String> ms) throws IOException{
		int nbMots = 10;
		
		String file = "data/WarAndPeace.txt";
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		while((line = br.readLine()) != null){
			for( String word : line.split("\\P{L}+") ){
				if (word.equals("")) continue;
				ms.add(word.toLowerCase());
			}
		}
		br.close();
		
		List<String> lt = ms.elements(); //renvoie liste des elem de ms avec les mots de File
		Set<String> lt_bis = new HashSet<String>(lt);
		List<String> lt_final = new ArrayList<>(lt_bis);
		Collections.sort(lt_final,Collections.reverseOrder());
		for(int i=0;i<nbMots;i++){
			System.out.println(lt_final.get(i));
		}
	}
	
}