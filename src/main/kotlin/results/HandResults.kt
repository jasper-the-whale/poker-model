package results

import domain.Card

private const val ALL_PICTURES_STRING = "2345678910JQKA"

fun List<Card>.isPair(): Boolean =
    this.groupBy { it.picture }.entries.any { it.value.size == 2 }

fun List<Card>.isTriple(): Boolean =
    this.groupBy { it.picture }.entries.any { it.value.size == 3 }

fun List<Card>.isQuadruple(): Boolean =
    this.groupBy { it.picture }.entries.any { it.value.size == 4 }

fun List<Card>.isTwoPair(): Boolean =
    true

fun List<Card>.isFullHouse(): Boolean =
    this.map { it.picture }.distinct().size != this.size

fun List<Card>.isFlush(): Boolean =
    this.groupBy { it.suit }.entries.any { it.value.size >= 5 }

fun List<Card>.isStraight(): Boolean {
    val orderedList = this.sortedBy { it.picture.valueNumber }.distinctBy { it.picture.valueString }
    println(orderedList)
    val orderedPictureLists = (0..orderedList.size - 5).map {
        (0..4).fold("",
            { accumulator, index -> "$accumulator${orderedList[it + index].picture.valueString}" }
        )
    }
    return orderedPictureLists.any { ALL_PICTURES_STRING.contains(it) }
}

fun List<Card>.isStraightFlush(): Boolean =
    this.groupBy { it.suit }.entries.filter {
        it.value.size >= 5
    }.any { it.value.isStraight() }


