package com.leovideo.surgeofwar.procedure;

import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.leovideo.surgeofwar.ElementsSurgeofwarMod;

@ElementsSurgeofwarMod.ModElement.Tag
public class ProcedureUnlessSwordQuandUneEntiteVivanteEstFrappeeAvecLoutil extends ElementsSurgeofwarMod.ModElement {
	public ProcedureUnlessSwordQuandUneEntiteVivanteEstFrappeeAvecLoutil(ElementsSurgeofwarMod instance) {
		super(instance, 340);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure UnlessSwordQuandUneEntiteVivanteEstFrappeeAvecLoutil!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.WITHER, (int) 60, (int) 1, (false), (false)));
	}
}
