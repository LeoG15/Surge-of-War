package com.leovideo.surgeofwar.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.leovideo.surgeofwar.entity.EntityAznarTheChaos;
import com.leovideo.surgeofwar.ElementsSurgeofwarMod;

@ElementsSurgeofwarMod.ModElement.Tag
public class ProcedureAznarInvocationBlockLorsDunClicDroitSurLeBloc extends ElementsSurgeofwarMod.ModElement {
	public ProcedureAznarInvocationBlockLorsDunClicDroitSurLeBloc(ElementsSurgeofwarMod instance) {
		super(instance, 329);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure AznarInvocationBlockLorsDunClicDroitSurLeBloc!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure AznarInvocationBlockLorsDunClicDroitSurLeBloc!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure AznarInvocationBlockLorsDunClicDroitSurLeBloc!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure AznarInvocationBlockLorsDunClicDroitSurLeBloc!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (!world.isRemote) {
			world.createExplosion(null, (int) x, (int) y, (int) z, (float) 4, true);
		}
		if (!world.isRemote) {
			Entity entityToSpawn = new EntityAznarTheChaos.EntityCustom(world);
			if (entityToSpawn != null) {
				entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
				world.spawnEntity(entityToSpawn);
			}
		}
		world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
	}
}
