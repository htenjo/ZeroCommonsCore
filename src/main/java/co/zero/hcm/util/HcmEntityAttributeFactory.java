//=======================================================================
// ARCHIVO EvaluationEntityAttributeFactory.java
// FECHA CREACIÓN: 2012/09/10
//=======================================================================
package co.zero.hcm.util;

import java.util.HashMap;
import java.util.Map;

import co.zero.common.dto.EntityDTO;
import co.zero.common.enumeration.IEntityAttribute;
import co.zero.common.factory.EntityAttributeFactory;
import co.zero.hcm.dto.DivisionDTO;
import co.zero.hcm.dto.EmployeeDTO;
import co.zero.hcm.dto.EmployeeExperienceDTO;
import co.zero.hcm.dto.EmployeeLanguageDTO;
import co.zero.hcm.dto.EmployeeVehicleDTO;
import co.zero.hcm.dto.JobDTO;
import co.zero.hcm.dto.RelativeDTO;
import co.zero.hcm.dto.StudyDTO;
import co.zero.hcm.enumeration.DivisionAttribute;
import co.zero.hcm.enumeration.EmployeeAttribute;
import co.zero.hcm.enumeration.EmployeeExperienceDescriptor;
import co.zero.hcm.enumeration.EmployeeLanguageDescriptor;
import co.zero.hcm.enumeration.EmployeeVehicleDescriptor;
import co.zero.hcm.enumeration.JobAttribute;
import co.zero.hcm.enumeration.RelativeDescriptor;
import co.zero.hcm.enumeration.StudyDescriptor;

/**
 * Clase que permite la creación de atributos de las entidades del módulo de Hcm
 * @author Hernán Tenjo
 * @version 1.0
 */
public class HcmEntityAttributeFactory extends EntityAttributeFactory{
	//Identificador para la serialización
	private static final long serialVersionUID = 1L;
		
	@Override
	public IEntityAttribute[] buildAttributes(int entityIndex){
		switch (entityIndex) {
		case HCM_DIVISION_ENTITY:
			return DivisionAttribute.values();
		case HCM_JOB_ENTITY:
			return JobAttribute.values();
		case HCM_EMPLOYEE_ENTITY:
			return EmployeeAttribute.values();
		case HCM_EMPLOYEE_EXPERIENCE_ENTITY:
			return EmployeeExperienceDescriptor.getSingleton().getAttributes();
		case HCM_EMPLOYEE_LANGUAGE_ENTITY:
			return EmployeeLanguageDescriptor.getSingleton().getAttributes();
		case HCM_EMPLOYEE_VEHICLE_ENTITY:
			return EmployeeVehicleDescriptor.getSingleton().getAttributes();
		case HCM_EMPLOYEE_STUDY_ENTITY:
			return StudyDescriptor.getSingleton().getAttributes();
		case HCM_EMPLOYEE_RELATIVE_ENTITY:
			return RelativeDescriptor.getSingleton().getAttributes();
		default:
			return null;
		}
	}
	
	@Override
	public Class<? extends EntityDTO> getEntityClass(int entityIndex){
		switch (entityIndex) {
		case HCM_DIVISION_ENTITY:
			return DivisionDTO.class;
		case HCM_JOB_ENTITY:
			return JobDTO.class;
		case HCM_EMPLOYEE_ENTITY:
			return EmployeeDTO.class;
		case HCM_EMPLOYEE_EXPERIENCE_ENTITY:
			return EmployeeExperienceDTO.class;
		case HCM_EMPLOYEE_LANGUAGE_ENTITY:
			return EmployeeLanguageDTO.class;
		case HCM_EMPLOYEE_VEHICLE_ENTITY:
			return EmployeeVehicleDTO.class;
		case HCM_EMPLOYEE_STUDY_ENTITY:
			return StudyDTO.class;
		case HCM_EMPLOYEE_RELATIVE_ENTITY:
			return RelativeDTO.class;
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
		case HCM_DIVISION_ENTITY:
			return DivisionAttribute.valueOf(attributeName);
		case HCM_JOB_ENTITY:
			return JobAttribute.valueOf(attributeName);
		case HCM_EMPLOYEE_ENTITY:
			return EmployeeAttribute.valueOf(attributeName);
		case HCM_EMPLOYEE_EXPERIENCE_ENTITY:
			return EmployeeExperienceDescriptor.getSingleton().getAttribute(attributeName);
		case HCM_EMPLOYEE_LANGUAGE_ENTITY:
			return EmployeeLanguageDescriptor.getSingleton().getAttribute(attributeName);
		case HCM_EMPLOYEE_VEHICLE_ENTITY:
			return EmployeeVehicleDescriptor.getSingleton().getAttribute(attributeName);
		case HCM_EMPLOYEE_STUDY_ENTITY:
			return StudyDescriptor.getSingleton().getAttribute(attributeName);
		case HCM_EMPLOYEE_RELATIVE_ENTITY:
			return RelativeDescriptor.getSingleton().getAttribute(attributeName);
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
		entityMap.put(DivisionDTO.class.getSimpleName(), HCM_DIVISION_ENTITY);
		entityMap.put(JobDTO.class.getSimpleName(), HCM_JOB_ENTITY);
		entityMap.put(EmployeeDTO.class.getSimpleName(), HCM_EMPLOYEE_ENTITY);
		entityMap.put(EmployeeExperienceDTO.class.getSimpleName(), HCM_EMPLOYEE_EXPERIENCE_ENTITY);
		entityMap.put(EmployeeLanguageDTO.class.getSimpleName(), HCM_EMPLOYEE_LANGUAGE_ENTITY);
		entityMap.put(EmployeeVehicleDTO.class.getSimpleName(), HCM_EMPLOYEE_VEHICLE_ENTITY);
		entityMap.put(StudyDTO.class.getSimpleName(), HCM_EMPLOYEE_STUDY_ENTITY);
		entityMap.put(RelativeDTO.class.getSimpleName(), HCM_EMPLOYEE_RELATIVE_ENTITY);
		return entityMap;
	}
}