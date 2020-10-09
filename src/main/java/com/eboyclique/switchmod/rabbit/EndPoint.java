package com.eboyclique.switchmod.rabbit;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Represents a connection with a queue
 * CREDIT: syntx (dzone.com/articles/getting-started-rabbitmq-java)
 */
public abstract class EndPoint{

    protected Channel channel;
    protected Connection connection;
    protected String endPointName;

    public EndPoint(String endpointName) throws IOException{
        this.endPointName = endpointName;

        //Create a connection factory
        ConnectionFactory factory = new ConnectionFactory();

        //hostname of your rabbitmq server
        factory.setHost("localhost");

        //getting a connection
        try {
            connection = factory.newConnection();

            //creating a channel
            channel = connection.createChannel();

            //declaring a queue for this channel. If queue does not exist,
            //it will be created on the server.
            channel.queueDeclare(endpointName, false, false, false, null);

        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }


    /**
     * Close channel and connection. Not necessary as it happens implicitly any way.
     * @throws IOException
     */
    public void close() {
        try {
            this.channel.close();
            this.connection.close();
        } catch (TimeoutException | IOException e) {
            e.printStackTrace();
        }

    }
}