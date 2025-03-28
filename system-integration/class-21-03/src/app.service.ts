import { Injectable } from '@nestjs/common';
import { User } from './models/user';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';

@Injectable()
export class AppService {
  constructor(
    @InjectRepository(User)
    private usersRepository: Repository<User>,
  ) {}

  getHello(): string {
    return 'Hello World!';
  }

  async getUser({ userId }: { userId: number }): Promise<User | null> {
    return await this.usersRepository.findOne({
      where: {
        id: userId,
      },
    });
  }
}
