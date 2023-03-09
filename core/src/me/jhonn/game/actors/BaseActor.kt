package me.jhonn.game.actors


import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.physics.box2d.Body

import com.badlogic.gdx.scenes.scene2d.Group




open class BaseActor() :
    Group() {
   lateinit var body: Body
    /* private var animation: Animation<AtlasRegion>? = null
          set(anim) {
              field = anim
              if (field != null) {
                  try {
                      textureRegion = field!!.getKeyFrame(0f)
                      val sprite = Sprite(textureRegion)
                      val w: Float = sprite.width
                      val h: Float = sprite.height
                      setSize(toBox2DUnits(w), toBox2DUnits(h))
                      physical = Physical(x, y, width, height)
                      setOrigin(w / 2, h / 2)
                  } catch (_: Exception) {
                  }
              }
          }*/


    fun centerAtPosition(x: Float, y: Float) {
        setPosition(x - width / 2, y - height / 2)
    }

    fun centerAtActor(other: BaseActor) {
        centerAtPosition(other.x + other.width / 2, other.y + other.height / 2)
    }

    fun setOpacity(opacity: Float) {
        color.a = opacity
    }


    override fun act(delta: Float) {
        super.act(delta)


    }


    override fun draw(batch: Batch, parentAlpha: Float) {
        /* if (animation != null) {

             val frame = animation!!.getKeyFrame(stateTime)
             if (isVisible) {
                 updatePosition()
                 batch.draw(frame, x, y, originX, originY, width, height, scaleX, scaleY, rotation)
                 super.draw(batch, parentAlpha)
             }
         }*/

    }


    /*fun isAnimationFinished(): Boolean {
        return animation!!.isAnimationFinished(stateTime)
    }*/

}





