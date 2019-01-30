package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Carrello<T> implements Serializable{
	
	List<T> list;
	
	public Carrello() {
		list = new ArrayList<T>(); //costruttore
	}
	
	public void aggElemento(T element) {
		list.add(element);
	}
	
	public void rimElemento(T element) {
		for(T elem : list) {
			if(elem.equals(element)) {
				list.remove(elem);
				break;
			}	
		}
	}
	
	public List<T> ottieniElem() {
		return list;
	}
	

	public void acquista() {
		for(T elem : list) {
			 {
				list.remove(elem);
			
			}	
		}
	}
	
	
}
