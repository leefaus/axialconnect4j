/******************************************************************************* 
 *  Copyright 2010-2011 Axial Exchange Inc., All rights reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 ******************************************************************************* 
 */
package org.axialproject.axialconnect.hl7.model;

/**
 * @author N. Lee Faus
 * @version 0.1
 */
public class PV1 extends Segment {
	private String type = "PV1";
	private String comment = "Patient Details";
	private String[] fields = {	"type",
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
	
	public String[] getFields() {
		return fields;
	}

	public String getType() {
		return type;
	}

	public String getComment() {
		return comment;
	}
}
