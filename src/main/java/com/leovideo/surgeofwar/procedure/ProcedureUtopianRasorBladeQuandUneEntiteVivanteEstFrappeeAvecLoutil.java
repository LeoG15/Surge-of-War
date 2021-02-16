package com.leovideo.surgeofwar.procedure;

import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.leovideo.surgeofwar.ElementsSurgeofwarMod;

@ElementsSurgeofwarMod.ModElement.Tag
public class ProcedureUtopianRasorBladeQuandUneEntiteVivanteEstFrappeeAvecLoutil extends ElementsSurgeofwarMod.ModElement {
	public ProcedureUtopianRasorBladeQuandUneEntiteVivanteEstFrappeeAvecLoutil(ElementsSurgeofwarMod instance) {
		super(instance, 332);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure UtopianRasorBladeQuandUneEntiteVivanteEstFrappeeAvecLoutil!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.INSTANT_DAMAGE, (int) 60, (int) 2));
	}
}
