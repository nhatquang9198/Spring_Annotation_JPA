package com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.repository.GenericRepository;

@Configuration
@Import({ GenericRepository.class })
public class RepositoryConfig {

}
