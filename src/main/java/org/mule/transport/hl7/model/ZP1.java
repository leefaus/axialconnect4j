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
public class ZP1 extends Segment {
	private String type = "ZP1";
	private String comment = "Extended Attributes";
	private String[] fields = {	"type",
								"notify_private_physician",
								"practice_id", 
								"no_news", 
								"selective_privacy"};

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
