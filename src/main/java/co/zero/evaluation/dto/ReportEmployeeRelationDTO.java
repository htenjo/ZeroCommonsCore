//=======================================================================
// ARCHIVO ReportEmployeeRelation.java
// FECHA CREACIÓN: 2013/04/10
//=======================================================================
package co.zero.evaluation.dto;

import co.zero.common.dto.EntityDTO;
import co.zero.hcm.dto.EmployeeDTO;

/**
 * Clase que relaciona los reportes configurados en una evaluación con las personas
 * que lo pueden ver desde la vista del empleado
 * @author Hernán Tenjo
 * @version 1.0
 */
public class ReportEmployeeRelationDTO extends EntityDTO{
	private static final long serialVersionUID = 1L;
	//Empleado que se está configurando para ver el tipo de reporte
	private EmployeeDTO employee;
	//Configuración del reporte que podrá ver el empleado
	private ReportConfigurationDTO reportConfig;
	
	/**
	 * @return the employee
	 */
	public EmployeeDTO getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(EmployeeDTO employee) {
		this.employee = employee;
	}

	/**
	 * @return the reportConfig
	 */
	public ReportConfigurationDTO getReportConfig() {
		return reportConfig;
	}

	/**
	 * @param reportConfig the reportConfig to set
	 */
	public void setReportConfig(ReportConfigurationDTO reportConfig) {
		this.reportConfig = reportConfig;
	}
}
