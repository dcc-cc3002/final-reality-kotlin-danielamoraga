package cl.uchile.dcc.finalreality.model.weapon

import cl.uchile.dcc.finalreality.model.character.player.BlackMage
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage
import java.util.Objects

/**
 * An `STAFF` is a type of [Item] (Weapon)
 *
 * @param name        the STAFF's name
 * @param damage      the STAFF's damage
 * @param weight      the STAFF's weight
 * @constructor Creates a new STAFF.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Daniela Moraga
 */

class STAFF(
    name: String,
    damage: Int,
    weight: Int
) : Weapon(name, damage, weight) {

    override fun equals(other: Any?) = when {
        this === other -> true
        other !is STAFF -> false
        hashCode() != other.hashCode() -> false
        name != other.name -> false
        damage != other.damage -> false
        weight != other.weight -> false
        else -> true
    }

    override fun hashCode() = Objects.hash(STAFF::class, name, damage, weight)

    override fun toString() = "STAFF { " +
        "name: $name, " +
        "damage: $damage, " +
        "weight: $weight " +
        "}"

    override fun equippedByBlackMage(blackMage: BlackMage) {
        blackMage.setEquippedWeapon(weapon = this)
    }

    override fun equippedByWhiteMage(whiteMage: WhiteMage) {
        whiteMage.setEquippedWeapon(weapon = this)
    }
}
