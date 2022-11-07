fun timeUnitsToString(absenceTime: Int, inMinutes: Boolean = true) = when {
    absenceTime == 1 || (absenceTime % 10 == 1 && absenceTime != 11) ->
        if (inMinutes) "минуту" else "час"
    (absenceTime > 1 && absenceTime < 5) || (absenceTime % 10 > 1 && absenceTime % 10 < 5) ->
        if (inMinutes) "минуты" else "часа"
    else -> if (inMinutes) "минут" else "часов"
}

fun agoToText(absenceTime: Int): String {
    val secondsInMinute = 60
    val secondsInHour = 60 * secondsInMinute
    val secondsInDay = 24 * secondsInHour
    val secondsInTwoDays = 2 * secondsInDay
    val secondsInThreeDays = 3 * secondsInDay
    val minutes = absenceTime / secondsInMinute
    val hours = absenceTime / secondsInHour
    return when {
        (absenceTime < secondsInMinute) -> "только что"
        (absenceTime < secondsInHour) -> "$minutes ${timeUnitsToString(minutes)} назад"
        (absenceTime < secondsInDay) -> "$hours ${timeUnitsToString(hours, false)} назад"
        (absenceTime < secondsInTwoDays) -> "вчера"
        (absenceTime < secondsInThreeDays) -> "позавчера"
        else -> "давно"
    }
}

fun main() {
    println("Alex был(а) ${agoToText(45)}")
    println("Вася был(а) ${agoToText(90)}")
    println("Женя :) был(а) ${agoToText(130)}")
    println("Владимир был(а) ${agoToText(310)}")
    println("Дима был(а) ${agoToText(660)}")
    println("Михаил был(а) ${agoToText(1_265)}")
    println("Иван был(а) ${agoToText(1_505)}")
    println("Олег был(а) ${agoToText(7_199)}")
    println("Аркадий был(а) ${agoToText(8_000)}")
    println("Crazy Frog был(а) ${agoToText(18_000)}")
    println("Вадим был(а) ${agoToText(40_000)}")
    println("Юра был(а) ${agoToText(75_600)}")
    println("Егор был(а) ${agoToText(79_200)}")
    println("Борис был(а) ${agoToText(160000)}")
    println("Анатолий был(а) ${agoToText(240000)}")
    println("Виктор был(а) ${agoToText(400000)}")
}