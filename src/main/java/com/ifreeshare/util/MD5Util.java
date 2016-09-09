package com.ifreeshare.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuss
 * @date 2016年9月9日下午3:17:01
 * @description The MD5 calculation file
 */

public class MD5Util {
	
	
	/**
	 * 根据文件计算出文件的MD5
	 * @param file
	 * @return
	 */
	public static String getFileIdentification(File file,String algorithm) {
		if (!file.isFile()) {
			return null;
		}
		
		MessageDigest digest = null;
		FileInputStream in = null;
		byte buffer[] = new byte[10240];
		int len;
		try {
			digest = MessageDigest.getInstance(algorithm);
			in = new FileInputStream(file);
			while ((len = in.read(buffer)) != -1) {
				digest.update(buffer, 0, len);
			}
			in.close();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		BigInteger bigInt = new BigInteger(1, digest.digest());

		return bigInt.toString(16);
	}
	
	public static String getFileMD5(String file){
		return getFileIdentification(new File(file),"MD5");
	}
	
	public static String getFileMD5(File file){
		return getFileIdentification(file,"MD5");
	}
	
	
	public static String getFileSHA1(String file){
		return getFileIdentification(new File(file),"SHA1");
	}
	
	public static String getFileSHA1(File file){
		return getFileIdentification(file,"SHA1");
	}
	
	public static String getFileSHA256(String file){
		return getFileIdentification(new File(file),"SHA-256");
	}
	
	public static String getFileSHA256(File file){
		return getFileIdentification(file,"SHA-256");
	}
	
	
	public static String getFileSHA384(String file){
		return getFileIdentification(new File(file),"SHA-384");
	}
	
	public static String getFileSHA384(File file){
		return getFileIdentification(file,"SHA-384");
	}
	
	public static String getFileSHA512(String file){
		return getFileIdentification(new File(file),"SHA-512");
	}
	
	public static String getFileSHA512(File file){
		return getFileIdentification(file,"SHA-512");
	}
	
	
	
	/**
	 * 获取文件夹中的文件的MD5值
	 * @param file
	 * @param listChild
	 * @return
	 */
	public static  Map<String,String> getFileIdentification(File file, boolean listChild,String algorithm){
		if(! file.isDirectory()){
			return null;
		}
		
		Map<String, String> map = new HashMap<String, String>();
		String md5;
		
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			File file2 = files[i];
			if(file2.isDirectory() && listChild){
				map.putAll(getFileIdentification(file2, listChild,algorithm));
			}else{
				md5 = getFileIdentification(file2,algorithm);
				if(md5 != null){
					map.put(file2.getPath(), md5);
				}
			}
		}
		return map;
	}
	
	
	
	

	
	public static void main(String[] args) {
		System.out.println(MD5Util.getFileMD5(new File("G:\\Java\\m2\\repository\\antlr\\antlr\\2.7.7\\antlr-2.7.7.jar")));
	}
}
