//=======================================================================
// ARCHIVO Behavior.java
// FECHA CREACIÓN: 26/07/2010
//=======================================================================
package co.zero.hcm.dto;

import co.zero.common.dto.EntityDTO;

/**
 * Clase que modela a un comportamiento asociado a una competencia.
 * Un comportamiento establece uno de los parámetros que permite evaluar
 * el nivel de desarrollo de una competencia por un empleado.
 * @author Hernán Tenjo
 * @version 1.0
 */
public class BehaviorDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	
	//Texto que permite describir de forma clara, uno de los comportemientos
	//que se pueden percibir en los empleados que requieren un nivel
	//de desarrollo mínimo de la competencia relacionada
	private String label;
	//Competencia a la que se encuentra asociado el comportamiento
	private CompetenceLevelDTO competenceLevel;
	
	/**
	 * Metodo que permite obtener el label descriptivo del comportemiento
	 * @return El texto configurado como label
	 */
	public String getLabel() {
		return label;
	}
	
	/**
	 * Metodo que permite modificar el texto descriptivo del comportamiento
	 * @param label El nuevo texto descriptivo que se desea asociar al 
	 * comportamiento
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	
	/**
	 * Metodo que permite obtener el nivel de la competencia asocida del comportamiento
	 * @return La competencia asociada al comportamiento
	 */
	public CompetenceLevelDTO getCompetenceLevel() {
		return competenceLevel;
	}
	
	/**
	 * Metodo que permite obtener el nivel de la competencia asocida del comportamiento
	 * @param competenceLevel La nueva competencia que se desea asociar
	 */
	public void setCompetenceLevel(CompetenceLevelDTO competenceLevel) {
		this.competenceLevel = competenceLevel;
	}
}