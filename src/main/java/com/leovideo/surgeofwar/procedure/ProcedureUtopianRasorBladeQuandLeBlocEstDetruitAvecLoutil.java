package com.leovideo.surgeofwar.procedure;

import net.minecraft.world.World;

import java.util.Map;

import com.leovideo.surgeofwar.ElementsSurgeofwarMod;

@ElementsSurgeofwarMod.ModElement.Tag
public class ProcedureUtopianRasorBladeQuandLeBlocEstDetruitAvecLoutil extends ElementsSurgeofwarMod.ModElement {
	public ProcedureUtopianRasorBladeQuandLeBlocEstDetruitAvecLoutil(ElementsSurgeofwarMod instance) {
		super(instance, 269);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure UtopianRasorBladeQuandLeBlocEstDetruitAvecLoutil!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure UtopianRasorBladeQuandLeBlocEstDetruitAvecLoutil!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure UtopianRasorBladeQuandLeBlocEstDetruitAvecLoutil!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure UtopianRasorBladeQuandLeBlocEstDetruitAvecLoutil!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (!world.isRemote) {
			world.createExplosion(null, (int) x, (int) y, (int) z, (float) 8, true);
		}
	}
}
