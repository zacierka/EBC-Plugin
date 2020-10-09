package com.eboyclique.switchmod.rabbit;

import java.io.IOException;
import java.io.Serializable;

import org.apache.commons.lang.SerializationUtils;


/**
 * The producer endpoint that writes to the queue.
 * CREDIT: syntx (dzone.com/articles/getting-started-rabbitmq-java)
 *
 */
public class Producer extends EndPoint{

    public Producer(String endPointName) throws IOException{
        super(endPointName);
    }

    public void sendMessage(Serializable object) throws IOException {
        channel.basicPublish("",endPointName, null, SerializationUtils.serialize(object));
    }
}