package me.jhonn.game.screens

import com.badlogic.gdx.scenes.scene2d.ui.Label
import me.jhonn.game.main.BaseGame


class GameScreen(game: BaseGame) : BaseScreen(game) {

    init {
        val label = Label("game screen", skin)
        uiStage.addActor(label)
    }


}