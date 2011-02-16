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

import org.mule.DefaultMuleMessage;
import org.mule.api.MuleMessage;
import org.mule.module.client.MuleClient;
import org.mule.tck.FunctionalTestCase;
import org.mule.transport.hl7.model.MSH;
import org.mule.transport.hl7.model.Message;
import org.mule.transport.hl7.model.Segment;

import java.util.HashMap;

public class MLLPHL7TestCase extends FunctionalTestCase
{
    public void testMessageComingIn() throws Exception
    {
        MuleClient client = new MuleClient(muleContext);
        client.dispatch("tcp://localhost:13000", createADTA08(), null);
        MuleMessage msg = client.request("vm://output", 15000);

        assertNotNull(msg.getPayload());
    }

    @Override
    protected String getConfigResources()
    {
        return "mule-config.xml";
    }

    private String createADTA08() {
        String msh = "MSH|^~@|INVISION|SMS|MD ALERT|AXIAL EXCHANGE|201002080005||ADT^A08|QP0210062-793942|P|2.3";
        String pid = "PID|||1853286^^^^MR^1||JOHNSON^JOHN||20070922|M||W|1234 MAIN ST^^RALEIGH^NC^27608|||||||65112465^^^^PN|999999999";
        String pv1 = "PV1||E|605||||680009^EMERGENCY^PHYSICIA^N||||||||||||||||||||||||||||||||605|||||201003022238";
        Message msg = new Message(); //hl7Message, not MuleMessage :)
        StringBuffer msgStr = new StringBuffer();
        msgStr.append(msh);
        msgStr.append('\r');
        msgStr.append(pid);
        msgStr.append('\r');
        msgStr.append(pv1);
        msgStr.append('\r');
        return msg.create(msgStr.toString());
    }
}
