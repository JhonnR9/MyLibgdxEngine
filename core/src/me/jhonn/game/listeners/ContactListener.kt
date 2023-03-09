package me.jhonn.game.listeners

import com.badlogic.gdx.physics.box2d.Contact
import com.badlogic.gdx.physics.box2d.ContactImpulse
import com.badlogic.gdx.physics.box2d.ContactListener
import com.badlogic.gdx.physics.box2d.Fixture
import com.badlogic.gdx.physics.box2d.Manifold
import me.jhonn.game.enuns.UserData

class ContactListener : ContactListener {
    var isPlayerToForeground = false

    /** Called when two fixtures begin to touch.  */
    override fun beginContact(contact: Contact) {
        val fa = contact.fixtureA
        val fb = contact.fixtureB
        if (fa == null || fb == null) return
        if (fa.userData == null || fb.userData == null) return

        isPlayerToForeground = isPlayerToForeground(fa, fb)

    }

    /** Called when two fixtures cease to touch.  */
    override fun endContact(contact: Contact) {
        val fa = contact.fixtureA
        val fb = contact.fixtureB
        if (fa == null || fb == null) return
        if (fa.userData == null || fb.userData == null) return
        isPlayerToForeground = false


    }

    private fun isPlayerToForeground(fa: Fixture, fb: Fixture): Boolean {
        if (fa.userData.equals(UserData.SENSOR_FOREGROUND) || fb.userData.equals(UserData.SENSOR_FOREGROUND)) {
            if (fa.userData.equals(UserData.PLAYER) || fb.userData.equals(UserData.PLAYER)) {
                return true
            }
        }
        return false
    }

    override fun preSolve(contact: Contact?, oldManifold: Manifold?) {

    }

    override fun postSolve(contact: Contact?, impulse: ContactImpulse?) {

    }
}