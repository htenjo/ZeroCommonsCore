package co.zero.common.enumeration;

public enum RelativeType {
	// Representa la relacion de madre para un empleado
	MOTHER,
	// Representa la relacion de padre para un empleado
	FATHER,
	// Representa la relacion de hijo para un empleado
	SON,
	// Representa la relacion de esposa y/o esposo para un empleado
	SPOUSE,
	// Representa la relacion de hermano y/o hermana para un empleado
	BROTHER;
	
	/**
	 * Metodo que permite determinar si el relative presenta opciones de selección
	 * @return True si el relative tiene opciones de selección. False en caso contrario (Por defecto)
	 */
	public boolean isSelectionComponent(){
		return false;
	}
}