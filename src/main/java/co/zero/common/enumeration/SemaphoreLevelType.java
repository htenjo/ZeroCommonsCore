//=======================================================================
// ARCHIVO SemaphoreLevelType.java
// FECHA CREACIÓN: 12/01/2011
//=======================================================================
package co.zero.common.enumeration;

import co.zero.common.constant.GenericConstants;

/**
 * Enumeración que permite definir los niveles de aceptación para un indicador
 * dado (En principio para los KPIs)
 * 
 * @author Hernán Tenjo
 * @version 1.0
 */
public enum SemaphoreLevelType {
	// Indicador no alcanzado
	RED_LIGHT() {
		@Override
		public String getColor() {
			return GenericConstants.RED;
		}

		@Override
		public int getColorNumber() {
			return GenericConstants.RED_NUMBER;
		}
	},
	// Indicador con grandes dificultades
	ORANGE_LIGHT() {
		@Override
		public String getColor() {
			return GenericConstants.ORANGE;
		}

		@Override
		public int getColorNumber() {
			return GenericConstants.ORANGE_NUMBER;
		}
	},
	// Indicador alcanzado de forma parcial o con cosas por mejorar
	YELLOW_LIGHT() {
		@Override
		public String getColor() {
			return GenericConstants.YELLOW;
		}

		@Override
		public int getColorNumber() {
			return GenericConstants.YELLOW_NUMBER;
		}
	},
	// Indicador alcanzado de forma satisfactoria
	GREEN_LIGHT() {
		@Override
		public String getColor() {
			return GenericConstants.GREEN;
		}

		@Override
		public int getColorNumber() {
			return GenericConstants.GREEN_NUMBER;
		}
	},
	// Indicador que se ha alcanzado superando las espectativas
	BLUE_LIGHT() {
		@Override
		public String getColor() {
			return GenericConstants.BLUE;
		}

		@Override
		public int getColorNumber() {
			return GenericConstants.BLUE_NUMBER;
		}
	};

	/**
	 * Devuelve el nombre del color correspondiente
	 */
	public abstract String getColor();
	
	/**
	 * Retorna el numero del color del semaforo
	 * 
	 * @return
	 */
	public abstract int getColorNumber();

	/**
	 * Devuelve el semaforo correspondiente al color indicado
	 */
	public static SemaphoreLevelType getSemaphoreByColor(String color) {
		if (color.equals(GenericConstants.RED)) {
			return RED_LIGHT;
		} else if (color.equals(GenericConstants.ORANGE)) {
			return ORANGE_LIGHT;
		} else if (color.equals(GenericConstants.YELLOW)) {
			return YELLOW_LIGHT;
		} else if (color.equals(GenericConstants.GREEN)) {
			return GREEN_LIGHT;
		} else if (color.equals(GenericConstants.BLUE)) {
			return BLUE_LIGHT;
		}
		return RED_LIGHT;
	}

}