package com.example.eightball

data class questionClass2(var fortune: String = "") {
    fun selectFortune() {
        fortune = fortunes.random()
    }

    val fortunes = arrayOf(
        "It is certain.", "Without a doubt.", "Yes definitely.",
        "Ask again later.", "Cannot predict now.", "Reply hazy, try again.",
        "Don't count on it.", "My sources say no.", "Outlook not so good."
    )
}