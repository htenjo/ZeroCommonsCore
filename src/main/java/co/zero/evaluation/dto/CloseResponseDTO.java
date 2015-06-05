//=======================================================================
// ARCHIVO ResponseDTO.java
// FECHA CREACIÓN: 10/05/2011
//=======================================================================
package co.zero.evaluation.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que modela una respuesta dada a una pregunta de un cuestionario
 * @author Hernán Tenjo
 * @version 1.0
 */
public class CloseResponseDTO extends ResponseDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Determina si la respuesta es producto de una respuesta dinámica
	private boolean dynamic;
	//Texto respondido como feedBack a una pregunta por el evaluador
	private String feedBack;
	//Lista con las opciones seleccionadas para la respuesta
	private List<SelectedOptionByResponseDTO> options = new ArrayList<SelectedOptionByResponseDTO>();
	
	/**
	 * Método que permite obtener las opciones seleccionadas en la respuesta
	 * @return Lista con las opciones seleccionadas para la respuesta
	 */
	public List<SelectedOptionByResponseDTO> getOptions() {
		return options;
	}

	/**
	 * Método que permite modificar las opciones seleccionadas de la respuesta
	 * @param options Lista con las nuevas opciones de la respuesta
	 */
	public void setOptions(List<SelectedOptionByResponseDTO> options) {
		this.options = options;
	}
	
	/**
	 * Método que permite agregar una opcion a la respuesta
	 * @param option Opcion que se desea agregar a la respuesta
	 */
	public void addOption(SelectedOptionByResponseDTO option){
		if(options == null){
			options = new ArrayList<SelectedOptionByResponseDTO>();
		}
		
		option.setResponse(this);
		options.add(option);
	}
	
	/**
	 * Método que permite obtener el texto de feedBack dado por el evaluador
	 * @return El texto registrado por el evaluador
	 */
	public String getFeedBack() {
		return feedBack;
	}

	/**
	 * Metodo que permite modificar el texto de feedBack dado por el evaluador
	 * @param feedBack Nuevo texto asociado a la respuesta
	 */
	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}
	
	/**
	 * Método que permite determinar si la respuesta es producto de una respuesta dinámica.
	 * Esto con el fin de determinar cuáles de las respuestas cerradas no son suceptibles de reportes
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