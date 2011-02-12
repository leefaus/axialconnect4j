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
package org.mule.transport.hl7.protocol;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mule.transport.hl7.model.Message;
import org.mule.transport.tcp.protocols.AbstractByteProtocol;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author N. Lee Faus
 * @version 0.1
 */
public class MLLPByteProtocol extends AbstractByteProtocol {
    protected final Log logger = LogFactory.getLog(getClass());
    private char end_of_message = 0x1c;

    public MLLPByteProtocol() {
        super(true);
    }

    @Override
    public void write(OutputStream os, Object data) throws IOException {
        super.write(os, data);
        os.flush();
    }

    public Object read(InputStream is) throws IOException {
        //MSH msh = new MSH();
        //Message ack = new Message();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte read[] = new byte[1];

        while (true) {
            if (safeRead(is, read) < 0) {
                return null;
            }
            byte b = read[0];
            baos.write(b);
            if (b == end_of_message) {
                if (logger.isDebugEnabled()) {
                    logger.debug("HL7[RAW] :: " + baos.toString());
                }

                Message message = new Message();
                message.setRaw(baos.toString());
                //List<Segment> segments = message.getSegments();
                return message;
                //return ack.create(msh.createACK(segments.get(0).getValues()));
            }
        }
    }

}
