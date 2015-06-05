//=======================================================================
// ARCHIVO CompanyActivityDTO.java
// FECHA CREACIÓN: 08/03/2012
//=======================================================================
package co.zero.hcm.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import co.zero.common.dto.EntityDTO;
import co.zero.common.enumeration.PeriodicType;

/**
 * Bean que contiene los atributos requeridos en la vista de un {@link ActivityTemplateDTO}
 * @author Hernán Tenjo
 * @version 1.0
 */
public class ActivityTemplateDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	
	//Nombre representativo de la actividad
	private String name;
	//Detalle de la actividad
	private String description;
	//Determina si la actividad se encuentra vigente en la organización
	private boolean active;
	//Compañía a la que pertenece el template
	private CompanyDTO company;
	// Tipo de periodicidad para el seguimiento de la actividad
	private PeriodicType period;
	//Competencias a las que apoya la actividad
	private Set<CompetenceLevelDTO> competenceLevels = new LinkedHashSet<CompetenceLevelDTO>();
	//================== 	ATRIBUTOS REQUERIDOS POR LA VISTA ==========================
	//Determina si la plantilla ha sido seleccionada en la vista
	private boolean selected;
	//Fecha probable de inicio de la actividad
	private Date startDate;
	//Fecha probable de finalización de la actividad
	private Date endDate;
	//Nombre del responsable si lo hay, se llevar a cabo la actividad
	private String responsible;
	
	/**
	 * Método que permite obtener el nombre de la actividad
	 * @return El nombre configurado para la actividad
	 */
	public String getName() {
		return name;
	}

	/**
	 * Método que permite modificar el nombre asignado a la actividad
	 * @param name El nuevo nombre que será asignado a la activida  
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Método que permite obtener la descripción detallada de la actividad
	 * @return Texto que describe mas detalladamente el proposito de la actividad
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Método que permite modificar la descripción detallada de la actividad
	 * @param description La nueva descripción de actividad
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Método que determina si la actividad se encuentra vigente en la empresa
	 * @return True si la actividad se encuentra activa, false de lo contrario
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Método que modifica la vigencia de la actividad en la empresa
	 * @param active True si se desea poner vigente la actividad, false de lo contrario
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	
	/**
	 * Método que agrega un nivel a la lista de niveles del template
	 * @param level
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
	 * Método que modifica las competencias a las que apoya la actividad
	 * @param competences El nuevo conjunto de competencias que pueden ser apoyadas por la actividad
	 */
	public void setCompetenceLevels(Set<CompetenceLevelDTO> competenceLevels) {
		this.competenceLevels = competenceLevels;
	}

	/**
	 * Método que obtiene la compañía a la que pertenece el template
	 * @return La compañía asociado al template
	 */
	public CompanyDTO getCompany() {
		return company;
	}

	/**
	 * Metodo que modifica la compañía a la que pertenece el template
	 * @param company La nueva compañía dueña del template
	 */
	public void setCompany(CompanyDTO company) {
		this.company = company;
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

	//======================	METODOS REQUERIDOS POR LA VISTA
	/**
	 * Método que obtiene la fecha probable de inicio de la actividad
	 * @return La fecha de inicio de la actividad
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Metodo que modifica la fecha problable de inicio de la actividad
	 * @param startDate La nueva fecha de inicio de la actividad
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Método que obtiene la fecha probable de finalización de la actividad
	 * @return La fecha de finalización de la actividad
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Método que modifica la fecha probable de finalización de la actividad
	 * @param endDate La nueva fecha de finalización de la actividad
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Método que obtiene el nombre del responsable de desarrollar la actividad si lo hay
	 * @return El nombre del responsable de la actividad si lo hay, null de lo contrario
	 */
	public String getResponsible() {
		return responsible;
	}

	/**
	 * Método que modifica el nombre del responsable de desarrollar la actividad
	 * @param responsible El nuevo nombre del responsable de la actividad
	 */
	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}
	
	/**
	 * Método que determina si la plantilla ha sido seleccionada en la vista
	 * @return True si la plantilla ha sido seleccionada, false de lo contrario
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * Método que modifica el estado seleccionado de la plantilla
	 * @param selected True si se ha seleccionado la plantilla, false de lo contrario
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	/**
	 * Método que obtiene los niveles de una forma conveniente para iterar (Lista)
	 * @return Lista con los niveles asociados al template
	 */
	public List<CompetenceLevelDTO> getCompetenceLevelsAsList(){
		return new ArrayList<CompetenceLevelDTO>(competenceLevels);
	}
	
	public PeriodicType[] getPeriodValues(){
		return PeriodicType.values();
	}
}