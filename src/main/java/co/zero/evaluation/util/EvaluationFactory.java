//=======================================================================
// ARCHIVO EvaluationFactory.java
// FECHA CREACIÓN: 12/05/2011
//=======================================================================
package co.zero.evaluation.util;

import co.zero.common.enumeration.evaluation.EvaluationType;
import co.zero.evaluation.dto.ClimateDTO;
import co.zero.evaluation.dto.Evaluation2646DTO;
import co.zero.evaluation.dto.EvaluationDTO;
import co.zero.evaluation.dto.InnovationDTO;
import co.zero.evaluation.dto.InnovationOrganizationDTO;
import co.zero.evaluation.dto.ThreesixtyDTO;

/**
 * Clase que permite centralizar la lógica para la creación de la Evaluaciones 
 * @author Hernán Tenjo
 * @version 1.0
 */
public class EvaluationFactory {
	/**
	 * Metodo que permite construir una evaluación con base en el 
	 * tipo de la evaluación
	 * @param type Tipo de la evaluación que se desea crear
	 * @return Instancia de la evaluación creada si el tipo de evaluación
	 * existe, Null en caso contrario
	 */
	public static EvaluationDTO buildEvaluation(EvaluationType type){
		switch (type) {
		case CLIMATE:
			return new ClimateDTO();
		case INNOVATION_360:
			return new InnovationDTO();
		case INNOVATION_ORGANIZATION:
			return new InnovationOrganizationDTO();
		case THREESIXTY:
			return new ThreesixtyDTO();
		case EVALUATION_2646:
			return new Evaluation2646DTO();
		default:
			return null;
		}
	}
}