package org.axialproject.axialconnect.hl7.model;

import java.util.HashMap;
import java.util.regex.Pattern;

public class ZP1 extends Segment {
	private char segment_value_seperator = '|';
	
	public String type = "ZP1";
	public String comment = "Extended Attributes";
	public String[] fields = {	"type",
								"notify_private_physician",
								"practice_id", 
								"no_news", 
								"selective_privacy"};
	
	public HashMap<String, String> parse(String segment) {
		HashMap<String, String> map = new HashMap();
		Pattern p = Pattern.compile("[" + segment_value_seperator + "]");
		String[] str = p.split(segment);
		System.out.println("Fields :: " + fields.length);
		System.out.println("Fields in Message :: " + str.length);
		
		int count = 0;
		for (String f : str) {
			System.out.println(fields[count] + " == " + str[count]);
			map.put(fields[count], str[count]);
			count++;
		}
		return map;
	}
}
