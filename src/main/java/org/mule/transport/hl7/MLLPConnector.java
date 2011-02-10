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

import org.mule.transport.hl7.protocol.MLLPByteProtocol;
import org.mule.api.MuleContext;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.transport.tcp.TcpConnector;

public class MLLPConnector extends TcpConnector
{
    public final static String MLLP = "hl7";

    public MLLPConnector(MuleContext context)
    {
        super(context);
        setTcpProtocol(new MLLPByteProtocol());
    }

    @Override
    protected void doInitialise() throws InitialisationException
    {
        super.doInitialise();

    }

    @Override
    public String getProtocol()
    {
        return MLLP;
    }
}

