package org.hotel.config;

import java.io.*;

public class PathHelper {

	public static FileInputStream fs=null;
	public static File f=null;
	static
	{
		f=new File(".");
		String path=f.getAbsolutePath().substring(0,f.getAbsolutePath().length()-1)+"src\\db.properties";
		try {
			fs=new FileInputStream(path);
		} catch (FileNotFoundException e) {
			System.out.println("Error in PathHelper"+e);
		}
	}
}