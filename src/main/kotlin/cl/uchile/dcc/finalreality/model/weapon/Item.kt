package cl.uchile.dcc.finalreality.model.weapon

import cl.uchile.dcc.finalreality.model.character.player.BlackMage
import cl.uchile.dcc.finalreality.model.character.player.Engineer
import cl.uchile.dcc.finalreality.model.character.player.Knight
import cl.uchile.dcc.finalreality.model.character.player.Thief
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage

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
    fun equippedByBlackMage(blackMage: BlackMage)
    fun equippedByEngineer(engineer: Engineer)
    fun equippedByKnight(knight: Knight)
    fun equippedByThief(thief: Thief)
    fun equippedByWhiteMage(whiteMage: WhiteMage)
}
