package example

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Day9Spec extends AnyFlatSpec with Matchers {
  "Day3 example" should "pass" in {
    val inputs = Map(
      0 -> List(2,1,9,9,9,4,3,2,1,0),
      1 -> List(3,9,8,7,8,9,4,9,2,1),
      2 -> List(9,8,5,6,7,8,9,8,9,2),
      3 -> List(8,7,6,7,8,9,6,7,8,9),
      4 -> List(9,8,9,9,9,6,5,6,7,8)
    )

    // Multiplying the gamma rate (22) by the epsilon rate (9) produces the power consumption, 198.
    val expectedOutput = 15
    Day9.run(inputs) shouldEqual expectedOutput
  }
}
