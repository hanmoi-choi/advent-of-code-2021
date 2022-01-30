package example

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Day1Spec extends AnyFlatSpec with Matchers {
  "Day1 example" should "pass" in {
    val inputs = List(
      199,
      200,
      208,
      210,
      200,
      207,
      240,
      269,
      260,
      263
    )

    val expectedOutput = List(
      "199 (N/A - no previous measurement)",
      "200 (increased)",
      "208 (increased)",
      "210 (increased)",
      "200 (decreased)",
      "207 (increased)",
      "240 (increased)",
      "269 (increased)",
      "260 (decreased)",
      "263 (increased)"
    )
    Day1.run(inputs) shouldEqual expectedOutput
  }
}
