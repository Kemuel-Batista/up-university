import { Injectable, UnauthorizedException } from '@nestjs/common'
import { JwtService } from '@nestjs/jwt'
import { compare } from 'bcryptjs'

import { GetUserService } from './get-user'

interface AuthenticateUserRequest {
  username: string
  password: string
}

interface AuthenticateUserResponse {
  accessToken: string
}

@Injectable()
export class AuthenticateUserService {
  constructor(
    private getUser: GetUserService,
    private jwtService: JwtService,
  ) {}

  async execute({
    username,
    password,
  }: AuthenticateUserRequest): Promise<AuthenticateUserResponse> {
    const user = await this.getUser.findByUsername(username)

    if (!user) {
      throw new UnauthorizedException('Credenciais inválidas')
    }

    const passwordMatches = await compare(password, user.password)

    if (!passwordMatches) {
      throw new UnauthorizedException('Credenciais inválidas')
    }

    const accessToken = await this.jwtService.signAsync({
      sub: user.id,
    })

    return {
      accessToken,
    }
  }
}
