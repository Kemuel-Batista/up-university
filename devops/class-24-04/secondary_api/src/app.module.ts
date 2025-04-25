import { Module } from "@nestjs/common";
import { TypeOrmModule } from "@nestjs/typeorm";
import { ProductModule } from "./modules/product.module";
import { Product } from "./models/product";
import { CategoryModule } from "./modules/category.module";
import { Category } from "./models/category";

@Module({
  imports: [
    TypeOrmModule.forRoot({
      type: "postgres",
      host: "wms-pg",
      port: 5432,
      username: "postgres",
      password: "wyms",
      database: "wms",
      entities: [Product, Category],
      migrations: [__dirname + '/migrations/*.ts'],
      synchronize: false,
    }),
    TypeOrmModule.forFeature([Product, Category]),
    ProductModule,
    CategoryModule,
  ],
  controllers: [],
  providers: [],
})
export class AppModule {}
