//=======================================================================
// ARCHIVO ScreenDTO.java
// FECHA CREACIÓN: 4/05/2010
//=======================================================================
package co.zero.hcm.dto.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import co.zero.common.dto.EntityDTO;
import co.zero.hcm.dto.CompanyDTO;

/**
 * Objeto que contiene la información de un Screen
 * @author Hernán Tenjo
 * @version 1.0
 */
public class ScreenDTO extends EntityDTO{
	//Identificador requerido para el proceso de serializacion
	private static final long serialVersionUID = 1L;
	//Nombre representativo del screen
	private String name;
	//Cadena requerida para la presentación visual del screen
	//Util como título o para identificacion de pestañas
	private String label;
	//El layout de la pantalla estará regido por la cantidad de
	//columnas que se deseen. Los fieldGroups se acomodarán de forma
	//secuencial en las columnas disponibles 
	private int numColumns = 1;
	//Conjunto de componentes que permiten el acceso al screen
	private Set<PrivilegedComponentDTO> components = new HashSet<PrivilegedComponentDTO>();
	//Conjunto de grupos de campos que pertenecen al screen 
	private List<FieldGroupDTO> fieldGroups = new ArrayList<FieldGroupDTO>();
	//Compañía a la que pertenece el screen
	private CompanyDTO company;
	
	/**
	 * Metodo que permite agregar un nuevo componente a la
	 * lista de componentes configurados para el screen
	 * @param component Nuevo componentes asociado al screen
	 */
	public void addComponent(PrivilegedComponentDTO component){
		if(components == null){
			components = new HashSet<PrivilegedComponentDTO>();
		}
		
		components.add(component);
	}
	
	/**
	 * Metodo que permite obtener el nombre del screen
	 * @return El nombre solicitado
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Permite modificar el nombre del Screen
	 * @param name El nuevo nombre que tendrá el screen
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Permite obtener el texto 'para mostrar' representativo del screen
	 * @return El label asociado al screen
	 */
	public String getLabel() {
		return label;
	}
	
	/**
	 * Permite modificar el label del screen
	 * @param label El nuevo label que mostrará el screen
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	
	/**
	 * Permite obtener la cantidad de columnas que tiene
	 * disponible el screen para la distribución de los {@link FieldGroupDTO}
	 * @return El numero de columnas configurado
	 */
	public int getNumColumns() {
		return numColumns;
	}
	
	/**
	 * Permite modificar la cantidad de columnas que tendrá
	 * disponible el screen para la distribución de los {@link FieldGroupDTO}
	 * @param numColumns La nueva cantidad de columnas disponibles en el screen
	 */
	public void setNumColumns(int numColumns){
		this.numColumns = numColumns > 1 ? numColumns : 1;
	}

	/**
	 * Permite obtener los componentes relacionados al screen
	 * @return El conjunto de componentes que tienen relacion con el screen
	 */
	public Set<PrivilegedComponentDTO> getComponents() {
		return components;
	}

	/**
	 * Permite modificar los componentes relacionados con el screen
	 * @param component El nuevo conjunto de componentes 
	 */
	public void setComponents(Set<PrivilegedComponentDTO> component) {
		this.components = component;
	}

	/**
	 * Permite obtener los grupos de campos relacionados con el screen
	 * @return El conjunto de grupos de campos pertenecientes al screen
	 */
	public List<FieldGroupDTO> getFieldGroups() {
		return fieldGroups;
	}
	
	/**
	 * Permite obtener los grupos de campos relacionados con el screen
	 * @param fieldGroups Conjunto de los nuevos grupos que conformarán el screen
	 */
	public void setFieldGroups(List<FieldGroupDTO> fieldGroups) {
		this.fieldGroups = fieldGroups;
	}
	
	/**
	 * Metodo que permite agregar un nuevo fieldGroup a la
	 * lista de fieldGroups configurados para el screen
	 * @param fieldGroup Nuevo fieldGroup que tendrá el screen
	 */
	public void addFieldGroup(FieldGroupDTO fieldGroup){
		if(fieldGroups == null){
			fieldGroups = new ArrayList<FieldGroupDTO>();
			
		}
		
		fieldGroups.add(fieldGroup);
	}
	
	/**
	 * Metodo utilitario que permite conocer la cantidad de grupos en el screen
	 * @return Cantidad de grupos asociados al screen
	 */
	public int getNumGroups(){
		return fieldGroups.size();
	}
	
	/**
	 * Permite obtener la compañía asociada al {@link ScreenDTO}
	 * @return La compañía asociada al screen
	 */
	public CompanyDTO getCompany() {
		return company;
	}

	/**
	 * Permite modificar la compañía a la que pertenece el screen
	 * @param company La nueva compañía a la que se relacionará el screen 
	 */
	public void setCompany(CompanyDTO company) {
		this.company = company;
	}
	
	/**
	 * Metodo que permite organizar los {@link FieldGroupDTO} de acuerdo
	 * a un criterio proporcionado
	 * @param comparator Objeto que conoce el criterio de organización 
	 */
	public void sortFieldGroups(Comparator<FieldGroupDTO> comparator){
		Collections.sort(fieldGroups, comparator);
	}
}