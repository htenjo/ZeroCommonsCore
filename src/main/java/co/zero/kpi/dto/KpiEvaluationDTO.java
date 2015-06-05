//=======================================================================
// ARCHIVO BscEvaluationDTO.java
// FECHA CREACIÓN: 22/03/2011
//=======================================================================
package co.zero.kpi.dto;

import java.util.Date;

import co.zero.common.dto.EntityDTO;
import co.zero.hcm.dto.CompanyDTO;

/**
 * Clase que define una Evaluación de KPIs, la cual agrupará las Métricas y Estrategias
 * que se diseñaron en la empresa para lograr los objetivos del BSC.
 * @author Hernán Tenjo
 * @version 1.0
 */
public class KpiEvaluationDTO extends EntityDTO{
	//Identificador requerido para la serialización
	private static final long serialVersionUID = 1L;
	//Nombre representativo de la evaluación de desempeño
	private String name;
	//Breve descripción del objetivo de la evaluación de desempeño
	private String description;
	//Fecha de inicio de la evaluación de desempeño
	private Date startDate;
	//Fecha de finalización de la evaluación de desempeño
	private Date endDate;
	//Compañía a la que pertenece la evaluación
	private CompanyDTO company;
	
	/**
	 * Metodo que permite obtener el nombre de la evaluación de desempeño
	 * @return El nombre configurado para la evaluación
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metodo que permite modificar el nombre de la evaluación de desempeño
	 * @param name El nuevo nombre de la evaluación
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Método que permite obtener la descripción de la evaluación de desempeño
	 * @return La descripción configurada para la evaluación
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Metodo que permite modificar la descripción de la evaluación de desempeño
	 * @param description La nueva descripción de la evaluación
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Método que permite obtener la fecha de inicio de la evaluación
	 * @return La fecha de inicio configurada para la evaluación
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Metodo que permite modificar la fecha de inicio de la evaluación
	 * @param startDate La nueva fecha de inicio de la evaluación
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Método que permite obtener la fecha de finalización de la evaluación
	 * @return La fecha de fin configurada para la evaluación
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Método que permite modificar la fecha de finalización de la evaluación
	 * @param endDate La nueva fecha de finalización para la evaluación 
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	/**
	 * Método que permite obtener la compañía dueña de la evaluación
	 * @return La compañía a la que pertenece la evaluación
	 */
	public CompanyDTO getCompany() {
		return company;
	}

	/**
	 * Metodo que permite modificar la compañía dueña de la evaluación
	 * @param company La compañía dueña de la relación
	 */
	public void setCompany(CompanyDTO company) {
		this.company = company;
	}
	
	/*
	 * (non-Javadoc)
	 * @see co.zero.common.dto.EntityDTO#toString()
	 */
	@Override
	public String toString() {
		long companyId = this.company == null ? 0 : this.company.getId();
		StringBuilder text = new StringBuilder(super.toString());
		text.append(" [name="+this.name+"]");
		text.append(" [description="+this.description+"]");
		text.append(" [startDate="+this.startDate+"]");
		text.append(" [endDate="+this.endDate+"]");
		text.append(" [companyId="+companyId+"]");
		return text.toString();
	}
}