package co.zero.hcm.enumeration;

import java.io.Serializable;
import java.util.Map;
import java.util.Map.Entry;

import co.zero.common.enumeration.IEntityAttribute;

public class DefaultAttribute implements IEntityAttribute, Serializable {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 7759849050569990489L;
	
	private String fieldName;
	private Class<?> entity;
	private boolean required;
	private int priority;
	private int index;
	private Object[] options;
	private Class<?> type;
	private String name;
	
	
	public DefaultAttribute(String name,String fieldName, Class<?> entity,
			boolean required, int priority, int index, Object[] options) {
		this(name, fieldName, entity, required, priority, index,options,null);
		if (fieldName!=null){
			try {
				this.type = entity.getDeclaredField(fieldName).getType();
			} catch (NoSuchFieldException e) {
				try {
					this.type = entity.getSuperclass().getDeclaredField(fieldName).getType();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
			
		}
		
	}
	public DefaultAttribute(String name,String fieldName, Class<?> entity,
			boolean required, int priority, int index, Object[] options,Class<?> type) {
		this.name = name;
		this.fieldName = fieldName;
		this.entity = entity;
		this.required = required;
		this.priority = priority;
		this.index = index;
		this.options = options;
		this.type = type;
	}

	public DefaultAttribute(String name,String fieldName, Class<?> entity,
			boolean required, int priority, int index) {
		this(name, fieldName,  entity,
				 required,  priority,  index,(Object[])null);
	}
	
	public Integer position(Map<IEntityAttribute, Integer> mapa){
		for (Entry<IEntityAttribute, Integer> entry : mapa.entrySet()) {
			if (entry.getKey().toString().equals(toString())){
				return entry.getValue();
			}
		}
		
		return null;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public String getFieldName() {
		return fieldName;
	}

	@Override
	public Class<?> getEntity() {
		return entity;
	}

	@Override
	public boolean isRequired() {
		return required;
	}

	@Override
	public int getPriority() {
		return priority;
	}

	@Override
	public int getIndex() {
		return index;
	}

	@Override
	public boolean hasOptions() {
		return options!= null;
	}

	@Override
	public Object[] getOptions() {
		return options;
	}
	public Class<?> getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	@Override
	public String getEntityName() {
		return entity.getName();
	}

	@Override
	public String getEntitySimpleName() {
		return entity.getSimpleName();
	}

	@Override
	public IEntityAttribute getByIndex(int index) {
		return null;
	}

	@Override
	public String getAttributeName() {
		return name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj==null) return false;
		return obj.toString().equals(toString());
	}
}