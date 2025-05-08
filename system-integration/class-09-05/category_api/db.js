// db.js
const { Pool } = require('pg');
const Redis = require('ioredis');

const db = new Pool({
    user: 'postgres',
    host: 'localhost',
    database: 'system-integration',
    password: 'postgres',
    port: 5432,
});

const redis = new Redis();

module.exports = { db, redis };
