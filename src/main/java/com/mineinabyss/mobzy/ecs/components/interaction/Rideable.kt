package com.mineinabyss.mobzy.ecs.components.interaction

import com.mineinabyss.geary.ecs.GearyComponent
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Allows players to right click on a mob with this component to start riding them.
 */
@Serializable
@SerialName("mobzy:rideable")
class Rideable : GearyComponent
