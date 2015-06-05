//=======================================================================
// ARCHIVO IndividualDevelopmentPlanDTO.java
// FECHA CREACIÓN: 28/09/2010
//=======================================================================
package co.zero.goals.dto.development;

import java.util.HashSet;
import java.util.Set;

import co.zero.common.dto.EntityDTO;
import co.zero.hcm.dto.CompanyDTO;

/**
 * Clase que modela un Plan de Desarrollo Individual. El PDI únicamente
 * pretende mantener agrupados diferentes {@link TrainingPlanDTO} que serán 
 * considerados como las entradas para los diferentes análisis
 * @author Hernán Tenjo
 * @version 1.0
 */
public class IndividualDevelopmentPlanDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Nombre que identificará al plan de desarrollo
	private String name;
	//Plan de entrenamiento al que apoyara la estrategia
	private Set<TrainingPlanDTO> trainingPlans = new HashSet<TrainingPlanDTO>();
	//Compañía a la que pertenece el plan de desarrollo individual
	private CompanyDTO company;
	
	/**
	 * Metodo que permite obtener la compañía a la que pertenece el plan 
	 * @return La compañía a la que pertenece el plan
	 */
	public CompanyDTO getCompany() {
		return company;
	}

	/**
	 * Metodo que permite modificar la compañía a la que pertenece el plan
	 * @param company La nueva compañía a asociar
	 */
	public void setCompany(CompanyDTO company) {
		this.company = company;
	}
	
	/**
	 * Metodo que permite agregar un plan de entrenamiento al 
	 * plan de desarrollo individual
	 * @param entity Entidad que se desea agregar
	 */
	public void addTrainingPlan(TrainingPlanDTO entity){
		if(trainingPlans == null){
			trainingPlans = new HashSet<TrainingPlanDTO>();
		}
		
		trainingPlans.add(entity);
	}
	
	/**
	 * Metodo que permite obtener los {@link TrainingPlan} relacionados
	 * que servirán de entrada para el plan de desarrollo individual
	 * @return Los planes configurados como entradas
	 */
	public Set<TrainingPlanDTO> getTrainingPlans() {
		return trainingPlans;
	}

	/**
	 * Metodo que permite modificar los {@link TrainingPlan} relacionados
	 * @param trainingPlans Lista con los planes asociados
	 */
	public void setTrainingPlans(Set<TrainingPlanDTO> trainingPlans) {
		this.trainingPlans = trainingPlans;
	}

	/**
	 * Metodo que permite obtener el nombre del plan de desarrollo
	 * @return El nombre del plan de desarrollo 
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}