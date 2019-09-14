package my.company.openchainsupervizer.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component
import org.springframework.validation.annotation.Validated
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

@Component
@Validated
@ConfigurationProperties(prefix = "node")
class AppProperties(

    @field:NotEmpty
    var localAddresses: List<String> = emptyList(),

    @field:NotEmpty
    @field:Size(min = 1)
    var remoteAddresses: List<String> = emptyList()
)

