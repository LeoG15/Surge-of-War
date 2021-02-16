package com.leovideo.surgeofwar.procedure;

import net.minecraft.world.World;
import net.minecraft.potion.PotionEffect;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.leovideo.surgeofwar.potion.PotionHucknessPotion;
import com.leovideo.surgeofwar.ElementsSurgeofwarMod;

@ElementsSurgeofwarMod.ModElement.Tag
public class ProcedureHucknessBowQuandUneBalleToucheUneEntiteVivante extends ElementsSurgeofwarMod.ModElement {
	public ProcedureHucknessBowQuandUneBalleToucheUneEntiteVivante(ElementsSurgeofwarMod instance) {
		super(instance, 354);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure HucknessBowQuandUneBalleToucheUneEntiteVivante!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure HucknessBowQuandUneBalleToucheUneEntiteVivante!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure HucknessBowQuandUneBalleToucheUneEntiteVivante!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure HucknessBowQuandUneBalleToucheUneEntiteVivante!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure HucknessBowQuandUneBalleToucheUneEntiteVivante!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(PotionHucknessPotion.potion, (int) 60, (int) 1));
		if (!world.isRemote) {
			world.createExplosion(null, (int) x, (int) y, (int) z, (float) 3, true);
		}
	}
}
