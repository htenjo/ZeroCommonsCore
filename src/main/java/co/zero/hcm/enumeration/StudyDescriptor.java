package co.zero.hcm.enumeration;

import co.zero.hcm.dto.StudyDTO;

/**
 * Enumeración que reune los nombres de los atributos de un {@link StudyDTO},
 * para permitir un tratamiento dinámico a los atributos fijos
 * 
 * @author Carlos Ballesteros
 * @version 1.0
 */
public class StudyDescriptor extends EntityDescriptor{

	public static final DefaultAttribute DOCUMENT_NUMBER = new DefaultAttribute("DOCUMENT_NUMBER", null , StudyDTO.class, true, 1, 0,null,String.class);
	public static final DefaultAttribute NAME = new DefaultAttribute("NAME", "name" , StudyDTO.class, true, 2, 1);
	public static final DefaultAttribute DESCRIPTION = new DefaultAttribute("DESCRIPTION", "description" , StudyDTO.class, false, 3, 2);
	public static final DefaultAttribute START_DATE = new DefaultAttribute("START_DATE","startDate", StudyDTO.class, false, 4, 3);
	public static final DefaultAttribute END_DATE = new DefaultAttribute("END_DATE","endDate", StudyDTO.class, false, 5, 4);

	private static StudyDescriptor singleton = new StudyDescriptor();
	
	public static StudyDescriptor getSingleton(){
		return singleton;
	}
	
	private StudyDescriptor() {
		super(StudyDTO.class);
		addAttribute(DOCUMENT_NUMBER);
		addAttribute(NAME);
		addAttribute(DESCRIPTION);
		addAttribute(START_DATE);
		addAttribute(END_DATE);
	}

}
