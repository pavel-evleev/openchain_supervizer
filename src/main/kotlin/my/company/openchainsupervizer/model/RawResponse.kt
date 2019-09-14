package my.company.openchainsupervizer.model

import java.util.concurrent.CompletableFuture

class RawResponse(val uri: String, val future: CompletableFuture<String>)