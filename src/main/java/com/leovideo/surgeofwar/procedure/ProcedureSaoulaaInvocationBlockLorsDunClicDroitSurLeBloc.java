package com.leovideo.surgeofwar.procedure;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import java.util.Map;
import java.util.Iterator;

import com.leovideo.surgeofwar.entity.EntitySaoula;
import com.leovideo.surgeofwar.entity.EntityRedemption;
import com.leovideo.surgeofwar.ElementsSurgeofwarMod;

@ElementsSurgeofwarMod.ModElement.Tag
public class ProcedureSaoulaaInvocationBlockLorsDunClicDroitSurLeBloc extends ElementsSurgeofwarMod.ModElement {
	public ProcedureSaoulaaInvocationBlockLorsDunClicDroitSurLeBloc(ElementsSurgeofwarMod instance) {
		super(instance, 240);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SaoulaaInvocationBlockLorsDunClicDroitSurLeBloc!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure SaoulaaInvocationBlockLorsDunClicDroitSurLeBloc!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure SaoulaaInvocationBlockLorsDunClicDroitSurLeBloc!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure SaoulaaInvocationBlockLorsDunClicDroitSurLeBloc!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure SaoulaaInvocationBlockLorsDunClicDroitSurLeBloc!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
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
		if (!world.isRemote) {
			Entity entityToSpawn = new EntityRedemption.EntityCustom(world);
			if (entityToSpawn != null) {
				entityToSpawn.setLocationAndAngles((x + 2), y, z, world.rand.nextFloat() * 360F, 0.0F);
				world.spawnEntity(entityToSpawn);
			}
		}
		if (!world.isRemote) {
			Entity entityToSpawn = new EntityRedemption.EntityCustom(world);
			if (entityToSpawn != null) {
				entityToSpawn.setLocationAndAngles((x + (-2)), y, z, world.rand.nextFloat() * 360F, 0.0F);
				world.spawnEntity(entityToSpawn);
			}
		}
		if (entity instanceof EntityPlayerMP) {
			Advancement _adv = ((MinecraftServer) ((EntityPlayerMP) entity).mcServer).getAdvancementManager()
					.getAdvancement(new ResourceLocation("surgeofwar:un_grand_reveil"));
			AdvancementProgress _ap = ((EntityPlayerMP) entity).getAdvancements().getProgress(_adv);
			if (!_ap.isDone()) {
				Iterator _iterator = _ap.getRemaningCriteria().iterator();
				while (_iterator.hasNext()) {
					String _criterion = (String) _iterator.next();
					((EntityPlayerMP) entity).getAdvancements().grantCriterion(_adv, _criterion);
				}
			}
		}
	}
}
