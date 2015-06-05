package co.zero.hcm.enumeration;

import java.util.ArrayList;
import java.util.List;

import co.zero.common.enumeration.IEntityAttribute;


/**
 * Clase generica que representa una entidad, construida para poder definir y recorrer de forma dinamica 
 * los campos de entidades en los cargadores masivos.
 * @author david
 *
 */
public abstract class EntityDescriptor {

	private List<DefaultAttribute> attributes = new ArrayList<DefaultAttribute>();
	private Class<?> entity;
	public EntityDescriptor(Class<?> entity) {
		this.entity = entity;
	}
	
	public void addAttribute(DefaultAttribute attribute){
		attributes.add(attribute);
	}

	public IEntityAttribute[] getAttributes() {
		IEntityAttribute[] res = new IEntityAttribute[attributes.size()];
		for (int i = 0; i < attributes.size(); i++) {
			res[i] = attributes.get(i);
		}
		return res;
	}

	public Class<?> getEntity() {
		return entity;
	}

	public DefaultAttribute getAttribute(String name){
		for (DefaultAttribute att : attributes) {
			if (att.getAttributeName().equals(name)){
				return att;
			}
		}
		return null;
	}
	
}
