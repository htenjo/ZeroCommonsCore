//=======================================================================
// ARCHIVO SearchSorter.java
// FECHA CREACIÓN: 31/08/2010
//=======================================================================
package co.zero.common.search;

import java.io.Serializable;

import co.zero.common.constant.GenericConstants;

/**
 * Clase que gestiona los parametros de ordenacion de una busqueda
 * @author Hernán Tenjo
 * @version 1.0
 */
public class SearchSorter implements Serializable {
	private static final long serialVersionUID = 1L;
	//Objeto al que pertenecen los parámetros de ordenamiento
	private String entityClass;
	//Atributo de la clase por el que se desea ordenar 
	private String sortAttribute;
	//Determina si se hará un ordenamiento ascendente
	private boolean ascendant;
	//Cadena que se antepondrá al atributo
	private String prefix;
	
	/**
	 * Metodo constructor del ordenador
	 * @param entityClass Clase de la entidad a la que pertenece el atributo
	 * @param attribute Nombre del atributo por el que se realizará el ordenamiento
	 * @param ascendant Determina se el ordenamiento se hará de forma ascendente
	 */
	public SearchSorter(String entityClass, String attribute, boolean ascendant) {
		setEntityClass(entityClass);
		setSortAttribute(attribute);
		setAscendant(ascendant);
	}
	
	/** 
	 * @return the entityClass
	 */
	public String getEntityClass() {
		return entityClass;
	}

	/**
	 * @param entityClass the entityClass to set
	 */
	public void setEntityClass(String entityClass) {
		this.entityClass = entityClass;
	}

	/**
	 * @return the sortAttribute
	 */
	public String getSortAttribute() {
		return sortAttribute;
	}

	/**
	 * @param sortAttribute the sortAttribute to set
	 */
	public void setSortAttribute(String sortAttribute) {
		this.sortAttribute = sortAttribute;
	}
	
	/**
	 * Metodo que determina si el ordenamiento se hará de forma ascendente
	 * @return TRUE si el ordenamiento se hará de forma ascendente, FALSE de lo contrario
	 */
	public boolean isAscendant() {
		return ascendant;
	}
	
	/**
	 * Metodo que permite obtener la cadena que representa la forma 
	 * de ordenamiento esperada
	 * @return Cadena que representa la forma de ordenamiento
	 */
	public String getAscendantClause(){
		if(ascendant){
			return GenericConstants.SQL_ORDER_ASCENDANT;
		}else{
			return GenericConstants.SQL_ORDER_DESCENDANT;
		}
	}

	/**
	 * Metodo que permite modificar el tipo de ordenamiento
	 * @param ascendant TRUE si el ordenamiento se hará de forma ascendente, 
	 * FALSE de lo contrario
	 */
	public void setAscendant(boolean ascendant) {
		this.ascendant = ascendant;
	}

	/**
	 * @return the prefix
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * @param prefix the prefix to set
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
}