package cl.uchile.dcc.finalreality.model.weapon

import cl.uchile.dcc.finalreality.model.character.player.Engineer
import cl.uchile.dcc.finalreality.model.character.player.Knight
import java.util.Objects

/**
 * An `AXE` is a type of [Item] (Weapon)
 *
 * @param name        the AXE's name
 * @param damage      the AXE's damage
 * @param weight      the AXE's weight
 * @constructor Creates a new AXE.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Daniela Moraga
 */

class AXE(
    name: String,
    damage: Int,
    weight: Int
) : Weapon(name, damage, weight) {

    override fun equals(other: Any?) = when {
        this === other -> true
        other !is AXE -> false
        hashCode() != other.hashCode() -> false
        name != other.name -> false
        damage != other.damage -> false
        weight != other.weight -> false
        else -> true
    }

    override fun hashCode() = Objects.hash(AXE::class, name, damage, weight)

    override fun toString() = "AXE { " +
        "name: $name, " +
        "damage: $damage, " +
        "weight: $weight " +
        "}"

    override fun equippedByKnight(knight: Knight) {
        knight.setEquippedWeapon(weapon = this)
    }

    override fun equippedByEngineer(engineer: Engineer) {
        engineer.setEquippedWeapon(weapon = this)
    }
}
