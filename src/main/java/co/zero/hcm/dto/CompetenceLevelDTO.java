/**
 * 
 */
package co.zero.hcm.dto;

import org.apache.commons.lang.StringUtils;

import co.zero.common.constant.GenericConstants;
import co.zero.common.dto.EntityDTO;

/**
 * Clase que permite definir diferentes niveles de cumplimiento para una competencia
 * @author Hernán Tenjo
 * @version 1.0
 */
public class CompetenceLevelDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Nombre de los campos que se podrán ignorar en un versión basica para JSON del DTO
	private static final String[] complexFieldsToIgnoreInJSON = 
			new String[]{"competence", "createdDate", "lastUpdatedDate", "new", "complexFieldsToIgnoreInJSON"};
	//Competencia a la que pertenece el nivel de cumplimiento
	private CompetenceDTO competence;
	//Nombre del nivel (Utilizado en la generación de reportes)
	private String name;
	//Descripción del nivel de cumplimiento
	private String description;
	//Nombre representativo del nivel (Utilizado en la presentación web)
	private String label;
	//Indice que identifica de forma cuantitativa al nivel
	private int level;
	//Valor mínimo que se espera tengan las personas de este nivel
	private double minimum;
	//Determina si el nivel se encuentra activo
	private boolean active;
	//Nombre compuesto del nivel + competenceName
	private String composeName;
	
	/**
	 * Método que permite obtener la competencia a la que pertenece el nivel
	 * @return La competencia asociada al nivel
	 */
	public CompetenceDTO getCompetence() {
		return competence;
	}

	/**
	 * Método que permite modificar la competencia a la que pertenece el nivel
	 * @param competence La nueva competencia que será dueña de este nivel 
	 */
	public void setCompetence(CompetenceDTO competence) {
		this.competence = competence;
	}

	/**
	 * Método que permite obtener el nombre del nivel
	 * @return Nombre configurado para el nivel
	 */
	public String getName() {
		return name;
	}

	/**
	 * Método que permite modificar el nombre del nivel
	 * @param name El nuevo nombre asignado al nivel 
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Método que obtiene la combinación del nombre de la competencia
	 * con el nombre del nivel, para formar un nombre casi único x compañía
	 * @return Composición del nombre de la competencia con el nombre del nivel
	 */
	public String getComposeName(){
		if(StringUtils.isBlank(composeName) && this.competence != null){
			composeName = competence.getName() + GenericConstants.MINUS;
			composeName += this.name;
		}
		
		return composeName;
	}
	
	/**
	 * Método que modifica la combinación del nombre de la competencia
	 * con el nombre del nivel, para formar un nombre casi único x compañía
	 * @param composeName El nuevo identificador del nivel
	 */
	public void setComposeName(String composeName){
		this.composeName = composeName;
	}

	/**
	 * Método que permite obtener la descripción del nivel
	 * @return La descripción configurada para el nivel
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Método que permite modificar la descripción asociada al nivel
	 * @param description La nueva descripción del nivel
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Método que permite obtener el label representativo del nivel
	 * @return El label configurado para el nivel
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Método que permite modificar el label representativo del nivel
	 * @param label El nuevo texto que representará al nivel
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Método que permite obtener el indice del nivel
	 * @return Valor numérico que representa al nivel
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Método que permite modificar el índice del nivel
	 * @param level El nuevo índice que representará al nivel
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	
	/**
	 * Método que permite obtener el valor mínimo esperado que deben presentar
	 * los empleados que deban demostrar este nivel de competencia
	 * @return El valor mínimo esperado para el nivel de competencia
	 */
	public double getMinimum() {
		return minimum;
	}

	/**
	 * Método que permite modificar el valor mínimo esperado que deben presentar
	 * los empleados que deban demostrar este nivel de competencia
	 * @param minimum El nuevo valor mínimo esperado para el nievl de competencia
	 */
	public void setMinimum(double minimum) {
		this.minimum = minimum;
	}
	
	/**
	 * Método que determina si el nivel de competencia se encuentra activo en el sistema
	 * @return True si el nivel se encuentra activo, false de lo contrario
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Método que modifica el estado activo del nivel de la competencia
	 * @param active True si se desea activar el nivel, false de lo contrario
	 */
	public void setActive(boolean active) {
		this.active = active;
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