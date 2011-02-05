package org.axialproject.axialconnect.integration;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

import org.axialproject.axialconnect.hl7.model.MSH;
import org.axialproject.axialconnect.hl7.model.Message;
import org.axialproject.axialconnect.hl7.model.Segment;
import org.mule.transport.jms.activemq.ActiveMQJmsConnector;
import org.mule.transport.tcp.protocols.AbstractByteProtocol;

public class MLLPByteProtocol extends AbstractByteProtocol {
	private char end_of_message = 0x1c;
	private char begin_of_message = 0x0b;
	private char end_of_segment = 0x0d;
	
	public MLLPByteProtocol() {
		super(true);
	}

	@Override
	public void write(OutputStream os, Object data) throws IOException {
		super.write(os, data);
	}

	@Override
	public Object read(InputStream is) throws IOException {
		MSH msh = new MSH();
		Message ack = new Message();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte read[] = new byte[1];
		
		while (true) {
			if (safeRead(is, read) < 0) {
				return null;
			} 
			byte b = read[0];
			baos.write(b);
			if (b == end_of_message) {
				System.out.println("HL7[RAW] :: " + baos.toString());
				Message aMessage = new Message();
				aMessage.setRaw(baos.toString());
				List<Segment> segments = aMessage.getSegments();
				return ack.create(msh.createACK(segments.get(0).getValues()));
			}
		}
	}

}
