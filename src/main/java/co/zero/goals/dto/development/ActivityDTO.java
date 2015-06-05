//=======================================================================
// ARCHIVO Activity.java
// FECHA CREACIÓN: 26/07/2010
//=======================================================================
package co.zero.goals.dto.development;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import co.zero.common.dto.EntityDTO;
import co.zero.common.enumeration.PeriodicType;
import co.zero.hcm.dto.CompetenceLevelDTO;
import co.zero.hcm.dto.EmployeeDTO;

/**
 * Clase que modela a una actividad ideada para complementar una
 * estrategia, la cual intentará mejorar un aspecto importante faltante
 * en el desarrollo de una competencia
 * @author Hernán Tenjo
 * @version 1.0
 */
public class ActivityDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	
	// Texto identifica a la actividad
	private String name;
	// Texto que describe el proposito de la actividad
	private String description;
	// Fecha en la que se espera comenzar la actividad
	private Date startDate;
	// Fecha en la que se espera terminar la actividad
	private Date endDate;
	// Nombre de la persona o entidad responsable de la actividad
	private String responsible;
	// Estrategia de capacitacion a la que pertenece la activiada
	private StrategyDTO strategy;
	// Tipo de periodicidad para el seguimiento de la actividad
	private PeriodicType period;
	//Competencias a las que apoya la actividad
	private Set<CompetenceLevelDTO> competenceLevels = new LinkedHashSet<CompetenceLevelDTO>();
	//Empleado que creó la actividad (Generalmente los jefes) en la vista de empleado
	private EmployeeDTO owner;
	//Nombre de los campos que se podrán ignorar en un versión basica para JSON del DTO
	private static final String[] complexFieldsToIgnoreInJSON = new String[]{"createdDate", "lastUpdatedDate", 
		"complexFieldsToIgnoreInJSON", "strategy", "competenceLevels", "competenceLevelsAsList", "owner"};
	
	//============== Atributos requeridos en la vista
	//Determina si la actividad ha sido seleccionada en la vista
	private boolean selected;
	
	/**
	 * Metodo que permite obtener el nombre de la actividad
	 * @return El nombre asignado a la actividad
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Metodo que permite modificar el nombre de la actividad
	 * @param name El nuevo nombre que se desea asignar a la actividad
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Metodo que permite obtener la descripcion del proposito 
	 * de la actividad
	 * @return La descripcion asignada a la actividad
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Metodo que permite modificar la descripcion asociada a la actividad
	 * @param description La nueva descripcion que se desea asociar
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Metodo que permite obtener la fecha esperada de inicio de la actividad
	 * @return La fecha esperada de inicio de la actividad
	 */
	public Date getStartDate() {
		return startDate;
	}
	
	/**
	 * Metodo que permite modificar la fecha esperada de inicio de la actividad
	 * @param startDate La nueva fecha de inicio de la actividad
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	/**
	 * Metodo que permite obtener la fecha esperada de finalizacion
	 * de la actividad
	 * @return La fecha esperada de finalizacion de la actividad
	 */
	public Date getEndDate() {
		return endDate;
	}
	
	/**
	 * Metodo que permite modificar la fecha esperada de finalización 
	 * de la actividad
	 * @param endDate La  nueva fecha esperada de finalización 
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	/**
	 * Metodo que permite obtener el nombre del responsable de la actividad
	 * @return El nombre de la persona o entidad responsable de la actividad
	 */
	public String getResponsible() {
		return responsible;
	}
	
	/**
	 * Metodo que permite moficicar el nombre del responsable de la actividad
	 * @param responsible El nuevo nombre de la persona o entidad 
	 * responsable de la actividad
	 */
	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}
	
	/**
	 * Metodo que permite obtener la estrategia a la que pertenece la actividad 
	 * @return La estrategia a la que pertenece la actividad
	 */
	public StrategyDTO getStrategy() {
		return strategy;
	}
	
	/**
	 * Metodo que permite modificar la estrategia a la que pertenece la actividad
	 * @param strategy La nueva estrategia a la que será asignada la actividad
	 */
	public void setStrategy(StrategyDTO strategy) {
		this.strategy = strategy;
	}
	
	/**
	 * Método que agrega un nivel de competencia para estar relacionado con la actividad
	 * @param level El nivel de competencia que se desea relacionar
	 */
	public void addCompetenceLevel(CompetenceLevelDTO level){
		if(competenceLevels == null){
			competenceLevels = new LinkedHashSet<CompetenceLevelDTO>();
		}
		
		competenceLevels.add(level);
	}

	/**
	 * Método que obtiene las competencias a las que apoya la actividad
	 * @return Conjunto de competencias que pueden ser apoyadas por la actividad
	 */
	public Set<CompetenceLevelDTO> getCompetenceLevels() {
		return competenceLevels;
	}
	
	/**
	 * Método que obtiene los niveles de una forma conveniente para iterar (Lista)
	 * @return Lista con los niveles asociados al template
	 */
	public List<CompetenceLevelDTO> getCompetenceLevelsAsList(){
		return new ArrayList<CompetenceLevelDTO>(competenceLevels);
	}
	
	/**
	 * Método que obtiene el empleado que creó la actividad
	 * @return Empleado al que le pertenece la actividad
	 */
	public EmployeeDTO getOwner() {
		return owner;
	}

	/**
	 * Método que modifica el empleado que creó la actividad
	 * @param owner El nuevo empleado que será el dueño de la actividad
	 */
	public void setOwner(EmployeeDTO owner) {
		this.owner = owner;
	}


	/**
	 * Método que modifica las competencias a las que apoya la actividad
	 * @param competences El nuevo conjunto de competencias que pueden ser apoyadas por la actividad
	 */
	public void setCompetenceLevels(Set<CompetenceLevelDTO> competenceLevels) {
		this.competenceLevels = competenceLevels;
	}

	/**
	 * Determina si la actividad ha sido seleccionada en la vista
	 * @return True si la actividad ha sido seleccionada
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * Modifica el estado seleccionado de la actividad
	 * @param selected True si se va a seleccionar la actividad, false de lo contrario
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	/**
	 * Método que obtiene la periodicidad de seguimiento esperada para la actividad
	 * @return La periodicidad de seguimient de la actividad
	 */
	public PeriodicType getPeriod() {
		return period;
	}

	/**
	 * Método que modifica la periodicidad de seguimiento esperada para la actividad
	 * @param period La nueva periodicidad de seguimiento
	 */
	public void setPeriod(PeriodicType period) {
		this.period = period;
	}
	
	public PeriodicType[] getPeriodValues(){
		return PeriodicType.values();
	}

	/**
	 * Método que obtiene la lista de campos que no se tendrán en cuenta
	 * cuando se haga un parse básico del DTO con JSON
	 * @return
	 */
	public static String[] getComplexFieldsToIgnoreInJSON(){
		return complexFieldsToIgnoreInJSON;
	}
}