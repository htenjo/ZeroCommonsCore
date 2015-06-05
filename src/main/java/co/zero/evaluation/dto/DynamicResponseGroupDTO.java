/**
 * 
 */
package co.zero.evaluation.dto;

import java.util.ArrayList;
import java.util.List;

import co.zero.common.dto.EntityDTO;

/**
 * Clase que permite realizar una agrupación de múltiples respuestas dadas
 * en un cuestionario
 * @author Hernán Tenjo
 */
public class DynamicResponseGroupDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Respuesta a la que pertenece el grupo dinámico
	private DynamicResponseDTO response;
	//Items dinámicos que pertenecen al grupo
	private List<DynamicResponseItemDTO> items;
	
	/**
	 * Método que permite agregar un {@link DynamicResponseItemDTO} al grupo
	 * @param item El {@link DynamicResponseItemDTO} que se desea agregar
	 */
	public void addItem(DynamicResponseItemDTO item){
		if(items == null){
			items = new ArrayList<DynamicResponseItemDTO>();
		}
		
		item.setGroup(this);
		items.add(item);
	}
	
	/**
	 * Metodo que permite obtener la respuesta dinámica a la que pertenece el grupo
	 * @return La respuesta dinámica a la que pertenece el grupo
	 */
	public DynamicResponseDTO getResponse() {
		return response;
	}

	/**
	 * Método que permite modificar la respuesta dinámica a la que pertenece el grupo
	 * @param response La nueva respuesta dinámica a la que será asociado el grupo
	 */
	public void setResponse(DynamicResponseDTO response) {
		this.response = response;
	}

	/**
	 * Método que permite obtener los items que pertenecen al grupo
	 * @return Los items dinámicos que pertenecen al grupo
	 */
	public List<DynamicResponseItemDTO> getItems() {
		return items;
	}

	/**
	 * Método que permite modificar los items que pertenecen al grupo
	 * @param items Nueva colección de items que pertenecerán al grupo
	 */
	public void setItems(List<DynamicResponseItemDTO> items) {
		this.items = items;
	}
}