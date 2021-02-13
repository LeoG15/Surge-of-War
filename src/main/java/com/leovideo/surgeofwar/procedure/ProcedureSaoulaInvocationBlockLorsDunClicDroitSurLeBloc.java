package com.leovideo.surgeofwar.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.leovideo.surgeofwar.entity.EntitySaoula;
import com.leovideo.surgeofwar.ElementsSurgeofwarMod;

@ElementsSurgeofwarMod.ModElement.Tag
public class ProcedureSaoulaInvocationBlockLorsDunClicDroitSurLeBloc extends ElementsSurgeofwarMod.ModElement {
	public ProcedureSaoulaInvocationBlockLorsDunClicDroitSurLeBloc(ElementsSurgeofwarMod instance) {
		super(instance, 242);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure SaoulaInvocationBlockLorsDunClicDroitSurLeBloc!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure SaoulaInvocationBlockLorsDunClicDroitSurLeBloc!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure SaoulaInvocationBlockLorsDunClicDroitSurLeBloc!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure SaoulaInvocationBlockLorsDunClicDroitSurLeBloc!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		world.addWeatherEffect(new EntityLightningBolt(world, (int) x, (int) y, (int) z, false));
		if (!world.isRemote) {
			Entity entityToSpawn = new EntitySaoula.EntityCustom(world);
			if (entityToSpawn != null) {
				entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
				world.spawnEntity(entityToSpawn);
			}
		}
	}
}
