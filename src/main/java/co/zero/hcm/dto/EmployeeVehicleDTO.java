//=======================================================================
// ARCHIVO Vehicle.java
// FECHA CREACIÓN: 11/05/2012
//=======================================================================
package co.zero.hcm.dto;

/**
 * Clase que representa los vehículos asociados a un empleado
 * @author Hernán Tenjo
 * @version 1.0
 */
public class EmployeeVehicleDTO extends HcmEntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	
	//Placa de identificación del vehículo
	private String license;
	//Año en el que el vehículo salió al mercado
	private int model;
	//Empleado al que se encuentran asociados el vehículo
	private EmployeeDTO employee;
	
	/**
	 * Método que obtiene el empleado dueño del vehículo
	 * @return El emplado dueño de la entidad
	 */
	public EmployeeDTO getEmployee() {
		return employee;
	}

	/**
	 * Método que modifica al empleado dueño del vehículo
	 * @param employee El nuevo empleado dueño de la entidad
	 */
	public void setEmployee(EmployeeDTO employee) {
		this.employee = employee;
	}
	
	/**
	 * Método que obtiene la placa del vehículo asociado
	 * @return La placa configurada para el vehículo
	 */
	public String getLicense() {
		return license;
	}
	
	/**
	 * Método que modifica la placa del vehículo asociado
	 * @param license Número de placa del vehículo asociado
	 */
	public void setLicense(String license) {
		this.license = license;
	}
	
	/**
	 * Método que obtiene el modelo del vehículo asociado
	 * @return El modelo del vehículo asociado
	 */
	public int getModel() {
		return model;
	}
	
	/**
	 * Método que modifica el modelo del vehículo asociado
	 * @param model El modelo del vehículo asociado
	 */
	public void setModel(int model) {
		this.model = model;
	}
}