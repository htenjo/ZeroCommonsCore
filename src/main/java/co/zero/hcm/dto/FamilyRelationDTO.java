package co.zero.hcm.dto;

import co.zero.common.dto.EntityDTO;
import co.zero.common.enumeration.RelativeType;

/**
 * Bean que contiene los atributos requeridos en la vista 
 * de un {@link FamilyRelationDTO} 
 * @author Andres
 *
 */

public class FamilyRelationDTO extends EntityDTO{

	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	
	private EmployeeDTO employeeDTO;
	private RelativeDTO relativeDTO;
	private RelativeType relation;
	
	/**
	 * Obtiene el empleado al que esta asociado el familiar
	 * @return el empleado al que esta asociado el familiar
	 */
	public EmployeeDTO getEmployeeDTO() {
		return employeeDTO;
	}
	/**
	 * Modifica el empleado al que esta asociado el familiar
	 * @param employeeDTO el nuevo empleado al que hay que asociar un familiar
	 */
	public void setEmployeeDTO(EmployeeDTO employeeDTO) {
		this.employeeDTO = employeeDTO;
	}
	/**
	 * Obtiene el familiar al que esta asociado un empleado
	 * @return el familiar al que esta asociado un empleado
	 */
	public RelativeDTO getRelativeDTO() {
		return relativeDTO;
	}
	/**
	 * Modifica el familiar al que esta asociado un empleado
	 * @param relativeDTO el nuevo familiar al que hay que asociar un empleado
	 */
	public void setRelativeDTO(RelativeDTO relativeDTO) {
		this.relativeDTO = relativeDTO;
	}
	/**
	 * Obtiene la relacion de parentesco entre un empleado y un familiar
	 * @return la relacion de parentesco entre un empleado y un familiar
	 */
	public RelativeType getRelation() {
		return relation;
	}
	/**
	 * Modifica la relacion de parentesco entre un empleado y un familiar
	 * @param relation la relacion entre el familiar y el empleado
	 */
	public void setRelation(RelativeType relation) {
		this.relation = relation;
	}

}
