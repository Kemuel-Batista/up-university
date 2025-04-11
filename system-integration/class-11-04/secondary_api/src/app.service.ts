import { Injectable } from '@nestjs/common';

export interface GetWeatherByCityResponse {
  city: string;
  temperature: number;
  unit: string;
}

@Injectable()
export class AppService {
  getWeatherByCity(city: string): GetWeatherByCityResponse {
    return {
      city,
      temperature: 25,
      unit: 'Celsius',
    };
  }
}
