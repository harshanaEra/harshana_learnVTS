const {Kafka} = require('kafkajs');
var mysql = require('mysql2');
var cron = require('node-cron');

var mysqlConnection = mysql.createConnection({
    host: "localhost",
    user: "root",
    password: "XUQdy2ZQY%y_",
    database: "fuel_order_db",
    insecureAuth: true
});

const kafka = new Kafka({
    clientId: "fuel-dispatch-service",
    brokers: ['localhost:9092']
});

const producer = kafka.producer({groupId: 'spring-boot-kafka'});

cron.schedule('*/30 * * * * *', () => {
    producer.connect().then(() => {
        mysqlConnection.connect(function (err) {
            if (err) throw err;
            console.log("My SQl connection connected!");
            mysqlConnection.query("SELECT * FROM fuel_order WHERE status=4", function (err, result) {
                if (err) throw err;
                let dataSet = [];
                result.forEach(value => {
                    dataSet.push({
                        orderId: value.id,
                        status: "DISPATCHED",
                        dispatchedDate: Date.now(),
                        driverId: "L1_001"
                    });
                });
                if (dataSet.length > 0) {
                    dataSet.forEach(mqData => {
                        producer.send({
                            topic: 'DispatcherTopic',
                            messages: [{
                                key: "dispatcher",
                                value: JSON.stringify(mqData),
                            }],
                        });
                    })
                }
            });
        });
    });
});

producer.disconnect();