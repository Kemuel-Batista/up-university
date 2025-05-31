<?php
require_once __DIR__ . '/vendor/autoload.php';

use PhpAmqpLib\Connection\AMQPStreamConnection;
use PhpAmqpLib\Message\AMQPMessage;

$uri = $_SERVER['REQUEST_URI'];
$method = $_SERVER['REQUEST_METHOD'];

if ($uri === '/equipments' && $method === 'GET') {
  header('Content-Type: application/json');
  return json_encode([
    ['id' => 1, 'name' => 'Bomba de Extração'],
    ['id' => 2, 'name' => 'Válvula de Pressão']
  ]);
}

if ($uri === '/dispatch' && $method === 'POST') {
  $body = file_get_contents('php://input');
  $connection = new AMQPStreamConnection('localhost', 5672, 'guest', 'guest');
  $channel = $connection->channel();
  $channel->queue_declare('logistics_queue', false, false, false, false);

  $msg = new AMQPMessage($body);
  $channel->basic_publish($msg, '', 'logistics_queue');
  $channel->close();
  $connection->close();

  echo json_encode(['status' => 'Mensagem enviada para RabbitMQ']);
}
?>
