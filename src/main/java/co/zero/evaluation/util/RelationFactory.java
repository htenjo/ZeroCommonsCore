//=======================================================================
// ARCHIVO RelationFactory.java
// FECHA CREACIÓN: 09/02/2012
//=======================================================================
package co.zero.evaluation.util;

import org.apache.commons.lang.StringUtils;

import co.zero.common.enumeration.evaluation.ThreesixtyRelationType;
import co.zero.evaluation.constant.EvaluationsConstant;
import co.zero.evaluation.exception.EvaluationException;

/**
 * Clase que permite la fabricación de las relaciones por diferentes conceptos
 * @author Hernán Tenjo
 * @version 1.0
 */
public class RelationFactory {
	/**
	 * Método que permite construir una {@link ThreesixtyRelationType} conociendo su nombre
	 * @param name Representación como cadena de la relación
	 * @return La relación si existe
	 * @throws EvaluationException Si la relación procesada no es soportada
	 */
	public static ThreesixtyRelationType buildFromName(String name) throws EvaluationException{
		if(StringUtils.equals(name, ThreesixtyRelationType.SELF.toString()) 
				|| StringUtils.equals(name, EvaluationsConstant.RELATION_SELF_SPANISH)){
			return ThreesixtyRelationType.SELF;
		}else if(StringUtils.equals(name, ThreesixtyRelationType.BOSS.toString()) 
				|| StringUtils.equals(name, EvaluationsConstant.RELATION_BOSS_SPANISH)){
			return ThreesixtyRelationType.BOSS;
		}else if(StringUtils.equals(name, ThreesixtyRelationType.COLLEAGUE.toString()) 
				|| StringUtils.equals(name, EvaluationsConstant.RELATION_COLLEAGUE_SPANISH)){
			return ThreesixtyRelationType.COLLEAGUE;
		}else if(StringUtils.equals(name, ThreesixtyRelationType.COLLABORATOR.toString()) 
				|| StringUtils.equals(name, EvaluationsConstant.RELATION_COLLABORATOR_SPANISH)){
			return ThreesixtyRelationType.COLLABORATOR;
		}else if(StringUtils.equals(name, ThreesixtyRelationType.CLIENT_INTERNAL.toString()) 
				|| StringUtils.equals(name, EvaluationsConstant.RELATION_INTERNAL_CLIENT_SPANISH)){
			return ThreesixtyRelationType.CLIENT_INTERNAL;
		}else if(StringUtils.equals(name, ThreesixtyRelationType.CLIENT_EXTERNAL.toString()) 
				|| StringUtils.equals(name, EvaluationsConstant.RELATION_EXTERNAL_CLIENT_SPANISH)){
			return ThreesixtyRelationType.CLIENT_EXTERNAL;
		}else if(StringUtils.equals(name, ThreesixtyRelationType.SUPPLIER.toString()) 
				|| StringUtils.equals(name, EvaluationsConstant.RELATION_SUPPLIER_SPANISH)){
			return ThreesixtyRelationType.SUPPLIER;
		}else if(StringUtils.equals(name, ThreesixtyRelationType.SUPERVISOR.toString()) 
				|| StringUtils.equals(name, EvaluationsConstant.RELATION_SUPERVISOR_SPANISH)){
			return ThreesixtyRelationType.SUPERVISOR;
		}else if(StringUtils.equals(name, ThreesixtyRelationType.OBSERVER.toString()) 
				|| StringUtils.equals(name, EvaluationsConstant.RELATION_OBSERVER_SPANISH)){
			return ThreesixtyRelationType.OBSERVER;
		}else{
			throw new EvaluationException(EvaluationException.RELATION_TYPE_NOT_SUPPORTED, name);
		}
	}
}