import { Body, Controller, Post, UsePipes } from '@nestjs/common'
import axios from 'axios'
import { z } from 'zod'

import { ZodValidationPipe } from '../pipes/zod-validation-pipe'

const createTransactionBodySchema = z.object({
  categoryId: z.number().int(),
  description: z.string(),
  value: z.number().int(),
})

type CreateTransactionBodySchema = z.infer<typeof createTransactionBodySchema>

@Controller('/transaction')
export class CreateTransactionUserController {
  @Post()
  @UsePipes(new ZodValidationPipe(createTransactionBodySchema))
  async handle(@Body() body: CreateTransactionBodySchema) {
    const { categoryId, description, value } = body

    const response = await axios.post('http://localhost:5000/lancamentos', {
      descricao: description,
      valor: value,
      categoria: categoryId,
    })

    return response.data
  }
}
