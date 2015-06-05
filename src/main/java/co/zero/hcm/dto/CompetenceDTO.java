//=======================================================================
// ARCHIVO Competence.java
// FECHA CREACIÓN: 26/07/2010
//=======================================================================
package co.zero.hcm.dto;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ValueChangeEvent;

import co.zero.common.dto.EntityDTO;


/**
 * Clase que modela una competencia en una organización.
 * Una competencia establece el nivel mínimo que debe cumplir un
 * empleado para realizar de forma efectiva una actividad establecida.
 * @author Hernán Tenjo
 * @version 1.0
 */
public class CompetenceDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	
	//Nombre de la competencia
	private String name;
	//Breve descripcion de la competencia
	private String description;
	//Determina si la competencia aplica para toda la organización
	private boolean organizational;
	//Atributo que permite determinar si la competencia se encuentra activa para la compañía
	private boolean active;
	//Compañía a la que pertenece la competencia
	private CompanyDTO company;
	//Lista con los niveles de cumplimiento de la competencia
	private List<CompetenceLevelDTO> levels;
	
	//===========		Atributos requeridos por la vista 		===========
	private boolean selected;
	private long selectedLevelId;
	
	/**
	 * Método que permite agregar un nivel de cumplimiento a la competencia
	 * @param level Nuevo nivel de cumplimiento que se desea agregar a la competencia
	 */
	public void addLevel(CompetenceLevelDTO level){
		if(levels == null){
			levels = new ArrayList<CompetenceLevelDTO>();
		}
		
		level.setCompetence(this);
		levels.add(level);
	}
	
	
	/**
	 * Metodo que permite obtener el nombre de la competencia
	 * @return El nombre de la compentencia 
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Metodo que permite modificar el nombre configurado de la competencia
	 * @param name El nuevo nombre que se desea asignar a la competencia
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Metodo que permite obtener la descripcion de la competencia
	 * @return La descripcion de la competencia
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Metodo que permite modificar la descripcion 
	 * configurada de la competencia
	 * @param description La nueva descripcion que se desea asociar a 
	 * la competencia
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Metodo que permite determinar si la competencia es general 
	 * para la compañía
	 * @return True si la competencia es organizacional, false de lo contrario
	 */
	public boolean isOrganizational() {
		return organizational;
	}

	/**
	 * Metodo que permite modicar el estado organizacional de la competencia
	 * @param organizational El nuevo estado de la competencia
	 * True: La competencia deberá ser aplicada de forma generalizada
	 * False: La competencia deberá ser aplicada de forma personalizada
	 */
	public void setOrganizational(boolean organizational) {
		this.organizational = organizational;
	}
	
	/**
	 * Metodo que permite obtener el {@link CompanyDTO} al que pertene la competencia
	 * @return La compañía a la que pertenece la competencia
	 */
	public CompanyDTO getCompany() {
		return company;
	}

	/**
	 * Metodo que permite modificar la compañía a la que pertenece la competencia
	 * @param company La nueva compañía a la que será asignada la competencia
	 */
	public void setCompany(CompanyDTO company) {
		this.company = company;
	}
	
	/**
	 * Método que permite obtener los niveles de cumplimiento de la competencia
	 * @return Los niveles de cumplimiento definidos para la competencia
	 */
	public List<CompetenceLevelDTO> getLevels() {
		return levels;
	}

	/**
	 * Método que permite  modificar los niveles de cumplimiento de la competencia
	 * @param levels Lista con los nuevos niveles de cumplimiento de la competencia
	 */
	public void setLevels(List<CompetenceLevelDTO> levels) {
		this.levels = levels;
	}

	/**
	 * Método que permite determinar si la competencia se encuentra activa en la compañía
	 * @return El estado de la competencia en la compañía (true=activa, false=inactiva)
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Método que permite activar/desactivar la competencia de una compañía
	 * @param active True si se quiere activar la compañía, false de lo contrario
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * Método que obtiene el id del nivel de la competencia seleccionado en la VISTA
	 * @return El id del nivel selecciado
	 */
	public long getSelectedLevelId() {
		return selectedLevelId;
	}

	/**
	 * Método que modifica el id del nivel seleccionado para la competencia
	 * @param selectedLevel El id del nivel seleccionado en la competencia
	 */
	public void setSelectedLevelId(long selectedLevelId) {
		this.selectedLevelId = selectedLevelId;
	}

	/**
	 * Método que determina si la competencia ha sido seleccionada en la vista
	 * @return True si la competencia ha sido seleccionada, false de lo contrario
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * Método que modifica el estado seleccionado de la competencia
	 * @param selected True si se ha seleccionado la competencia, false de lo contrario
	 */
	public void setSelected(boolean selected) {
		if(selected && levels != null && levels.size() > 0){
			selectedLevelId = levels.get(0).getId();
		}else{
			selectedLevelId = 0;
		}
		
		this.selected = selected;
	}
	
	/**
	 * Método que permite seleccionar uno de los niveles de la competencia
	 * @param event Objeto que contiene la información requerida para el proceso
	 */
	public void selectCompetenceLevel(ValueChangeEvent event){
		long levelId = (Long)event.getNewValue();
		selectedLevelId = levelId;
	}
	
	/**
	 * Metodo que obtiene el nivel seleccionado de la competencia
	 * @return El nivel seleccionado de la competencia si existe, null de lo contrario
	 */
	public CompetenceLevelDTO getSelectedLevel(){
		CompetenceLevelDTO levelAux = null;
		
		if(selectedLevelId > 0){
			for(CompetenceLevelDTO level : levels){
				if(level.getId() == selectedLevelId){
					levelAux = level;
					break;
				}
			}
		}
		
		return levelAux;
	}
	
	/**
	 * Método que obtiene uno de los niveles de la competencia conociendo su id
	 * @param competenceLevelId Identificador del nivel que se desea obtener
	 * @return El nivel si existe, null de lo contrario
	 */
	public CompetenceLevelDTO getLevelById(long competenceLevelId){
		CompetenceLevelDTO levelAux = null;
		
		for(CompetenceLevelDTO level : levels){
			if(level.getId() == competenceLevelId){
				levelAux = level;
				break;
			}
		}
		
		return levelAux;
	}
}