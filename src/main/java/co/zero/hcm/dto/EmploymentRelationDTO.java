//=======================================================================
// ARCHIVO JobRelationDTO.java
// FECHA CREACIÓN: 9/02/2011
//=======================================================================
package co.zero.hcm.dto;

import co.zero.common.dto.EntityDTO;
import co.zero.common.enumeration.evaluation.ThreesixtyRelationType;

/**
 * Bean que contiene los atributos requeridos en la vista 
 * de un {@link EmploymentRelationDTO}
 * @author Hernán Tenjo
 * @version 1.0
 */
public class EmploymentRelationDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Cargo dueño de la relación 
	private EmploymentDTO owner;
	//Cargo dependiente de la relación
	private EmploymentDTO dependent;
	//Relación entre los dos cargos en el sentido owner -> relation -> dependent
	private ThreesixtyRelationType relation;
	
	/**
	 * Metodo que permite obtener el cargo dueño de la relación 
	 * (El lado izquierdo de la relación ::: Cargo1 - Relation - Cargo2)
	 * @return El cargo dueño de la relación
	 */
	public EmploymentDTO getOwner(){
		return owner;
	}

	/**
	 * Metodo que permite modificar el cargo dueño de la relacion
	 * @param owner El nuevo cargo que encabezará la relación
	 */
	public void setOwner(EmploymentDTO owner) {
		this.owner = owner;
	}

	/**
	 * Metodo que permite obtener el cargo secundario de la relación
	 * (El lado derecho de la relación ::: Cargo1 - Relation - Cargo2)
	 * @return El cargo secundario de la relación
	 */
	public EmploymentDTO getDependent() {
		return dependent;
	}

	/**
	 * Metodo que permite modificar el cargo secundario de la relación
	 * @param dependent El nuevo cargo secundario
	 */
	public void setDependent(EmploymentDTO dependent) {
		this.dependent = dependent;
	}

	/**
	 * Metodo que permite obtener el tipo de relacion presentada 
	 * entre cada uno de los lados de la relación
	 * @return El tipo de relacion presentada entre los cargos de la relación
	 */
	public ThreesixtyRelationType getRelation() {
		return relation;
	}

	/**
	 * Metodo que permite modificar la relacion entre los cargos
	 * @param relation La nueva relacion presentada entre los cargos
	 */
	public void setRelation(ThreesixtyRelationType relation) {
		this.relation = relation;
	}
}