package com.leovideo.surgeofwar.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.leovideo.surgeofwar.entity.EntityAngurusClone;
import com.leovideo.surgeofwar.entity.EntityAngurus;
import com.leovideo.surgeofwar.ElementsSurgeofwarMod;

@ElementsSurgeofwarMod.ModElement.Tag
public class ProcedureAngurusInvocationBlockLorsDunClicDroitSurLeBloc extends ElementsSurgeofwarMod.ModElement {
	public ProcedureAngurusInvocationBlockLorsDunClicDroitSurLeBloc(ElementsSurgeofwarMod instance) {
		super(instance, 318);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure AngurusInvocationBlockLorsDunClicDroitSurLeBloc!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure AngurusInvocationBlockLorsDunClicDroitSurLeBloc!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure AngurusInvocationBlockLorsDunClicDroitSurLeBloc!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure AngurusInvocationBlockLorsDunClicDroitSurLeBloc!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
		if (!world.isRemote) {
			Entity entityToSpawn = new EntityAngurus.EntityCustom(world);
			if (entityToSpawn != null) {
				entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
				world.spawnEntity(entityToSpawn);
			}
		}
		if (!world.isRemote) {
			Entity entityToSpawn = new EntityAngurusClone.EntityCustom(world);
			if (entityToSpawn != null) {
				entityToSpawn.setLocationAndAngles((x + 2), y, z, world.rand.nextFloat() * 360F, 0.0F);
				world.spawnEntity(entityToSpawn);
			}
		}
		if (!world.isRemote) {
			Entity entityToSpawn = new EntityAngurusClone.EntityCustom(world);
			if (entityToSpawn != null) {
				entityToSpawn.setLocationAndAngles((x + (-2)), y, z, world.rand.nextFloat() * 360F, 0.0F);
				world.spawnEntity(entityToSpawn);
			}
		}
	}
}
