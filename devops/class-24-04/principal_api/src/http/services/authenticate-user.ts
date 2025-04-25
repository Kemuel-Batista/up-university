import { Injectable, UnauthorizedException } from '@nestjs/common'
import { JwtService } from '@nestjs/jwt'
import { InjectRepository } from '@nestjs/typeorm'
import { compare } from 'bcryptjs'
import { User } from 'src/models/user'
import { Repository } from 'typeorm'

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
    @InjectRepository(User)
    private usersRepository: Repository<User>,
    private jwtService: JwtService,
  ) {}

  async execute({
    username,
    password,
  }: AuthenticateUserRequest): Promise<AuthenticateUserResponse> {
    const user = await this.usersRepository.findOne({
      where: {
        username,
      },
    })

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
