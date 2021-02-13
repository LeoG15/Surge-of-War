package com.leovideo.surgeofwar.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.leovideo.surgeofwar.ElementsSurgeofwarMod;

@ElementsSurgeofwarMod.ModElement.Tag
public class ProcedureAznarTheChaos3thPhaseEntityIsHurt extends ElementsSurgeofwarMod.ModElement {
	public ProcedureAznarTheChaos3thPhaseEntityIsHurt(ElementsSurgeofwarMod instance) {
		super(instance, 146);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure AznarTheChaos3thPhaseEntityIsHurt!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure AznarTheChaos3thPhaseEntityIsHurt!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		if (!world.isRemote && entity instanceof EntityLivingBase) {
			EntityTippedArrow entityToSpawn = new EntityTippedArrow(world, (EntityLivingBase) entity);
			entityToSpawn.shoot(entity.getLookVec().x, entity.getLookVec().y, entity.getLookVec().z, ((float) 2) * 2.0F, 0);
			entityToSpawn.setDamage(((float) 2) * 2.0F);
			entityToSpawn.setKnockbackStrength((int) 0);
			world.spawnEntity(entityToSpawn);
		}
	}
}
