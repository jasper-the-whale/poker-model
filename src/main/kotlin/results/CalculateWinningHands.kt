package results

import domain.Card

private const val ALL_PICTURES_STRING = "2345678910JQKA"

fun List<Card>.isPair(): Boolean =
    this.groupBy { it.pictures }.entries.count() <= 6

fun List<Card>.isTriple(): Boolean =
    this.groupBy { it.pictures }.entries.any { it.value.size == 3 }

fun List<Card>.isQuadruple(): Boolean =
    this.groupBy { it.pictures }.entries.any { it.value.size == 4 }

fun List<Card>.isTwoPair(): Boolean =
    this.groupBy { it.pictures }.entries.count { it.value.size == 2 } >= 2

fun List<Card>.isFullHouse(): Boolean =
    this.map { it.pictures }.distinct().size != this.size

fun List<Card>.isFlush(): Boolean =
    this.groupBy { it.suit }.entries.any { it.value.size >= 5 }

fun List<Card>.isStraight(): Boolean {
    val orderedList = this.sortedBy { it.pictures.picturesNumber }
    val orderedPictureLists = (0..orderedList.size - 5).map {
        orderedList[it].pictures.pictureString +
            orderedList[it + 1].pictures.pictureString +
            orderedList[it + 2].pictures.pictureString +
            orderedList[it + 3].pictures.pictureString +
            orderedList[it + 4].pictures.pictureString
    }
    return orderedPictureLists.any { ALL_PICTURES_STRING.contains(it) }
}

