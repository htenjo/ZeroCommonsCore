/**
 * 
 */
package co.zero.evaluation.dto;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import co.zero.common.constant.GenericConstants;
import co.zero.common.dto.EntityDTO;
import co.zero.common.util.FormatUtils;
import co.zero.evaluation.exception.EvaluationException;

/**
 * Clase que permite realizar una agrupación de múltiples respuestas dadas
 * en un cuestionario
 * @author Hernán Tenjo
 */
public class DynamicResponseItemDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Grupo al que pertenece el item
	private DynamicResponseGroupDTO group;
	//Pregunta que está respondiento el item
	private QuestionDTO question;
	//Si la pregunta es cerrada, este atributo gestionará la respuesta
	private CloseResponseDTO closeResponse;
	//Si la pregunta es abierta, este atributo gestionará la respuesta
	private OpenResponseDTO openResponse;
	
	//================== 	METODOS requeridos por la vista =======================
	/**
	 * Método que permite obtener el texto de la respuesta abierta
	 * @return El texto que se tiene registrado en la respuesta abierta
	 */
	public String getResponseText(){
		if(openResponse != null){
			return openResponse.getResponseText();
		}
		
		return null;
	}
	
	/**
	 * Método que permite modificar el texto de la respuesta abierta
	 * @param text El nuevo texto de la respuesta abierta
	 */
	public void setResponseText(String text){
		buildOpenResponse(text);
	}
	
	/**
	 * Método que permite obtener la fecha de una respuesta abierta
	 * @return La fecha que se tiene registrada en la respuesta abierta
	 */
	public Date getResponseDate(){
		if(openResponse != null){
			try{
				return FormatUtils.formatDate(openResponse.getResponseText(), GenericConstants.FORMAT_DATE_SHORT);
			}catch(ParseException e){
				return null;
			}
		}
		
		return null;
	}
	
	/**
	 * Método que permite modificar la fecha de la respuesta abierta
	 * @param date La nueva fecha de la respuesta abierta
	 */
	public void setResponseDate(Date date){
		String dateAsString = date == null ? GenericConstants.EMPTY_STRING : 
			FormatUtils.formatDate(date, GenericConstants.FORMAT_DATE_SHORT);
		buildOpenResponse(dateAsString);
	}
	
	/**
	 * Método que permite obtener el valor de la respuesta 
	 * seleccionada para una respuesta cerrada
	 * @return El valor de la opción de respuesta seleccionada
	 */
	public String getSelectedValue(){
		if(closeResponse != null && closeResponse.getOptions() != null && closeResponse.getOptions().size() > 0){
			return Double.toString(closeResponse.getOptions().get(0).getRealValue());
		}
		
		return null;
	}
	
	/**
	 * Método que permite asignar la opcion seleccionada a la respuesta vigente
	 * @param value Valor de la seleccion realizada
	 */
	public void setSelectedValue(String paramValue){
		try{
			List<ResponseOptionDTO> selectedOptions = new ArrayList<ResponseOptionDTO>();
			double value;
			
			if(!question.getType().getResponseType().isOpen() && closeResponse == null){
				closeResponse = new CloseResponseDTO();
				closeResponse.setQuestion(question);
				closeResponse.setDynamic(true);
			}
				
			value = Double.parseDouble(paramValue);
			selectedOptions.add(findResponseOptionByValue(value));
			addSelectedResponseByResponseOption(selectedOptions);
		}catch(EvaluationException e){
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage jsfMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.toString(), null);
			context.addMessage(null, jsfMessage);
		}
	}
	
	/**
	 * Método que permite obtener los valores seleccionados en la pregunta cerrada
	 * @return Arreglo con los valores seleccionados en la respuesta
	 */
	public String[] getSelectedValues(){
		String[] values = null;
		
		if(closeResponse != null && closeResponse.getOptions() != null && closeResponse.getOptions().size() > 0){
			values = new String[closeResponse.getOptions().size()];
			
			for(int i=0; i < closeResponse.getOptions().size(); i++){
				values[i] = Double.toString(closeResponse.getOptions().get(i).getRealValue());
			}
		}
		
		return values;
	}
	
	/**
	 * Método que permite modificar los valores seleccionados en la pregunta cerrada
	 * @param values El nuevo conjunto de valores que serán asignados a la respuesta cerrada
	 */
	public void setSelectedValues(String[] values){
		updateMultipleResponseOptions(values);
	}
	
	/**
	 * Método que permite asignar las opciones seleccionadas a la respuesta vigente
	 * @param event Objeto que contiene los valores antiguos y nuevos seleccionados
	 */
	private void updateMultipleResponseOptions(String[] paramValues){
		try{
			List<ResponseOptionDTO> selectedOptions = new ArrayList<ResponseOptionDTO>();
			double value;
			
			if(!question.getType().getResponseType().isOpen() && closeResponse == null){
				closeResponse = new CloseResponseDTO();
				closeResponse.setQuestion(question);
			}
			
			for(String paramValue : paramValues){
				value = Double.parseDouble(paramValue);
				selectedOptions.add(findResponseOptionByValue(value));
			}
			
			addSelectedResponseByResponseOption(selectedOptions);
		}catch(EvaluationException e){
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage jsfMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.toString(), null);
			context.addMessage(null, jsfMessage);
		}		
	}
	
	/**
	 * Método que permite construir la respuesta abierta
	 * @param paramValue El texto asignado a la respuesta abierta
	 */
	private void buildOpenResponse(String paramValue){
		if(question.getType().getResponseType().isOpen() && openResponse == null){
			openResponse = new OpenResponseDTO();
			openResponse.setQuestion(question);
			openResponse.setDynamic(true);
		}
		
		openResponse.setResponseText(paramValue);
	}
	
	/**
	 * Método que permite buscar la opción de respuesta que tenga un valor dado
	 * @param value Valor que se desea buscar dentro de las opciones de respuesta
	 * @return La primera opcion de respuesta que tenga el valor dado, si no existe
	 * una opción que corresponda, se retornará null
	 * @throws EvaluationException 
	 */
	private ResponseOptionDTO findResponseOptionByValue(double value) throws EvaluationException{
		for(ResponseOptionDTO option : question.getType().getOptions()){
			if(option.getValue() == value){
				return option;
			}
		}
		
		throw new EvaluationException(EvaluationException.RESPONSE_OPTION_VALUE_NOT_FOUND_IN_OPTIONS);
	}
	
	/**
	 * Método que permite agregar una opción de respuesta seleccionada en la respuesta actual
	 * @param option Opcion de respuesta que se seleccionó
	 * @return {@link SelectedOptionByResponseDTO} correspondiente a la opcion dada, si no existe se crea
	 */
	private void addSelectedResponseByResponseOption(List<ResponseOptionDTO> selectedResponseOptionList){
		SelectedOptionByResponseDTO selectedOption = null;
		List<SelectedOptionByResponseDTO> newSelectedResponseOptions = new ArrayList<SelectedOptionByResponseDTO>();
		
		for(ResponseOptionDTO option : selectedResponseOptionList){
			for(SelectedOptionByResponseDTO selectedOptionAux : closeResponse.getOptions()){
				if(selectedOptionAux.getOption().equals(option)){
					selectedOption = selectedOptionAux;
					break;
				}
			}
			
			if(selectedOption == null){
				selectedOption = new SelectedOptionByResponseDTO();
			}
			
			selectedOption.setRealValue(option.getValue());
			selectedOption.setOption(option);
			newSelectedResponseOptions.add(selectedOption);
			selectedOption = null;
		}
		
		closeResponse.setOptions(newSelectedResponseOptions);
	}
	
	//================== 	METODOS GET/SET  =======================
	/**
	 * Método que permite obtener el grupo al que pertenece el ítem dinámico
	 * @return El grupo al que pertenece el item
	 */
	public DynamicResponseGroupDTO getGroup() {
		return group;
	}

	/**
	 * Método que permite modificar el grupo al que pertenece el ítem dinámico
	 * @param group El nuevo grupo que será asociado al ítem dinámico
	 */
	public void setGroup(DynamicResponseGroupDTO group) {
		this.group = group;
	}

	/**
	 * Método que permite obtener la pregunta que está respondiendo el item dinámico
	 * @return La pregunta asociada al ítem dinámico
	 */
	public QuestionDTO getQuestion() {
		return question;
	}

	/**
	 * Método que permite modificar la pregunta que está respondiendo el ítem dinámico
	 * @param question La nueva pregunta que será asociadas al ítem dinámico
	 */
	public void setQuestion(QuestionDTO question) {
		this.question = question;
	}

	/**
	 * Método que permite obtener la respuesta cerrada asociada al item dinámico
	 * @return La respuesta cerrada asociada al item
	 */
	public CloseResponseDTO getCloseResponse() {
		return closeResponse;
	}

	/**
	 * Método que permite modificar la respuesta cerrada del item dinámico
	 * @param closeResponse La nueva respuesta cerrada que será asociada al item
	 */
	public void setCloseResponse(CloseResponseDTO closeResponse) {
		this.closeResponse = closeResponse;
	}

	/**
	 * Método que permite obtener la respuesta abierta asociada al item dinámico 
	 * @return La respuesta abierta asociada al item
	 */
	public OpenResponseDTO getOpenResponse() {
		return openResponse;
	}

	/**
	 * @param openResponse the openResponse to set
	 */
	public void setOpenResponse(OpenResponseDTO openResponse) {
		this.openResponse = openResponse;
	}
}