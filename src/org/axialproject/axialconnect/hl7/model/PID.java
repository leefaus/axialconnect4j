package org.axialproject.axialconnect.hl7.model;

import java.util.HashMap;
import java.util.regex.Pattern;

public class PID extends Segment {
	private char segment_value_seperator = '|';
	
	public String type = "PID";
	public String comment = "Patient Identification";
	public String[] fields = {	"type",
								"set_id",
								"patient_id", 
								"patient_id_list", 
								"alt_patient_id",
								"patient_name",
								"mother_maiden_name", 
								"patient_dob", 
								"admin_sex", 
								"patient_alias", 
								"race",
								"address", 
								"country_code", 
								"phone_home", 
								"phone_business", 
								"primary_language", 
								"marital_status", 
								"religion", 
								"account_number",
								"social_security_num",
								"mothers_id",
								"ethnic_group",
								"birthplace",
								"multi_birth",
								"birth_order",
								"citizenship",
								"vet_status",
								"nationality",
								"death_date",
								"death_indicator",
								"id_unknown_indicator",
								"id_readability_code",
								"last_update_date",
								"last_update_facility",
								"species_code",
								"breed_code",
								"strain",
								"production_class_code",
								"tribal_citizenship"};
	
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
