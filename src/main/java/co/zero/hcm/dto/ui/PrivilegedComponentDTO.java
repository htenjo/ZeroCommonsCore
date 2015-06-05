//=======================================================================
// ARCHIVO PrivilegedComponent.java
// FECHA CREACIÓN: 12/04/2010
//=======================================================================
package co.zero.hcm.dto.ui;

import co.zero.common.dto.EntityDTO;
import co.zero.common.enumeration.ui.MenuType;
import co.zero.hcm.dto.PersistentEntityMetadataDTO;
import co.zero.hcm.dto.PrivilegeDTO;

/**
 * Clase que encapsulará los comportamientos requeridos para 
 * un componente que requiere privilegios (Generalmente un link o un boton)
 * @author Hernán Tenjo
 * @version 1.0
 */
public class PrivilegedComponentDTO extends EntityDTO{
	//Identificador requerido para el proceso de serializacion
	private static final long serialVersionUID = 1L;
	//Url que nos llevara a una ubicacion privilegiada
	private String url;
	//Url a la que se solicitará hacer operaciones privilegidas
	private String urlAction;
	//Origen del recurso requerido para mostrar el componente
	private String src;
	//==================	INICIO : URLs REQUERIDAS POR JSF 	====================
	//Url que nos llevara a una ubicacion privilegiada
	private String urlJsf;
	//Url a la que se solicitará hacer operaciones privilegidas
	private String urlActionJsf;
	//Origen del recurso requerido para mostrar el componente
	private String srcPathJsf;
	//==================	FIN :URLs REQUERIDAS POR JSF 	====================
	//En caso de no conocer el recurso, se muestra un texto relacionado
	private String alternativeText;
	//Cadena para mostrar, especialmente util con los links
	private String label;
	//Permiso asociado al componente
	private PrivilegeDTO privilege;
	//Determina si el componente se debe tratar como un menu
	private boolean menu;
	//Determina si el componente hace referencia a un formulario dinámico
	private boolean form;
	//En caso de tratarse de un componente que represente a un menu
	//Determina el tipo de menu a manejarse
	private MenuType menuType;
	//En caso de que se requiera un orden especifico en un grupo de componentes
	private int priority;
	//En caso de que el componente haga referencia a una entidad dinamica compleja,
	//este atributo establecerá la relación con esa entidad
	private PersistentEntityMetadataDTO persistentEM;
	
	/**
	 * Permite obtener la url del componente
	 * Esta URL generalmente se utiliza como link que permite
	 * llevarnos a una ubicacion privilegiada 
	 * @return La nueva url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Permite modificar la url del componente
	 * @param url  La nueva url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Permite obtener la url de acciones del componente
	 * Esta URL generalmente se utiliza para solicitar la 
	 * ejecucion de acciones privilegiadas
	 * @return the urlAction
	 */
	public String getUrlAction() {
		return urlAction;
	}

	/**
	 * Permite modificar la url de accion del componente
	 * @param urlAction La nueva url de accion del componente
	 */
	public void setUrlAction(String urlAction) {
		this.urlAction = urlAction;
	}

	/**
	 * Permite obtener la cadena que representa al recurso que 
	 * identificará al componente. Generalmente una url que apunte
	 * a un recurso como una imagen en el caso de los botones
	 * @return Ruta de destino del recurso
	 */
	public String getSrc() {
		return src;
	}

	/**
	 * Permit modificar el destion del recurso de representa al componente
	 * @param src El nuevo destino
	 */
	public void setSrc(String src) {
		this.src = src;
	}


	/**
	 * Permite obtener la url del componente
	 * Esta URL generalmente se utiliza como link que permite
	 * llevarnos a una ubicacion privilegiada 
	 * @return La nueva url
	 */
	public String getUrlJsf() {
		return urlJsf;
	}

	/**
	 * Permite modificar la url del componente
	 * @param url  La nueva url
	 */
	public void setUrlJsf(String urlJsf) {
		this.urlJsf = urlJsf;
	}

	/**
	 * Permite obtener la url de acciones del componente
	 * Esta URL generalmente se utiliza para solicitar la 
	 * ejecucion de acciones privilegiadas
	 * @return the urlAction
	 */
	public String getUrlActionJsf() {
		return urlActionJsf;
	}

	/**
	 * Permite modificar la url de accion del componente
	 * @param urlAction La nueva url de accion del componente
	 */
	public void setUrlActionJsf(String urlActionJsf) {
		this.urlActionJsf = urlActionJsf;
	}

	/**
	 * Permite obtener la cadena que representa al recurso que 
	 * identificará al componente. Generalmente una url que apunte
	 * a un recurso como una imagen en el caso de los botones
	 * @return Ruta de destino del recurso
	 */
	public String getSrcPathJsf() {
		return srcPathJsf;
	}

	/**
	 * Permit modificar el destion del recurso de representa al componente
	 * @param srcPath El nuevo destino
	 */
	public void setSrcPathJsf(String srcPathJsf) {
		this.srcPathJsf = srcPathJsf;
	}
	
	/**
	 * Permite obtener un texto que servirá como representación del 
	 * componente en caso que el srcPath no se encuentre disponible
	 * @return the alternativeText
	 */
	public String getAlternativeText() {
		return alternativeText;
	}

	/**
	 * Permite modificar el texto de representacion alternativo 
	 * @param alternativeText El nuevo texto a asignar
	 */
	public void setAlternativeText(String alternativeText) {
		this.alternativeText = alternativeText;
	}

	/**
	 * Permite obtener el label acompañante del componente
	 * Especialmente util en componentes tipo link  
	 * @return El label asociado al componente
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Permite modificar el label asociado al componente
	 * @param label El nuevo label del componente
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Permite obtener el privilegio asociado al componente
	 * @return El privilegio asociado
	 */
	public PrivilegeDTO getPrivilege() {
		return privilege;
	}

	/**
	 * Permite modificar el privilegio asociado al componente
	 * @param privilege El nuevo privilegio a asociar
	 */
	public void setPrivilege(PrivilegeDTO privilege) {
		this.privilege = privilege;
	}

	/**
	 * Permite obtener el tipo del menu que representa el componente
	 * en caso de ser uno
	 * @return El tipo del menu representado si es un menu, null de lo contrario
	 */
	public MenuType getMenuType() {
		return menuType;
	}

	/**
	 * Permite modificar el tipo de menu que representa el componente
	 * @param menuType El nuevo menu que representara el componente
	 */
	public void setMenuType(MenuType menuType) {
		this.menuType = menuType;
	}

	/**
	 * Permite determinar si el componente debe representar a un menu
	 * @return True si el componente debe representar a un menu, 
	 * 	false de lo contrario
	 */
	public boolean isMenu() {
		return menu;
	}

	/**
	 * Permite modificar si el componente debe representar a un menu
	 * @param menu True si se quiere que el componente represente a un menu,
	 * false de lo contrario
	 */
	public void setMenu(boolean menu) {
		this.menu = menu;
	}
	
	/**
	 * Metodo que permite obtener la prioridad del componente.
	 * @return La prioridad asignada al componente
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * Permite modificar la prioridad del componente
	 * @param priority La nueva prioridad del componente
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	/**
	 * Permite determinar si el componente debe hacer referencia a
	 * un formulario dinámico
	 * @return True si debe hacer referencia a un formulario, false de lo contrario
	 */
	public boolean isForm() {
		return form;
	}

	/**
	 * Permite modificar si el componente debe hacer referencia a
	 * un formulario dinámico
	 * @param form True si se quiere referenciar a un formulario, false de lo contrario
	 */
	public void setForm(boolean form) {
		this.form = form;
	}
	
	/**
	 * Permite obtener el {@link PersistentEntityMetadataDTO} asociados
	 * @return La entidad asociada si existe, null de lo contrario
	 */
	public PersistentEntityMetadataDTO getPersistentEM() {
		return persistentEM;
	}

	/**
	 * Permite modificar el {@link PersistentEntityMetadataDTO} asociado
	 * @param pem La nueva entidad con la que se desea asociar el componente
	 */
	public void setPersistentEM(PersistentEntityMetadataDTO pem) {
		this.persistentEM = pem;
	}
}