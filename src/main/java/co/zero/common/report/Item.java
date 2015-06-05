//=======================================================================
// ARCHIVO Item.java
// FECHA CREACIN: 2/02/2009
//=======================================================================
package co.zero.common.report;

import java.io.Serializable;

/**
 * Clase que modela un dato de un reporte
 * Ej. Si se tiene un reporte en forma de barras, esta clase representara
 * a una barra específica
 * @author Hernn Tenjo
 * @version 1.0
 */
public class Item implements Serializable{
	private static final long serialVersionUID = 1L;
	// Valor que tomara el item
	private double value;
	// Para el caso en el que los items no son numericos
	private String textValue;
	// Nombre representativo del conjunto de datos
	private String itemName;
	
	/**
	 * Metodo que permite obtener el valor de texto del item
	 * @return El texto que ha sido guardado como valor
	 */
	public String getTextValue() {
		return textValue;
	}

	/**
	 * Metodo que permite modificar el valor de texto del item
	 * @param textValue El nuevo valor de texto del item
	 */
	public void setTextValue(String textValue) {
		this.textValue = textValue;
	}

	/**
	 * Metodo que permite obtener el valor numérico del item
	 * @return El valor numérico del item
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Metodo que permite modificar el valor numerico del item
	 * @param values Nuevo valor que tendrá el item
	 */
	public void setValue(double value) {
		this.value = value;
	}

	/**
	 * Metodo que permite obtener el nombre representativo del item
	 * @return El nombre que representa al item
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * Metodo que permite modificar el nombre del item
	 * @param itemName El nuevo nombre que representará al item
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String string = "\nItemName: "+itemName;
		string += "\nItemValue: "+value;
		string += "\nItemTextValue: "+textValue;
		return string;
	}
}