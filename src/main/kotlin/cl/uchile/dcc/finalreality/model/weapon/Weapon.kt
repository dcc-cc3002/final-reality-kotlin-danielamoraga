package cl.uchile.dcc.finalreality.model

import cl.uchile.dcc.finalreality.model.weapon.Item
import cl.uchile.dcc.finalreality.model.weapon.WeaponType
import java.util.Objects

/**
 * A class that holds all the information of a weapon.
 *
 * @property name String
 *     The name of the weapon.
 * @property damage Int
 *     The base damage done by the weapon.
 * @property weight Int
 *     The weight of the weapon.
 * @property type WeaponType
 *     The type of the weapon.
 *
 * @constructor Creates a weapon with a name, a base damage, speed, and it's type.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Daniela Moraga
 */


class Weapon(
    override val name: String,
    override val damage: Int,
    override val weight: Int,
    val type: WeaponType
    ) : Item {

    override fun equals(other: Any?) = when {
        this === other                 -> true
        other !is Weapon               -> false
        hashCode() != other.hashCode() -> false
        name != other.name             -> false
        damage != other.damage         -> false
        weight != other.weight         -> false
        type != other.type             -> false
        else                           -> true
    }

    override fun hashCode() = Objects.hash(Weapon::class, name, damage, weight, type)

    override fun toString() = "Weapon { name: $name, damage: $damage, weight: $weight, type: $type)"
}