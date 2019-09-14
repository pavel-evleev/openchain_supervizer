package my.company.openchainsupervizer.model

import com.beust.klaxon.JsonObject

data class NodeStatus(val address: String, val response: JsonObject)
