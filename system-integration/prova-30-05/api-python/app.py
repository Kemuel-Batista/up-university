from flask import Flask, request, jsonify
import redis
import json
import threading
import pika

app = Flask(__name__)
r = redis.Redis(host='localhost', port=6379, password='university', decode_responses=True)

events_key = 'events:list'

@app.route('/event', methods=['POST'])
def receive_event():
  event = request.json
  events = json.loads(r.get(events_key) or '[]')
  events.append(event)
  r.set(events_key, json.dumps(events))
  return {'message': 'Evento recebido'}, 200

@app.route('/events', methods=['GET'])
def get_events():
  events = r.get(events_key)
  return jsonify(json.loads(events or '[]'))

# Consumidor RabbitMQ
def consume_logistics():
  def callback(ch, method, properties, body):
    event = {
      'source': 'php-logistics',
      'type': 'dispatch',
      'payload': json.loads(body),
    }
    events = json.loads(r.get(events_key) or '[]')
    events.append(event)
    r.set(events_key, json.dumps(events))
    print("Evento recebido do RabbitMQ:", event)

  connection = pika.BlockingConnection(pika.ConnectionParameters('localhost'))
  channel = connection.channel()
  channel.queue_declare(queue='logistics_queue')

  channel.basic_consume(queue='logistics_queue', on_message_callback=callback, auto_ack=True)
  print('Aguardando mensagens RabbitMQ...')
  channel.start_consuming()

# Rodar o consumidor em paralelo
threading.Thread(target=consume_logistics, daemon=True).start()

if __name__ == '__main__':
  app.run(port=5000)