//=======================================================================
// ARCHIVO HcmConstant.java
// FECHA CREACIÓN: 21/01/2010
//=======================================================================
package co.zero.hcm.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que reune las constantes utilizadas en Hcm
 * @author Hernán Tenjo
 * @version 1.0
 */
public class HcmConstant {
	
	//Id de las entidades que se pueden configurar inicialmente para el wizard
	public static final List<Long> ID_ENTITY_FOR_WIZARD = new ArrayList<Long>();
	static {
		ID_ENTITY_FOR_WIZARD.add(6L);
		ID_ENTITY_FOR_WIZARD.add(7L);
		ID_ENTITY_FOR_WIZARD.add(8L);
		ID_ENTITY_FOR_WIZARD.add(9L);
		ID_ENTITY_FOR_WIZARD.add(10L);
		ID_ENTITY_FOR_WIZARD.add(11L);
		ID_ENTITY_FOR_WIZARD.add(12L);
	}
	
	//Crear empleado
	public static final long ID_PRIVILEGE_CREATE_EMPLOYEE = 48L;
	//Modificar mi info
	public static final long ID_PRIVILEGE_MY_INFO = 55L;
	
	//Lista de los id de los privilegios que se pueden configurar para el wizard
	public static final List<Long> ID_PRIVILEGE_FOR_WIZARD = new ArrayList<Long>();
	static {
		ID_PRIVILEGE_FOR_WIZARD.add(ID_PRIVILEGE_CREATE_EMPLOYEE);
		ID_PRIVILEGE_FOR_WIZARD.add(ID_PRIVILEGE_MY_INFO);
	}
	
}

