package services

import scala.collection.mutable._
import play.api.libs.json.Json
import play.api.libs.json.Writes
import play.api.libs.json.JsPath

class DataStore(var data: Seq[String] = Seq("Sachin", "Dravid") ){
  def getData(id: Int = -1): Seq[String] = {
      if(id == -1)
        data
      else
        Seq(data(id))
  }
  
  def addPlayer(player: String) = {
    data = data.:+(player)
  }

  def removePlayer(id: Int) = {
    data = data.slice(0, id).concat(data.slice(id+1, data.size))
  }
}
