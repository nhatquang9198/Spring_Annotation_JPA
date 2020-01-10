package com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ ServiceConfig.class, DataConfig.class, RepositoryConfig.class })
public class AppConfig {

}
