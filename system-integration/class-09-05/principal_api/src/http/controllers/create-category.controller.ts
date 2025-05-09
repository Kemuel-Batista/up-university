import { Body, Controller, Post, UsePipes } from '@nestjs/common'
import axios from 'axios'
import { z } from 'zod'

import { ZodValidationPipe } from '../pipes/zod-validation-pipe'

const createCategoryBodySchema = z.object({
  name: z.string(),
  description: z.string(),
})

type CreateCategoryBodySchema = z.infer<typeof createCategoryBodySchema>

@Controller('/category')
export class CreateCategoryUserController {
  @Post()
  @UsePipes(new ZodValidationPipe(createCategoryBodySchema))
  async handle(@Body() body: CreateCategoryBodySchema) {
    const { name, description } = body

    const response = await axios.post('http://localhost:3003/category', {
      name,
      description,
    })

    return response.data
  }
}
