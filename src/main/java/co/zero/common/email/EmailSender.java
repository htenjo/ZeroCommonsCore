//=======================================================================
// ARCHIVO EmailSender.java
// FECHA CREACIÓN: 10/11/2008
//=======================================================================
package co.zero.common.email;

import java.io.UnsupportedEncodingException;
import java.security.Security;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.lang.StringUtils;

/**
 * EmailSender es una clase que encapsula la configuración requerida para el envío de un email 
 * @author Hernán Tenjo
 * @version 1.0
 */
public class EmailSender {
	public static final String MAIL_USER = "mail.user";
	public static final String MAIL_PASSWORD = "mail.password";
	public static final String MAIL_HOST = "mail.smtp.host";
	public static final String MAIL_PORT = "mail.smtp.port";
	public static final String MAIL_AUTHENTICATION = "mail.smtp.auth";
	
//	private static final String FILE_ENCODING = "file.encoding";
//	private static final String DEFAULT_ENCODING = "iso-8859-1";
	private static final String MIME_TYPE_HTML = "text/html; charset=UTF-8";
	private static final String DEFAULT_ENCODING = "UTF-8";

	private Properties properties;
	private boolean debugMode;
	private String fromEmail;
	private String fromName;
	private String subject;
	private String textMessage;
	private String htmlMessage;
	private Map< String, DataHandler> fields;
	
	/**
	 * Bloque que agrega el proveedor ssl requerido para establecer la comunicacion
	 */
	static{
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
	}
	
	/**
	 * Metodo constructor que recibe un Properties el cual debe
	 * tener todos los parametros de configuracion requeridos para enviar un email.<br>
	 * @param properties Objeto con la información requerida
	 */
	public EmailSender(){
//		this.properties = properties;
//		this.properties.setProperty(FILE_ENCODING, DEFAULT_ENCODING);
//		System.getProperties().put(FILE_ENCODING, DEFAULT_ENCODING);
	}
	
	/**
	 * Metodo que permite enviar un correo electronico por medio de un
	 * servidor que requiera una conexion ssl (Como gmail)
	 * Propiedades requeridas:<br>
	 * - mail.smtp.host : Nombre del servidor de correo electrónico desde donde se enviarán los correos<br>
	 * - mail.smtp.auth : Valor booleano que determina si el servidor requiere autenticación<br>
	 * - mail.debug: Valor booleano que determina si se muestra informacion de debug<br> 
	 * - mail.smtp.port: Puerto por el que se hará la conexión con el servidor de correo<br>
	 * - mail.smtp.socketFactory.port: Puerto que utilizará la fábrica para establecer la conexión<br>
	 * - mail.smtp.socketFactory.class: Nombre de la clase de la fábrica que se utilizará<br>
	 * - mail.smtp.socketFactory.fallback: Valor booleano (False)<br>
	 * - mail.user: usuario con el que se autenticará ante el servidor de correo<br>
	 * - mail.password: Clave de acceso al servidor de correo  <br><br>
	 * @param to Lista con los correos electrónicos de los destinatarios
	 * @param from Correo electrónico del que se enviarán los correos
	 * @param subject Descripción del contenido del correo
	 * @param htmlMessage Cadena con el mensaje del correo en formato html 
	 * @param textMessage Cadena con el mensaje del correo el formato de texto plano.
	 * 					  Esto en caso de que el servidor de correo del cliente no 
	 * 					  acepte formato html para los correos
	 * @throws MessagingException Si existe un error en la configuracion (Error en los parametros)
	 * @throws UnsupportedEncodingException 
	 */
	public void sendSSLMessage(List<String> to, String from, String fromName, String subject,
			String htmlMessage, String textMessage) throws MessagingException, UnsupportedEncodingException{
		
		MimeMultipart content = new MimeMultipart();		
		InternetAddress[] addressTo = new InternetAddress[to.size()];
		InternetAddress fromAddress = new InternetAddress(from, fromName);
//		MimeBodyPart text = new MimeBodyPart();
		MimeBodyPart html = new MimeBodyPart();
		
		Session session = Session.getDefaultInstance(properties,
			new Authenticator() {	
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(properties.getProperty(MAIL_USER), 
						properties.getProperty(MAIL_PASSWORD));
				}
			});
		
		session.setDebug(debugMode);	
		MimeMessage message = new MimeMessage(session);		
		message.setFrom(fromAddress);
		
		for (int i = 0; i < to.size(); i++) {
			addressTo[i] = new InternetAddress(to.get(i));
		}
		
		message.setRecipients(Message.RecipientType.TO, addressTo);
		message.setSubject(subject, DEFAULT_ENCODING);
		html.setContent(htmlMessage, MIME_TYPE_HTML);
//		content.addBodyPart(text);
		content.addBodyPart(html);
		message.setContent(content);
		message.addHeaderLine("X-SMTPAPI: {\"category\": \"Cbre\"}");
		Transport.send(message);
	}
	
	/**
	 * Metodo que permite enviar un correo electronico por medio de un
	 * servidor que requiera una conexion ssl (Como gmail)
	 * Propiedades requeridas:<br>
	 * - mail.user: usuario con el que se autenticará ante el servidor de correo<br>
	 * - mail.password: Clave de acceso al servidor de correo  <br>
	 * - mail.smtp.host : Nombre del servidor de correo electrónico desde donde se enviarán los correos<br>
	 * - mail.debug: Valor booleano que determina si se muestra informacion de debug<br>
	 * - mail.smtp.auth : Valor booleano que determina si el servidor requiere autenticacion<br>  
	 * - mail.smtp.port: Puerto por el que se hará la conexión con el servidor de correo<br>
	 * - mail.smtp.socketFactory.port: Puerto que utilizará la fábrica para establecer la conexión<br>
	 * - mail.smtp.socketFactory.class: Nombre de la clase de la fábrica que se utilizará<br>
	 * - mail.smtp.socketFactory.fallback: Valor booleano (False)<br><br>
	 * @param to Lista con los correos electrónicos de los destinatarios
	 * @param fromEmail Correo electrónico del que se enviarán los correos
	 * @param fromName
	 * @param subject Descripción del contenido del correo
	 * @param htmlMessage Cadena con el mensaje del correo en formato html 
	 * @param textMessage Cadena con el mensaje del correo el formato de texto plano.
	 * 					  Esto en caso de que el servidor de correo del cliente no 
	 * 					  acepte formato html para los correos
	 * @throws MessagingException Si existe un error en la configuracion (Error en los parametros)
	 * @throws UnsupportedEncodingException 
	 */
	public void sendSimpleMessage(List<String> to, String fromEmail, String fromName, String subject,
			String htmlMessage, String textMessage, List<String> ccTo, List<String> bccTo, 
			Map<String, DataHandler> attachments, Session mailSession) throws MessagingException{
		try{
			MimeMultipart content = new MimeMultipart();		
			InternetAddress[] addressTo = to != null ? new InternetAddress[to.size()] : null;
			InternetAddress[] addressToCC = ccTo != null ? new InternetAddress[ccTo.size()] : null;
			InternetAddress[] addressToBCC = bccTo != null ? new InternetAddress[bccTo.size()] : null;
			InternetAddress fromAddress = new InternetAddress(fromEmail, fromName,DEFAULT_ENCODING);
			MimeBodyPart html = new MimeBodyPart();
			MimeBodyPart archive;
				
			MimeMessage message = new MimeMessage(mailSession);		
			message.setFrom(fromAddress);
			
			for (int i = 0; to != null && i < to.size(); i++) {
				addressTo[i] = new InternetAddress(to.get(i));
			}

			for (int i = 0; ccTo != null && i < ccTo.size(); i++) {
				addressToCC[i] = new InternetAddress(ccTo.get(i));
			}
			
			for (int i = 0; bccTo != null && i < bccTo.size(); i++) {
				addressToBCC[i] = new InternetAddress(bccTo.get(i));
			}
			
			message.setRecipients(Message.RecipientType.TO, addressTo);
			message.setRecipients(Message.RecipientType.CC, addressToCC);
			message.setRecipients(Message.RecipientType.BCC, addressToBCC);
			message.setSubject(subject, DEFAULT_ENCODING);
			html.setContent(htmlMessage, MIME_TYPE_HTML);
			content.addBodyPart(html);
			
			if(attachments != null && !attachments.isEmpty()){
				for(String key : attachments.keySet()){
					archive = new MimeBodyPart();
					archive.setDataHandler(attachments.get(key));
					archive.setFileName(key);
					content.addBodyPart(archive);
				}	
			}
			
			message.setContent(content);
			Transport.send(message);
		}catch (UnsupportedEncodingException e) {
			throw new MessagingException("::: Problemas al crear en from en EmailSender", e);
		}
	}
	
	/**
	 * Metodo que permite enviar un mensaje cuyos valores han sido previamente configurados
	 * @param to Lista de las personas a las que le será enviado el correo
	 * @throws MessagingException
	 */
	public void sendSimpleMessage(List<String> to, Session mailSession) throws MessagingException{
		if(to == null || to.isEmpty() || StringUtils.isBlank(fromEmail)
				|| StringUtils.isBlank(fromName) || StringUtils.isBlank(subject)
				|| (StringUtils.isBlank(htmlMessage) && StringUtils.isBlank(textMessage))){
			throw new MessagingException("::: Alguno de los parámetros del correo se encuentra vacio");
		}
			
		sendSimpleMessage(to, fromEmail, fromName, subject, htmlMessage, textMessage, null, null, fields, mailSession);
	}
		
	/**
	 * Método que permite obtener el email que figura como "From" del correo
	 * @return El email que aparecerá en el "From" del correo
	 */
	public String getFromEmail() {
		return fromEmail;
	}

	/**
	 * Método que permite modificar el "From" del correo
	 * @param fromEmail El nuevo email para el "From"
	 */
	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}

	/**
	 * Método que permite obtener el nombre del From del correo
	 * @return El nombre del From del correo 
	 */
	public String getFromName() {
		return fromName;
	}

	/**
	 * Método que permite modificar el nombre del From del correo
	 * @param fromName El nuevo nombre del From del correo
	 */
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	/**
	 * Método que permite obtener el asunto del email
	 * @return El asunto del email
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Método que permite modificar el asunto del email
	 * @param subject El nuevo asunto del email
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * Método que permite obtener el mensaje en formato de texto plano
	 * @return El texto del mensaje que se desea enviar
	 */
	public String getTextMessage() {
		return textMessage;
	}

	/**
	 * Método que permite modificar el mensaje en formato de texto plano
	 * @param textMessage El nuevo texto plano que será enviado como mensaje del email
	 */
	public void setTextMessage(String textMessage) {
		this.textMessage = textMessage;
	}

	/**
	 * Método que permite obtener el mensaje en formato Html
	 * @return El texto del mensaje que se desea enviar
	 */
	public String getHtmlMessage() {
		return htmlMessage;
	}

	/**
	 * Método que permite modificar el mensaje en formato Html
	 * @param htmlMessage EL nuevo html que será enviado como mensaje del email
	 */
	public void setHtmlMessage(String htmlMessage) {
		this.htmlMessage = htmlMessage;
	}

	/**
	 * Método que permite obtener las propiedades de configuración del email
	 * @return Objeto que contiene las propiedades de configuaración del email
	 */
	public Properties getProperties() {
		return properties;
	}

	/**
	 * Método que permite modificar las propiedades de configuración del email
	 * @param properties Objeto con las nuevas propiedades de configuración del email
	 */
	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	/**
	 * Método que determina si se debe hacer seguimiento al proceso de envio del correo
	 * @return True si se desea hacer seguimiento al envio del correo, False de lo contrario
	 */
	public boolean isDebugMode() {
		return debugMode;
	}

	/**
	 * Método que permite modificar el monitoreo del proceso de envío de correos
	 * @param debugMode True si se desea hacer seguimiento, false de lo contrario
	 */
	public void setDebugMode(boolean debugMode) {
		this.debugMode = debugMode;
	}
}