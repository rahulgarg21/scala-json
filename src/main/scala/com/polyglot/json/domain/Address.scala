package com.polyglot.json.domain

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonIgnore
import scala.beans.BeanProperty

case class Address( @JsonProperty("address1") var road:String, 
               var city: String, 
               var state: String, 
               var zipCode: Int) {
  
 @JsonProperty("roads")def setRoads(road:String) { this.road = road}
// @JsonIgnore def getRoads():String = road
 @JsonProperty("zip") def setZip(zip:Int) { this.zipCode = zip}

}
