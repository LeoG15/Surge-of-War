package com.leovideo.surgeofwar.procedure;

import net.minecraft.world.World;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.leovideo.surgeofwar.ElementsSurgeofwarMod;

@ElementsSurgeofwarMod.ModElement.Tag
public class ProcedureHucknessPotionQuandLaPotionCommenceappliquee extends ElementsSurgeofwarMod.ModElement {
	public ProcedureHucknessPotionQuandLaPotionCommenceappliquee(ElementsSurgeofwarMod instance) {
		super(instance, 351);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure HucknessPotionQuandLaPotionCommenceappliquee!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure HucknessPotionQuandLaPotionCommenceappliquee!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure HucknessPotionQuandLaPotionCommenceappliquee!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure HucknessPotionQuandLaPotionCommenceappliquee!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure HucknessPotionQuandLaPotionCommenceappliquee!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.POISON, (int) 120, (int) 2, (false), (false)));
		world.spawnParticle(EnumParticleTypes.SPELL_WITCH, x, y, z, 0, 1, 0);
	}
}
