//=======================================================================
// ARCHIVO SelectedOptionByResponseDTO.java
// FECHA CREACIÓN: 10/05/2011
//=======================================================================
package co.zero.evaluation.dto;

import co.zero.common.dto.EntityDTO;

/**
 * Clase que agrupa las opciones de respuesta seleccionadas por el 
 * evaluador en una pregunta dada. Esto es necesario ya que se pueden
 * tener preguntas de selección múltiple con múltiple respuesta
 * @author Hernán Tenjo
 * @version 1.0
 */
public class SelectedOptionByResponseDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//El valor real de la opción de respuesta seleccionada
	private double realValue;
	//La respuesta a la que pertenece la opción seleccionada
	private CloseResponseDTO response;
	//La opción seleccionada del grupo de QuestionTypeDTO
	private ResponseOptionDTO option;
	
	/**
	 * Metodo que permite obtener el valor real de la respuesta. Este valor puede ser
	 * diferente al de las opciones de respueta, ya que se puede dar un pre procesamiento 
	 * de la información antes de ser registrar en la BD
	 * @return El valor real registrado para la opción de respuesta
	 */
	public double getRealValue() {
		return realValue;
	}

	/**
	 * Método que permite modificar el valor real de la respuesta
	 * @param realValue El nuevo valor asociado a la respuesta
	 */
	public void setRealValue(double realValue) {
		this.realValue = realValue;
	}

	/**
	 * Metodo que permite obtener la respuesta a la que pertenece esta opción
	 * @return La respuesta a la que pertenece la opcion seleccionada
	 */
	public CloseResponseDTO getResponse() {
		return response;
	}

	/**
	 * Método que permite modificar la respuesta a la que pertenece esta opción
	 * @param response La nueva respuesta a ser relacionada
	 */
	public void setResponse(CloseResponseDTO response) {
		this.response = response;
	}

	/**
	 * Metodo que permite obtener la opción de respuesta seleccionada
	 * @return La opción de respuesta seleccionada
	 */
	public ResponseOptionDTO getOption() {
		return option;
	}

	/**
	 * Método que permite modificar la opcion de respuesta selecccionada
	 * @param option La nueva opción de respuesta seleccionada a relacionar
	 */
	public void setOption(ResponseOptionDTO option) {
		this.option = option;
	}
}