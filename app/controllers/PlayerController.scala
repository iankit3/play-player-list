package controllers

import play.api.mvc.AbstractController
import scala.concurrent.Future
import play.mvc.Result
import play.api.mvc.Results
import com.google.inject.Inject
import play.api.mvc.ControllerComponents
import play.api.mvc.Action
import services.DataStore
import play.api.libs.json.Json
import play.api.libs.json.Writes
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Seq
import play.api.libs.json.JsPath

class PlayerController @Inject()(
        cc: ControllerComponents
    ) extends AbstractController(cc){

    val ds: DataStore = new DataStore() 

    def get(id: Int) = Action {
        Ok(Json.toJson(ds.getData(id)))
    }

    def add(player: String) = Action.async { request => 
            ds.addPlayer(player)
            get(-1)(request)
    }

    def remove(id: Int) = Action.async { request => 
            ds.removePlayer(id)
            get(-1)(request)
    }
}