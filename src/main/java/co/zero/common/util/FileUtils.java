//=======================================================================
// ARCHIVO FileUtils.java
// FECHA CREACIÓN: 09/02/2012
//=======================================================================
package co.zero.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import co.zero.common.constant.GenericConstants;
import co.zero.common.exception.ZeroApplicationException;
import co.zero.common.exception.ZeroException;

/**
 * Clase que permite reunir funcionalidades utilitarias para la gestion de archivos
 * @author Hernán Tenjo
 * @version 1.0
 */
public class FileUtils {
	/**
	 * Método qu permite cerrar de forma adecuada un stream de datos de lectura
	 * @param inputStream Stream de datos que se desea cerrar
	 * @throws ZeroException Si se produce un error al tratar de cerrar el stream
	 */
	public static void closeInputStream(InputStream inputStream) throws ZeroException{
		try{
			if(inputStream != null){
				inputStream.close();
			}
		}catch(IOException e){
			throw new ZeroApplicationException(ZeroApplicationException.UNKNOWN_EXCEPTION, e.getMessage());
		}
	}
	
	/**
	 * Método qu permite cerrar de forma adecuada un stream de datos de escritura
	 * @param inputStream Stream de datos que se desea cerrar
	 * @throws ZeroException Si se produce un error al tratar de cerrar el stream
	 */
	public static void closeOutputStream(OutputStream outputStream) throws ZeroApplicationException{
		try{
			if(outputStream != null){
				outputStream.close();
			}
		}catch(IOException e){
			throw new ZeroApplicationException(ZeroApplicationException.UNKNOWN_EXCEPTION, e.getMessage());
		}
	}
	
	/**
	 * Método que elimina un archivo simple
	 * @param filePath Ruta del archivo que se desea eliminar
	 * @return True si el archivo ha sido eliminado, false de lo contrario
	 */
	public static boolean deleteFile(String filePath){
		File file = new File(filePath);
		return file.delete();
	}
	
	/**
	 * Método que permite comprimir un archivo dada su ubicación en un archivo ZIP
	 * @param unzipedFileUrl Ubicación del archivo que se desea comprimir
	 * @param zipFileUrl Ubicación donde se desea dejar el archivo comprimido
	 * @param fileName Nombre del que archivo zip que se va a crear
	 * @throws IOException Si se produce algún problema en la creación del archivo
	 */
	public static void compressFileWithZip(String unzipedFileUrl, String zipFileUrl, String fileName) throws IOException{
		FileInputStream fis = null;
		FileOutputStream fos = null;
		ZipOutputStream zipos = null;
		byte[] buffer = new byte[GenericConstants.DEFAUL_BUFFER_SIZE];
		int len = 0;
		
		try {
			fis = new FileInputStream(unzipedFileUrl);
			fos = new FileOutputStream(zipFileUrl);
			zipos = new ZipOutputStream(fos);
			ZipEntry zipEntry = new ZipEntry(fileName);
			zipos.putNextEntry(zipEntry);

			while ((len = fis.read(buffer, 0, GenericConstants.DEFAUL_BUFFER_SIZE)) != -1){
				zipos.write(buffer, 0, len);
			}
			
			zipos.flush();
		} finally {
			zipos.close();
			fis.close();
			fos.close();
		}
	}
	
	/**
	 * Método que permite comprimir una carpeta completa en formato ZIP dada su ubicación
	 * @param folderUrl Ubicación de la carpeta que se desea comprimir
	 * @param filedestUrl Ubicación donde se dejará el archivo ZIP
	 * @throws IOException Si se presenta algún problema en la creación del archivo
	 */
	public static void compressFolderWithZip(String folderUrl, String filedestUrl) throws IOException {
		ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(filedestUrl));
		zipDir(folderUrl, zos);
		zos.close();
	}

	/**
	 * Método que permite comprimir de forma recursiva un directorio
	 * @param folderUrl Ubicación del directorio que se desea comprimir
	 * @param zos Stream de datos donde se va a escribir el archivo comprimido
	 * @throws IOException
	 */
	private static void zipDir(String folderUrl, ZipOutputStream zos) throws IOException {
		File zipDir = new File(folderUrl);
		String[] directoryContent = zipDir.list();
		byte[] readBuffer = new byte[2156];
		int bytesCounter = 0;
		
		for (int i = 0; i < directoryContent.length; i++) {
			File directoryFile = new File(zipDir, directoryContent[i]);
			
			if (directoryFile.isDirectory()) {
				String innerDirectoryPath = directoryFile.getPath();
				zipDir(innerDirectoryPath, zos);
				continue;
			}
			
			FileInputStream fis = new FileInputStream(directoryFile);
			ZipEntry zipEntry = new ZipEntry(directoryContent[i]);
			zos.putNextEntry(zipEntry);
			
			while ((bytesCounter = fis.read(readBuffer)) != -1) {
				zos.write(readBuffer, 0, bytesCounter);
			}
			
			fis.close();
		}
	}
}