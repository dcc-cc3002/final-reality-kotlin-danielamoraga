package cl.uchile.dcc.finalreality.model.character

import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter

/**
 * A method that enemies can use to attack a player character
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Daniela Moraga
 */

interface Attacks : GameCharacter {

    /**
     * Attacks a player character
     */
    fun attack(target: PlayerCharacter)
}
