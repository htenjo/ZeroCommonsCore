package co.zero.kpi.dto;

import co.zero.hcm.dto.CompanyDTO;

/**
 * Clase que define una relacion entre una compania y un objetivo
 * 
 * @author Youlyn Chinome
 */
public class KpiGoalRelationCompanyDTO extends KpiGoalRelationDTO{
	//Identificador requerido para la serialización
	private static final long serialVersionUID = 1L;
	//Compania que esta asignada al objetivo
	private CompanyDTO company;
	
	/**
	 * Metodo que permite obtener la compania que esta asignada al objetivo
	 * @return La compania que esta asignada al objetivo
	 */
	public CompanyDTO getCompany() {
		return company;
	}

	/**
	 * Metodo que permite modificar la compania que esta asignada al objetivo
	 * @param company La compania que esta asignada al objetivo
	 */
	public void setCompany(CompanyDTO company){
		this.company = company;
	}
	
	/*
	 * (non-Javadoc)
	 * @see co.zero.common.dto.EntityDTO#toString()
	 */
	@Override
	public String toString() {
		StringBuilder text = new StringBuilder(super.toString());
		long companyId = this.company == null ? 0 : this.company.getId();
		long goalId = this.goal == null ? 0 : this.goal.getId();
		text.append(" [company="+companyId+"]");
		text.append(" [goal="+goalId+"]");
		text.append(" [contributeWeight="+this.contributeWeight+"]");
		return text.toString();
	}
}