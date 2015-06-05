//=======================================================================
// ARCHIVO StackMapCache.java
// FECHA CREACIÓN: 09/02/2012
//=======================================================================
package co.zero.common.datastructure;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import co.zero.common.constant.GenericConstants;

/**
 * Clase que permite gestionar un cache basado en un mapa con tipo de acceso
 * FIFO (First In First Out) y un tamaño máximo.
 * @author Hernán Tenjo
 * @version 1.0
 */
public class QueueMapCache<T, K>{
	private int maxSize;
	private Map<T, K> cache;
	
	/**
	 * Constructor del cache que se desea gestionar
	 * @param maxSize Máximo tamaño del cache que se desea utilizar
	 */
	public QueueMapCache(int maxSize) {
		this.maxSize = maxSize;
		this.cache = new LinkedHashMap<T, K>();
	}
	
	/**
	 * Método que permite agregar un elemento al cache, si el elemento ya existe pasará al inicio
	 * para tener menor posibilidad de ser eliminado
	 * @param key LLave del valor que se desea agregar
	 * @param value Valor que se desea agregar
	 */
	public void add(T key, K value){
		if(cache.size() == maxSize && !cache.containsKey(key)){
			removeOlderElement();
		}
		
		if(cache.containsKey(key)){
			//Esto para renovar el elemento que ya existe
			cache.remove(value);
		}
		
		cache.put(key, value);
	}
	
	/**
	 * Método que permite obtener un elemento del cache
	 * @param key Llave que identifica de forma única al elemento del cache
	 * @return El elemento si existe, null de lo contrario
	 */
	public K getElement(T key){
		return cache.get(key);
	}
	
	/**
	 * Método que permite eliminar el elemento más antiguo del cache.
	 * Para una estructura FIFO, el elemento más antiguo es el primero de la estructura.
	 */
	public void removeOlderElement(){
		T keyToDelete = null;
		
		if(cache.keySet().iterator().hasNext()){
			keyToDelete = cache.keySet().iterator().next();
		}
		
		cache.remove(keyToDelete);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String content = StringUtils.EMPTY;
		
		for(T key : cache.keySet()){
			content += GenericConstants.BRACKET_SQUARE_START;
			content += key.toString();
			content += GenericConstants.COMMA;
			content += cache.get(key).toString();
			content += GenericConstants.BRACKET_SQUARE_END;
		}
		
		return content;
	}
}