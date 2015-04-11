package com.polyglot.json.common

import org.scalatest.WordSpecLike
import org.scalatest.MustMatchers
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.databind.DeserializationFeature
import java.io.StringWriter
import com.polyglot.json.domain.Address
import com.polyglot.json.domain.Person

class BaseTest extends WordSpecLike with MustMatchers {
  
  val objectMapper:ObjectMapper = new ObjectMapper
  objectMapper.registerModule(DefaultScalaModule)
  objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false)
  
  def toJson(obj:Any):String = {
    val sw:StringWriter = new StringWriter
    objectMapper.writeValue(sw, obj)
    sw.close()
    sw.getBuffer.toString()    
  }
  
  def fromJson[A](jsonString:String,cls:Class[A]):A = {
    objectMapper.readValue(jsonString, cls)
  }
  
  val testAddress = new Address("962 Clarke Rd", "North Brunswick", "NJ", 8902)
  val testPerson = Person("Rajiv", "Singla", testAddress)
}