//=======================================================================
// ARCHIVO OpenResponseDTO.java
// FECHA CREACIÓN: 10/05/2011
//=======================================================================
package co.zero.evaluation.dto;


/**
 * Clase que modela una respuesta dada por un evaluador a una
 * pregunta abierta donde el valor ingresado es de tipo texto
 * @author Hernán Tenjo
 * @version 1.0
 */
public class OpenResponseDTO extends ResponseDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Determina si la respuesta es producto de una respuesta dinámica
	private boolean dynamic;
	//Valor de la respuesta cuando es de tipo texto
	private String responseText;
	
	/**
	 * Método que permite obtener el valor de la respuesta de texto
	 * @return El texto ingresado por el evaluador
	 */
	public String getResponseText() {
		return responseText;
	}

	/**
	 * Metodo que permite modificar el valor de la respuesta de texto
	 * @param responseText El nuevo texto dado por el evaluador
	 */
	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}
	
	/**
	 * Método que permite determinar si la respuesta es producto de una respuesta dinámica.
	 * Esto con el fin de determinar cuáles de las respuestas abiertas no se deben interpretar 
	 * como una respuesta independiente sino como una parte de una respuesta
	 * @return True si la respuesta es producto de una respuesta dinámica, False de lo contrario
	 */
	public boolean isDynamic() {
		return dynamic;
	}

	/**
	 * Método que permite modificar si la respuesta es producto de una respuesta dinámica.
	 * @param dynamic True si la respuesta es producto de una respuesta dinámica, False de lo contrario
	 */
	public void setDynamic(boolean dynamic) {
		this.dynamic = dynamic;
	}
}