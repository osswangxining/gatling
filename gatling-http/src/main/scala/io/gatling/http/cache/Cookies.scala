/**
 * Copyright 2011-2017 GatlingCorp (http://gatling.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gatling.http.cache

import java.util.{ Collection => JCollection }

import scala.collection.breakOut
import scala.collection.JavaConverters._

import io.netty.handler.codec.http.cookie.Cookie

class Cookies(cookies: JCollection[Cookie]) {

  lazy val cookieNameValuePairs: Map[String, String] = cookies.asScala.map(cookie => cookie.name -> cookie.path)(breakOut)

  override def hashCode = cookieNameValuePairs.hashCode

  override def equals(other: Any): Boolean =
    other match {
      case otherCookies: Cookies => cookieNameValuePairs == otherCookies.cookieNameValuePairs
      case _                     => false
    }
}
