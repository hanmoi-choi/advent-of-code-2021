package example

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Day2Spec extends AnyFlatSpec with Matchers {
  "Day2 example" should "pass" in {
    val inputs = List(
      "forward 5",
      "down 5",
      "forward 8",
      "up 3",
      "down 8",
      "forward 2"
    )

    val expectedOutput = 150
    Day2.run(inputs) shouldEqual expectedOutput
  }
}
