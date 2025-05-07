import { Injectable } from '@nestjs/common';
import { RedisService } from './redis.service';
import { CacheRepository } from '../cache-repository';

@Injectable()
export class RedisCacheRepository implements CacheRepository {
  constructor(private redis: RedisService) {}

  async set(key: string, value: string, seconds: number): Promise<void> {
    await this.redis.set(key, value, 'EX', seconds);
  }

  get(key: string): Promise<string | null> {
    return this.redis.get(key);
  }

  async delete(key: string): Promise<void> {
    await this.redis.del(key);
  }
}
