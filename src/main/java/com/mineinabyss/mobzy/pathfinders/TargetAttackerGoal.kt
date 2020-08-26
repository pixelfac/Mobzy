package com.mineinabyss.mobzy.pathfinders

import com.mineinabyss.mobzy.api.nms.aliases.toBukkit
import com.mineinabyss.mobzy.ecs.components.minecraft.attributes
import com.mineinabyss.mobzy.mobs.CustomMob
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityTargetEvent

class TargetAttackerGoal(
        override val mob: CustomMob,
        private val range: Double = mob.attributes?.followRange ?: 0.0
) : MobzyPathfinderGoal() {
    init {
        setType(Type.TARGET)
    }
    private lateinit var playerDamager: Player
    override fun shouldExecute(): Boolean {
        val damager = (nmsEntity.lastDamager ?: return false).toBukkit()
        if (damager !is Player) return false
        playerDamager = damager
        return shouldKeepExecuting()
    }

    override fun shouldKeepExecuting(): Boolean = isPlayerValidTarget(playerDamager, range)

    override fun init() {
        nmsEntity.setGoalTarget(nmsEntity.lastDamager ?: return,
                EntityTargetEvent.TargetReason.TARGET_ATTACKED_NEARBY_ENTITY, true)
    }

    override fun reset() {
        mob.target = null
    }
}