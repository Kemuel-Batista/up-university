import {
  Controller,
  Get,
  Post,
  Put,
  Delete,
  Body,
  Param,
  UsePipes,
} from '@nestjs/common';
import { ProductService } from './product.service';
import { Product } from './models/product';
import { z } from 'zod';
import { ZodValidationPipe } from './pipes/zod-validation-pipe';

const saveProductBodySchema = z.object({
  name: z.string(),
  supplier: z.string(),
  supplierAddress: z.string(),
  quantity: z.number(),
  description: z.string(),
});

type SaveProductBodySchema = z.infer<typeof saveProductBodySchema>;

@Controller('/product')
export class ProductController {
  constructor(private readonly productService: ProductService) {}

  @Post()
  @UsePipes(new ZodValidationPipe(saveProductBodySchema))
  create(@Body() body: SaveProductBodySchema): Promise<Product> {
    return this.productService.create(body);
  }

  @Get()
  findAll(): Promise<Product[]> {
    return this.productService.findAll();
  }

  @Get(':id')
  findOne(@Param('id') id: number): Promise<Product> {
    return this.productService.findOne(id);
  }

  @Put(':id')
  update(
    @Param('id') id: number,
    @Body() body: SaveProductBodySchema,
  ): Promise<Product> {
    return this.productService.update(id, body);
  }

  @Delete(':id')
  remove(@Param('id') id: number): Promise<void> {
    return this.productService.remove(id);
  }
}
