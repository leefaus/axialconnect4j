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
package org.mule.transport.hl7.model;

/**
 * @author N. Lee Faus
 * @version 0.1
 */
public class PID extends Segment {
	public String type = "PID";
	public String comment = "Patient Identification";
	private String[] fields = {	"type",
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
