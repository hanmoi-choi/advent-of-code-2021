package example

case class Cell(value: Int, neighborIndices: List[(Int, Int)] = List.empty[(Int, Int)], neighborValues: List[Int] = List.empty[Int])

object Day9 {
  def run(inputs: Map[Int, List[Int]]): Int = {
    val numberOfRows = inputs.keys.size
    val numberOfColumns = inputs.values.head.size

    val cells = inputs.map { row =>
      val (i, data) = row

      val cells = data.zipWithIndex.map{ e =>
        val (v, j) = e
        val potentialNeighborIndices = List((i, j-1), (i, j+1), (i-1, j), (i+1, j))
        val neighborIndices = potentialNeighborIndices.filter { i =>
          val (x, y) = i
          x >= 0 && y >= 0 && x < numberOfRows && y < numberOfColumns
        }
        val neighborValues = neighborIndices.map { i =>
          val (x, y) = i
          inputs.get(x).map(_.drop(y).head).get
        }
        Cell(v, neighborIndices, neighborValues)
      }

      i -> cells
    }

    cells.flatMap { row =>
      val (_, data) = row

      data.filter { c =>
        c.value < c.neighborValues.min
      }
    }.map(_.value + 1).sum
  }

}

