//=======================================================================
// ARCHIVO EmployeeRelation.java
// FECHA CREACIÓN: Sep 18, 2009
//=======================================================================
package co.zero.hcm.dto;

import co.zero.common.dto.EntityDTO;

/**
 * Bean que contiene los atributos requeridos en la vista 
 * de un {@link PeopleRelationDTO} 
 * @author Hernán Tenjo
 * @version 1.0
 */
public class PeopleRelationDTO extends EntityDTO{	
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;	
	//Personas de la relación. 
	//Ej. employeeOwnerRelation es 'RELATION_TYPE' de employeeDependantRelation
	//Empleado que inicia la relación
	private PersonDTO personOwnerRelation;
	//Empleado que finaliza la relacion
	private PersonDTO personDependentRelation;
	//Identificador de la relación que mantienen los empleados
	private CompanyRelationDTO relation;
	
	/**
	 * Permite obtener la persona dueña de la relación
	 * @return La person dueña de la relación
	 */
	public PersonDTO getPersonOwnerRelation() {
		return personOwnerRelation;
	}
	
	/**
	 * Permite modificar la persona dueña de la relación
	 * @param personOwnerRelation La nueva persona dueña de la relación
	 */
	public void setPersonOwnerRelation(PersonDTO personOwnerRelation) {
		this.personOwnerRelation = personOwnerRelation;
	}
	
	/**
	 * Permite obtener la persona dependiente de la relación
	 * @return La person dependiente de la relación
	 */
	public PersonDTO getPersonDependentRelation() {
		return personDependentRelation;
	}
	
	/**
	 * Permite modificar la persona dependiente de la relacion
	 * @param personDependentRelation La nueva persona dependiente de la relacion
	 */
	public void setPersonDependentRelation(PersonDTO personDependentRelation) {
		this.personDependentRelation = personDependentRelation;
	}
	
	/**
	 * Permite obtener la relacion establecida entre las dos personas
	 * @return La relacion solicitada
	 */
	public CompanyRelationDTO getRelation() {
		return relation;
	}
	
	/**
	 * Permite modificar la relacion establecida entra las dos personas
	 * @param relation La nueva relacion a establecer entre las dos personas
	 */
	public void setRelation(CompanyRelationDTO relation) {
		this.relation = relation;
	}
}

