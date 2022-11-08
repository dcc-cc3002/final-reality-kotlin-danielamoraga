package cl.uchile.dcc.finalreality.model.weapon

import cl.uchile.dcc.finalreality.model.character.player.BlackMage
import cl.uchile.dcc.finalreality.model.character.player.Engineer
import cl.uchile.dcc.finalreality.model.character.player.Knight
import cl.uchile.dcc.finalreality.model.character.player.Thief
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage

/**
 * A class that holds all the information of a weapon.
 *
 * @property name String
 *     The name of the weapon.
 * @property damage Int
 *     The base damage done by the weapon.
 * @property weight Int
 *     The weight of the weapon.
 *
 * @constructor Creates a weapon with a name, a base damage, speed, and it's type.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Daniela Moraga
 */
abstract class Weapon(
    val name: String,
    val damage: Int,
    val weight: Int
) : Item {

    override fun equippedByBlackMage(blackMage: BlackMage) {
    }
    override fun equippedByEngineer(engineer: Engineer) {
    }
    override fun equippedByKnight(knight: Knight) {
    }
    override fun equippedByThief(thief: Thief) {
    }
    override fun equippedByWhiteMage(whiteMage: WhiteMage) {
    }
}
