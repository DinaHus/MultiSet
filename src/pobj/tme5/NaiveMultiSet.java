package pobj.tme5;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class NaiveMultiSet<T> extends AbstractCollection<T> implements MultiSet<T>{
	
	private List<T> liste = new ArrayList<T>();
	

	@Override
	public boolean add(T e, int count) {
		for(int i = 0; i < count; i++)
			liste.add(e);
		return true;
	}

	@Override
	public boolean remove(Object e, int count) {
		for(int i = 0; i < count; i++)
			liste.remove(e);
		return true;
	}

	@Override
	public int count(T o) {
		int cpt = 0;
		for(int i = 0; i < liste.size(); i++){
			if(liste.get(i).equals(o))
				cpt++;
		}
		return cpt;
	}


	@Override
	public List<T> elements() {
		List<T> liste_bis = new ArrayList<>(liste);
		Set<T> hs = new HashSet<T>();
		hs.addAll(liste_bis);
		liste_bis.clear();
		liste_bis.addAll(hs);
		Collections.sort(liste_bis,Collections.reverseOrder());
		for(int i = 0; i < 10; i++)
			System.out.println(liste_bis.get(i));
		return liste_bis;
	}

	@Override
	public Iterator<T> iterator() {
		return liste.iterator();
	}

	@Override
	public int size() {
		return liste.size();
	}

}