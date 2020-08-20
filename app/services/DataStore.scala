package services

class DataStore(var data: List[String] = List("Sachin", "Dravid") ){
  def getData(id: Int = -1) = {
      if(id == -1)
        data
      else 
        data(id)
  }
  
  def addPlayer(player: String) = {
    data = data.::(player)
  }
}
