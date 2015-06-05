//=======================================================================
// ARCHIVO FieldGroup.java
// FECHA CREACIÓN: 4/05/2010
//=======================================================================
package co.zero.hcm.dto.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import co.zero.common.dto.EntityDTO;

/**
 * Objeto que contiene la información de los grupos de campos que conforman un screen
 * @author Hernán Tenjo
 * @version 1.0
 */
public class FieldGroupDTO extends EntityDTO{
	//Identificador requerido para el proceso de serializacion
	private static final long serialVersionUID = 1L;
	
	private static final String RELATED_LABEL = "relatedGroup";
	private static final String BASIC_LABEL = "basicGroup";
	//Determina si el grupo va a tener campos de entidades relacionadas
	private boolean relatedGroup;
	//Determina si el grupo va a tener campos fijos de la entidad
	private boolean basicGroup;
	//Nombre que identifica al fieldGroup
	private String name;
	//Texto descriptivo del fieldGroup
	private String label;
	//Determina la prioridad de aparición del fieldGroup con respecto
	//a otros que pertenezcan al mismo screen
	private int priority;
	//Pantalla donde será mostrado el fieldGroup
	private ScreenDTO screen;
	//Lista de compos que conforman el grupo
	private List<FieldDTO> fields;
	//Determina si el fieldGroup contendrá los atributos estáticos de las entidades
	//p.e. En la entidad Job, este field group contendrá un campo division
	private boolean mandatory;
		
	/**
	 * Metodo que permite agregar un nuevo fieldGroup a la
	 * lista de fieldGroups configurados para el screen
	 * @param fieldGroup Nuevo fieldGroup que tendrá el screen
	 */
	public void addFields(Collection<FieldDTO> fields){
		if(fields == null){
			fields = new ArrayList<FieldDTO>();
		}
		
		fields.addAll(fields);
	}
	
	/**
	 * Metodo que permite agregar un nuevo fieldGroup a la
	 * lista de fieldGroups configurados para el screen
	 * @param field Nuevo fieldGroup que tendrá el screen
	 */
	public void addField(FieldDTO field){
		if(fields == null){
			fields = new ArrayList<FieldDTO>();
		}
		
		fields.add(field);
	}
	
	/**
	 * Metodo que permite obtener el nombre del {@link FieldGroupDTO}
	 * @return El nombre solicitado
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Permite modificar el nombre del {@link FieldGroupDTO}
	 * @param name El nuevo nombre que tendrá el {@link FieldGroupDTO}
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Permite obtener el texto 'para mostrar' representativo del {@link FieldGroupDTO}
	 * @return El label asociado al {@link FieldGroupDTO}
	 */
	public String getLabel() {
		return label;
	}
	
	/**
	 * Permite modificar el label del {@link FieldGroupDTO}
	 * @param label El nuevo label que mostrará el {@link FieldGroupDTO}
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Permite obtener la prioridad de aparicion del {@link FieldGroupDTO}
	 * @return La prioridad del {@link FieldGroupDTO} configurada
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * Permite modifiacr la prioridad de aparicion del {@link FieldGroupDTO}
	 * @param priority La nueva prioridad de aparición
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * Permite obtener el screen al que pertenece el {@link FieldGroupDTO}
	 * @return El screen que tiene asociado el {@link FieldGroupDTO}
	 */
	public ScreenDTO getScreen() {
		return screen;
	}

	/**
	 * Permite modificar el screen al que pertenece el {@link FieldGroupDTO}
	 * @param screen El nuevo screen a relacionar
	 */
	public void setScreen(ScreenDTO screen) {
		this.screen = screen;
	}

	/**
	 * Metodo que permite obtener los campos que conforman al grupo
	 * @return La lista de campos relacionados al grupo
	 */
	public List<FieldDTO> getFields() {
		return fields;
	}

	/**
	 * Permite modificar la lista de campos que conforma al grupo
	 * @param fields Nueva lista de campos que conforman el grupo
	 */
	public void setFields(List<FieldDTO> fields) {
		this.fields = fields;
	}
	
	/**
	 * Permite determinar si el grupo es de caracter obligatorio
	 * @return True si es obligatorio, false de lo contrario
	 */
	public boolean isMandatory() {
		return mandatory;
	}

	/**
	 * Permite modicar la calidad obligatoria del grupo
	 * @param mandatory True si se desea que el grupo sea obligatorio, false de lo contrario
	 */
	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}

	/**
	 * Metodo que permite determinar si es un componente
	 * que agrupará a campos de entidades relacionadas
	 * @return TRUE si agrupará campos de entidades relacionadas
	 * FALSE de lo contrario
	 */
	public boolean isRelatedGroup() {
		return relatedGroup;
	}

	/**
	 * Metodo que modifica el hecho de agrupar campos
	 * de entidades relacionadas
	 * @param relatedGroup TRUE si se quiere que el componente 
	 * agrupe campos de otras entidades, FALSE de lo contrario
	 */
	public void setRelatedGroup(boolean relatedGroup) {
		this.relatedGroup = relatedGroup;
		
		if(this.relatedGroup){
			setLabel(RELATED_LABEL);
			setName(RELATED_LABEL);
			basicGroup = false;
		}
	}

	/**
	 * Metodo que permite determinar si es un componente
	 * que agrupará a campos fijos de la entidad
	 * @return TRUE si agrupará campos fijos de la entidad
	 * FALSE de lo contrario
	 */
	public boolean isBasicGroup() {
		return basicGroup;
	}

	/**
	 * Metodo que modifica el hecho de agrupar campos fijos de la entidad
	 * @param basicGroup TRUE si se quiere que el componente 
	 * agrupe campos fijos de la entidad, FALSE de lo contrario
	 */
	public void setBasicGroup(boolean basicGroup) {
		this.basicGroup = basicGroup;
		
		if(this.basicGroup){
			setLabel(BASIC_LABEL);
			setName(BASIC_LABEL);
			relatedGroup = false;
		}
	}

	/* (non-Javadoc)
	 * @see co.zero.common.dto.EntityDTO#toString()
	 */
	@Override
	public String toString() {
		StringBuilder aux = new StringBuilder(super.toString());
		aux.append("[name: " + getName());
		aux.append("][label: " + getLabel());
		aux.append("][priority: " + getPriority());
		aux.append("][mandatory: " + isMandatory());
		aux.append("][relatedGroup: " + isRelatedGroup());
		aux.append("][basicGroup: " + isBasicGroup() + "]");
		return aux.toString();
	}
}