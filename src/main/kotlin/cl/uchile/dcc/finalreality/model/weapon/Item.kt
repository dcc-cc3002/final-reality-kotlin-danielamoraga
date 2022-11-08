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
     * Use the Item on a black mage
     */
    fun equippedByBlackMage(blackMage: BlackMage)
    /**
     * Use the Item on an engineer
     */
    fun equippedByEngineer(engineer: Engineer)
    /**
     * Use the Item on a knight
     */
    fun equippedByKnight(knight: Knight)
    /**
     * Use the Item on a thief
     */
    fun equippedByThief(thief: Thief)
    /**
     * Use the Item on a white mage
     */
    fun equippedByWhiteMage(whiteMage: WhiteMage)
}
