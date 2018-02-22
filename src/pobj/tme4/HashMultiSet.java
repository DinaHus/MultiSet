package pobj.tme4;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class HashMultiSet<T> implements MultiSet<T>{
	private HashMap<T,Integer> col;
	int size =0;

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

	@Override
	public boolean add(T e) {
		return this.add(e,1);
	}

	@Override
	public boolean remove(Object e) {
		return col.remove(e,1);
	}

	@Override
	public boolean remove(Object e, int count) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int count(T o) {
		// TODO Auto-generated method stub
			return 0;
	}
	/**
	 * effectue un clear de la liste 
	 */
	@Override
	public void clear() {
		col.clear();
		
	}
	/**
	 * @return la taille de la liste
	 */
	@Override
	public int size() {
		return col.size();
	}

}
