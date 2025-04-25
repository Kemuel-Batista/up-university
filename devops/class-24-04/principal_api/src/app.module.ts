import { Module } from '@nestjs/common'
import { ConfigModule } from '@nestjs/config'
import { TypeOrmModule } from '@nestjs/typeorm'

import { AuthModule } from './auth/auth.module'
import { envSchema } from './env/env'
import { EnvModule } from './env/env.module'
import { HttpModule } from './http/http.module'
import { User } from './models/user'

@Module({
  imports: [
    ConfigModule.forRoot({
      validate: (env) => envSchema.parse(env),
      isGlobal: true,
    }),
    TypeOrmModule.forRoot({
      type: 'postgres',
      host: 'wms-pg',
      port: 5432,
      username: 'postgres',
      password: 'wyms',
      database: 'wms',
      synchronize: true,
    }),
    TypeOrmModule.forFeature([User]),
    AuthModule,
    EnvModule,
    HttpModule,
  ],
  controllers: [],
  providers: [],
})
export class AppModule {}
