package com.leovideo.surgeofwar.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.effect.EntityLightningBolt;

import java.util.Map;

import com.leovideo.surgeofwar.ElementsSurgeofwarMod;

@ElementsSurgeofwarMod.ModElement.Tag
public class ProcedureSunSwordQuandUneEntiteVivanteEstFrappeeAvecLoutil extends ElementsSurgeofwarMod.ModElement {
	public ProcedureSunSwordQuandUneEntiteVivanteEstFrappeeAvecLoutil(ElementsSurgeofwarMod instance) {
		super(instance, 237);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure SunSwordQuandUneEntiteVivanteEstFrappeeAvecLoutil!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure SunSwordQuandUneEntiteVivanteEstFrappeeAvecLoutil!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure SunSwordQuandUneEntiteVivanteEstFrappeeAvecLoutil!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure SunSwordQuandUneEntiteVivanteEstFrappeeAvecLoutil!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		world.addWeatherEffect(new EntityLightningBolt(world, (int) x, (int) y, (int) z, false));
	}
}
