//=======================================================================
// ARCHIVO ActivityEmployeeDTO.java
// FECHA CREACIÓN: 23/09/2010
//=======================================================================
package co.zero.goals.dto.development;

import co.zero.common.dto.EntityDTO;
import co.zero.hcm.dto.CompetenceLevelDTO;
import co.zero.hcm.dto.EmployeeDTO;

/**
 * Clase que contiene la informacion de la relacion existente
 * entre un empleado que esta inscrito en una actividad y la competencia
 * que está siendo afectada.
 * @author Hernán Tenjo
 * @version 1.0
 */
public class ActivityEmployeeDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;

	//Actividad a la que pertenece el empleado
	private ActivityDTO activity;
	//Emplado que se encuentra inscrito en la actividad
	private EmployeeDTO employee;
	//Competencia que está siendo afectada por la actividad para el empleado
	private CompetenceLevelDTO level;
	//Estados (1-4) que puede tener una actividad (0-25%, 26-50%, 51-75%, 76-100%), 0 = No evaluada
	private int currentTrackingState;
	
	//-------  TODO: Estos atributos deben ser eliminados, cuando los reportes sean ajustados al nuevo desarrollo
	//Determina si ya se ha dado por finalizada la actividad
	private boolean finished;
	//Determina si se completo satisfactoriamente la actividad
	private boolean completed;
	//Si no se completo la actividad, se puede agregar una observación del por qué
	private String observation;
	
	//Atributo de utileria para indicar que el usuario desea borrar el registro
	private boolean selected;
	
	/**
	 * Metodo que permite obtener la actividad en la que 
	 * se encuentra inscrito el empleado
	 * @return La actividad relacionada con el empleado
	 */
	public ActivityDTO getActivity() {
		return activity;
	}

	/**
	 * Metodo que permite modificar la actividad en la que 
	 * se encuentra inscrito el empleado
	 * @param activity La nueva actividad en la que será 
	 * inscrito el empleado
	 */
	public void setActivity(ActivityDTO activity) {
		this.activity = activity;
	}

	/**
	 * Metodo que permite obtener el empleado que se desea relacionar 
	 * @return El empleado relacionado
	 */
	public EmployeeDTO getEmployee() {
		return employee;
	}

	/**
	 * Metodo que permite modificar el empleado relacionado
	 * @param employee El nuevo empleado que se desea relacionar
	 */
	public void setEmployee(EmployeeDTO employee) {
		this.employee = employee;
	}
	
	/**
	 * Metodo que permite obtener el nivel de la competencia que está siendo
	 * afectada con la inscripcion del empleado en la actividad
	 * @return La competencia que será afectada con la actividad
	 */
	public CompetenceLevelDTO getLevel() {
		return level;
	}

	/**
	 * Metodo que permite modificar la competencia que está siendo
	 * afectada con la inscripcion del empleado en la actividad
	 * @param competence La nueva competencia que será afectada
	 * con la actividad
	 */
	public void setLevel(CompetenceLevelDTO level) {
		this.level = level;
	}

	/**
	 * Método que permite determinar si la actividad ya ha sido finalizada.
	 * @return TRUE si la actividad ya fue terminada, FALSE de lo contrario
	 */
	public boolean isFinished() {
		return finished;
	}

	/**
	 * Metodo que permite modificar el estado de finalizado de la actividad
	 * @param finished TRUE si se quiere que la actividad figure como 
	 * terminada, FALSE de lo contrario
	 */
	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	/**
	 * Metodo que permite determinar si la actividad ha sido completada con exito,
	 * esto es util ya que una actividad se pudo terminar y el empleado por 
	 * algún motivo no asistió a la capacitación, lo cuál no sirve para cubrir
	 * las brechas encontradas en las competencias del empleado.
	 * @return TRUE si el empleado completo satisfactoriamente la capacitación
	 * o la actividad en la que fue inscrito
	 */
	public boolean isCompleted() {
		return completed;
	}

	/**
	 * Metodo que permite modificar el estado de completada de una actividad
	 * @param completed TRUE si se quiere que la actividad sea tomada como
	 * terminada de forma satisfactoria, false de lo contrario
	 */
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	/**
	 * Metodo que permite obtener las observaciones adicionales generadas 
	 * en la finalización de la actividad
	 * @return El texto ingresado como observaciones adicionales
	 */
	public String getObservation() {
		return observation;
	}

	/**
	 * Metodo que permite modificar las observaciones adicionales 
	 * @param observation Nuevo texto que será tomado como las observaciones adicionales
	 */
	public void setObservation(String observation) {
		this.observation = observation;
	}

	/**
	 * Método que obtiene el estado de la actividad para el periodo evaluado
	 * @return El estado de la actividad al momento de realizar el seguimiento:
	 * 1: Avance entre  0% - 25% = Color Rojo
	 * 2: Avance entre 26% - 50% = Color Naranja
	 * 3: Avance entre 51% - 75% = Color Amarillo
	 * 4: Avance entre 76% - 100%= Color Verde
	 */
	public int getCurrentTrackingState() {
		return currentTrackingState;
	}

	/**
	 * Método que modifica el estado de la actividad para el periodo evaluado
	 * @param trackingState El nuevo estado de la actividad
	 */
	public void setCurrentTrackingState(int trackingState) {
		this.currentTrackingState = trackingState;
	}

	/**
	 * Metodo que obtiene el atributo de utileria que indica si el usuario desea borrar el registro
	 * 
	 * @return
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * Metodo que modifica el atributo de utileria que indica si el usuario desea borrar el registro
	 * 
	 * @param selected
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}