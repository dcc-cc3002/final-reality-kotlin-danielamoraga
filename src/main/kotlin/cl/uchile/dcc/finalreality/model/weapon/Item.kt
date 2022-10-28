package cl.uchile.dcc.finalreality.model.weapon

import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter

/**
 * An Item is something player chacarters can use
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Daniela Moraga
 */
interface Item {
    /**
     * Use the Item on a player character
     */
    fun useOn(character: PlayerCharacter)
}