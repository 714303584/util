package com.ifreeshare.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import co.paralleluniverse.fibers.Suspendable;

/**
 * Package for file operation
 * @author zhuss
 * @date 2016-10-21-11:37:59
 */
public class FileAccess {

	
	/**
	 * Get the name of the file
	 * @param file fileName.type
	 * @return
	 */
	public static String getFileType(String file){
		return file.substring(file.lastIndexOf('.')+1, file.length());
	}
	
	/**
	 * Get the Type of the file
	 * @param file fileName.type
	 * @return
	 */
	public static String getFileName(String file){
		return file.substring(0, file.lastIndexOf('.'));
	}
	
	
	public static void getFiles(File dir, List<File> list, String fileType){
		File[] files =  dir.listFiles();
		if(files == null) return;
		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			if(fileType == null){
				if(file.isDirectory()){
					getFiles(file, list, fileType);
				}
				list.add(file);
				continue;
			}
			
			if(file.isDirectory()){
				getFiles(file, list, fileType);
			}else{
				String fileName = file.getName();
				String type = getFileType(fileName);
				if(fileType.equals(type)){
					list.add(file);
//					System.out.println(file.getAbsolutePath());
				}
			}
		}
	}
	
	
	/**
	 * move file
	 * @param srcFile source file
	 * @param destPath
	 * @return
	 */
	public static boolean Move(File srcFile, String destPath) {
		File dir = new File(destPath);
		// Move file to new directory
		boolean success = srcFile.renameTo(new File(dir, srcFile.getName()));
		return success;
	}
	
	
	
	public static boolean Move(String srcFile, String destPath) {
		// File (or directory) to be moved
		File file = new File(srcFile);

		// Destination directory
		File dir = new File(destPath);

		// Move file to new directory
		boolean success = file.renameTo(new File(dir, file.getName()));

		return success;
	}
	
	
	/**
	 * copy file
	 * @param oldPath source file 
	 * @param newPath  target file 
	 */
	public static void Copy(String oldPath, String newPath) {
		try {
			int bytesum = 0;
			int byteread = 0;
			File oldfile = new File(oldPath);
			if (oldfile.exists()) {
				InputStream inStream = new FileInputStream(oldPath);
				FileOutputStream fs = new FileOutputStream(newPath);
				byte[] buffer = new byte[10240];
				int length;
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread;
					System.out.println(bytesum);
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
				fs.close();
			}
		} catch (Exception e) {
			System.out.println("error  ");
			e.printStackTrace();
		}
	}
	
	public static void Copy(File oldfile, String newPath) {
		try {
			int bytesum = 0;
			int byteread = 0;
			// File oldfile = new File(oldPath);
			if (oldfile.exists()) {
				InputStream inStream = new FileInputStream(oldfile);
				FileOutputStream fs = new FileOutputStream(newPath);
				byte[] buffer = new byte[10240];
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread;
					System.out.println(bytesum);
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
				fs.close();
			}
		} catch (Exception e) {
			System.out.println("error  ");
			e.printStackTrace();
		}
	}
	
	/**
	 * 创建目录： 目录存在返回true，目录不存在，则创建目录，返回创建的结果。
	 * 			若所要创建的目录已存在切不为目录类型，则返回false.
	 * @param dirPath 需要创建的目录的名称。
	 * @return boolean Exist or create success is True, other false;
	 */
	public static boolean createDir(String dirPath){
		File file = new File(dirPath);
		if(file.exists()){
			if(file.isDirectory()){
				return true;
			}else{
				return false;
			}
		}else{
			 return file.mkdirs();
		}
	}
	
	
	
	
	
	
	
}
