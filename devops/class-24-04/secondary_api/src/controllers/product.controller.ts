import {
  Controller,
  Get,
  Post,
  Body,
  Param,
  Put,
  Delete,
} from "@nestjs/common";

import { Product } from "src/models/product";

import { ProductService } from "src/services/product.service";

@Controller("product")
export class ProductController {
  constructor(private readonly productService: ProductService) {}

  @Get()
  async getAllProduct(): Promise<Product[]> {
    return this.productService.findAll();
  }

  @Get(":id")
  async getProduct(@Param("id") id: number): Promise<Product> {
    return this.productService.findOne(id);
  }

  @Post()
  async createProduct(@Body() newproduct: Product): Promise<Product> {
    return this.productService.create(newproduct);
  }

  @Put(":id")
  async updateProduct(
    @Param("id") id: number,
    @Body() product: Partial<Product>,
  ): Promise<Product> {
    return this.productService.update(id, product);
  }

  @Delete(":id")
  async deleteProduct(@Param("id") id: number): Promise<void> {
    return this.productService.remove(id);
  }
}
