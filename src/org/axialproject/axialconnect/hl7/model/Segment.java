package org.axialproject.axialconnect.hl7.model;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Segment {
	private char segment_value_seperator = '|';
	private String segment;
	private String segmentType;
	
	public Segment() {
	}
	
	public Segment(String segment) {
		this.segment = segment;
		Pattern p = Pattern.compile("[" + segment_value_seperator + "]");
		String[] str = p.split(segment);
		segmentType = str[0];
	}

	public HashMap<String, String> getValues() {	
		HashMap<String, String> valueMap = null;
		try {
			Class cls = Class.forName("org.axialproject.axialconnect.hl7.model." + segmentType.toUpperCase());
			Constructor ct = cls.getConstructor(new Class[0]);
			Object objinst = ct.newInstance(new Object[0]);
			Class paramTypes[] = new Class[1];
			paramTypes[0] = String.class;
			Method meth = cls.getMethod("parse", paramTypes);
			Object arglist[] = new Object[1];
			arglist[0] = segment;
			valueMap = (HashMap<String, String>)meth.invoke(objinst, arglist);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return valueMap;
	}
}
