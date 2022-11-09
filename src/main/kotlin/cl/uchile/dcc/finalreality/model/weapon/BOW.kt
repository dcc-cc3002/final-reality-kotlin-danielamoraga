package cl.uchile.dcc.finalreality.model.weapon

import cl.uchile.dcc.finalreality.model.character.player.Engineer
import cl.uchile.dcc.finalreality.model.character.player.Thief
import java.util.Objects

/**
 * A `BOW` is a type of [Item] (Weapon)
 *
 * @param name        the BOW's name
 * @param damage      the BOW's damage
 * @param weight      the BOW's weight
 * @constructor Creates a new BOW.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Daniela Moraga
 */

class BOW(
    name: String,
    damage: Int,
    weight: Int
) : Weapon(name, damage, weight) {

    override fun equals(other: Any?) = when {
        this === other -> true
        other !is BOW -> false
        hashCode() != other.hashCode() -> false
        name != other.name -> false
        damage != other.damage -> false
        weight != other.weight -> false
        else -> true
    }

    override fun hashCode() = Objects.hash(BOW::class, name, damage, weight)

    override fun toString() = "BOW { " +
        "name: $name, " +
        "damage: $damage, " +
        "weight: $weight " +
        "}"

    override fun equippedByEngineer(engineer: Engineer) {
        engineer.setEquippedWeapon(item = this)
    }

    override fun equippedByThief(thief: Thief) {
        thief.setEquippedWeapon(item = this)
    }
}
