package com.leovideo.surgeofwar.procedure;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.leovideo.surgeofwar.item.ItemCreationOrb;
import com.leovideo.surgeofwar.entity.EntityAznarTheChaos4thPhase;
import com.leovideo.surgeofwar.ElementsSurgeofwarMod;

@ElementsSurgeofwarMod.ModElement.Tag
public class ProcedureAznarTheChaos3thPhaseEntityDies extends ElementsSurgeofwarMod.ModElement {
	public ProcedureAznarTheChaos3thPhaseEntityDies(ElementsSurgeofwarMod instance) {
		super(instance, 257);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure AznarTheChaos3thPhaseEntityDies!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure AznarTheChaos3thPhaseEntityDies!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure AznarTheChaos3thPhaseEntityDies!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure AznarTheChaos3thPhaseEntityDies!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure AznarTheChaos3thPhaseEntityDies!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (!world.isRemote) {
			world.createExplosion(null, (int) x, (int) y, (int) z, (float) 5, true);
		}
		if (!world.isRemote) {
			Entity entityToSpawn = new EntityAznarTheChaos4thPhase.EntityCustom(world);
			if (entityToSpawn != null) {
				entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
				world.spawnEntity(entityToSpawn);
			}
		}
		if (entity instanceof EntityPlayer) {
			ItemStack _setstack = new ItemStack(ItemCreationOrb.block, (int) (1));
			_setstack.setCount(2);
			ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
		}
	}
}
