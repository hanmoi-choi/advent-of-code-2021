package example

import scala.util.parsing.combinator._

sealed trait DirectionToken
case class Forward(value: Int) extends DirectionToken
case class Down(value: Int) extends DirectionToken
case class Up(value: Int) extends DirectionToken

class WorkflowLexer extends RegexParsers {
  def forward: Parser[String] = "forward".r
  def down: Parser[String]    = "down".r
  def up: Parser[String]      = "up".r
  def number: Parser[Int]    = """(\d*)""".r ^^ { _.toInt }

  def forwardDirection: Parser[DirectionToken] = forward ~ number ^^ { case _ ~ v => Forward(v) }
  def downDirection: Parser[DirectionToken] = down ~ number ^^ { case _ ~ v => Down(v) }
  def upDirection: Parser[DirectionToken] = up ~ number ^^ { case _ ~ v => Up(v) }

  def directions: Parser[DirectionToken] = forwardDirection | downDirection | upDirection
}

case class Position(x: Int, y: Int)

object Day2 extends WorkflowLexer {
  def run(inputs: List[String]): Int = {
    val lastPosition = inputs.foldLeft(Position(0, 0)) { (acc: Position, elem: String) =>
      parse(directions, elem) match {
        case Success(matched,_) => moveDirection(acc, matched)
        case Failure(msg,_) =>
          println(s"FAILURE: $msg")
          acc
        case Error(msg,_) =>
          println(s"ERROR: $msg")
          acc
      }
    }

    lastPosition.x * lastPosition.y
  }

  private def moveDirection(acc: Position, directionToken: DirectionToken) =
    directionToken match {
      case Forward(v) => Position(acc.x + v, acc.y)
      case Down(v) => Position(acc.x, acc.y + v)
      case Up(v) => Position(acc.x, acc.y - v)
    }
}

