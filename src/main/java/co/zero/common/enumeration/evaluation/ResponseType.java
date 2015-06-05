//=======================================================================
// ARCHIVO ResponseType.java
// FECHA CREACIÓN: 10/05/2011
//=======================================================================
package co.zero.common.enumeration.evaluation;

/**
 * Enumeración que reune los diferentes tipos de respuesta
 * contemplados en el sistema de evaluaciones
 * @author Hernán Tenjo
 * @version 1.0
 */
public enum ResponseType {
	//Preguntas de selección múltiple con única respuesta
	MULTIPLE_CHOICE_SINGLE_RESPONSE(){
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.ResponseType#isOpen()
		 */
		@Override
		public boolean isOpen() {
			return false;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.ResponseType#isSingleResponse()
		 */
		@Override
		public boolean isSingleResponse(){
			return true;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.ResponseType#isDynamicResponse()
		 */
		@Override
		public boolean isDynamicResponse(){
			return false;
		}
	},
	//Preguntas de selección múltiple con múltiple respuesta
	MULTIPLE_CHOICE_MULTIPLE_RESPONSE(){		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.ResponseType#isOpen()
		 */
		@Override
		public boolean isOpen() {
			return false;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.ResponseType#isSingleResponse()
		 */
		@Override
		public boolean isSingleResponse(){
			return false;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.ResponseType#isDynamicResponse()
		 */
		@Override
		public boolean isDynamicResponse(){
			return false;
		}
	},
	//Preguntas abiertas que contienen texto
	OPEN_TEXT_RESPONSE(){		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.ResponseType#isOpen()
		 */
		@Override
		public boolean isOpen() {
			return true;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.ResponseType#isSingleResponse()
		 */
		@Override
		public boolean isSingleResponse(){
			return false;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.ResponseType#isDynamicResponse()
		 */
		@Override
		public boolean isDynamicResponse(){
			return false;
		}
	},
	//Preguntas abiertas que contienen graficos (para dibujar)
	OPEN_GRAPHIC_RESPONSE(){
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.ResponseType#isOpen()
		 */
		@Override
		public boolean isOpen() {
			return true;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.ResponseType#isSingleResponse()
		 */
		@Override
		public boolean isSingleResponse(){
			return false;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.ResponseType#isDynamicResponse()
		 */
		@Override
		public boolean isDynamicResponse(){
			return false;
		}
	},
	//Tipo de pregunta para formar parejas entre multiples proposiciones
	PROPOSITION_MATCH_RESPONSE(){	
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.ResponseType#isOpen()
		 */
		@Override
		public boolean isOpen() {
			return false;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.ResponseType#isSingleResponse()
		 */
		@Override
		public boolean isSingleResponse(){
			return false;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.ResponseType#isDynamicResponse()
		 */
		@Override
		public boolean isDynamicResponse(){
			return false;
		}
	},
	//Tipo de respuesta en la que se tienen opciones generalmente
	//del tipo 3-0, 2-1, 1-2, 0-3
	IMPORTANCE_LEVEL_RESPONSE(){		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.ResponseType#isOpen()
		 */
		@Override
		public boolean isOpen() {
			return false;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.ResponseType#isSingleResponse()
		 */
		@Override
		public boolean isSingleResponse(){
			return false;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.ResponseType#isDynamicResponse()
		 */
		@Override
		public boolean isDynamicResponse(){
			return false;
		}
	},
	
	DYNAMIC_RESPONSE(){
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.ResponseType#isOpen()
		 */
		@Override
		public boolean isOpen() {
			return false;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.ResponseType#isSingleResponse()
		 */
		@Override
		public boolean isSingleResponse(){
			return false;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.ResponseType#isDynamicResponse()
		 */
		@Override
		public boolean isDynamicResponse(){
			return true;
		}
	};
	
	/**
	 * Metodo que permite determinar si la opcion de respuesta
	 * es de tipo abierta o si se tienen opciones de selección
	 */
	public abstract boolean isOpen();
	
	/**
	 * Método que permte determinar si la opción de respuesta
	 * presenta una única opción posible de respuesta
	 * @return True si la opción es de única respuesta, false de lo contrario
	 */
	public abstract boolean isSingleResponse();
	
	/**
	 * Método que permite determinar si la opción de respuesta 
	 * es de tipo dinámico (p.e. ingrese la información de personas dependientes)
	 * @return True si la opción es de tipo dinámico, false de lo contrario
	 */
	public abstract boolean isDynamicResponse();
}

