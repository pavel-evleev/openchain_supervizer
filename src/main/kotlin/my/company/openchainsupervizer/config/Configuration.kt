package my.company.openchainsupervizer.config

import com.beust.klaxon.Parser
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Configuration {

    @Bean
    fun getParser(): Parser = Parser()

}