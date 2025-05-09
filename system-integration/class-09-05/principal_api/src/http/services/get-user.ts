import { InjectRepository } from '@nestjs/typeorm'
import { CacheRepository } from 'src/cache/cache-repository'
import { User } from 'src/models/user'
import { Repository } from 'typeorm'

export class GetUserService {
  constructor(
    @InjectRepository(User)
    private usersRepository: Repository<User>,
    private cache: CacheRepository,
  ) {}

  async findByUsername(username: string): Promise<User | null> {
    const cacheHit = await this.cache.get(`user:username:${username}`)

    if (cacheHit) {
      const cachedData = JSON.parse(cacheHit)

      return cachedData
    }

    const user = await this.usersRepository.findOne({
      where: {
        username,
      },
    })

    await this.cache.set(
      `user:username:${username}`,
      JSON.stringify(user),
      60 * 60 * 24, // 1 day
    )

    if (!user) {
      return null
    }

    return user
  }
}
