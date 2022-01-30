package example

object Day1{
  def run(inputs: List[Int]): List[String] = {
    val maybeInput = inputs.map(Some(_))
    val pairedWithPreviousInput = maybeInput.zip(maybeInput.prepended(None))

    pairedWithPreviousInput.map {
      case (Some(v), None) => s"$v (N/A - no previous measurement)"
      case (Some(v), Some(prevV)) if v >= prevV => s"$v (increased)"
      case (Some(v), Some(prevV)) if v < prevV => s"$v (decreased)"
    }
  }
}

