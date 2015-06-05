//=======================================================================
// ARCHIVO InnovationOrganizationDTO.java
// FECHA CREACIÓN: 9/05/2011
//=======================================================================
package co.zero.evaluation.dto;

import co.zero.common.enumeration.evaluation.EvaluationType;

/**
 * Clase que representa a las evaluaciones de tipo 2646
 * (Posiblemente requeridas por SURA por ley)
 * @author Hernán Tenjo
 * @version 1.0
 */
public class Evaluation2646DTO extends ClimateDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	
	/* (non-Javadoc)
	 * @see co.zero.core.model.evaluation.Evaluation#getDefaultType()
	 */
	@Override
	protected EvaluationType getDefaultType() {
		return EvaluationType.EVALUATION_2646;
	}
}