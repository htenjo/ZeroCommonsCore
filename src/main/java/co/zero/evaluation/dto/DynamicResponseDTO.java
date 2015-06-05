/**
 * 
 */
package co.zero.evaluation.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.event.ActionEvent;

/**
 * Clase que permite modelar una respuesta dinámica dada a una pregunta de un cuestionario
 * Esta clase de respuestas generalmente son dadas en cuestionarios sociodemográficos donde
 * se requiere capturar la mayor cantidad de información posible de los evaluadores.
 * @author Hernán Tenjo
 */
public class DynamicResponseDTO extends ResponseDTO {
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Texto respondido como feedBack a una pregunta por el evaluador
	private String feedBack;
	//Grupos de respuestas dadas en una pregunta con QuestionType dinámico
	private List<DynamicResponseGroupDTO> groups;
	
	//==== Atributos requeridos por la capa de presentación ====
	//Los grupos que han sido seleccionados para ser involucrados en un proceso
	private DynamicResponseGroupDTO[] selectedGroups;
	private long groupUniqueNewId = 0;
	
	/**
	 * Método que permite agregar grupos a la respuesta dinámica
	 * @param group El grupo que se desea agregar
	 */
	public void addGroup(DynamicResponseGroupDTO group){
		if(groups == null){
			groups = new ArrayList<DynamicResponseGroupDTO>();
		}
		
		group.setResponse(this);
		groups.add(group);
	}
	
	//================== 	Metodos requeridos por la vista =======================
	public int getItemColumns(){
		if(groups == null || groups.size() == 0){
			addGroupRow();
		}
		
		return groups.get(0).getItems().size();
	}
	
	public int getGroupsCount(){
		if(groups == null || groups.size() == 0){
			return 0;
		}else{
			return groups.size();
		}
	}
	
	/**
	 * Agrega un grupo de preguntas para la tabla dinamica
	 */
	public void addGroupRow(){
		DynamicResponseItemDTO item;
		List<QuestionDTO> questions = question.getType().getDynamicQuestions();
		DynamicResponseGroupDTO group = buildGroup();
		
		for(QuestionDTO question : questions){
			item = new DynamicResponseItemDTO();
			item.setQuestion(question);
			
			if(question.getType().getResponseType().isOpen()){
				item.setOpenResponse(buildOpenResponseEmpty(question));
			}else{
				item.setCloseResponse(buildCloseResponseEmpty(question));
			}
			
			group.addItem(item);
		}
	}
	
	/**
	 * Método que permite eliminar uno de los grupos de respuestas dinámicas
	 */
	public void removeGroupRow(ActionEvent e){
		if(selectedGroups != null){
			groups.removeAll(Arrays.asList(selectedGroups));
		}
	}
	
	private DynamicResponseGroupDTO buildGroup(){
		DynamicResponseGroupDTO group = new DynamicResponseGroupDTO();
		group.setId(--groupUniqueNewId);
		this.addGroup(group);
		return group;
	}
	
	private CloseResponseDTO buildCloseResponseEmpty(QuestionDTO question){
		CloseResponseDTO response = new CloseResponseDTO();
		response.setQuestion(question);
		response.setSolvedQuestionnaire(solvedQuestionnaire);
		return response;
	}
	
	private OpenResponseDTO buildOpenResponseEmpty(QuestionDTO question){
		OpenResponseDTO response = new OpenResponseDTO();
		response.setQuestion(question);
		response.setSolvedQuestionnaire(solvedQuestionnaire);
		return response;
	}

	//================== 	METODOS GET/SET requeridos por la vista =======================
	/**
	 * @return the selectedGroups
	 */
	public DynamicResponseGroupDTO[] getSelectedGroups() {
		return selectedGroups;
	}

	/**
	 * @param selectedGroups the selectedGroups to set
	 */
	public void setSelectedGroups(DynamicResponseGroupDTO[] selectedGroups) {
		this.selectedGroups = selectedGroups;
	}
	
	//================== 	METODOS GET/SET  =======================
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
	 * Método que permite obtener los grupos de respuestas de la respuesta dinámica
	 * @return Los grupos de respuestas que pertenecen a la respuesta dinámica
	 */
	public List<DynamicResponseGroupDTO> getGroups() {
		return groups;
	}

	/**
	 * Método que permite modificar los grupos de respuestas de la respuesta dinámica
	 * @param groups Los nuevos grupos que serán asociados a la respuesta dinámica
	 */
	public void setGroups(List<DynamicResponseGroupDTO> groups) {
		this.groups = groups;
	}
}