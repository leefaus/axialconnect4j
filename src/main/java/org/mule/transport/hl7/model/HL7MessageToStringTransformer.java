package org.mule.transport.hl7.model;

import org.mule.api.MuleMessage;
import org.mule.api.annotations.ContainsTransformerMethods;
import org.mule.api.annotations.Transformer;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;

public class HL7MessageToStringTransformer extends AbstractTransformer {
    public HL7MessageToStringTransformer() {
        registerSourceType(Message.class);
        setReturnClass(String.class);
        setName("HL7MessageToString");
    }

    @Override
    protected String doTransform(Object o, String s) throws TransformerException {
        Message message = (Message) o;
        return o.toString();  //To change body of implemented methods use File | Settings | File Templates.
    }
}
