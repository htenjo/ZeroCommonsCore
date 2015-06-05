//=======================================================================
// ARCHIVO PoiUtils.java
// FECHA CREACIÓN: 06/02/2012
//=======================================================================
package co.zero.common.util;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFDataValidation;
import org.apache.poi.xssf.usermodel.XSSFDataValidationConstraint;
import org.apache.poi.xssf.usermodel.XSSFDataValidationHelper;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import co.zero.common.constant.GenericConstants;

/**
 * Clase que contiene funcionalidades utilitarias que facilitan la gestión de los 
 * documentos de POI (En especial los de excel)
 * @author Hernán Tenjo
 * @version 1.0
 */
public class PoiUtils {
	/**
	 * Método que permite agregar un mensaje de error a una celda
	 * @param book Libro que se está procesando
	 * @param sheet Hoja de excel que se está procesando
	 * @param row Fila del excel que se está procesando
	 * @param cell Celda que se está procesando
	 * @param attributeIndex Indice de la columna que se está procesando
	 * @param e Excepción con el mensaje de error que se desea agregar a la celda
	 */
	public void addMessageErrorToCell(Workbook book, Sheet sheet, Row row, Cell cell, int attributeIndex, Exception e){
		cell = cell == null ? row.createCell(attributeIndex) : cell;
		this.markCellWithErrorStyle(book, cell);
		this.createComment(book, sheet, row, cell, e.toString());
	}
	
	/**
	 * Método que permite agregar los estilos característicos de un error
	 * a una celda determinada
	 * @param cell Celda que se desea marcar como erronea
	 */
	public void markCellWithErrorStyle(Workbook book, Cell cell){
		markCellWithColorStyle(book, cell, HSSFColor.LIGHT_ORANGE.index);
	}
	
	/**
	 * Método que permite agregar los estilos característicos para una creación
	 * realizada correctamente sobre una celda determinada
	 * @param cell Celda que se desea marcar como creada correctamente
	 */
	public void markCellWithSuccessfulSaveStyle(Workbook book, Cell cell){
		markCellWithColorStyle(book, cell, HSSFColor.GREEN.index);
	}
	
	/**
	 * Método que permite agregar los estilos característicos para una acción
	 * realizada correctamente sobre una celda determinada
	 * @param cell Celda que se desea marcar como erronea
	 */
	public void markCellWithSuccessfulUpdateStyle(Workbook book, Cell cell){
		markCellWithColorStyle(book, cell, HSSFColor.PALE_BLUE.index);
	}
	
	/**
	 * Método que permite agregar los estilos característicos para una acción
	 * realizada correctamente sobre una celda determinada
	 * @param color Indice del color que será asignado a la celda
	 * @param cell Celda que se desea marcar como OK
	 */
	public void markCellWithColorStyle(Workbook book, Cell cell, short color){
		CellStyle style = book.createCellStyle();
		style.setFillForegroundColor(color);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		cell.setCellStyle(style);
	}
	
	/**
	 * Método que permite asignar un comentario a una celda
	 * @param book Objeto que representa al libro de excel
	 * @param sheet Objeto que representa a la hoja de trabajo actual 
	 * @param row Objeto que representa la fila de trabajo actual
	 * @param cell Celda a la que se desea agregar el comentario
	 * @param commentMsg Mensaje que será asignado el comentario
	 */
	public void createComment(Workbook book, Sheet sheet, Row row, Cell cell, String commentMsg){
		CreationHelper factory = book.getCreationHelper();
		Drawing drawing = sheet.createDrawingPatriarch();
		ClientAnchor anchor = factory.createClientAnchor();
		anchor.setCol1(cell.getColumnIndex());
		anchor.setCol2(cell.getColumnIndex() + 2);
		anchor.setRow1(row.getRowNum());
		anchor.setRow2(row.getRowNum() + 2);
		
		// Se crea el comentario y se asigna a una celda
	    Comment comment = drawing.createCellComment(anchor);
	    RichTextString str = factory.createRichTextString(commentMsg);
	    comment.setString(str);
	    comment.setAuthor("ZERO");
	    cell.setCellComment(comment);
	}
	
	/**
	 * Método que agrega un combo con las opciones que deben ir en la celda y su correspondiente validación
	 * @param book Objeto que representa al libro de excel
	 * @param sheet Objeto que representa a la hoja de trabajo actual
	 * @param cell Celda a la que se desea agregar el comentario
	 * @param itemValues
	 */
	public void createDropDownInCell(XSSFWorkbook workbook, XSSFSheet sheet, XSSFCell cell, String[] itemValues){
		XSSFDataValidationHelper dvHelper = new XSSFDataValidationHelper(sheet);
		XSSFDataValidationConstraint dvConstraint = (XSSFDataValidationConstraint)dvHelper.createExplicitListConstraint(itemValues);
		CellRangeAddressList addressList = new CellRangeAddressList(
				cell.getRowIndex(), cell.getRowIndex(), cell.getColumnIndex(), cell.getColumnIndex());
		XSSFDataValidation validation = (XSSFDataValidation) dvHelper.createValidation(dvConstraint, addressList);
		validation.setShowErrorBox(true);
		sheet.addValidationData(validation);
	}
	
	/**
	 * Método que permite obtener el valor de una celda que se cree numérico
	 * @param cell Celda del excel que contiene la información deseada
	 * @return El valor de la celda en caso de ser un número o null si es una celda
	 * sin contenido
	 * @throws NumberFormatException Si el contenido de la celda no es de tipo numérico
	 */
	public Double getNumberFromCellIfExist(Cell cell){
		if(cell != null){
			if(cell.getCellType() == Cell.CELL_TYPE_BLANK){
				return null;
			}else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
				return cell.getNumericCellValue();
			}else if(cell.getCellType() == Cell.CELL_TYPE_STRING){
				if(StringUtils.isBlank(cell.getStringCellValue().trim())){
					return null;
				}else{
					return Double.parseDouble(cell.getStringCellValue());
				}
			}
		}
			
		throw new NumberFormatException();
	}
	
	/**
	 * Método que permite obtener el valor de una celda que se cree de tipo texto
	 * @param cell Celda del excel que contiene la información deseada
	 * @return El valor de la celda en caso de ser un número o null si es una celda
	 * sin contenido
	 */
	public String getStringFromCellIfExist(Cell cell){
		if(cell != null && cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
			if(HSSFDateUtil.isCellDateFormatted(cell)){
				return FormatUtils.formatDate(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()), GenericConstants.FORMAT_DATE_SHORT);
			}else{
				return (long)cell.getNumericCellValue() + GenericConstants.EMPTY_STRING;
			}
		}else if(cell != null && cell.getCellType() == Cell.CELL_TYPE_STRING){
			if(StringUtils.isBlank(cell.getStringCellValue())){
				return null;
			}else{
				return cell.getStringCellValue().trim();
			}
		}else{
			return null;
		}
	}
}