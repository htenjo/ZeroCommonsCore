//=======================================================================
// ARCHIVO QuestionDTO.java
// FECHA CREACIÓN: 9/05/2011
//=======================================================================
package co.zero.evaluation.dto;

import org.apache.commons.lang.StringUtils;

import co.zero.common.dto.EntityDTO;

/**
 * Clase que representa a una de las preguntas con la mínima info
 * que conforman el cuestionario de la evaluación
 * @author Hernán Tenjo
 * @version 1.0
 */
public class QuestionDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Texto principal usado en una pregunta
	private String firstLabel;
	//Texto secundario de la pregunta, útil p.e en las preguntas de 3-0
	private String secondLabel;
	//Tipo de la pregunta que se desea (Seleccion multiple, abierta, etc)
	private QuestionTypeDTO type;
	//El elemento calificable que se desea evaluar con la pregunta
	private QualificationDTO qualification;
	//Determina si se deben mostrar los tags de las opciones de respuesta en vez
	//de utilizar una numeración automática
	private boolean tagged;
	//Determina si la pregunta pertenece al cuestionario sociodemográfico y no
	//al cuestionario principal de la evaluación
	private boolean social;
	//Texto alternativo a la numeración automática
	private String tag;
	//Determina si esta pregunta corresponde a una pregunta anidada de una pregunta dinámica
	private boolean dynamic; 
	//Número que permite ordenar de forma arbitraria la aparición de las preguntas en el cuestionario
	private int priority;
	//Atributo provisional para la generación de unos reportes específicos x nivel
	//Esto en un futuro podría pasar a ser una entidad completa
	private int level;
	//En caso de tener preguntas dependientes, esto representa al padre de la pregunta
	private QuestionDTO parent;
	//En ocasiones las preguntas requieren un encabezado que describan la pregunya
	private String header;
	
	/**
	 * Método que permite obtener el primer label asociado a la pregunta
	 * @return El texto del primer label asociado a la pregunta
	 */
	public String getFirstLabel() {
		return firstLabel;
	}

	/**
	 * Método que permite modificar el primer label asociado a la pregunta
	 * @param firstLabel El nuevo texto que será asociado como principal de la pregunta
	 */
	public void setFirstLabel(String firstLabel) {
		this.firstLabel = firstLabel;
	}

	/**
	 * Método que permite obtener el segundo label asociado a las pregunta
	 * @return El texto del segundo label asociado a la pregunta
	 */
	public String getSecondLabel() {
		return secondLabel;
	}

	/**
	 * Método que permite modificar el segundo label asociado a la pregunta
	 * @param secondLabel El nuevo texto que será asociado a la pregunta
	 */
	public void setSecondLabel(String secondLabel) {
		this.secondLabel = secondLabel;
	}

	/**
	 * Método que permite obtener el tipo de la pregunta
	 * @return El tipo de la pregunta configurado
	 */
	public QuestionTypeDTO getType() {
		return type;
	}

	/**
	 * Método que permite modificar el tipo de la pregunta
	 * @param type the type to set
	 */
	public void setType(QuestionTypeDTO type) {
		this.type = type;
	}
	
	/**
	 * Método que permite obtener el elemento calificable al 
	 * que se desea evaluar con la pregunta
	 * @return El elemento calificable configurado para la pregunta
	 */
	public QualificationDTO getQualification() {
		return qualification;
	}

	/**
	 * Método que permite modificar el elemento calificable al 
	 * que se desea evaluar con la pregunta
	 * @param qualification El nuevo elemento calificable
	 */
	public void setQualification(QualificationDTO qualification) {
		this.qualification = qualification;
	}
	
	/**
	 * Método que permite obtener el tag asociado a la opción de respuesta
	 * @return El tag configurado para la opción de respuesta
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * Método que permite modificar el tag asociado a la opción de respuesta
	 * @param tag EL nuevo texto que servirá de tag para la opción de respuesta
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	/**
	 * Metodo que permite determinar si las opciones de respuestas asociadas serán
	 * autonumeradas o si tendrán un label que podría ser mostrado en su lugar
	 * @return True si se mostrará el tag de las opciones de respuesta, False si se
	 * desea mostrar una lista autonumerada
	 */
	public boolean isTagged(){
		return tagged;
	}

	/**
	 * Método que permite modificar el hecho de mostrar los tags de las opciones de 
	 * respuesta o una lista autonumerada
	 * @param tagged True si se desean mostrar los tags de las opciones de respuestas
	 * False de lo contrario 
	 */
	public void setTagged(boolean tagged){
		this.tagged = tagged;
	}

	/**
	 * Método que permite determinar si la pregunta es de tipo sociodemográfico
	 * @return True si la pregunta pertenece al cuestionario sociodemográfico, 
	 * false de lo contrario
	 */
	public boolean isSocial() {
		return social;
	}

	/**
	 * Método que permite modificar es estado social de la pregunta
	 * @param social True si se desea que la pregunta pertenezca al cuestionario
	 * sociodemográfico, false de lo contrario
	 */
	public void setSocial(boolean social) {
		this.social = social;
	}

	/**
	 * Método que permite determinar si la pregunta es una subpregunta de una pregunta dinámica
	 * @return True si la pregunta es dinámica, False de lo contrario
	 */
	public boolean isDynamic() {
		return dynamic;
	}

	/**
	 * Método que permite modificar si la pregunta es una subpregunta de una pregunta dinámica
	 * @param dynamic True si se desea que la pregunta sea de carácter dinámico, false de lo contrario.
	 */
	public void setDynamic(boolean dynamic) {
		this.dynamic = dynamic;
	}
	
	/**
	 * Método que permite obtener la prioridad de la pregunta en el cuestionario
	 * @return El número que identifica la prioridad del cuestionario
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * Método que permite modificar la prioridad de la pregunta en el cuestionario
	 * @param priority La nueva prioridad de la pregunta en el cuestionario
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * Método que permite obtener el nivel de la pregunta
	 * @return El nivel asociado a la pregunta
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Método que permite modificar el nivel de la pregunta
	 * @param level El nuevo nivel de la pregunta
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	

	/**
	 * Método que obtiene el padre de la pregunta dependiente
	 * @return La pregunta padre si existe, null de lo contrario
	 */
	public QuestionDTO getParent() {
		return parent;
	}

	/**
	 * Método que modifica el padre de la pregunta dependiente
	 * @param parent La nueva pregunta padre de la pregunta dependiente
	 */
	public void setParent(QuestionDTO parent) {
		this.parent = parent;
	}
	


	/**
	 * Método que obtiene el encabezado de la pregunta
	 * @return Texto con el encabezado de la pregunta
	 */
	public String getHeader() {
		return header;
	}

	/**
	 * Método que modifica el encabezado de la pregunta
	 * @param header Texto con el nuevo encabezado de la pregunta
	 */
	public void setHeader(String header) {
		this.header = header;
	}
	
	public boolean isWithHeader(){
		return !StringUtils.isEmpty(header);
	}
}