//=======================================================================
// ARCHIVO FormulaScoreDTO.java
// FECHA CREACIN: 30/01/2009
//=======================================================================
package co.zero.common.report;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase que modela una respuesta que será utilizada por un reporte
 * Contiene los atributos utilitarios que se consideren necesarios
 * @author Hernn Tenjo
 * @version 1.0
 */
public class FormulaScoreDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	/* Mapa con un conjunto de objetos adicionales que pueden ser requeridos
	 *  para la presentacion del reporte. Especialmente util cuando se requiere
	 *  mostrar datos estilo tablas, los cuales no tienen relación directa con los datos
	 *  de las series
	 */
	private Map<String, Object> objectModel = new HashMap<String, Object>();
	// Conjunto de series de datos que arroja la formula
	private List<Serie> formulaSeries = new ArrayList<Serie>();
	// Promedio de los valores de los items
	private double average;
	// Valor minimo esperado para el conjunto de series
	private double minimum;
	// Rotulo general para el resultado de la formula
	private String label;
	
	/**
	 * Metodo que obtiene todos los valores de una serie en una lista
	 * @param seriePosition Posicion en la lista de series del DTO
	 * @return Los valores de la lista 
	 */
	public List<Double> getSerieValues(int seriePosition){
		Serie serie = formulaSeries.get(seriePosition);
		List<Double> values = new ArrayList<Double>();
		
		if(serie != null){
			for(Item item : serie.getItems()){
				values.add(item.getValue());
			}
		}
		
		return values;
	}
	
	/**
	 * Metodo que permite obtener una serie por su nombre
	 * donde Nombre != nombre != NOMBRE 
	 * @param name Cadena que describe el contenido de la serie
	 * @return La primera serie de formulaSeries que tenga el nombre 
	 * dado, null de lo contrario
	 */
	public Serie getSerieByName(String name){
		Serie serie = null;
		
		for(Serie serieAux : formulaSeries){
			if(serieAux.getSerieName().equals(name)){
				serie = serieAux;
				break;
			}
		}
		
		return serie;
	}
	
	/**
	 * Metodo que permite conocer la posicin de una serie 
	 * en la lista de series dado su nombre 
	 * @param name Nombre de la serie que se desea analizar
	 * @return Si la serie con el nombre dado existe -> la posicion, -1 de lo contrario
	 */
	public int getIndexSerieByName(String name){
		int index = -1;
		
		for(int i=0; i < formulaSeries.size(); i++){
			if(formulaSeries.get(i).getSerieName().equals(name)){
				index = i;
				break;
			}
		}
		
		return index;
	}
	
	/**
	 * Metodo que permite eliminar la primera serie que tenga el nombre dado
	 * @param name Nombre de la serie que se desea eliminar
	 */
	public void removeSerieByName(String name){
		Serie serie = null;
		int removePosition = -1;
		
		for(int i=0; i < formulaSeries.size(); i++){
			serie = formulaSeries.get(i);
			
			if(serie.getSerieName().equals(name)){
				removePosition = i;
				break;
			}
		}
		
		if(removePosition >= 0){
			formulaSeries.remove(removePosition);
		}
	}
	
	/**
	 * Metodo que permite obtener el conjunto de series de datos requeridos
	 * por el reporte
	 * @return formulaSeries lista con las series que contiene la respuesta
	 */
	public List<Serie> getFormulaSeries() {
		return formulaSeries;
	}
	
	/**
	 * Metodo que permite modificar las series asociadas a la respuesta
	 * @param formulaSeries Nueva lista de series asociadas a la respuesta
	 */
	public void setFormulaSeries(List<Serie> formulaSeries) {
		this.formulaSeries = formulaSeries;
	}
	
	/**
	 * Promedio utilitario de la respuesta. Este valor no es calculado con la invocación del
	 * método, sino que es asignado y requiere de una actualización manual
	 * @return El promedio asignado a la respuesta
	 */
	public double getAverage() {
		return average;
	}
	
	/**
	 * Metodo que permite modificar el promedio utilitario de la respuesta
	 * @param average El nuevo promedio que será asignado
	 */
	public void setAverage(double average) {
		this.average = average;
	}
	
	/**
	 * Para aquellos reportes que presenten un valor esperado, este método permite 
	 * obtener el valor minimo esperado para el conjunto de datos
	 * @return El valor mínimo esperado
	 */
	public double getMinimum() {
		return minimum;
	}
	
	/**
	 * Metodo que permite modificar el valor minimo esperado de la respuesta
	 * @param minimum El nuevo valor mínimo esperado
	 */
	public void setMinimum(double minimum) {
		this.minimum = minimum;
	}
	
	/**
	 * Metodo que permite obtener el label representativo de la respuesta
	 * @return El label asociado a la respuesta
	 */
	public String getLabel() {
		return label;
	}
	
	/**
	 * Metodo que permite modificar el label asociado a la respuesta
	 * @param label El nuevo label que será asociado a la respuesta
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Metodo que permite obtener la estructura que guarda los objetos 
	 * adicionales que no se encuentran contemplados en una respuesta comun
	 * @return El mapa con los objetos adicionales de la respuesta
	 */
	public Map<String, Object> getObjectModel() {
		return objectModel;
	}

	/**
	 * Metodo que permite modificar la estructura de objetos adicionales de la respuesta
	 * @param objectModel Nuevo mapa con los objetos relacionados
	 */
	public void setObjectModel(Map<String, Object> objectModel) {
		this.objectModel = objectModel;
	}
	
	
	public void addObjectModel(String key, Object value){
		this.objectModel.put(key, value);
	}
}