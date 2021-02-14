
package com.leovideo.surgeofwar.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import java.util.Map;
import java.util.HashMap;

import com.leovideo.surgeofwar.procedure.ProcedureAmethistearmorBodyTickEvent;
import com.leovideo.surgeofwar.creativetab.TabItemOfWar;
import com.leovideo.surgeofwar.ElementsSurgeofwarMod;

@ElementsSurgeofwarMod.ModElement.Tag
public class ItemAmethistearmor extends ElementsSurgeofwarMod.ModElement {
	@GameRegistry.ObjectHolder("surgeofwar:amethistearmorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("surgeofwar:amethistearmorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("surgeofwar:amethistearmorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("surgeofwar:amethistearmorboots")
	public static final Item boots = null;
	public ItemAmethistearmor(ElementsSurgeofwarMod instance) {
		super(instance, 11);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("AMETHISTEARMOR", "surgeofwar:ametihiste_", 200, new int[]{3, 6, 7, 4}, 9,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("block.dispenser.launch")), 2f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("amethistearmorhelmet")
				.setRegistryName("amethistearmorhelmet").setCreativeTab(TabItemOfWar.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					ProcedureAmethistearmorBodyTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("amethistearmorbody").setRegistryName("amethistearmorbody").setCreativeTab(TabItemOfWar.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("amethistearmorlegs")
				.setRegistryName("amethistearmorlegs").setCreativeTab(TabItemOfWar.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("amethistearmorboots")
				.setRegistryName("amethistearmorboots").setCreativeTab(TabItemOfWar.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("surgeofwar:amethistearmorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("surgeofwar:amethistearmorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("surgeofwar:amethistearmorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("surgeofwar:amethistearmorboots", "inventory"));
	}
}
