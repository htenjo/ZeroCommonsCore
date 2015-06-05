//=======================================================================
// ARCHIVO FieldGroupPriorityComparator.java
// FECHA CREACIÓN: 15/07/2010
//=======================================================================
package co.zero.hcm.comparator;

import java.util.Comparator;

import co.zero.hcm.dto.ui.FieldDTO;

/**
 * Clase que permite comparar dos {@link FieldDTO}, tomando como
 * punto de comparación la prioridad asociada
 * @author Hernan
 * @version 1.0
 */
public class FieldPriorityComparator implements Comparator<FieldDTO> {
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(FieldDTO field1, FieldDTO field2) {
		if(field1.getPriority() > field2.getPriority()){
			return -1;
		}else if(field1.getPriority() < field2.getPriority()){
			return 1;
		}else{
			return 0;
		}
	}
}
