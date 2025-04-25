import { Module } from '@nestjs/common'
import { DatabaseModule } from 'src/database/database.module'

import { AuthenticateUserController } from './controllers/authenticate-user.controller'
import { CreateCategoryUserController } from './controllers/create-category.controller'
import { AuthenticateUserService } from './services/authenticate-user'

@Module({
  imports: [DatabaseModule],
  controllers: [AuthenticateUserController, CreateCategoryUserController],
  providers: [AuthenticateUserService],
})
export class HttpModule {}
