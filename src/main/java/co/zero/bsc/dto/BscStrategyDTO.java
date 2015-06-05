//=======================================================================
// ARCHIVO BscStrategyDTO.java
// FECHA CREACIÓN: 23/12/2010
//=======================================================================
package co.zero.bsc.dto;

import java.util.Date;

import co.zero.common.dto.EntityDTO;

/**
 * Clase que permite modelar las estrategias que serán implantadas por la
 * empresa como carta de navegación para lograr los objetivos propuestos
 * @author Hernán Tenjo
 * @version 1.0
 */
public class BscStrategyDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	
	//Nombre que representará a la estrategia
	private String name;
	//Breve descripción del propósito de la estrategia
	private String description;
	//Fecha de inicio de la estratégia
	private Date startDate;
	//Fecha de finalización de la estrategia
	private Date endDate;
	//Evaluación de desempeño a la que pertenece la estrategia
	private BscEvaluationDTO evaluation;
		
	/**
	 * Metodo que permite obtener la evaluation a la que pertenece la estrategia
	 * @return La evaluation configurada para la estrategia
	 */
	public BscEvaluationDTO getEvaluation() {
		return evaluation;
	}	

	/**
	 * Metodo que permite modificar la evaluation a la que pertenece la estrategia
	 * @param evaluation La nueva evaluation a la que pertenece la estrategia
	 */
	public void setEvaluation(BscEvaluationDTO evaluation) {
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
	 * Metodo que permite obtener la fecha de inicio para la vigencia de la estrategia 
	 * @return La fecha de inicio de la estrategia
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Metodo que permite modificar la fecha de inicio para la 
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Metodo que permite obtener la fecha de fin para la vigencia de la estrategia
	 * @return La fecha de fin de la estrategia
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Metodo que permite modificar la fecha de fin para la vigencia de la estrategia
	 * @param endDate La nueva fecha de fin de la estrategia
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.zero.common.dto.EntityDTO#toString()
	 */
	@Override
	public String toString() {
		long evaluationId = this.evaluation == null ? 0 : this.evaluation.getId();
		StringBuilder text = new StringBuilder(super.toString());
		text.append(" [name="+this.name+"]");
		text.append(" [description="+this.description+"]");
		text.append(" [startDate="+this.startDate+"]");
		text.append(" [endDate="+this.endDate+"]");
		text.append(" [evaluationId="+evaluationId+"]");
		return text.toString();
	}
}