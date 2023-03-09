package me.jhonn.game.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.scenes.scene2d.ui.Label
import me.jhonn.game.main.BaseGame


class MainMenuScreen(game: BaseGame) : BaseScreen(game) {


    init {
        val label = Label("main menu", skin)
        uiStage.addActor(label)
    }

    override fun keyDown(keyCode: Int): Boolean {
        println(keyCode)
        if (keyCode == Input.Keys.A) {
            game.screen.hide()
            game.screen.dispose()
            game.screen = MainMenuScreen(game)
            game.screen.show()
        }
        return super.keyDown(keyCode)
    }

    override fun render(delta: Float) {
        if (Gdx.input.isKeyPressed(Input.Keys.E)) {
            game.screen.hide()
            game.screen.dispose()
            game.screen = GameScreen(game)
            game.screen.show()
        }
        super.render(delta)
    }
}