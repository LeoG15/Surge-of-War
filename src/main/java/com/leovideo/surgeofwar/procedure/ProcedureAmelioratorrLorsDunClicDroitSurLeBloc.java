package com.leovideo.surgeofwar.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.leovideo.surgeofwar.gui.GuiAmeliorator;
import com.leovideo.surgeofwar.SurgeofwarMod;
import com.leovideo.surgeofwar.ElementsSurgeofwarMod;

@ElementsSurgeofwarMod.ModElement.Tag
public class ProcedureAmelioratorrLorsDunClicDroitSurLeBloc extends ElementsSurgeofwarMod.ModElement {
	public ProcedureAmelioratorrLorsDunClicDroitSurLeBloc(ElementsSurgeofwarMod instance) {
		super(instance, 350);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure AmelioratorrLorsDunClicDroitSurLeBloc!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure AmelioratorrLorsDunClicDroitSurLeBloc!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure AmelioratorrLorsDunClicDroitSurLeBloc!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure AmelioratorrLorsDunClicDroitSurLeBloc!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure AmelioratorrLorsDunClicDroitSurLeBloc!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).openGui(SurgeofwarMod.instance, GuiAmeliorator.GUIID, world, x, y, z);
	}
}
