import { Module } from '@nestjs/common'
import { CacheModule } from 'src/cache/cache.module'
import { DatabaseModule } from 'src/database/database.module'

import { AuthenticateUserController } from './controllers/authenticate-user.controller'
import { CreateCategoryUserController } from './controllers/create-category.controller'
import { AuthenticateUserService } from './services/authenticate-user'
import { GetUserService } from './services/get-user'

@Module({
  imports: [DatabaseModule, CacheModule],
  controllers: [AuthenticateUserController, CreateCategoryUserController],
  providers: [AuthenticateUserService, GetUserService],
})
export class HttpModule {}
