package pobj.tme5;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class MultiSetDecorator<T> implements MultiSet<T>{
	
	private MultiSet<T> decorated;

	@Override
	public Iterator<T> iterator() {
		return decorated.iterator();
	}

	@Override
	public boolean add(T e, int count) {
		boolean bool = decorated.add(e, count);
		assert isConsistent();
		return bool;
	}

	@Override
	public boolean add(T e) {
		return decorated.add(e);
	}

	@Override
	public boolean remove(Object e) {
		return decorated.remove(e);
	}

	@Override
	public boolean remove(Object e, int count) {
		boolean bool= decorated.remove(e, count);
		assert isConsistent();
		return bool;
	}

	@Override
	public int count(T o) {
		int cpt = decorated.count(o);
		return cpt;
	}

	@Override
	public void clear() {
		decorated.clear();
	}

	@Override
	public int size() {
		return decorated.size();
	}

	@Override
	public List<T> elements() {
		return decorated.elements();
	}
	
	public boolean isConsistent(){
		boolean bool = true;
		int taille = 0;
		for (T t: elements()){
			if (count(t) <= 0)
				bool=false;
			taille+=count(t);
		}
		if (taille != this.size())
			bool = false;
		return bool;
	}

	@Override
	public boolean isEmpty() {
		return decorated.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return decorated.contains(o);
	}

	@Override
	public Object[] toArray() {
		return decorated.toArray();
	}

	@SuppressWarnings("hiding")
	@Override
	public <T> T[] toArray(T[] a) {
		return decorated.toArray(a);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return decorated.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		return decorated.addAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return decorated.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return decorated.removeAll(c);
	}

}
