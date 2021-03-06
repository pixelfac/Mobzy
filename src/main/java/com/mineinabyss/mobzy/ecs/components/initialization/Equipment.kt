package com.mineinabyss.mobzy.ecs.components.initialization

import com.mineinabyss.geary.ecs.GearyComponent
import com.mineinabyss.idofront.serialization.SerializableItemStack
import kotlinx.serialization.Serializable

/**
 * A component for adding equipment to spawned mobs.
 */
@Serializable
data class Equipment(
    val helmet: SerializableItemStack? = null,
    val chestplate: SerializableItemStack? = null,
    val leggings: SerializableItemStack? = null,
    val boots: SerializableItemStack? = null
) : GearyComponent
