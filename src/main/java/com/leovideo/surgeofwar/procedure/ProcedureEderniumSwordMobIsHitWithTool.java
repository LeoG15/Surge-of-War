package com.leovideo.surgeofwar.procedure;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import com.leovideo.surgeofwar.ElementsSurgeofWar;

@ElementsSurgeofWar.ModElement.Tag
public class ProcedureEderniumSwordMobIsHitWithTool extends ElementsSurgeofWar.ModElement {
	public ProcedureEderniumSwordMobIsHitWithTool(ElementsSurgeofWar instance) {
		super(instance, 88);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure EderniumSwordMobIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).addExperience((int) 5);
	}
}
