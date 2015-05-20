package com.polyglot.json.domain

import com.fasterxml.jackson.annotation.{JsonGetter, JsonSetter}

case class Address(
                    @JsonGetter("road") @JsonSetter("road") var road: String,
                    @JsonGetter("city") @JsonSetter("city") var city: String,
                    @JsonGetter("state") @JsonSetter("state") var state: String,
                    @JsonGetter("zipCode") @JsonSetter("zip") var zipCode: String
                    )
