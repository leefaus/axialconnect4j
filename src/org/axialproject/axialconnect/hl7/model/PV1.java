package org.axialproject.axialconnect.hl7.model;

import java.util.HashMap;
import java.util.regex.Pattern;

public class PV1 extends Segment {
	private char segment_value_seperator = '|';
	
	public String type = "PV1";
	public String comment = "Patient Details";
	public String[] fields = {	"type",
								"set_id",
								"patient_class", 
								"assigned_location", 
								"admission_type",
								"preadmit_number",
								"prior_location", 
								"attending_doctor", 
								"referring_doctor", 
								"consulting_doctor", 
								"hospital_service",
								"temporary_location", 
								"preadmin_indicator", 
								"readmit_locator", 
								"admit_source", 
								"ambulatory_status", 
								"vip_indicator", 
								"admitting_doctor", 
								"patient_type",
								"visit_number",
								"financial_class",
								"charge_price_indicator",
								"courtesy_code",
								"credit_rating",
								"contract_code",
								"contract_effective_date",
								"contract_amount",
								"contract_period",
								"interest_code",
								"death_indicator",
								"transfer_bad_debt_code",
								"transfer_bad_debt_date",
								"bad_debt_agency_code",
								"bad_debt_transfer_amount",
								"bad_debt_recovery_amount",
								"delete_account_indicator",
								"delete_account_date",
								"discharge_disposition",
								"discharge_to_location",
								"diet_type",
								"servicing_facility",
								"bed_status",
								"account_status",
								"pending_location",
								"prior_temporary_location",
								"admit_date",
								"discharge_date",
								"current_patient_balance",
								"total_charges",
								"total_adjustments",
								"total_payments",
								"alternate_visit_id",
								"visit_indicator",
								"other_healthcare_provider"};
	
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
