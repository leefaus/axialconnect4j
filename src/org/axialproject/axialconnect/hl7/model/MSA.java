package org.axialproject.axialconnect.hl7.model;

import java.util.HashMap;
import java.util.regex.Pattern;

public class MSA extends Segment {
	private char segment_value_seperator = '|';
	private char end_of_segment = 0x0d;
	
	public String type = "MSA";
	public String comment = "Message Acknowledgement";
	public String[] fields = {	"type",
								"ack_code",
								"control_id", 
								"expected_seq", 
								"selective_privacy",
								"delayed_ack_type",
								"error_cond"};
	
	public String create(String[] params) {
		StringBuffer ack = new StringBuffer();
		ack.append(type);
		for (String f : params) {
			ack.append(segment_value_seperator);
			ack.append(f);
		}
		ack.append(end_of_segment);
		return ack.toString();
	}
	
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
