import { Body, Controller, Post, UsePipes } from '@nestjs/common'
import { Public } from 'src/auth/public'
import { z } from 'zod'

import { ZodValidationPipe } from '../pipes/zod-validation-pipe'
import { AuthenticateUserService } from '../services/authenticate-user'

const authenticateBodySchema = z.object({
  username: z.string(),
  password: z.string(),
})

type AuthenticateBodySchema = z.infer<typeof authenticateBodySchema>

@Controller('/sessions')
@Public()
export class AuthenticateUserController {
  constructor(private authenticateUser: AuthenticateUserService) {}

  @Post()
  @UsePipes(new ZodValidationPipe(authenticateBodySchema))
  async handle(@Body() body: AuthenticateBodySchema) {
    const { username, password } = body

    const result = await this.authenticateUser.execute({
      username,
      password,
    })

    const { accessToken } = result

    return {
      access_token: accessToken,
    }
  }
}
