package com.leovideo.surgeofwar.procedure;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.leovideo.surgeofwar.ElementsSurgeofwarMod;

@ElementsSurgeofwarMod.ModElement.Tag
public class ProcedureDevilOnEntityTickUpdate extends ElementsSurgeofwarMod.ModElement {
	public ProcedureDevilOnEntityTickUpdate(ElementsSurgeofwarMod instance) {
		super(instance, 211);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure DevilOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure DevilOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure DevilOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure DevilOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure DevilOnEntityTickUpdate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((!(Biome.REGISTRY
				.getNameForObject(world.getBiome(new BlockPos((int) (x + ((entity.motionX) + 1)), (int) y, (int) (z + ((entity.motionZ) + 1)))))
				.equals(new ResourceLocation("surgeofwar:viprinbiome"))))) {
			entity.motionX = (0 - (entity.motionX));
			entity.motionY = 0;
			entity.motionZ = (0 - (entity.motionZ));
		}
	}
}
