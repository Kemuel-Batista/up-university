import 'dotenv/config'

import { DataSource } from 'typeorm'
import { Category } from './models/category'
import { Product } from './models/product'

export const AppDataSource = new DataSource({
  type: 'postgres',
  host: 'localhost',
  port: 5432,
  username: "postgres",
  password: "wyms",
  database: "wms",
  entities: [Product, Category],
  migrations: [__dirname + '/migrations/*.ts'],
  // Não habilite synchronize em produção
  synchronize: false,
})
