//=======================================================================
// ARCHIVO DataItemDTO.java
// FECHA CREACIÓN: 11/11/2010
//=======================================================================
package co.zero.hcm.dto.ui;

import co.zero.common.dto.EntityDTO;

/**
 * Entidad que modela a uno de los datos de un {@link DataGroupDTO}
 * @author Hernán Tenjo
 * @version 1.0
 */
public class DataItemDTO extends EntityDTO{
	//Identificador requerido para el proceso de serializacion
	private static final long serialVersionUID = 1L;
	//Atributos propios de la entidad
	//Texto descriptivo del item
	private String label;
	//Valor asociado al item, util para la generación de estadísticas
	private int value;
	//Grupo al que pertenecen las opciones
	private DataGroupDTO group;
	//Cuando un item presenta la relación padre/hijo con otro,
	//este atributo representaría al padre, p.e. Si se tiene los dataGroups Ciudad y
	//País, Los items de ciudad serían dependientes de los items de pais y de esta forma
	//al seleccionar el item Colombia se podrían obtener las ciudades del pais y no de todos.
	private DataItemDTO parent;
	
	/**
	 * Metodo que permite obtener el label descriptivo del item
	 * @return El label asociado al item
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Metodo que permite modificar el label descriptivo del item
	 * @param label El nuevo label que será asociado al item
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Metodo que permite obtener el valor asociado al item
	 * @return El valor del item
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Metodo que permite modificar el valor asociado al item
	 * @param value El nuevo valor asociado al item
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * Metodo que permite obtener el grupo al que pertenece el item
	 * @return El grupo asociado al item
	 */
	public DataGroupDTO getGroup() {
		return group;
	}

	/**
	 * Metodo que permite modificar el grupo al que pertenece el item
	 * @param group El nuevo grupo al que pertenece el item
	 */
	public void setGroup(DataGroupDTO group) {
		this.group = group;
	}

	/**
	 * Metodo que permite obtener el item padre de este item
	 * @return El item padre asociado si existe, null de lo contrario
	 */
	public DataItemDTO getParent() {
		return parent;
	}

	/**
	 * Metodo que permite modificar el item padre de este item 
	 * @param parent El nuevo item que será padre de este item
	 */
	public void setParent(DataItemDTO parent) {
		this.parent = parent;
	}
}