/*
 * $Id: $
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.transport.hl7;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mule.api.construct.FlowConstruct;
import org.mule.api.endpoint.InboundEndpoint;
import org.mule.api.lifecycle.CreateException;
import org.mule.api.transport.Connector;
import org.mule.transport.AbstractMessageReceiver;
import org.mule.transport.hl7.model.Message;
import org.mule.transport.tcp.TcpMessageReceiver;

import javax.resource.spi.work.Work;
import java.io.IOException;
import java.net.Socket;

public class MLLPMessageReceiver extends TcpMessageReceiver {
    protected final Log logger = LogFactory.getLog(getClass());

    public MLLPMessageReceiver(Connector connector, FlowConstruct flowConstruct, InboundEndpoint endpoint) throws CreateException {
        super(connector, flowConstruct, endpoint);
    }

    @Override
    protected Work createWork(Socket socket) throws IOException {
        return new MLLPWorker(socket, this);
    }

    protected class MLLPWorker extends TcpWorker {
        public MLLPWorker(Socket socket, AbstractMessageReceiver receiver) throws IOException {
            super(socket, receiver);
        }

        @Override
        protected Object getNextMessage(Object resource) throws Exception {
            Object readMsg = null;
            readMsg = super.getNextMessage(resource);

            // We need to send an ack back to the server to let it know we got the message
            if (readMsg != null) {
                Message msg = (Message) readMsg;
                protocol.write(dataOut, msg.create(msg.createACK(msg.getSegments().get(0))));
            }
            return readMsg;
        }
    }
}
