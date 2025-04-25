import {
  Controller,
  Get,
  Post,
  Body,
  Param,
  Put,
  Delete,
} from "@nestjs/common";
import { Category } from "src/models/category";
import { CategoryService } from "src/services/category.service";

@Controller("category")
export class CategoryController {
  constructor(private readonly categoryService: CategoryService) {}

  @Get()
  async getAllCategory(): Promise<Category[]> {
    return this.categoryService.findAll();
  }

  @Get(":id")
  async getCategory(@Param("id") id: number): Promise<Category> {
    return this.categoryService.findOne(id);
  }

  @Post()
  async createCategory(@Body() category: Category): Promise<Category> {
    return this.categoryService.create(category);
  }

  @Put(":id")
  async updateCategory(
    @Param("id") id: number,
    @Body() category: Partial<Category>,
  ): Promise<Category> {
    return this.categoryService.update(id, category);
  }

  @Delete(":id")
  async deleteCategory(@Param("id") id: number): Promise<void> {
    return this.categoryService.remove(id);
  }
}
