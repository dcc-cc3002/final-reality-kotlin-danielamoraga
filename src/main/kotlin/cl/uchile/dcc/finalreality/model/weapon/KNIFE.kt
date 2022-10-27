package cl.uchile.dcc.finalreality.model.weapon

import java.util.Objects

/**
 * An `KNIFE` is a type of [Item] (Weapon)
 *
 * @param name        the KNIFE's name
 * @param damage      the KNIFE's damage
 * @param weight      the KNIFE's weight
 * @constructor Creates a new KNIFE.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Daniela Moraga
 */

class KNIFE (
    name: String,
    damage: Int,
    weight: Int
) : Weapon(name, damage, weight) {

    override fun equals(other: Any?) = when {
        this === other -> true
        other !is KNIFE -> false
        hashCode() != other.hashCode() -> false
        name != other.name -> false
        damage != other.damage -> false
        weight != other.weight -> false
        else -> true
    }

    override fun hashCode() = Objects.hash(KNIFE::class, name, damage, weight)

    override fun toString() = "KNIFE { " +
        "name: $name, " +
        "damage: $damage, " +
        "weight: $weight " +
        "}"
}