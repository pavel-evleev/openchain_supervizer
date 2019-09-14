package my.company.openchainsupervizer.service

import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import my.company.openchainsupervizer.model.NodeStatus
import my.company.openchainsupervizer.model.RawResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.net.URI
import java.time.Duration
import java.util.concurrent.CompletableFuture

@Service
class DataFetcher(
    val parser: Parser
) {

    fun fetchData(addresses: List<String>, path: String): List<NodeStatus> {
        val result = addresses.map { RawResponse(it, executeRequest(it, path)) }
        return result.map { parseData(it.uri, it.future.join()) }.toList()
    }

    private fun executeRequest(address: String, uri: String): CompletableFuture<String> {
        log.info("Node request $address")
        val client = HttpClient.newHttpClient()
        val req = HttpRequest.newBuilder()
            .timeout(Duration.ofMillis(5000))
            .uri(URI.create("http://$address$uri"))
            .build()

        return client.sendAsync(req, HttpResponse.BodyHandlers.ofString())
            .thenApply { it.body() }
            .handle { response, throwable ->
                throwable?.let { throwable.message!! } ?: response
            }

    }

    private fun parseData(uri: String, body: String): NodeStatus {
        val json = try {
            parser.parse(StringBuilder(body)) as JsonObject
        } catch (e: RuntimeException) {
            JsonObject(mapOf(Pair("error", body)))
        }
        return NodeStatus(uri, json)
    }


    companion object {
        private val log: Logger = LoggerFactory.getLogger(DataFetcher::class.java)
    }

}