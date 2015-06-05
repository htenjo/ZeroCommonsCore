//=======================================================================
// ARCHIVO QuestionAttribute.java
// FECHA CREACIÓN: 2012/09/10
//=======================================================================
package co.zero.evaluation.enumeration;

import co.zero.common.enumeration.IEntityAttribute;
import co.zero.evaluation.dto.QuestionDTO;

/**
 * Enumeración que reune los nombres de los atributos de un {@link QuestionDTO},
 * para permitir un tratamiento dinámico a los atributos fijos
 * @author Hernán Tenjo
 * @version 1.0
 */
public enum QuestionAttribute implements IEntityAttribute{
	FIRST_LABEL(){
		/*
		 * (non-Javadoc)
		 * @see co.zero.evaluation.enumeration.QualificationAttribute#isRequired()
		 */
		public boolean isRequired(){
			return true;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.evaluation.enumeration.QualificationAttribute#getPriority()
		 */
		public int getPriority(){
			return 1;
		}
		
		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.IEntityAttribute#getIndex()
		 */
		@Override
		public int getIndex() {
			return 0;
		}
	},
	
	PRIORITY(){
		/*
		 * (non-Javadoc)
		 * @see co.zero.evaluation.enumeration.QualificationAttribute#isRequired()
		 */
		public boolean isRequired(){
			return false;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.evaluation.enumeration.QualificationAttribute#getPriority()
		 */
		public int getPriority(){
			return 2;
		}
		
		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.IEntityAttribute#getIndex()
		 */
		@Override
		public int getIndex() {
			return 1;
		}
	},
	
	HEADER(){
		/*
		 * (non-Javadoc)
		 * @see co.zero.evaluation.enumeration.QualificationAttribute#isRequired()
		 */
		public boolean isRequired(){
			return false;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.evaluation.enumeration.QualificationAttribute#getPriority()
		 */
		public int getPriority(){
			return 3;
		}
		
		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.IEntityAttribute#getIndex()
		 */
		@Override
		public int getIndex() {
			return 2;
		}
	},
	
	QUESTION_TYPE(){
		/*
		 * (non-Javadoc)
		 * @see co.zero.evaluation.enumeration.QualificationAttribute#isRequired()
		 */
		public boolean isRequired(){
			return true;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.evaluation.enumeration.QualificationAttribute#getPriority()
		 */
		public int getPriority(){
			return 4;
		}
		
		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.IEntityAttribute#getIndex()
		 */
		@Override
		public int getIndex() {
			return 3;
		}
	},
	
	SOCIODEMOGRAPHIC(){
		/*
		 * (non-Javadoc)
		 * @see co.zero.evaluation.enumeration.QualificationAttribute#isRequired()
		 */
		public boolean isRequired(){
			return false;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.evaluation.enumeration.QualificationAttribute#getPriority()
		 */
		public int getPriority(){
			return 5;
		}
		
		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.IEntityAttribute#getIndex()
		 */
		@Override
		public int getIndex() {
			return 4;
		}
	},
	
	QUALIFICATION(){
		/*
		 * (non-Javadoc)
		 * @see co.zero.evaluation.enumeration.QualificationAttribute#isRequired()
		 */
		public boolean isRequired(){
			return true;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.evaluation.enumeration.QualificationAttribute#getPriority()
		 */
		public int getPriority(){
			return 6;
		}
		
		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.IEntityAttribute#getIndex()
		 */
		@Override
		public int getIndex() {
			return 5;
		}
	};

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
		return QuestionDTO.class;
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
		IEntityAttribute[] attributes = QuestionAttribute.values();
		
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