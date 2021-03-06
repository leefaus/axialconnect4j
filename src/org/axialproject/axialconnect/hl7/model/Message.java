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

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author N. Lee Faus
 * @version 0.1
 */
public class Message {
	private char end_of_message = 0x1c;
	private char begin_of_message = 0x0b;
	private char end_of_segment = 0x0d;
	
	private String raw;
	
	public int num_segments;
	
	private List<Segment> segments = new ArrayList<Segment>();
	
	public List<Segment> getSegments() {
		return getSegments(raw);
	}
	
	public List<Segment> getSegments(String raw) {
		StringTokenizer st = new StringTokenizer(getActualMessage(raw), Character.toString(end_of_segment));
		this.num_segments = st.countTokens();
		System.out.println("Num of Segemnts :: " + this.num_segments);
		
		while (st.hasMoreTokens()) {
			Segment aSegment = new Segment(st.nextToken());
			aSegment.getValues();
			segments.add(aSegment);
		}
		return segments;
	}
	
	public String create(String message) {
		StringBuffer msg = new StringBuffer();
		msg.append(begin_of_message);
		msg.append(message);
		msg.append(end_of_message);
		msg.append(end_of_segment);
		return msg.toString();
	}
	
	private String getActualMessage(String raw) {
		int startMessage = raw.indexOf(begin_of_message) + 1;
		int endMessage = raw.indexOf(end_of_message) - 1;	
		return raw.substring(startMessage, endMessage);
	}
	
	public void setRaw(String raw) {
		this.raw = raw;
	}
	
	public String getRaw() {
		return this.raw;
	}

}
