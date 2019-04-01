package play

import javafx.scene.input.{KeyCode, KeyEvent, MouseEvent}
import scalafx.scene.shape.{Box, Circle}
import scalafx.scene.{Group, Scene}
import scalafx.animation.AnimationTimer
import scalafx.application.JFXApp.PrimaryStage
import scalafx.application.JFXApp
import scalafx.scene.control.{TextField, Label,Button}
import scalafx.scene.paint.Color
import scalafx.scene.image._
import scalafx.scene.text.{Text}
import scalafx.event.ActionEvent


object GUI extends JFXApp {


  val map: Group = new Group{}
  val message: String = ""

  //Sets the map
  val background = new Image("town.png",600, 600, true, true, true  )
  val view = new ImageView(background)


  //character replies under construction
  val scripts: List[String] = List("what are you doing!?",
                                  "I don't move that way.",
                                  "I can't move like that!",
                            "you're just messing with me now.")
  /*var linePlease: String = ""
  for(script <- scripts){
    this.linePlease = script
  }
  */


  //chat functions
  val welcome = new Text(15,410,"Enter player message")

  val hi = new Button("Hello!"){
    layoutX = 15
    layoutY = 550
    minHeight = 5
    minWidth = 100
    //onAction = (event: ActionEvent) => chatUpdate(hi)
  }

  val thanks = new Button ("Thanks!"){
    layoutX = 215
    layoutY = 550
    minHeight = 5
    minWidth = 100
  }

  val bye = new Button ("Goodbye!"){
    layoutX = 415
    layoutY = 550
    minHeight = 5
    minWidth = 100
  }

  /*val button = new Button("Send"){
    layoutX = 475
    layoutY = 550
    minHeight = 5
    minWidth = 100
    onAction = (event:ActionEvent) => buttonHit()
  }

  //def buttonHit(): Unit = {


  //}

  val textField: TextField = new TextField{
    editable = true
    layoutX = 15
    layoutY = 550
    minHeight = 5
    minWidth = 450
    text
  }*/

  /*val chatLog: TextField = new TextField{
    editable = false
    layoutX = 15
    layoutY = 420
    minHeight = 100
    minWidth = 500
  }*/

  //add user
  val player: Circle = new Circle{
    centerX = 200
    centerY = 200
    radius = 8
    fill = Color.Blue
  }
  map.children.add(player)

  //controls
  def movement(keyPressed: KeyCode): Unit = {
    keyPressed.getName match{
      case "Up" => player.translateY.value -= 15
      case "Left" => player.translateX.value -= 15
      case "Down" => player.translateY.value += 15
      case "Right" => player.translateX.value += 15
      case _ => println("I can't move like that!")
      }
  }

  /*def chatUpdate(buttonPressed: Button):Unit = {
    buttonPressed.onAction = (event: ActionEvent) =>
  }*/

  this.stage = new PrimaryStage{
    this.title = "Adventure Game or something"
    scene = new Scene(600, 600) {
      content = List(view, map, welcome, hi, thanks, bye)


      addEventHandler(KeyEvent.KEY_PRESSED, (event: KeyEvent) => movement(event.getCode))
    }
  }
}
