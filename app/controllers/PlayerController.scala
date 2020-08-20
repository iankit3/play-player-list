package controllers

import play.api.mvc.AbstractController
import scala.concurrent.Future
import play.mvc.Result
import play.api.mvc.Results
import com.google.inject.Inject
import play.api.mvc.ControllerComponents
import play.api.mvc.Action
import services.DataStore

class PlayerController @Inject()(
        cc: ControllerComponents
    ) extends AbstractController(cc){

    val ds: DataStore = new DataStore()   

    def get(id: Int) = Action {
        Ok(ds.getData(id).toString())
    }

    def add(player: String) = Action.async { request => 
            ds.addPlayer(player)
            //Redirect(routes.PlayerController.get(-1))
            get(-1)(request)
    }
}