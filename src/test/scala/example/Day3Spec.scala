package example

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Day3Spec extends AnyFlatSpec with Matchers {
  "Day3 example" should "pass" in {
    val inputs = List(
      "00100",
      "11110",
      "10110",
      "10111",
      "10101",
      "01111",
      "00111",
      "11100",
      "10000",
      "11001",
      "00010",
      "01010"
    )

    // Multiplying the gamma rate (22) by the epsilon rate (9) produces the power consumption, 198.
    val expectedOutput = 198
    Day3.run(inputs) shouldEqual expectedOutput
  }
}
