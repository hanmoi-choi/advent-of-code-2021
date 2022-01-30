package example

case class DiagnosticReport(data: String, numberOfZeroBit: Int, numberOfOneBit: Int)

object Day3 {
  def run(binaryNumbers: List[String]): Int = {
    val transposedInputs = transpose(binaryNumbers)
    val bitInfos = toBitInfo(transposedInputs)
    val gammaRate = calculateGammaRate(bitInfos)
    val epsilonRate = calculateEpsilonRate(bitInfos)

    gammaRate * epsilonRate
  }

  def toBitInfo(transposedInputs: List[String]): List[DiagnosticReport] =
    transposedInputs.map { data =>
      data.foldLeft(DiagnosticReport(data, 0, 0)) { (acc, bit) =>
        bit match {
          case '0' => DiagnosticReport(acc.data, acc.numberOfZeroBit + 1, acc.numberOfOneBit)
          case '1' => DiagnosticReport(acc.data, acc.numberOfZeroBit, acc.numberOfOneBit + 1)
        }
      }
    }

  def calculateGammaRate(bitInfos: List[DiagnosticReport]): Int = {
    val gammaBinaryValue = bitInfos.map {
      case DiagnosticReport(_, z, o) if z > o => "0"
      case DiagnosticReport(_, z, o) if z <= o => "1"
    }.mkString

    Integer.parseInt(gammaBinaryValue, 2)
  }


  def calculateEpsilonRate(bitInfos: List[DiagnosticReport]): Int = {
    val epsilonBinaryValue = bitInfos.map {
      case DiagnosticReport(_, z, o) if z > o => "1"
      case DiagnosticReport(_, z, o) if z <= o => "0"
    }.mkString

    Integer.parseInt(epsilonBinaryValue, 2)
  }

  def transpose(binaryNumbers: List[String]): List[String] = {
    val lengthOfBinaryNumber = binaryNumbers.head.length

    Range(0, lengthOfBinaryNumber).map { index =>
      binaryNumbers.foldLeft(List.empty[String]){ (acc, e) => acc :+ e.charAt(index).toString }.mkString
    }.toList
  }
}

