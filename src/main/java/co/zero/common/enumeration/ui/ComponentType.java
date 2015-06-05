//=======================================================================
// ARCHIVO CompontentType.java
// FECHA CREACIÓN: 4/05/2010
//=======================================================================
package co.zero.common.enumeration.ui;

/**
 * Enumeración que reune los componentes de presentación soportados por 
 * Hcm. Un componente es la representación de un extrafield en un 
 * ambiente gráfico
 * @author Hernán Tenjo
 * @version 1.0
 */
public enum ComponentType{
	//Componente que permite capturar texto de una linea
	TEXT,
	//Igual que TEXT, pero con varias lineas
	TEXT_AREA,
	//Componente que oculta su contenido por seguridad
	SECRET,
	//Componente que validará el texto de entrada como email
	EMAIL,
	//Componente que validará el texto de entrada como numero entero
	NUMERIC,
	//Componente que permite recorrer enteros de forma secuencial 
	NUMERIC_SPINNER,
	//Componente que validará el texto de entrada como numero decimal
	DECIMAL,
	//Componente que permite recorrer decimales de forma secuencial
	DECIMAL_SPINNER,
	//Componente que permite la captura de fechas
	DATE,
	//Componente que permite capturar información binaria
	YES_NO,	
	//Componente que permite cargar y mostrar imagenes
	IMAGE,
	//Componente que permite cargar y mostrar otro tipo de archivos
	FILE,
	//Componente que permite mostrar un combo con opciones para seleccionar
	DROP_DOWN(){
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.ui.ComponentType#isSelectionComponent()
		 */
		@Override
		public boolean isSelectionComponent(){
			return true;
		}
	};
	
	/**
	 * Metodo que permite determinar si el componente presenta opciones de selección
	 * @return True si el componente tiene opciones de selección. False en caso contrario (Por defecto)
	 */
	public boolean isSelectionComponent(){
		return false;
	}
}