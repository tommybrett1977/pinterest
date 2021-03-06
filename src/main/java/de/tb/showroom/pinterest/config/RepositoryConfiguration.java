package de.tb.showroom.pinterest.config;

import de.tb.showroom.pinterest.util.AutowireHelper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"de.tb.showroom.pinterest.model"})
@EnableJpaRepositories(basePackages = {"de.tb.showroom.pinterest.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {

    /**
     * Returns an AutowireHelper that allows for Spring managed JPA EntityListener.
     * @return autowireHelper
     */
    @Bean
    public AutowireHelper autowireHelper(){
        return AutowireHelper.getInstance();
    }
}
