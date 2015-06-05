package co.zero.hcm.dto;


/**
 * Clase que define una plantilla de un mesaje
 *  
 * @author Youlyn Chinome
 */
public class EmailMessageTemplateDTO extends HcmEntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Nombre representativo de la plantilla
	private String messageName;
	//Asunto del mensaje
	private String subject;
	//Email desde el que se va enviar el mensaje
	private String fromEmail;
	//Nombre utilizado como remitente para enviar el mensaje
	private String fromName;
	//Mensaje del email
	private String message;
	//Indica si el mensaje va a personalizarse con etiquetas
	private boolean personalMessage;
	//Compania a la que pertenece la plantilla
	private CompanyDTO company;
	//Modulo al que pertence la plantilla
	private ModuleDTO module;
	
	/**
	 * Método que permite obtener el nombre representativo de la plantilla
	 * @return El nombre representativo de la plantilla
	 */
	public String getMessageName() {
		return messageName;
	}

	/**
	 * Metodo que permite modificar el nombre representativo de la plantilla
	 * @param messageName El nombre representativo de la plantilla
	 */
	public void setMessageName(String messageName) {
		this.messageName = messageName;
	}
	
	/**
	 * Método que permite obtener el asunto del mensaje
	 * @return El asunto del mensaje
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Metodo que permite modificar el asunto del mensaje
	 * @param subject El asunto del mensaje
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	/**
	 * Método que permite obtener el email desde el que se va a enviar el mensaje
	 * @return El email desde el que se va a enviar el mensaje
	 */
	public String getFromEmail() {
		return fromEmail;
	}

	/**
	 * Metodo que permite modificar el email desde el que se va a enviar el mensaje
	 * @param fromEmail El email desde el que se va a enviar el mensaje
	 */
	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}
	
	/**
	 * Metodo que permite obtener el nombre que se va a utilizar para como remitente para enviar el mensaje
	 * @return El nombre que se va a utilizar para como remitente para enviar el mensaje
	 */
	public String getFromName() {
		return fromName;
	}

	/**
	 * Metodo que permite modificar el nombre que se va a utilizar para como remitente para enviar el mensaje
	 * @param name El nuevo nombre que se va a utilizar para como remitente para enviar el mensaje
	 */
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	
	/**
	 * Método que obtiene el mensaje del email
	 * @return El mensaje del email
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Método que modifica el mensaje del email
	 * @param message El mensaje del email
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * Método que obtiene la compañía a la que pertenece la plantilla
	 * @return La compañía a la que pertenece la plantilla
	 */
	public CompanyDTO getCompany() {
		return company;
	}

	/**
	 * Metodo que modifica la compañía a la que pertenece la plantilla
	 * @param company La nueva compañía a la que pertenece la plantilla
	 */
	public void setCompany(CompanyDTO company) {
		this.company = company;
	}
	
	/**
	 * Método que obtiene el modulo al que pertenece la plantilla
	 * @return El modulo al que pertenece la plantilla
	 */
	public ModuleDTO getModule() {
		return module;
	}

	/**
	 * Metodo que modifica el modulo al que pertenece la plantilla
	 * @param module El nuevo modulo al que pertenece la plantilla
	 */
	public void setModule(ModuleDTO module) {
		this.module = module;
	}

	/**
	 * Metodo que obtiene la configuracion si el mensaje va a personalizarse con etiquetas
	 * @return
	 */
	public boolean isPersonalMessage() {
		return personalMessage;
	}

	/**
	 * Metodo que permite modificar si el mensaje va a personalizarse con etiquetas
	 * @param personalMessage
	 */
	public void setPersonalMessage(boolean personalMessage) {
		this.personalMessage = personalMessage;
	}
	
	/*
	 * (non-Javadoc)
	 * @see co.zero.common.dto.EntityDTO#toString()
	 */
	@Override
	public String toString() {
		long companyId = this.company == null ? 0 : this.company.getId();
		long moduleId = this.module == null ? 0 : this.module.getId();
		StringBuilder text = new StringBuilder(super.toString());
		text.append(" [messageName="+this.messageName+"]");
		text.append(" [subject="+this.subject+"]");
		text.append(" [fromEmail="+this.fromEmail+"]");
		text.append(" [fromName="+this.fromName+"]");
		text.append(" [message="+this.message+"]");
		text.append(" [personalMessage="+this.personalMessage+"]");
		text.append(" [companyId="+companyId+"]");
		text.append(" [moduleId="+moduleId+"]");
		return text.toString();
	}
	
}