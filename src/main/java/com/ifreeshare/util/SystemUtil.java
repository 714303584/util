package com.ifreeshare.util;

/**
 * Get system information
 * @author zhuss
 */
public class SystemUtil {
	
	/**
	 * Java runtime environment provider
	 * @return --- Java runtime environment provider
	 */
	public String getJavaVendor(){
		return System.getProperty("java.vendor");
	}
	
	/**
	 * Java runtime environment provider URL
	 * @returnJ --- Java runtime environment provider URL
	 */
	public String getJavaVendorUrl(){
		return System.getProperty("java.vendor.url");
	}
	
	
	/**
	 * Java installation directory
	 * @return --- Java installation directory
	 */
	public String getJavaHome(){
		return System.getProperty("java.home");
	}
	
	
	/**
	 * Java virtual machine specification version
	 * @return --- Java virtual machine specification version
	 */
	public String getJavaVmSpecificationVersion(){
		return System.getProperty("java.vm.specification.version");
	}
	
	
	/**
	 * The version number of  Java class format 
	 * @return --- The version number of  Java class format 
	 */
	public String getJavaClassVersion(){
		return System.getProperty("java.class.version");
	}
	
	
	/**
	 * The Java class path
	 * A third-party class library is listed
	 * @return --- The Java class path
	 */
	public String getJavaClassPath(){
		return System.getProperty("java.class.path");
	}
	
	/**
	 * The list of paths searched when loading the library
	 * @return --- The list of paths searched when loading the library
	 */
	public String getJavaLibraryPath(){
		return System.getProperty("java.library.path");
	}
	
	/**
	 * The default temporary file path
	 * @return --- The default temporary file path
	 */
	public String getJavaIoPath(){
		return System.getProperty("java.io.tmpdir");
	}
	
	
	/**
	 * The name of the JIT compiler to use
	 * @return --- The name of the JIT compiler to use
	 */
	public String getCompiler(){
		return System.getProperty("java.compiler");
	}
	
	
	/**
	 * The path to one or more extension directories
	 * @return --- The path to one or more extension directories
	 */
	public String getExtDirs(){
		return System.getProperty("java.ext.dirs");
	}
	
	/**
	 * The name of the operating system
	 * @return --- The name of the operating system
	 */
	public String getOsName(){
		return System.getProperty("os.name");
	}
	
	
	/**
	 * The architecture of the operating system
	 * @return --- The architecture of the operating system
	 */
	public String getOsArch(){
		return System.getProperty("os.arch");
	}
	
	/**
	 * The version of the operating system
	 * @return --- The version of the operating system
	 */
	public String getOsVersion(){
		return System.getProperty("os.version");
	}
	
	/**
	 * The file separator for the operating system
	 * @return --- The file separator for the operating system
	 */
	public String getFileSeparator(){
		return System.getProperty("file.separator");
	}
	
	/**
	 * The path separator for the operating system
	 * @return --- The path separator for the operating system
	 */
	public String getPathSeparator(){
		return System.getProperty("path.separator");
	}
	
	
	/**
	 * The behavior of the operating system
	 * @return --- The behavior of the operating system
	 */
	public String getLineSeparator(){
		return System.getProperty("line.separator");
	}
	
	
	/**
	 * The user's account name
	 * @return --- The user's account name
	 */
	public String getUserName(){
		return System.getProperty("user.name");
	}
	
	
	/**
	 * The user's home directory
	 * @return --- The user's home directory
	 */
	public String getUserHome(){
		return System.getProperty("user.home");
	}
	
	/**
	 * The current working directory
	 * @return --- The current working directory
	 */
	public String getUserDir(){
		return System.getProperty("user.dir");
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
	}

}
