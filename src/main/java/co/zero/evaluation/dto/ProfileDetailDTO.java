//=======================================================================
// ARCHIVO ProfileDetailDTO.java
// FECHA CREACIÓN: 9/05/2011
//=======================================================================
package co.zero.evaluation.dto;

import co.zero.common.dto.EntityDTO;

/**
 * Clase que permite relacionar de manera individual un {@link QualificationDTO}
 * con un {@link ProfileDTO}, estableciendo el valor mínimo esperado (Util en 360°)
 * @author Hernán Tenjo
 * @version 1.0
 */
public class ProfileDetailDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Valor mínino esperado para este competencia en este perfil
	private double minimum;
	//Perfil al que pertenece este detalle
	private ProfileDTO profile;
	//QualificationDTO para la que se establece el mínimo esperado
	private QualificationDTO qualification;
	
	/**
	 * Metodo que permite obtener el mínimo esperado del detalle
	 * @return El valor mínimo esperado en el perfil para el {@link QualificationDTO}
	 */
	public double getMinimum() {
		return minimum;
	}

	/**
	 * Método que permite modificar el mínimo esperado del detalle
	 * @param minimum El nuevo valor mínimo esperado del perfil
	 */
	public void setMinimum(double minimum) {
		this.minimum = minimum;
	}

	/**
	 * Método que permite obtener el perfil al que pertenece el detalle
	 * @return El perfil al que pertenece el detalle
	 */
	public ProfileDTO getProfile() {
		return profile;
	}

	/**
	 * Método que permite modificar el perfil al que pertenece el detalle
	 * @param profile El nuevo perfil al que será asociado el detalle
	 */
	public void setProfile(ProfileDTO profile) {
		this.profile = profile;
	}

	/**
	 * Método que permite obtener el {@link QualificationDTO} del detalle
	 * @return El {@link QualificationDTO} configurado para el detalle de perfil
	 */
	public QualificationDTO getQualification() {
		return qualification;
	}

	/**
	 * Método que permite modificar el {@link QualificationDTO} del detalle
	 * @param qualification El nuevo {@link QualificationDTO} al que será relacionado el detalle
	 */
	public void setQualification(QualificationDTO qualification){
		this.qualification = qualification;
	}
}