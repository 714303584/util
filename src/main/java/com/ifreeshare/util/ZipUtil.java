package com.ifreeshare.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;


/**
 * @author zhuss
 * @time  2013-09-07
 */
public class ZipUtil {
	
	/**
	 * @param zipOutFile The file will be generated
	 * @param zipInputFile To compress the file or folder
	 * @throws IOException
	 */
	public static void zipCompressing(File zipOutFile,File zipInputFile) throws IOException{
		ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipOutFile));
		BufferedOutputStream bos = new BufferedOutputStream(zos);
		zipCompressingStream(zos, zipInputFile, zipOutFile.getAbsolutePath(), bos);
		bos.close();
		zos.close();
		
	}
	
	/**
	 * @param zipFileName  The name of the zip file will be generated
	 * @param zipInputFile To compress the file or folder
	 * @throws IOException 
	 */
	public static void zipCompressing(String zipFileName,String zipInputFile) throws IOException{
		zipCompressing(new File(zipFileName), new File(zipInputFile));
	}
	
	/**
	 * 
	 * @param out  The implementation of file compression flow
	 * @param f To compress the file or folder
	 * @param base Root node of the compressed file
	 * @param bos The compression stream buffer
	 * @throws IOException 
	 */
	public static void zipCompressingStream(ZipOutputStream out, File f, String base, BufferedOutputStream bos) throws IOException{
		if(f.isDirectory()){
			File[] f1 = f.listFiles();
			if(f1.length == 0){
				out.putNextEntry(new ZipEntry(base + "/"));   
			}else{
				for (int i = 0; i < f1.length; i++) {
					File file = f1[i];
					zipCompressingStream(out, file, file.getName(), bos);
				}
			}
			
		}else{
			out.putNextEntry(new ZipEntry(base));  
			FileInputStream in = new FileInputStream(f);
			BufferedInputStream bis = new BufferedInputStream(in);
			int b ;
			
			while ((b = bis.read()) != -1) {
				bos.write(b);
			}
			bos.flush();
			bis.close();
			in.close();
		}
		
	}
	
	
	/**
	 * 
	 * @param zipFile  To unzip the files
	 * @param outputPath Extract the location
	 */
	public static void zipDecompressing(File zipFile , String outputPath) throws IOException{
		
		ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
		BufferedInputStream bis = new BufferedInputStream(zis);
		
		File fOut = null;
		ZipEntry entry = null;
		while ((entry = zis.getNextEntry()) != null && !entry.isDirectory()) {
			
			fOut = new File(outputPath,entry.getName());
			
			if(!fOut.exists()){
				(new File(fOut.getParent())).mkdirs();
			}
			
			FileOutputStream fos = new FileOutputStream(fOut);
			
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			int b;
			while ((b = bis.read()) != -1) {
				bos.write(b);
			}
			bos.close();
			fos.close();
		}
		bis.close();
		zis.close();
		
	}
	
	
	
	
	
	
	

	
	
	public static void main(String[] args) {
		
		try {
			ZipUtil.zipDecompressing(new File("D:\\test.zip"), "D:\\s");
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	
	

}
