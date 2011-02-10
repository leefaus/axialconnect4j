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
public class MSA extends Segment {
	private String type = "MSA";
	private String comment = "Message Acknowledgement";
	private String[] fields = {	"type",
								"ack_code",
								"control_id", 
								"expected_seq", 
								"selective_privacy",
								"delayed_ack_type",
								"error_cond"};
	
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
