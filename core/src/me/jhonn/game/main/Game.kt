package me.jhonn.game.main

import me.jhonn.game.screens.MainMenuScreen

class Game() : BaseGame() {

    override fun create() {
        super.create()
        screen = MainMenuScreen(this)

    }

    override fun render() {

        super.render()
    }
}