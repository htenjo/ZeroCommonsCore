//=======================================================================
// ARCHIVO InnovationDTO.java
// FECHA CREACIÓN: 9/05/2011
//=======================================================================
package co.zero.evaluation.dto;

import co.zero.common.enumeration.evaluation.EvaluationType;

/**
 * Clase que representa a las evaluaciones de innovación
 * (Generalmente exclusivas de Katharsis), donde el proceso 
 * es muy similar al de evaluaciones 360°, con la diferencia 
 * de que los evaluadores seleccionan las personas a las que
 * desean evaluar
 * @author Hernán Tenjo
 * @version 1.0
 */
public class InnovationDTO extends ThreesixtyDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Ya que las relaciones en este tipo de evaluaciones son generadas
	//cuando el evaluador entra y selecciona las personas a evaluar
	//este atributo define la cantidad de relaciones requeridas 
	//para poder continuar con el proceso
	private int expectedRelations;

	/* (non-Javadoc)
	 * @see co.zero.core.model.evaluation.Evaluation#getDefaultType()
	 */
	@Override
	protected EvaluationType getDefaultType() {
		return EvaluationType.INNOVATION_360;
	}
	
	/**
	 * Metodo que permite obtener la cantidad de relaciones esperadas
	 * @return La cantidad de relaciones esperadas en la evaluación
	 */
	public int getExpectedRelations() {
		return expectedRelations;
	}

	/**
	 * Metodo que permite modificar la cantidad de relaciones esperadas
	 * @param expectedRelations La nueva cantidad de relaciones esperadas
	 */
	public void setExpectedRelations(int expectedRelations) {
		this.expectedRelations = expectedRelations;
	}
}