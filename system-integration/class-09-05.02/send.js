const amqp = require('amqplib/callback_api')

amqp.connect("amqp://localhost", (error, connection) => {
  if (error) throw error

  connection.createChannel(function(error1, channel) {
    if (error1) throw error1

    var queue = 'q1'
    var msg = 'Meu primeiro envio para fila'

    channel.assertQueue(queue, {
      durable: false
    })

    channel.sendToQueue(queue, Buffer.from(msg))
  });
})