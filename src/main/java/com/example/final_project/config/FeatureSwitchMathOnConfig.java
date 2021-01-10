package com.example.final_project.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("feature-switch")
public class FeatureSwitchMathOnConfig {
    private boolean isMathOn;
}
