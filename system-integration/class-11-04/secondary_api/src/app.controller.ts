import { Controller, Get, Param } from '@nestjs/common';
import { AppService, GetWeatherByCityResponse } from './app.service';

@Controller('/weather/:city')
export class AppController {
  constructor(private readonly appService: AppService) {}

  @Get()
  handle(@Param('city') city: string): GetWeatherByCityResponse {
    const weather = this.appService.getWeatherByCity(city);

    return weather;
  }
}
