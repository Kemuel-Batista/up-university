import { Controller, Get, Param, Res } from '@nestjs/common';
import axios from 'axios';
import { Response } from 'express';
import { CacheRepository } from './cache/cache-repository';

export interface GetWeatherRecommendationByCityResponse {
  city: string;
  temperature: number;
  unit: string;
}

@Controller('/recommendation/:city')
export class AppController {
  constructor(private cache: CacheRepository) {}

  @Get()
  async handle(@Param('city') city: string, @Res() response: Response) {
    const cacheHit = await this.cache.get(`recommendation:${city}`);

    if (cacheHit) {
      const cachedData = JSON.parse(cacheHit);

      return response.json({
        recommendation: cachedData,
      });
    }

    const { data } = await axios.get<GetWeatherRecommendationByCityResponse>(
      `http://localhost:3333/weather/${city}`,
    );

    let recommendation = '';

    if (data.temperature > 30) {
      recommendation = 'Segue a recomendação: hidratação e protetor solar';
    } else if (data.temperature >= 15 && data.temperature <= 30) {
      recommendation = 'clima está agradável';
    } else {
      recommendation = 'Segue a recomendação: um casaco';
    }

    await this.cache.set(
      `recommendation:${city}`,
      JSON.stringify(recommendation),
      60,
    );

    return response.json({
      recommendation,
    });
  }
}
