//=======================================================================
// ARCHIVO ProfileDTO.java
// FECHA CREACIÓN: 9/05/2011
//=======================================================================
package co.zero.evaluation.dto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import co.zero.common.dto.EntityDTO;

/**
 * Clase que permite modelar la relación entre un {@link EvaluatedDTO} y
 * entre los múltiples {@link QualificationDTO} asociados
 * @author Hernán Tenjo
 * @version 1.0
 */
public class ProfileDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Evaluado al que será asociado el perfile. (Un evaluado por ahora
	//sólo podrá tener un único perfil, pero esto podría cambiar)
	private EvaluatedDTO evaluated;
	//Evaluación para la que se está construyendo el perfil
	private EvaluationDTO evaluation;
	//Mapa que relaciona 
	private Map<Long, ProfileDetailDTO> profileDetailMap = new LinkedHashMap<Long, ProfileDetailDTO>();
		
	/**
	 * Método que permite obtener el evaluado asociado al perfil
	 * @return El evaluado asociado al perfil
	 */
	public EvaluatedDTO getEvaluated() {
		return evaluated;
	}

	/**
	 * Método que permite moficiar el evalado asociado al perfil
	 * @param evaluated El nuevo evaluado que será asociado al perfil
	 */
	public void setEvaluated(EvaluatedDTO evaluated) {
		this.evaluated = evaluated;
	}

	/**
	 * Método que permite obtener la evaluación a la que pertenece el perfil
	 * @return La evaluación configurada a la que pertenece el perfil
	 */
	public EvaluationDTO getEvaluation() {
		return evaluation;
	}

	/**
	 * Método que permite modificar la evaluación a la que pertenece el perfil
	 * @param evaluation La nueva evaluación a la que pertenecerá el perfil
	 */
	public void setEvaluation(EvaluationDTO evaluation) {
		this.evaluation = evaluation;
	}

	/**
	 * Método que permite agregar un detalle al perfil
	 * @param profileDetail Objeto con la información del detalle del perfil
	 */
	public void addProfileDetail(ProfileDetailDTO profileDetail){
		if(profileDetailMap == null){
			profileDetailMap = new LinkedHashMap<Long, ProfileDetailDTO>();
		}
		
		profileDetail.setProfile(this);
		profileDetailMap.put(profileDetail.getQualification().getId(), profileDetail);		
	}
	
	/**
	 * Método que permite obtener la lista con el detalle del perfil
	 * @return El mapa con los detalles del perfil
	 */
	public Map<Long, ProfileDetailDTO> getProfileDetails() {
		return profileDetailMap;
	}

	/**
	 * Método que permite modificar los detalles del perfil
	 * @param profileDetailMap Map con los nuevos detalles del perfil
	 */
	public void setProfileDetails(Map<Long, ProfileDetailDTO> profileDetailMap) {
		this.profileDetailMap = profileDetailMap;
	}
	
	/**
	 * Método que permite modificar los detalles del perfil
	 * @param profileDetailList Lista con los nuevos detalles del perfil
	 */
	public void setProfileDetails(List<ProfileDetailDTO> profileDetailList) {
		this.profileDetailMap.clear();
		
		for(ProfileDetailDTO detailAux : profileDetailList){
			this.addProfileDetail(detailAux);	
		}
	}
}