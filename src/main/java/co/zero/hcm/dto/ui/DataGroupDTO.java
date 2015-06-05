//=======================================================================
// ARCHIVO DataGroupDTO.java
// FECHA CREACIÓN: 11/11/2010
//=======================================================================
package co.zero.hcm.dto.ui;

import java.util.ArrayList;
import java.util.List;

import co.zero.common.dto.EntityDTO;
import co.zero.hcm.dto.CompanyDTO;

/**
 * Objeto que permite el transporte de la información de un grupo de datos
 * @author Hernán Tenjo
 * @version 1.0
 */
public class DataGroupDTO extends EntityDTO{
	//Identificador requerido para el proceso de serializacion
	private static final long serialVersionUID = 1L;
	//Atributos propios de la entidad
	private String label;
	//Compañía a la que pertenece el grupo. Si la compañía es nula, es porque
	//es un grupo de acceso público
	private CompanyDTO company;
	//Conjunto de items relacionados
	private List<DataItemDTO> items = new ArrayList<DataItemDTO>();
	
	/**
	 * Metodo que permite obtener el label descriptivo del Grupo de Datos
	 * @return El label asociado al grupo de datos
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Metodo que permite modificar el label descriptivo del Grupo de Datos
	 * @param label Nueva etiqueta que será asignada al grupo
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	
	/**
	 * Metodo que permite obtener la compañía a la que pertenece el grupo
	 * @return La compañía a la que pertenece el grupo si existe. Null
	 * si el grupo es de acceso público.
	 */
	public CompanyDTO getCompany() {
		return company;
	}

	/**
	 * Metodo que permite modificar la compañía a la que pertenece el grupo
	 * @param company La nueva compañía dueña del grupo de datos
	 */
	public void setCompany(CompanyDTO company) {
		this.company = company;
	}
	
	/**
	 * Metodo que permite agregar un item a la lista de items relacionados con el grupo
	 * @param item Nuevo item que se desea agregar
	 */
	public void addItem(DataItemDTO item){
		if(items == null){
			items = new ArrayList<DataItemDTO>();
		}
		
		item.setGroup(this);
		items.add(item);
	}
	
	/**
	 * metodo que permite obtener todos los items asociados al grupo
	 * @return Conjunto con los items del grupo
	 */
	public List<DataItemDTO> getItems(){
		return items;
	}

	/**
	 * Metodo que permite modificar los items asociados al grupo
	 * @param items El nuevo conjunto de items asociados al grupo
	 */
	public void setItems(List<DataItemDTO> items) {
		this.items = items;
	}
}