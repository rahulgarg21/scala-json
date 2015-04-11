package com.polyglot.json.domain

import com.polyglot.json.common.BaseTest
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ObjectNode

class AddressTest extends BaseTest {

  "Address " must {

    "be able to seralize to JSON properly" in {
      val personJson: String = toJson(testPerson)
      println(personJson)
      val personFromJson: Person = fromJson(personJson, classOf[Person])
      println(personFromJson)

      val rootNode: JsonNode = objectMapper.readTree(personJson)
      val addressNode: JsonNode = rootNode.path("address")
      val addressNodeJson: String = objectMapper.writeValueAsString(addressNode)
      println(addressNodeJson)
      val addressFromJson: Address = fromJson(addressNodeJson, classOf[Address])
      println(addressFromJson)

      val nonStdAddressJsonString: String = """{"roads":"962 Clarke Rd","state":"NJ","zip":8902, "city":"North Brunswick", "test":"test"}"""
      val nonStdAddressFromJson: Address = fromJson(nonStdAddressJsonString, classOf[Address])
      println(nonStdAddressFromJson)
      println(toJson(nonStdAddressFromJson))
    }

  }

}