package com.kafka.producer;



import java.io.IOException;
import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProducerDemo {
    private static final Logger log = LoggerFactory.getLogger(ProducerDemo.class);
    public static void producer(String jsonString ) throws IOException {
        log.info("I am a Kafka Producer");
        Properties prop = ReadProducerProperties.readPropertiesFile("producer.properties");
        //String bootstrapServers = "127.0.0.1:9092";
        String bootstrapServers =prop.getProperty("bootstrapServers");
        String topic = prop.getProperty("topic");
        // create Producer properties
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // create the producer
        final  KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        // create a producer record
      final  ProducerRecord<String, String> producerRecord =
                new ProducerRecord<>(topic,jsonString); 

        // send data - asynchronous
       // producer.send(producerRecord);
         producer.send(producerRecord, new Callback() {
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                // executes every time a record is successfully sent or an exception is thrown
                if (e == null) {
                    // the record was successfully sent
                	
                	System.out.println("Received new metadata. \n" +
                            "Topic:" + recordMetadata.topic() + "\n" +
                            "Partition: " + recordMetadata.partition() + "\n" +
                            "Offset: " + recordMetadata.offset() + "\n" +
                            "Key:" + producerRecord.key() +"\n"+
                            "Timestamp: " + recordMetadata.timestamp() );
                } else {
                    log.error("Error while producing", e);
                }
            }
        });



        // flush data - synchronous
        producer.flush();
        // flush and close producer
        producer.close();
    }
}