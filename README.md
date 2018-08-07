##  SpringBatch-KafkaDB Demo ##
---

### What is it? ###
A small demo that leverages Spring batch's capabilities to do job processing and Apache Kafka's stream processing.
A simple CSV file is used in a batch job which then writes it to a Kafka Producer for further processing.
A Kafka consumer can then verify by consuming the messages from the correct topic.

![image](https://user-images.githubusercontent.com/12872673/43775559-cf5ab356-9a6a-11e8-89e9-162d5acae872.png)

  
---


### Spring Batch pipeline ###
Below mentioned pipeline has been followed through out the codebase. The implementation is trivial once you modularize the responsibilities of each relevant class. 

![image](https://user-images.githubusercontent.com/12872673/43773992-394a9156-9a65-11e8-93df-ceb3e95a5889.png)

---


### Prerequisites ###
* Spring Boot + Batch + JPA  
* Apache Kafka
* Apache Zookeeper

---

### Expectation ###
 Batch systems offer tremendous advantages as compared to interactive systems.
 * Repeated jobs are done fast in batch systems without user interaction.
 * You don’t need special hardware and system support to input data in batch systems.
 * Best for large organizations but small organizations can also benefit from it.
 ---
 Expectation is to convert the following flat file into something meaningful when run as a batch process.
 
 ![image](https://user-images.githubusercontent.com/12872673/43774267-30bed9ba-9a66-11e8-88b1-19978d0e6397.png)
 
 * Such as a Kafka stream like this *
 
 ![image](https://user-images.githubusercontent.com/12872673/43774875-4646bd3c-9a68-11e8-9bcd-a352e8b36618.png)


 * Or to a datastore like this *
 
 ![image](https://user-images.githubusercontent.com/12872673/43774750-d6392048-9a67-11e8-8d8d-8a11db5750ef.png)

---

### Setting up Apache Kafka ###
```
  # Start Zookeeper instance 
  $ zookeeper-server-start.bat ..\..\config\zookeeper.properties
  
  # Start Kafka server
  $ kafka-server-start.bat ..\..\config\server.properties
  
  # Create a topic
  $ kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic CSV_TOPIC_K
  
```
 Make sure following is appended to **config\server.properties**
 ```
 port = 9092
 advertised.host.name = localhost 
 ```
 
 ---

### What are the list of branches ###
Branch | Description
------------ | -------------
master | Base branch that reads from CSV and processes them to a topic in a Kafka producer
batch-db-upload | Similar to master except that it deserializes the CSV to a H2 Database instead of Kafka

