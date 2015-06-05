package co.zero.kpi.dto;

import java.util.ArrayList;
import java.util.List;

import co.zero.common.dto.EntityDTO;
import co.zero.hcm.dto.EmployeeDTO;

/**
 * Clase que reune el employee con sus respectivas relaciones a los objetivos
 * 
 * @author Youlyn Chinome
 */
public class EmployeeKpiGoalRelationDTO extends EntityDTO{
	//Identificador requerido para la serialización
	private static final long serialVersionUID = 1L;
	//Empleado
	private EmployeeDTO employee;
	//Lista de los objetivos asignados al empleado
	private List<KpiGoalRelationDTO> relations = new ArrayList<KpiGoalRelationDTO>();
	//Relacion que ha sido elegida para ver los detalles
	private long selectedRelation;
	
	/**
	 * Empleado
	 * @return
	 */
	public EmployeeDTO getEmployee() {
		return employee;
	}
	
	/**
	 * Empleado
	 * @param employee
	 */
	public void setEmployee(EmployeeDTO employee) {
		this.employee = employee;
	}
	
	/**
	 * Lista de los objetivos asignados al empleado
	 * @return
	 */
	public List<KpiGoalRelationDTO> getRelations() {
		return relations;
	}
	
	/**
	 * Lista de los objetivos asignados al empleado
	 * @param relations
	 */
	public void setRelations(List<KpiGoalRelationDTO> relations) {
		this.relations = relations;
	}
	
	/**
	 * Relacion que ha sido elegida para ver los detalles
	 * @return
	 */
	public long getSelectedRelation() {
		return selectedRelation;
	}
	
	/**
	 * Relacion que ha sido elegida para ver los detalles
	 * @param selectedRelation
	 */
	public void setSelectedRelation(long selectedRelation) {
		this.selectedRelation = selectedRelation;
	}
	
}