package co.zero.kpi.enumaration;

import co.zero.common.enumeration.IEntityAttribute;
import co.zero.kpi.dto.KpiMetricPartialDTO;

/**
 * Enumeración que reune los atributos asociados a una métrica parcial
 * @author Hernan
 */
public enum KpiMetricPartialAttribute implements IEntityAttribute{
	NAME(){
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.IEntityAttribute#isRequired()
		 */
		public boolean isRequired(){
			return true;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.IEntityAttribute#getPriority()
		 */
		public int getPriority(){
			return 2;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.IEntityAttribute#getIndex()
		 */
		@Override
		public int getIndex() {
			return 1;
		}
	},
	
	DESCRIPTION(){
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.IEntityAttribute#isRequired()
		 */
		public boolean isRequired(){
			return false;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.IEntityAttribute#getPriority()
		 */
		public int getPriority(){
			return 3;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.IEntityAttribute#getIndex()
		 */
		@Override
		public int getIndex() {
			return 2;
		}
	},
	
	CONTINUOUS(){
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.IEntityAttribute#isRequired()
		 */
		public boolean isRequired(){
			return true;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.IEntityAttribute#getPriority()
		 */
		public int getPriority(){
			return 4;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.IEntityAttribute#getIndex()
		 */
		@Override
		public int getIndex() {
			return 3;
		}
	},
	
	VALUE_AS_DATE(){
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.IEntityAttribute#isRequired()
		 */
		public boolean isRequired(){
			return true;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.IEntityAttribute#getPriority()
		 */
		public int getPriority(){
			return 5;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.IEntityAttribute#getIndex()
		 */
		@Override
		public int getIndex() {
			return 4;
		}
	},
	
	UNIT_VALUE(){
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.IEntityAttribute#isRequired()
		 */
		public boolean isRequired(){
			return false;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.IEntityAttribute#getPriority()
		 */
		public int getPriority(){
			return 6;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.IEntityAttribute#getIndex()
		 */
		@Override
		public int getIndex() {
			return 5;
		}
	},
	UNIT_VALUE_SYMBOL(){
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.IEntityAttribute#isRequired()
		 */
		public boolean isRequired(){
			return false;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.IEntityAttribute#getPriority()
		 */
		public int getPriority(){
			return 7;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.IEntityAttribute#getIndex()
		 */
		@Override
		public int getIndex() {
			return 6;
		}
	},
	TREND(){
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.IEntityAttribute#isRequired()
		 */
		public boolean isRequired(){
			return true;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.IEntityAttribute#getPriority()
		 */
		public int getPriority(){
			return 8;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.IEntityAttribute#getIndex()
		 */
		@Override
		public int getIndex() {
			return 7;
		}
	}
	;
	
	/* (non-Javadoc)
	 * @see co.zero.common.enumeration.IEntityAttribute#getEntityName()
	 */
	@Override
	public String getEntityName() {
		return getEntity().getName();
	}
	
	/* (non-Javadoc)
	 * @see co.zero.common.enumeration.IEntityAttribute#getEntitySimpleName()
	 */
	@Override
	public String getEntitySimpleName() {
		return getEntity().getSimpleName();
	}
	
	/* (non-Javadoc)
	 * @see co.zero.common.enumeration.IEntityAttribute#getEntity()
	 */
	@Override
	public Class<?> getEntity() {
		return KpiMetricPartialDTO.class;
	}
	
	/* (non-Javadoc)
	 * @see co.zero.common.enumeration.IEntityAttribute#getAttributeName()
	 */
	@Override
	public String getAttributeName() {
		return this.toString();
	}

	/* (non-Javadoc)
	 * @see co.zero.common.enumeration.IEntityAttribute#getByIndex()
	 */
	@Override
	public IEntityAttribute getByIndex(int index) {
		IEntityAttribute[] attributes = KpiMetricPartialAttribute.values();
		
		for(IEntityAttribute attribute : attributes){
			if(attribute.getIndex() == index){
				return attribute;
			}
		}
		
		return null;
	}

	/* (non-Javadoc)
	 * @see co.zero.common.enumeration.IEntityAttribute#hasOptions()
	 */
	@Override
	public boolean hasOptions() {
		return false;
	}

	/* (non-Javadoc)
	 * @see co.zero.common.enumeration.IEntityAttribute#getOptions()
	 */
	@Override
	public Object[] getOptions() {
		return null;
	}
}
