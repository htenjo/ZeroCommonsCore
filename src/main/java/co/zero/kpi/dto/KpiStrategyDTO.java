//=======================================================================
// ARCHIVO BscStrategyDTO.java
// FECHA CREACIÓN: 23/12/2010
//=======================================================================
package co.zero.kpi.dto;

import co.zero.common.dto.EntityDTO;

/**
 * Clase que permite modelar las estrategias que serán implantadas por la
 * empresa como carta de navegación para lograr los objetivos propuestos
 * @author Hernán Tenjo
 * @version 1.0
 */
public class KpiStrategyDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	
	//Nombre que representará a la estrategia
	private String name;
	//Breve descripción del propósito de la estrategia
	private String description;
	//Ponderación de la colaboración de esta estrategia sobre la evaluación
	private double contributeWeight;
	//Evaluación de desempeño a la que pertenece la estrategia
	private KpiEvaluationDTO evaluation;
		
	/**
	 * Metodo que permite obtener la evaluation a la que pertenece la estrategia
	 * @return La evaluation configurada para la estrategia
	 */
	public KpiEvaluationDTO getEvaluation() {
		return evaluation;
	}	

	/**
	 * Metodo que permite modificar la evaluation a la que pertenece la estrategia
	 * @param evaluation La nueva evaluation a la que pertenece la estrategia
	 */
	public void setEvaluation(KpiEvaluationDTO evaluation) {
		this.evaluation = evaluation;
	}

	/**
	 * Metodo que permite obtener el nombre de la estrategia
	 * @return El nombre de la estrategia
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metodo que permite modificar el nombre de la estrategia
	 * @param name El nuevo nombre de la estrategia
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Metodo que permite obtener la descripcion de la estrategia
	 * @return La descripcion configurada de la estrategia
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Metodo que permite modificar la descripcion de la estrategia
	 * @param description La nueva descripcion de la estrategia
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Método que obtiene el porcentaje de contribución a la evaluación
	 * @return Valor de aporte a la evaluación
	 */
	public double getContributeWeight() {
		return contributeWeight;
	}

	/**
	 * Método que modifica el porcentaje de contribución a la evaluación
	 * @param contributeWeight Nuevo porcentaje de contribución de la estrategia
	 */
	public void setContributeWeight(double contributeWeight) {
		this.contributeWeight = contributeWeight;
	}

	/*
	 * (non-Javadoc)
	 * @see co.zero.common.dto.EntityDTO#toString()
	 */
	@Override
	public String toString() {
		long evaluationId = this.evaluation == null ? 0 : this.evaluation.getId();
		StringBuilder text = new StringBuilder(super.toString());
		text.append(" [name="); text.append(this.name); text.append("]");
		text.append(" [description="); text.append(this.name); text.append("]");
		text.append(" [%Contribute=");text.append(this.contributeWeight); text.append("]");
		text.append(" [evaluationId=");text.append(evaluationId); text.append("]");
		return text.toString();
	}
}