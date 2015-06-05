package co.zero.hcm.enumeration;

import co.zero.hcm.dto.EmployeeLanguageDTO;

/**
 * Enumeración que reune los nombres de los atributos de un {@link EmployeeLanguageDTO},
 * para permitir un tratamiento dinámico a los atributos fijos
 * 
 * @author Carlos Ballesteros
 * @version 1.0
 */
public class EmployeeLanguageDescriptor extends EntityDescriptor{

	public static final DefaultAttribute DOCUMENT_NUMBER = new DefaultAttribute("DOCUMENT_NUMBER", null , EmployeeLanguageDTO.class, true, 1, 0,null,String.class);
	public static final DefaultAttribute NAME = new DefaultAttribute("NAME", "name" , EmployeeLanguageDTO.class, true, 2, 1);
	public static final DefaultAttribute READ_LEVEL = new DefaultAttribute("READ_LEVEL","readLevel", EmployeeLanguageDTO.class, true, 3, 2);
	public static final DefaultAttribute WRITE_LEVEL = new DefaultAttribute("WRITE_LEVEL","writeLevel", EmployeeLanguageDTO.class, true, 4, 3);
	public static final DefaultAttribute SPEAK_LEVEL = new DefaultAttribute("SPEAK_LEVEL","speakLevel", EmployeeLanguageDTO.class, true, 5, 4);

	private static EmployeeLanguageDescriptor singleton = new EmployeeLanguageDescriptor();
	
	public static EmployeeLanguageDescriptor getSingleton(){
		return singleton;
	}
	
	private EmployeeLanguageDescriptor() {
		super(EmployeeLanguageDTO.class);
		addAttribute(DOCUMENT_NUMBER);
		addAttribute(NAME);
		addAttribute(READ_LEVEL);
		addAttribute(WRITE_LEVEL);
		addAttribute(SPEAK_LEVEL);
	}

}
