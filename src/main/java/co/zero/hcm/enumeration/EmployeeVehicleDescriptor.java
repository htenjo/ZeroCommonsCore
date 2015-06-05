package co.zero.hcm.enumeration;

import co.zero.hcm.dto.EmployeeVehicleDTO;

/**
 * Enumeración que reune los nombres de los atributos de un {@link EmployeeVehicleDTO},
 * para permitir un tratamiento dinámico a los atributos fijos
 * 
 * @author Carlos Ballesteros
 * @version 1.0
 */
public class EmployeeVehicleDescriptor extends EntityDescriptor{

	public static final DefaultAttribute DOCUMENT_NUMBER = new DefaultAttribute("DOCUMENT_NUMBER", null , EmployeeVehicleDTO.class, true, 1, 0,null,String.class);
	public static final DefaultAttribute LICENSE = new DefaultAttribute("LICENSE", "license" , EmployeeVehicleDTO.class, true, 2, 1);
	public static final DefaultAttribute MODEL = new DefaultAttribute("MODEL","model", EmployeeVehicleDTO.class, true, 3, 2);

	private static EmployeeVehicleDescriptor singleton = new EmployeeVehicleDescriptor();
	
	public static EmployeeVehicleDescriptor getSingleton(){
		return singleton;
	}
	
	private EmployeeVehicleDescriptor() {
		super(EmployeeVehicleDTO.class);
		addAttribute(DOCUMENT_NUMBER);
		addAttribute(LICENSE);
		addAttribute(MODEL);
	}

}
