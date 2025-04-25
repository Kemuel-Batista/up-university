import { Module } from '@nestjs/common'
import { TypeOrmModule } from '@nestjs/typeorm'
import { User } from 'src/models/user'

@Module({
  imports: [TypeOrmModule.forFeature([User])],
  providers: [],
  exports: [TypeOrmModule],
})
export class DatabaseModule {}
