package org.axialproject.axialconnect.hl7.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import org.apache.tomcat.jni.Time;

public class MSH extends Segment {
	private char segment_value_seperator = '|';
	private char end_of_segment = 0x0d;
	
	public String type = "MSH";
	public String comment = "Message Header";
	public String[] fields = {	"type",
								"encoding_characters", 
								"sending_application", 
								"sending_facility",
								"receiving_application",
								"receiving_facility", 
								"time", 
								"security", 
								"message_type", 
								"message_control_id",
								"processing_id", 
								"version_id", 
								"sequence", 
								"continue_pointer", 
								"accept_ack_type", 
								"application_ack_type", 
								"country_code", 
								"charset"};
	
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
	
	public String createACK(HashMap<String, String> msh) {
		MSH a_msh = new MSH();
		MSA a_msa = new MSA();
		String DATE_FORMAT = "yyyyMMddHHmm";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		String[] msh_f = {	msh.get("encoding_characters"), 
							msh.get("receiving_application"), 
							msh.get("receiving_facility"), 
							msh.get("sending_application"), 
							msh.get("sending_facility"), 
							sdf.format(Calendar.getInstance().getTime()), 
							msh.get("security"),
							"ACK",
							msh.get("message_control_id"),
							msh.get("processing_id"),
							msh.get("version_id")};
		String[] msa_f = {	"AA",
							msh.get("message_control_id")};
		StringBuffer msg_body = new StringBuffer();
		msg_body.append(a_msh.create(msh_f));
		msg_body.append(a_msa.create(msa_f));
		return msg_body.toString();
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
