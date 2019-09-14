package my.company.openchainsupervizer.controller

import my.company.openchainsupervizer.config.AppProperties
import my.company.openchainsupervizer.model.NodeStatus
import my.company.openchainsupervizer.service.DataFetcher
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/nodes")
class MainController(
    val appProperties: AppProperties,
    val dataFetcher: DataFetcher
) {

    @GetMapping("/remote/status")
    fun fetchRemote(): List<NodeStatus> =
        dataFetcher.fetchData(appProperties.remoteAddresses, path = "/rpc/explorer/info")

    @GetMapping("/local/status")
    fun fetchLocal(): List<NodeStatus> =
        dataFetcher.fetchData(appProperties.localAddresses, path = "/rpc/explorer/info")

    @GetMapping("/remote/delegates")
    fun getRemoteDelegates(): List<NodeStatus> =
        dataFetcher.fetchData(appProperties.remoteAddresses, path = "/rpc/delegates")

    @GetMapping("/remote/delegates/active")
    fun getRemoteActiveDelegates(): List<NodeStatus> =
        dataFetcher.fetchData(appProperties.remoteAddresses, path = "/rpc/delegates/active")

}