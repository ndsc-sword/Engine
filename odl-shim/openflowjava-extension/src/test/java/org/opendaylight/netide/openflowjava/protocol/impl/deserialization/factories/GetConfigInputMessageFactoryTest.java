/*
 * Copyright (c) 2015 NetIDE Consortium and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.netide.openflowjava.protocol.impl.deserialization.factories;

import io.netty.buffer.ByteBuf;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.netide.openflowjava.protocol.impl.deserialization.NetIdeDeserializerRegistryImpl;
import org.opendaylight.netide.openflowjava.protocol.impl.util.BufferHelper;
import org.opendaylight.openflowjava.protocol.api.extensibility.DeserializerRegistry;
import org.opendaylight.openflowjava.protocol.api.keys.MessageCodeKey;
import org.opendaylight.openflowjava.protocol.api.util.EncodeConstants;
import org.opendaylight.yang.gen.v1.urn.opendaylight.openflow.protocol.rev130731.GetConfigInput;

/**
 * @author giuseppex.petralia@intel.com
 *
 */
public class GetConfigInputMessageFactoryTest {

    ByteBuf bb = BufferHelper.buildBuffer();

    GetConfigInput deserializedMessage;

    @Before
    public void startUp() throws Exception {
        DeserializerRegistry desRegistry = new NetIdeDeserializerRegistryImpl();
        desRegistry.init();
        GetConfigInputMessageFactory factory = desRegistry
                .getDeserializer(new MessageCodeKey(EncodeConstants.OF13_VERSION_ID, 7, GetConfigInput.class));

        deserializedMessage = BufferHelper.deserialize(factory, bb);
    }

    @Test
    public void test() throws Exception {
        BufferHelper.checkHeaderV13(deserializedMessage);
    }
}
