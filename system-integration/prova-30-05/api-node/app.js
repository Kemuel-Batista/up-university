const express = require('express');
const Redis = require('ioredis');
const axios = require('axios');
require('dotenv').config();

const app = express();
const redis = new Redis({
  host: process.env.REDIS_HOST || '127.0.0.1',
  port: parseInt(process.env.REDIS_PORT || '6379', 10),
  password: process.env.REDIS_PASSWORD || undefined,
});
app.use(express.json());

// Simular dados de sensores
function generateSensorData() {
  return {
    temperature: (20 + Math.random() * 30).toFixed(2),
    pressure: (1 + Math.random() * 5).toFixed(2),
    timestamp: new Date()
  };
}

// Cache com Redis
app.get('/sensor-data', async (req, res) => {
  const cache = await redis.get('sensor:data');
  if (cache) return res.json(JSON.parse(cache));

  const data = generateSensorData();
  await redis.set('sensor:data', JSON.stringify(data), 'EX', 10); // Expira em 10s
  res.json(data);
});

// Enviar alerta para API Python
app.post('/alert', async (req, res) => {
  const alert = req.body;
  try {
    await axios.post('http://localhost:5000/event', alert); // Python API
    res.status(200).send('Alerta enviado');
  } catch (err) {
    res.status(500).send('Erro ao enviar alerta');
  }
});

const PORT = 3000;
app.listen(PORT, () => {
  console.log(`API Sensor rodando na porta ${PORT}`);
});
