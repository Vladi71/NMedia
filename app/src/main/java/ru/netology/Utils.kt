package ru.netology

class Utils {
    companion object {
        fun valueUpgrade(count: Int): String {
            return when (count) {
                in 0..999 -> count.toString()
                in 1000..1099 -> String.format((count / 1000).toString() + "K")
                in 1099..9999 -> String.format((count / 1000.toDouble()).toString() + "K")
                in 10000..99999 -> String.format((count / 1000).toString() + "K")
                in 100000..999999 -> String.format((count / 1000).toString() + "K")
                in 1000000..1099999 -> String.format((count / 1000000).toString() + "M")
                else -> String.format((count / 1000000.toDouble()).toString() + "M")
            }
        }
    }
}