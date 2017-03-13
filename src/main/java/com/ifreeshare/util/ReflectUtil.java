package com.ifreeshare.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public class ReflectUtil {

	/**
	 * 从一个包中找出所有的类，不包括jar包
	 * 
	 * @param packageName
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("rawtypes")
	public static List<Class> getClasses(String packageName) throws IOException, ClassNotFoundException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		String path = packageName.replace(".", "/");
		Enumeration<URL> resources = classLoader.getResources(path);
		List<File> dirs = new ArrayList<File>();
		while (resources.hasMoreElements()) {
			URL urlResource = resources.nextElement();
			String jarPaht = urlResource.toString();
			if(jarPaht.contains("!")){
				String jarpath = jarPaht.split("!")[0];
				if (jarPaht.contains(":")){
					String[] pathArray = jarpath.split(":");
					int length = pathArray.length;
					jarpath = pathArray[length - 1];
				}
				dirs.add(new File(jarpath));
			}else{
				dirs.add(new File(urlResource.getFile()));
			}
		}
		List<Class> classes = new ArrayList<Class>();
		for (File directory : dirs) {
			classes.addAll(findClasses(directory, packageName));
		}
		return classes;
	}

	/**
	 * Automatically scan classes under the package
	 * @param directory ------- Directory or Jar file
	 * @param packageName	-------- Package name
	 * @return
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("rawtypes")
	private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
		List<Class> classes = new ArrayList<Class>();
		//Not a directory, ------- jar
		if (!directory.isDirectory()) { 
			String rPath = packageName.replace('.', '/') + "/";
			try {
				FileInputStream fis = new FileInputStream(directory);
				JarInputStream jis = new JarInputStream(fis, false);
				JarEntry e = null;
				while ((e = jis.getNextJarEntry()) != null) {
					String eName = e.getName();
					if (eName.startsWith(rPath) && !eName.endsWith("/")) {
						classes.add(Class.forName(eName.replace('/', '.').substring(0, eName.length() - 6)));
					}
					jis.closeEntry();
				}
				jis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return classes;
		}else{
			// it is a directory.
			File[] files = directory.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					assert !file.getName().contains(".");
					classes.addAll(findClasses(file, packageName + "." + file.getName()));
				} else if (file.getName().endsWith(".class")) {
					System.out.println(packageName + "." + file.getName().substring(0, file.getName().length() - 6));
					classes.add(Class.forName(packageName + "." + file.getName().substring(0, file.getName().length() - 6)));
				}
			}
		}
		return classes;
	}

	public static void main(String[] args) throws IOException {
//		List<String> cls = getClassInPackage("java.util");
//		for (String s : cls) {
//			System.out.println(s);
//		}
		
			String file = "file:/D:/spider2/wcc.jar!/com/ifreeshare/framework/web/controller";
			
			File directory = new File(file);
			
			System.out.println("getpath:" + directory.getPath());
			System.out.println("getCanonicalPath:" + directory.getCanonicalPath());
			System.out.println("getAbsolutePath:" + directory.getAbsolutePath());
			System.out.println("toPath:" + directory.toPath());
			


	}

	public static List<String> getClassInPackage(String pkgName) {
		List<String> ret = new ArrayList<String>();
		String rPath = pkgName.replace('.', '/') + "/";
		try {
			for (File classPath : CLASS_PATH_ARRAY) {
				if (!classPath.exists())
					continue;
				if (classPath.isDirectory()) {
					File dir = new File(classPath, rPath);
					if (!dir.exists())
						continue;
					for (File file : dir.listFiles()) {
						if (file.isFile()) {
							String clsName = file.getName();
							clsName = pkgName + "." + clsName.substring(0, clsName.length() - 6);
							ret.add(clsName);
						}
					}
				} else {
					FileInputStream fis = new FileInputStream(classPath);
					JarInputStream jis = new JarInputStream(fis, false);
					JarEntry e = null;
					while ((e = jis.getNextJarEntry()) != null) {
						String eName = e.getName();
						if (eName.startsWith(rPath) && !eName.endsWith("/")) {
							ret.add(eName.replace('/', '.').substring(0, eName.length() - 6));
						}
						jis.closeEntry();
					}
					jis.close();
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return ret;
	}

	private static String[] CLASS_PATH_PROP = { "java.class.path", "java.ext.dirs", "sun.boot.class.path" };

	private static List<File> CLASS_PATH_ARRAY = getClassPath();

	private static List<File> getClassPath() {
		List<File> ret = new ArrayList<File>();
		String delim = ":";
		if (System.getProperty("os.name").indexOf("Windows") != -1)
			delim = ";";
		for (String pro : CLASS_PATH_PROP) {
			String[] pathes = System.getProperty(pro).split(delim);
			for (String path : pathes)
				ret.add(new File(path));
		}
		return ret;
	}

	public void loadJar(String url) {

		ClassLoader classload = Thread.currentThread().getContextClassLoader();
	}
	
	
	
}
