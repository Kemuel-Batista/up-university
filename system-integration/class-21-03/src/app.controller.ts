import { Controller, Get, Query, Res } from '@nestjs/common';
import { AppService } from './app.service';
import { Response } from 'express';

@Controller()
export class AppController {
  constructor(private readonly appService: AppService) {}

  @Get('/user')
  async handle(@Res() res: Response, @Query('userId') userId: string) {
    const user = await this.appService.getUser({ userId: parseInt(userId) });

    return res.status(200).json({
      user,
    });
  }
}
