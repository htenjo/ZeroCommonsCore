//=======================================================================
// ARCHIVO Strategy.java
// FECHA CREACIÓN: 26/07/2010
//=======================================================================
package co.zero.goals.dto.development;

import co.zero.common.dto.EntityDTO;

/**
 * Clase que modela a una estrategia ideada para cerrar las breachas
 * detectadas en una competencia especifica.
 * @author Hernán Tenjo
 * @version 1.0
 */
public class StrategyDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	
	//Nombre que identificará a la estrategia de capacitación
	private String name;
	//Breve descripción de lo que busca la estrategia
	private String description;
	//Plan de entrenamiento al que apoyara la estrategia
	private TrainingPlanDTO trainingPlan;
	//Nombre de los campos que se podrán ignorar en un versión basica para JSON del DTO
	private static final String[] complexFieldsToIgnoreInJSON = new String[]{"createdDate", "lastUpdatedDate", 
		"complexFieldsToIgnoreInJSON", "trainingPlan"};
	
	/**
	 * Metodo que permite obtener el nombre de la estrategia
	 * @return El nombre de la estrategia
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Metodo que permite modificar el nombre asignado a la estrategia
	 * @param name El nuevo nombre que se desea para la estrategia
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Metodo que permite obtener la descripcion de la estrategia
	 * @return La descripcion asignada a la estrategia
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Metodo que permite modificar la descripcion asignada a la estrategia
	 * @param description La nueva descripcion que se desea asignar
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Metodo que permite obtener el plan al que apoya la estrategia
	 * @return El plan al que apoya la estrategia
	 */
	public TrainingPlanDTO getTrainingPlan() {
		return trainingPlan;
	}

	/**
	 * Metodo que permite modificar el plan al que apoya la estrategia
	 * @param trainingPlan El nuevo plan al que apoyará la estrategia
	 */
	public void setTrainingPlan(TrainingPlanDTO trainingPlan) {
		this.trainingPlan = trainingPlan;
	}

	/**
	 * Método que obtiene la lista de campos que no se tendrán en cuenta
	 * cuando se haga un parse básico del DTO con JSON
	 * @return
	 */
	public static String[] getComplexFieldsToIgnoreInJSON(){
		return complexFieldsToIgnoreInJSON;
	}
}