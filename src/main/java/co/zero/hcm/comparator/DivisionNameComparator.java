//=======================================================================
// ARCHIVO GenericIdComparator.java
// FECHA CREACIÓN: 07/09/2010
//=======================================================================
package co.zero.hcm.comparator;

import java.util.Comparator;

import co.zero.hcm.dto.DivisionDTO;

/**
 * Clase que permite comparar dos {@link DivisionDTO}, tomando como
 * punto de comparación el nombre
 * @author Hernan
 * @version 1.0
 */
public class DivisionNameComparator implements Comparator<DivisionDTO> {
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(DivisionDTO division1, DivisionDTO division2) {
		return division1.getName().compareToIgnoreCase(division2.getName());
	}
}
