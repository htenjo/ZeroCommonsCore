//=======================================================================
// ARCHIVO QuestionTypeDTO.java
// FECHA CREACIÓN: 10/05/2011
//=======================================================================
package co.zero.evaluation.dto;

import java.util.ArrayList;
import java.util.List;

import co.zero.common.dto.EntityDTO;
import co.zero.common.enumeration.evaluation.EvaluationComponentType;
import co.zero.common.enumeration.evaluation.QuestionSizeType;
import co.zero.common.enumeration.evaluation.ResponseType;

/**
 * Clase que representa a un tipo de pregunta que se puede tener en 
 * el sistema de evaluaciones
 * @author Hernán Tenjo
 * @version 1.0
 */
public class QuestionTypeDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Texto que identifica al tipo de pregunta en el sistema
	private String label;
	//Evaluación para la que se configura el tipo de pregunta
	private EvaluationDTO evaluation;
	//Tipo de respuesta asociado al tipo de pregunta
	private ResponseType responseType;
	//Determina si el tipo de pregunta representa una respuesta dinámica 
	//(p.e. Ingrese la info de las personas dependientes)
	private boolean dynamic;
	//Determina si el tipo de pregunta tiene asocidas preguntas condicionalmente dependientes
	private boolean conditional;
	//Determina si la pregunta puede presentar feedBack por parte del evaluador
	private boolean feedBack;
	//Texto introductorio para la retroalimentación
	private String feedBackMsg;
	//Establece la cantidad mínima de selecciones a realizar en una pregunta
	//de selección múltiple con múltiple respuesta
	private int minSelection;
	//Establece la cantidad máxima de selecciones a realizar en una pregunta 
	//de selección múltiple con múltiple respuesta
	private int maxSelection;
	//Determina si la pregunta debe ser respondida de forma obligatoria
	private boolean required;
	//Determina si las opciones de respuesta serán mostradas vertical u horizontalmente
	//Por el momento determinar si las opciones de respuesta se muestran en frente de la pregunta
	//o debajo, como en el caso de las preguntas ICFES. Esto posteriormente se podría dejar en una 
	//variable independiente 'inline' que determine esto, para que esta variable defina si en la linea
	//que se mostrarán las opciones estas se muestran vertical y horizontalmente
	private boolean vertialDirection = true;
	//Tipo del componente que va a representar las opciones de respuesta
	private EvaluationComponentType component;
	//Tamaño de presentación del texto de la pregunta
	private QuestionSizeType questionSize;
	//Lista con las opciones de respuesta asociadas a la entidad
	private List<ResponseOptionDTO> options = new ArrayList<ResponseOptionDTO>();
	//Colección de Tipos de preguntas hijas para los tipos de preguntas dinámicas
	private List<QuestionDTO> dynamicQuestions;
	
	/**
	 * Método que permite agregar una pregunta que relaciona a una opción de respuesta dinámica
	 * @param question Pregunta que se desea asociar al tipo de respuesta
	 */
	public void addDynamicQuestions(QuestionDTO question){
		if(dynamicQuestions == null){
			dynamicQuestions = new ArrayList<QuestionDTO>();
		}
		
		dynamicQuestions.add(question);
	}
	
	/**
	 * Método que permite obtener el label que identifica al {@link QuestionTypeDTO} en el sistema
	 * @return El texto que se ha configurado como identificador del {@link QuestionTypeDTO}
	 */
	public String getLabel(){
		return label;
	}

	/**
	 * Método que permite modificar el label del {@link QuestionTypeDTO}
	 * @param label El nuevo texto que identificará al tipo de pregunta
	 */
	public void setLabel(String label){
		this.label = label;
	}

	/**
	 * Metodo que permite obtener la evaluación a la que pertenece el {@link QuestionTypeDTO}
	 * @return La evaluación configurada para el tipo de pregunta
	 */
	public EvaluationDTO getEvaluation(){
		return evaluation;
	}

	/**
	 * Método que permite modificar la evaluación a la que pertenece el {@link QuestionTypeDTO}
	 * @param evaluation La nueva evaluación a la que pertenecerá la entidad
	 */
	public void setEvaluation(EvaluationDTO evaluation){
		this.evaluation = evaluation;
	}

	/**
	 * Método que permite obtener el tipo de respuesta esperado para la pregunta
	 * @return El tipo de respuesta configurada
	 */
	public ResponseType getResponseType(){
		return responseType;
	}

	/**
	 * Método que permite modificar el tipo de respuesta esperado para la respuesta
	 * @param responseType El nuevo tipo de respuesta esperado
	 */
	public void setResponseType(ResponseType responseType){
		this.responseType = responseType;
	}

	/**
	 * Método que permite determinar si la la pregunta asociada podrá
	 * disponer de feedBack por parte del evaluador
	 * @return True si la pregunta asociada tendrá disponible la posibilidad 
	 * de registrar feedBack, False de lo contrario
	 */
	public boolean isFeedBack(){
		return feedBack;
	}

	/**
	 * Método que permite modificar la gestion del feedBack para la pregunta asociada
	 * @param feedBack True si se desea gestionar feedBack por parte del evaluador 
	 * en la pregunta asociada, False de lo contrario
	 */
	public void setFeedBack(boolean feedBack){
		this.feedBack = feedBack;
	}

	/**
	 * Método que permite obtener la cantidad de respuestas mínimas esperadas 
	 * @return La cantidad mínima de opciones de respuesta seleccionables
	 */
	public int getMinSelection(){
		return minSelection;
	}

	/**
	 * Método que permite modificar la cantidad de respuestas mínimas esperadas
	 * @param minSelection La nueva cantidad mínima de opciones de respuesta seleccionables
	 */
	public void setMinSelection(int minSelection){
		this.minSelection = minSelection;
	}

	/**
	 * Método que permite obtener la cantidad de respuestas máximas esperadas 
	 * @return La cantidad máxima de opciones de respuesta seleccionables
	 */
	public int getMaxSelection(){
		return maxSelection;
	}

	/**
	 * Método que permite modificar la cantidad de respuestas máximas esperadas
	 * @param maxSelection La nueva cantidad máxima de opciones de respuesta seleccionables
	 */
	public void setMaxSelection(int maxSelection){
		this.maxSelection = maxSelection;
	}

	/**
	 * Método que permite determinar si la pregunta asociada será requerida o no
	 * @return True si la pregunta será requerida, False de lo contrario
	 */
	public boolean isRequired(){
		return required;
	}

	/**
	 * Metodo que permite cambiar el estado de requerido para la pregunta asociada
	 * @param required True si se desea que la pregunta sea requerida, False de lo contrario.
	 * NOTA: Una pregunta NO requerida, que NO sea contestada no será registrada como
	 * una posible respuesta.
	 */
	public void setRequired(boolean required){
		this.required = required;
	}

	/**
	 * Método que permite agregar un {@link ResponseOptionDTO} al {@link QuestionTypeDTO}
	 * @param responseOption Objeto con la información del {@link ResponseOptionDTO}
	 */
	public void addResponseOption(ResponseOptionDTO responseOption){
		if(options == null){
			options = new ArrayList<ResponseOptionDTO>();
		}
		
		responseOption.setQuestionType(this);
		options.add(responseOption);		
	}
	
	/**
	 * Metodo que permite obtener los {@link ResponseOptionDTO} asociados a la entidad
	 * @return Lista con los {@link ResponseOptionDTO} configurados para la entidad
	 */
	public List<ResponseOptionDTO> getOptions() {
		return options;
	}

	/**
	 * Método que permite modificar los {@link ResponseOptionDTO} asociados a la entidad
	 * @param options Lista con los nuevos {@link ResponseOptionDTO} de la entidad
	 */
	public void setOptions(List<ResponseOptionDTO> options) {
		this.options = options;
	}
	
	/**
	 * Método que permite buscar una opcion de respuesta por su id
	 * @param responseOptionId Identificador de la opcion de respuesta
	 * @return El DTO con la información de la opción de respuesta si existe,
	 * NULL de lo contrario
	 */
	public ResponseOptionDTO getOptionbyId(long responseOptionId){
		ResponseOptionDTO optionAux = null;
		
		if(options != null){
			for(ResponseOptionDTO option : options){
				if(option.getId() == responseOptionId){
					optionAux = option;
					break;
				}
			}
		}
		
		return optionAux;
	}
	
	/**
	 * Método que permite obtener la etiqueta para el componente de feedback
	 * @return EL mensaje configurado para el feedBack
	 */
	public String getFeedBackMsg() {
		return feedBackMsg;
	}

	/**
	 * Método que permite modificar la etiqueta para el componente de feedBack
	 * @param feedBackMsg El nuevo mensaje que será mostrado como invitación 
	 * para dar feedBack
	 */
	public void setFeedBackMsg(String feedBackMsg) {
		this.feedBackMsg = feedBackMsg;
	}
	
	/**
	 * @return the vertialDirection
	 */
	public boolean isVertialDirection() {
		return vertialDirection;
	}

	/**
	 * @param vertialDirection the vertialDirection to set
	 */
	public void setVertialDirection(boolean vertialDirection) {
		this.vertialDirection = vertialDirection;
	}

	/**
	 * @return the component
	 */
	public EvaluationComponentType getComponent() {
		return component;
	}

	/**
	 * @param component the component to set
	 */
	public void setComponent(EvaluationComponentType component) {
		this.component = component;
	}

	/**
	 * @return the questionSize
	 */
	public QuestionSizeType getQuestionSize() {
		return questionSize;
	}

	/**
	 * @param questionSize the questionSize to set
	 */
	public void setQuestionSize(QuestionSizeType questionSize) {
		this.questionSize = questionSize;
	}

	/**
	 * Método que determina si el tipo de pregunta representa a una respuesta dinámica
	 * @return True si se requiere una respuesta dinámica, False de lo contrario
	 */
	public boolean isDynamic() {
		return dynamic;
	}

	/**
	 * Método que permite modificar el estado dinámico del tipo de pregunta
	 * @param dynamic True si se espera una respuesta dinámica, false de lo contrarioxs
	 */
	public void setDynamic(boolean dynamic) {
		this.dynamic = dynamic;
		
		if(dynamic){
			this.conditional = false;
		}
	}
	
	/**
	 * Método que permite obtener las preguntas dinamicas asociadas, cuando el tipo de
	 * pregunta requiere una respuesta dinámica
	 * @return Las preguntas asociadas al {@link QuestionTypeDTO} dinámico
	 */
	public List<QuestionDTO> getDynamicQuestions() {
		return dynamicQuestions;
	}

	/**
	 * Método que permite modificar las preguntas dinámicas asociadas
	 * @param dynamicQuestions Las nuevas preguntas que serán asociadas
	 */
	public void setDynamicQuestions(List<QuestionDTO> dynamicQuestions) {
		this.dynamicQuestions = dynamicQuestions;
	}

	
	/**
	 * Método que determina si el tipo de pregunta contiene preguntas condicionalmente dependientes
	 * @return True si el tipo de pregunta tiene preguntas condicionalmente dependientes,
	 * false de lo contrario
	 */
	public boolean isConditional() {
		return conditional;
	}

	/**
	 * Método que modifica la capacidad del tipo de pregunta de tener preguntas dependientes
	 * @param conditional True si se desea que el tipo de pregunta pueda tener preguntas
	 * condicionalmente dependientes, false de lo contrario
	 */
	public void setConditional(boolean conditional) {
		this.conditional = conditional;
		
		if(conditional){
			this.dynamic = false;
		}
	}

	/**
	 * Metodo que permite crear una entidad igual a esta
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}