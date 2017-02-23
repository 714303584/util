package com.ifreeshare.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Get system information
 * @author zhuss
 */
public class SystemUtil {
	
	/**
	 * Java runtime environment provider
	 * @return --- Java runtime environment provider
	 */
	public static String getJavaVendor(){
		return System.getProperty("java.vendor");
	}
	
	/**
	 * Java runtime environment provider URL
	 * @returnJ --- Java runtime environment provider URL
	 */
	public static String getJavaVendorUrl(){
		return  System.getProperty("java.vendor.url");
	}
	
	
	/**
	 * Java installation directory
	 * @return --- Java installation directory
	 */
	public static String getJavaHome(){
		return System.getProperty("java.home");
	}
	
	
	/**
	 * Java virtual machine specification version
	 * @return --- Java virtual machine specification version
	 */
	public static String getJavaVmSpecificationVersion(){
		return System.getProperty("java.vm.specification.version");
	}
	
	
	/**
	 * The version number of  Java class format 
	 * @return --- The version number of  Java class format 
	 */
	public static String getJavaClassVersion(){
		return System.getProperty("java.class.version");
	}
	
	
	/**
	 * The Java class path
	 * A third-party class library is listed
	 * @return --- The Java class path
	 */
	public static String getJavaClassPath(){
		return System.getProperty("java.class.path");
	}
	
	

	public static String[] getLibsPath(){
		return System.getProperty("java.class.path").split(";");
	}
	
	/**
	 * The list of paths searched when loading the library
	 * @return --- The list of paths searched when loading the library
	 */
	public static String getJavaLibraryPath(){
		return System.getProperty("java.library.path");
	}
	
	/**
	 * The default temporary file path
	 * @return --- The default temporary file path
	 */
	public static String getJavaIoPath(){
		return System.getProperty("java.io.tmpdir");
	}
	
	
	/**
	 * The name of the JIT compiler to use
	 * @return --- The name of the JIT compiler to use
	 */
	public static String getCompiler(){
		return System.getProperty("java.compiler");
	}
	
	
	/**
	 * The path to one or more extension directories
	 * @return --- The path to one or more extension directories
	 */
	public static String getExtDirs(){
		return System.getProperty("java.ext.dirs");
	}
	
	/**
	 * The name of the operating system
	 * @return --- The name of the operating system
	 */
	public static String getOsName(){
		return System.getProperty("os.name");
	}
	
	
	/**
	 * The architecture of the operating system
	 * @return --- The architecture of the operating system
	 */
	public static String getOsArch(){
		return System.getProperty("os.arch");
	}
	
	/**
	 * The version of the operating system
	 * @return --- The version of the operating system
	 */
	public static String getOsVersion(){
		return System.getProperty("os.version");
	}
	
	/**
	 * The file separator for the operating system
	 * @return --- The file separator for the operating system
	 */
	public static String getFileSeparator(){
		return System.getProperty("file.separator");
	}
	
	/**
	 * The path separator for the operating system
	 * @return --- The path separator for the operating system
	 */
	public static String getPathSeparator(){
		return System.getProperty("path.separator");
	}
	
	
	/**
	 * The behavior of the operating system
	 * @return --- The behavior of the operating system
	 */
	public static String getLineSeparator(){
		return System.getProperty("line.separator");
	}
	
	
	/**
	 * The user's account name
	 * @return --- The user's account name
	 */
	public static String getUserName(){
		return System.getProperty("user.name");
	}
	
	
	/**
	 * The user's home directory
	 * @return --- The user's home directory
	 */
	public static String getUserHome(){
		return System.getProperty("user.home");
	}
	
	/**
	 * The current working directory
	 * @return --- The current working directory
	 */
	public static String getUserDir(){
		return System.getProperty("user.dir");
	}
	
	
	/**
	 * Get Host Address 
	 * @return host address
	 */
	public static String getLocalAddress(){
		 try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Java 运行时环境供应商:/n"+System.getProperty("java.vendor"));
		System.out.println("Java 供应商的URL:/n"+System.getProperty("java.vendor.url"));
		System.out.println("Java安装目录:/n"+System.getProperty("java.home"));
		System.out.println("Java 虚拟机规范版本:/n"+System.getProperty("java.vm.specification.version"));
		System.out.println("Java 类格式版本号:/n"+System.getProperty("java.class.version"));
		System.out.println("Java类路径：/n"+System.getProperty("java.class.path"));
		System.out.println("加载库时搜索的路径列表:/n"+System.getProperty("java.library.path"));
		System.out.println("默认的临时文件路径:/n"+System.getProperty("java.io.tmpdir"));
		System.out.println("要使用的 JIT 编译器的名称:/n"+System.getProperty("java.compiler"));
		System.out.println("一个或多个扩展目录的路径:/n"+System.getProperty("java.ext.dirs"));
		System.out.println("操作系统的名称:/n"+System.getProperty("os.name"));
		System.out.println("操作系统的"+System.getProperty("os.arch"));
		System.out.println("操作系统的版本:/n"+System.getProperty("os.version"));
		System.out.println("文件分隔符（在 UNIX 系统中是“/”）:/n"+System.getProperty("file.separator"));
		System.out.println("路径分隔符（在 UNIX 系统中是“:”）:/n"+System.getProperty("path.separator"));
		System.out.println("行分隔符（在 UNIX 系统中是“/n”）:/n"+System.getProperty("line.separator"));
		System.out.println("用户的账户名称:/n"+System.getProperty("user.name"));
		System.out.println("用户的主目录:/n"+System.getProperty("user.home"));
		System.out.println("用户的当前工作目录:/n"+System.getProperty("user.dir"));
		System.out.println("主机的本地IP地址:/n"+getLocalAddress());
	}

}
