package com.leovideo.surgeofwar.procedure;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.Explosion;

import com.leovideo.surgeofwar.ElementsSurgeofWar;

@ElementsSurgeofWar.ModElement.Tag
public class ProcedureBooklingMageEntityDies extends ElementsSurgeofWar.ModElement {
	public ProcedureBooklingMageEntityDies(ElementsSurgeofWar instance) {
		super(instance, 71);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure BooklingMageEntityDies!");
			return;
		}
		World world = (World) dependencies.get("world");
		world.getWorldInfo().setRaining((true));
	}

	@SubscribeEvent
	public void onExplode(ExplosionEvent.Detonate event) {
		World world = event.getWorld();
		Explosion explosion = event.getExplosion();
		int i = (int) explosion.getPosition().x;
		int j = (int) explosion.getPosition().y;
		int k = (int) explosion.getPosition().z;
		java.util.HashMap<String, Object> dependencies = new java.util.HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", world);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
	}
}
