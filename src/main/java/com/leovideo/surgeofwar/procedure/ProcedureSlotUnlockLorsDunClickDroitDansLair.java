package com.leovideo.surgeofwar.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.leovideo.surgeofwar.gui.GuiArmetisUnlockChest;
import com.leovideo.surgeofwar.SurgeofwarMod;
import com.leovideo.surgeofwar.ElementsSurgeofwarMod;

@ElementsSurgeofwarMod.ModElement.Tag
public class ProcedureSlotUnlockLorsDunClickDroitDansLair extends ElementsSurgeofwarMod.ModElement {
	public ProcedureSlotUnlockLorsDunClickDroitDansLair(ElementsSurgeofwarMod instance) {
		super(instance, 348);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SlotUnlockLorsDunClickDroitDansLair!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure SlotUnlockLorsDunClickDroitDansLair!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure SlotUnlockLorsDunClickDroitDansLair!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure SlotUnlockLorsDunClickDroitDansLair!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure SlotUnlockLorsDunClickDroitDansLair!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).openGui(SurgeofwarMod.instance, GuiArmetisUnlockChest.GUIID, world, x, y, z);
	}
}
