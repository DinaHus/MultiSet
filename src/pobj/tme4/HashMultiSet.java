package pobj.tme4;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class HashMultiSet<T> extends AbstractCollection<T> implements MultiSet<T> {
	private HashMap<T,Integer> col;
	int size = 0;

	/**
	 * Construit une nouvelle HashMap vide
	 */
	public HashMultiSet(){
		col = new HashMap<T,Integer>();
	}
	
	/**
	 * Construit une copie d'un objet Collection<T> passer en argument et initialise notre 
	 * Hashmap avec le contenue de la collection
	 * @param c Collection d'objet de type T
	 */
	public HashMultiSet(Collection<T> c) {
		//Initialisation de col avec une taille c
		col = new HashMap<T, Integer>(c.size());
		//Parcour des elements de c
		for(T object : c) {
			//Ajout dans col a valeur(T = object,Integer = get(object) + 1
			col.put(object,col.get(object)+1);
			//Incrementation de la taille de col
			this.size++;
		}
	}

	// Methods.

	@Override
	public List<T> elements() {
		return new ArrayList<T>(this.col.keySet());
	}

	@Override
	public boolean contains(Object o) {
		return this.col.containsKey(o);
	}

	/**
	 * Ajout 
	 * @param e clé de type T
	 * @param count valeur de type Integer
	 * @return true ou false
	 */
	@Override
	public boolean add(T e, int count) {
		Integer x1 = col.get(e); 
		//Verification pour savoir si e possede une valeur nul 
		if(x1 == null){
			//Creation d'un nouvel Integer
			Integer x2 = new Integer(count);
			//Ajout dans col du nouvel element(e,x2)
			col.put(e, x2);
			//Retourne boolean, verifie si la valeur de x1 et x2 sont identique
			//autrement dit, si l'ajout s'est bien passer, et que "e" a pris sa nouvelle valeur
			return x2 != x1;
		
		}else{
			//Entre dans le else que si "e" a une valeur == null
			// Creation d'un nouvel integer,
			Integer x2 = new Integer(count + x1.intValue());
			this.col.put(e,x2);
			//Retourne boolean, verifie si la valeur de x1 et x2 sont identique
			//autrement dit, si l'ajout s'est bien passer, et que "e" a pris sa nouvelle valeur
			return x2 != x1;
		}
	}

	/**
	 * ajoute un objet T dans la liste courante sans valeur
	 * @param T object
	 * @return true ou false
	 */
	@Override
	public boolean add(T e) {
		return this.add(e,1);
	}

	/**
	 * retire 
	 * @param Object e
	 * @return true ou false
	 */
	@Override
	public boolean remove(Object e) {
		return col.remove(e,1);
	}


	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object e, int count) {
		if(col.containsKey(e)){
			if(col.get(e) == 1)
				col.remove(e);
			else
				col.put((T)e, col.get(e) - 1);
			size--;
		}
		return true;
	}

	/**
	 * retourne la valeur associer a un objet T de la liste
	 * @param T object
	 */
	@Override
	public int count(T o) {
		if(col.get(o) == null) 
			return 0;
		return col.get(o).intValue();
	}

	@Override
	public void clear() {
		this.size = 0;
		this.col.clear();
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public Iterator<T> iterator() {
		return new HashMultiSetIterator<T>(this.col);
	}

	private class HashMultiSetIterator<T> implements Iterator<T> {

		private Iterator<Map.Entry<T, Integer>> listIterator;
		private Map.Entry<T, Integer> elem;
		private int cpt = 0;
		
		public HashMultiSetIterator(HashMap<T, Integer> v) {
			this.listIterator = v.entrySet().iterator();
			this.elem = listIterator.next();
		}

		@Override
		public boolean hasNext() {
			int elemCpt = elem.getValue();
			
			if(this.cpt < elemCpt){
				return true;
			}else{
				return this.listIterator.hasNext();
			}
		}

		@Override
		public T next() {
			int count = this.elem.getValue();

			if (this.cpt < count) {
				this.cpt++;
				return this.elem.getKey();
			} else {
				this.cpt = 1;
				this.elem = this.listIterator.next();
				return this.elem.getKey();
			}
		}

	}
}
