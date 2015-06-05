//=======================================================================
// ARCHIVO TrackingSelectionValueType.java
// FECHA CREACIÓN: 25/07/2011
//=======================================================================
package co.zero.common.enumeration.kpi;


/**
 * Descripción de la clase
 * @author Hernán Tenjo
 * @version 1.0
 */
public enum TrackingGeneralFormulaType {
	
	/**
	 * El valor final del objetivo será el reflejo de los valores
	 * alcanzados por todos los objetivos dependientes de este, según
	 * la lógica implementada por las expresiones.
	 */
	CALCULATED_FROM_CHILDREN(){
		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.bsc.TrackingSelectionValueType#isAssigned()
		 */
		@Override
		public boolean isAssigned() {
			return false;
		}
	},
	
	/**
	 * El valor final del objetivo será calculado con base en los 
	 * valores alcanzados por el objetivo en cada uno de los periodos
	 * evaluados de forma parcial
	 */
	ASSIGNED_BY_PARTIALS(){
		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.bsc.TrackingSelectionValueType#isAssigned()
		 */
		@Override
		public boolean isAssigned() {
			return true;
		}
	},
	
	/**
	 * El valor final del objetivo será tomado directamente del 
	 * usuario que esté realizando la evalución
	 */
	ASSIGNED_DIRECTLY(){
		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.bsc.TrackingSelectionValueType#isAssigned()
		 */
		@Override
		public boolean isAssigned() {
			return true;
		}
	};
	
	/**
	 * Método que permite determinar si la forma para obtener
	 * el valor final del objetivo es asignada o calculada con base 
	 * en los hijos del objetivo
	 * @return True si la forma para obtener el valor final del objetivo
	 * es asignada, false si es calculada.
	 */
	public abstract boolean isAssigned();
}