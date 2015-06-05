/**
 * 
 */
package co.zero.common.enumeration.evaluation;

/**
 * Enumeración que reune los componentes de presentación soportados por las
 * evaluaciones de Hcm
 * 
 * @author hernan
 */
public enum EvaluationComponentType {
	//Componentes que permiten ingresar texto
	INPUT_TEXT,
	INPUT_TEXT_AREA,
	INPUT_CALENDAR,
	INPUT_NUMERIC_TEXT,
	INPUT_NUMERIC_SPINNER,
	INPUT_EMAIL,
	
	//Componentes de seleccion
	SELECT_ONE_CHECKBOX,
	SELECT_MANY_CHECKBOX,
	SELECT_ONE_RADIO,
	SELECT_ONE_LISTBOX,
	SELECT_MANY_LISTBOX,
	SELECT_ONE_MENU,
	SELECT_MANY_MENU,
	
	//Componente requerido para las respuestas dinámicas
	DYNAMIC_TABLE;

	/**
	 * Retorna el arreglo de componentes que puede tener un tipo de pregunta
	 * segun su tipo de respuesta
	 * 
	 * @param responseType
	 * @return
	 */
	public static EvaluationComponentType[] componentsByResponseType(ResponseType responseType) {
		EvaluationComponentType[] components = null;
		
		switch (responseType) {
		case MULTIPLE_CHOICE_SINGLE_RESPONSE:
			components = new EvaluationComponentType[] { SELECT_ONE_RADIO,
					SELECT_ONE_LISTBOX, SELECT_ONE_MENU };
			break;
		case MULTIPLE_CHOICE_MULTIPLE_RESPONSE:
			components = new EvaluationComponentType[] { SELECT_MANY_CHECKBOX,
					SELECT_MANY_LISTBOX, SELECT_MANY_MENU };
			break;
		case OPEN_TEXT_RESPONSE:
			components = new EvaluationComponentType[] { INPUT_TEXT,
					INPUT_TEXT_AREA, INPUT_CALENDAR, INPUT_NUMERIC_TEXT,
					INPUT_NUMERIC_SPINNER, INPUT_EMAIL };
			break;
		case DYNAMIC_RESPONSE:
			components = new EvaluationComponentType[] { DYNAMIC_TABLE };
			break;
		default:
			break;
		}
			
		return components;
	}
}
