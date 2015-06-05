//=======================================================================
// ARCHIVO JobDTO.java
// FECHA CREACIÓN: Oct 1, 2009
//=======================================================================
package co.zero.hcm.dto;

import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

/**
 * Bean que contiene los atributos requeridos en la vista de un {@link JobDTO} 
 * @author Hernán Tenjo
 * @version 1.0
 */
public class JobDTO extends HcmEntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	private static final int NUMBER_CHARACTERS = 166;
	//Division a la que pertenece el cargo
	private DivisionDTO division;
	//Niveles de competencias que deberá desempeñar el cargo
	private Set<CompetenceLevelDTO> competenceLevel = new LinkedHashSet<CompetenceLevelDTO>();
	//Atributos duplicados de los extrafields, requeridos por 
	//algunos módulos para poder tener acceso directo a la informacion
	private String name;
	//Breve descripción acerca de la funcionalidad o el propósito del cargo
	private String description;
	
	/**
	 * Permite obtener la division a la que pertenece el cargo
	 * @return division La division a la que pertenece el cargo
	 */
	public DivisionDTO getDivision() {
		return division;
	}
	
	/**
	 * Permite modificar la division a la que pertenece el cargo
	 * @param division La nueva division a la que pertenecera el cargo
	 */
	public void setDivision(DivisionDTO divisionDTO) {
		this.division = divisionDTO;
	}

	/**
	 * Método que obtiene los niveles de las competencias que debe tener el cargo
	 * @return Los niveles de las competencias que se deben presentar en el cargo
	 */
	public Set<CompetenceLevelDTO> getCompetenceLevel() {
		return competenceLevel;
	}

	/**
	 * Método que modifica los niveles de las competencias que debe tener el cargo
	 * @param competenceLevel Los nuevos niveles de competencias que debe presentar el cargo
	 */
	public void setCompetenceLevel(Set<CompetenceLevelDTO> competenceLevel) {
		this.competenceLevel = competenceLevel;
	}
	
	/**
	 * Metodo que permite asignar el nombre del extrafield
	 * que contiene el nombre de la compañía
	 * @return El nombre del extrafield que contiene la info
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metodo que permite modificar el nombre del extrafield
	 * que contiene el nombre de la compañía
	 * @param name El nuevo nombre del extrafield
	 * que contendrá la información requerida
	 */
	public void setName(String name) {
		this.name = name;
	}
	

	/**
	 * Método que obtiene la descripción del cargo
	 * @return La descripción configurada para el cargo
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Método que modifica la descripción del cargo
	 * @param description La nueva descripción que será asociada al cargo
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Obtiene la descripcion del cargo con una cantidad de caracteres definidos
	 * @return
	 */
	public String getDescriptionForProfile(){
		return StringUtils.abbreviate(description, NUMBER_CHARACTERS);
	}
}