//=======================================================================
// ARCHIVO Serie.java
// FECHA CREACIÓN: 2/02/2009
//=======================================================================
package co.zero.common.report;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que agrupa un conjunto de items 
 * Ej. Cuando se tiene un grafico de barras p.e., en una grafica valor 
 * obtenido vs valor esperado, la serie podria ser aquellos
 * valores que corresponden con el valor obtenido
 * @author Hernán Tenjo
 * @version 1.0
 */
public class Serie implements Serializable{
	private static final long serialVersionUID = 1L;
	// Determina la cantidad de items que tendrá la serie
	private List<Item> items = new ArrayList<Item>();
	// Label descriptivo de la serie
	private String serieName;
	
	/**
	 * Metodo que permite agregar un item a la serie conociendo sus valores
	 * @param value valor numerico del item
	 * @param name Nombre asociado al item
	 */
	public void addItem(double value, String name){
		Item item = new Item();
		item.setValue(value);
		item.setItemName(name);
		items.add(item);
	}
	
	/**
	 * Metodo que permite agregar un item no numerico a la serie
	 * @param textValue Texto que hará las veces de valor en el item 
	 * @param name Nombre asignado al item
	 */
	public void addItem(String textValue, String name){
		Item item = new Item();
		item.setTextValue(textValue);
		item.setItemName(name);
		items.add(item);
	}
	
	/**
	 * Metodo que permite obtener un promedio simple
	 * de los valores que conforman la serie en el momento
	 * NOTA: NO SE TIENEN EN CUENTA LOS VALORES 0, YA QUE CORRESPONDEN
	 * A VALORES DE RESPUESTAS NO APLICA
	 * @return Promedio simple de los valores de la serie
	 */
	public double getSerieAverage(){
		double average = 0;
		int divisionFactor = 0;
		
		for(Item item : items){
			if(item.getValue() > 0){
				average += item.getValue();
				divisionFactor++;
			}
		}
		
		return divisionFactor == 0 ? 0 : average/divisionFactor;
	}
	
	/**
	 * Metodo que permite obtener los items que tendrá la serie
	 * @return items Lista de los items asociados a la serie
	 */
	public List<Item> getItems() {
		return items;
	}
	
	/**
	 * Metodo que permite modificar los items asociados a la serie
	 * @param items Lista de items que serán asociados a la serie
	 */
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	/**
	 * Label que describe a la serie
	 * @return Nombre que representa a la serie
	 */
	public String getSerieName() {
		return serieName;
	}
	
	/**
	 * Metodo que permite modificar el nombre de la serie
	 * @param serieName El nuevo nombre que será asociado a la serie
	 */
	public void setSerieName(String serieName) {
		this.serieName = serieName;
	}
	 
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String string = "\nSerieName: "+serieName;
		string += "\nItems: "+items.toString();
		return string;
	}
}