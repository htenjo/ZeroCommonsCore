/**
 * 
 */
package co.zero.kpi.enumaration;

import co.zero.common.enumeration.IEntityAttribute;
import co.zero.kpi.dto.KpiGoalDTO;

/**
 * @author TOSHIBA
 *
 */
public enum KpiGoalAttribute implements IEntityAttribute{
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
			return 1;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.IEntityAttribute#getIndex()
		 */
		@Override
		public int getIndex() {
			return 0;
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
	CONTRIBUTE_WEIGHT(){
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
	CODE(){
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
	PARENT(){
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
	STRATEGY(){
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
		return KpiGoalDTO.class;
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
		IEntityAttribute[] attributes = KpiMetricGeneralAttribute.values();
		
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
