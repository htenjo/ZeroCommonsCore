//=======================================================================
// ARCHIVO EvaluationEntityAttributeFactory.java
// FECHA CREACIÓN: 2012/09/10
//=======================================================================
package co.zero.evaluation.util;

import java.util.HashMap;
import java.util.Map;

import co.zero.common.dto.EntityDTO;
import co.zero.common.enumeration.IEntityAttribute;
import co.zero.common.factory.EntityAttributeFactory;
import co.zero.evaluation.dto.QualificationDTO;
import co.zero.evaluation.dto.QuestionDTO;
import co.zero.evaluation.enumeration.QualificationAttribute;
import co.zero.evaluation.enumeration.QuestionAttribute;

/**
 * Clase que permite la creación de atributos de las entidades del módulo de Evaluaciones
 * @author Hernán Tenjo
 * @version 1.0
 */
public class EvaluationEntityAttributeFactory extends EntityAttributeFactory{
	//Identificador para la serialización
	private static final long serialVersionUID = 1L;
		
	@Override
	public IEntityAttribute[] buildAttributes(int entityIndex){
		switch (entityIndex) {
		case EVALUATION_QUALIFICATION_ENTITY:
			return QualificationAttribute.values();
		case EVALUATION_QUESTION_ENTITY:
			return QuestionAttribute.values();
		default:
			return null;
		}
	}
	
	@Override
	public Class<? extends EntityDTO> getEntityClass(int entityIndex){
		switch (entityIndex) {
		case EVALUATION_QUALIFICATION_ENTITY:
			return QualificationDTO.class;
		case EVALUATION_QUESTION_ENTITY:
			return QuestionDTO.class;
		default:
			return null;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see co.zero.common.factory.EntityAttributeFactory#getEntityAttribute(int, java.lang.String)
	 */
	@Override
	public IEntityAttribute getEntityAttribute(int entityIndex, String attributeName) {
		switch (entityIndex) {
		case EVALUATION_QUALIFICATION_ENTITY:
			return QualificationAttribute.valueOf(attributeName);
		case EVALUATION_QUESTION_ENTITY:
			return QuestionAttribute.valueOf(attributeName);
		default:
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see co.zero.common.factory.EntityAttributeFactory#buildEntityNamesWithIndexes()
	 */
	@Override
	public Map<String, Integer> buildEntityNamesWithIndexes() {
		Map<String, Integer> entityMap = new HashMap<String, Integer>();
		entityMap.put(QualificationDTO.class.getSimpleName(), EVALUATION_QUALIFICATION_ENTITY);
		entityMap.put(QuestionDTO.class.getSimpleName(), EVALUATION_QUESTION_ENTITY);
		return entityMap;
	}
}