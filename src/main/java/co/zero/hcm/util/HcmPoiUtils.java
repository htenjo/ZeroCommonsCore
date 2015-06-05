//=======================================================================
// ARCHIVO HcmPoiUtils.java
// FECHA CREACIÓN: 25/11/2009
//=======================================================================
package co.zero.hcm.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import co.zero.hcm.exception.HcmException;

/**
 * Clase que contiene funciones utilitarias para el manejo de Apache - Poi
 * @author Hernán Tenjo
 * @version 1.0
 */
public class HcmPoiUtils {
	/**
	 * Metodo que permite crear un Workbook con base en una representación de bytes
	 * @param file Archivo representado como un arreglo de bytes
	 * @return Workbook de poi
	 * @throws InvalidFormatException Si la estructura del archivo es incorrecta
	 * @throws IOException Si se presentan problemas al procesar los bytes
	 */
	public static Workbook getWorkbookFromBytes(byte[] file) 
		throws InvalidFormatException, IOException{
		ByteArrayInputStream bais = new ByteArrayInputStream(file);
		Workbook workbook = WorkbookFactory.create(bais);
		return workbook;
	}
	
	/**
	 * Metodo que permite obtener la representacion en bytes de un Workbook
	 * @param workbook Objeto con la informacion que se desea transformar a bytes
	 * @return Arreglo con el conjunto de bytes que representan al Workbook
	 * @throws HcmException Si se produce un error al escribir en el OutputStream
	 */
	public static byte[] getBytesFromWorkbook(Workbook workbook) throws HcmException{
		try{
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			workbook.write(baos);
			return baos.toByteArray();
		} catch (IOException e) {
			throw new HcmException(
					HcmException.ADAPT_FILE_TO_BYTES_ERROR, e);
		}
	}
	
	/**
	 * Metodo que permite obtener los labels diferentes de una fila de un archivo 
	 * de excel con sus respectivos indices de posicion 
	 * @param row Fila del archivo que se desea analizar
	 * @return Mapa con los labels y su respectivo indice
	 */
	public static Map<String, Integer> getCellUniqueNameIndex(Row row){
		Map<String, Integer> columnMap = new HashMap<String, Integer>();
		
		for(Cell cell : row){
			columnMap.put(getCellValueAsString(cell), cell.getColumnIndex());
		}
		
		return columnMap;
	}
	
	/**
	 * Metodo que permite obtener el valor de una celda como cadena
	 * @param cell Celda que se va a procesar
	 * @return Valor de la celda como cadena
	 */
	public static String getCellValueAsString(Cell cell) {
		if(cell != null){
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				return cell.getRichStringCellValue().getString();
			case Cell.CELL_TYPE_NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					return cell.getDateCellValue().toString();
				} else {
					return String.valueOf(cell.getNumericCellValue());
				}
			case Cell.CELL_TYPE_BOOLEAN:
				return String.valueOf(cell.getBooleanCellValue());
			case Cell.CELL_TYPE_FORMULA:
				return String.valueOf(cell.getCellFormula());
			default:
				return null;
			}
		}else{
			return null;
		}
	}	
}