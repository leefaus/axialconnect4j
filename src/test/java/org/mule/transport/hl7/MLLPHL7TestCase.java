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

import org.mule.api.MuleMessage;
import org.mule.module.client.MuleClient;
import org.mule.tck.FunctionalTestCase;

public class MLLPHL7TestCase extends FunctionalTestCase
{

    public void testMessageComingIn() throws Exception
    {
        MuleClient client = new MuleClient(muleContext);

        MuleMessage msg = client.request("vm://output", 60000);

        assertNotNull(msg);
    }

    @Override
    protected String getConfigResources()
    {
        return "mule-config.xml";
    }
}
