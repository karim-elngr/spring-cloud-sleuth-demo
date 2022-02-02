package com.example.springcloudsleuthreport;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleServiceDecoratorConfig {

  @Bean
  public HikariDataSource hikariDataSource() {
    return new HikariDataSource();
  }

  @Bean
  public SampleServiceDecorator sampleService(HikariDataSource hikariDataSource) {
    return new SampleServiceDecorator(hikariDataSource);
  }
}
