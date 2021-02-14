
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

import com.leovideo.surgeofwar.procedure.ProcedureHellstoneArmorBodyTickEvent;
import com.leovideo.surgeofwar.creativetab.TabItemOfWar;
import com.leovideo.surgeofwar.ElementsSurgeofwarMod;

@ElementsSurgeofwarMod.ModElement.Tag
public class ItemHellstoneArmor extends ElementsSurgeofwarMod.ModElement {
	@GameRegistry.ObjectHolder("surgeofwar:hellstonearmorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("surgeofwar:hellstonearmorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("surgeofwar:hellstonearmorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("surgeofwar:hellstonearmorboots")
	public static final Item boots = null;
	public ItemHellstoneArmor(ElementsSurgeofwarMod instance) {
		super(instance, 183);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("HELLSTONEARMOR", "surgeofwar:ellstone_rmor_", 1024, new int[]{12, 17, 19, 14}, 9,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 0f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("hellstonearmorhelmet")
				.setRegistryName("hellstonearmorhelmet").setCreativeTab(TabItemOfWar.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					ProcedureHellstoneArmorBodyTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("hellstonearmorbody").setRegistryName("hellstonearmorbody").setCreativeTab(TabItemOfWar.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("hellstonearmorlegs")
				.setRegistryName("hellstonearmorlegs").setCreativeTab(TabItemOfWar.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("hellstonearmorboots")
				.setRegistryName("hellstonearmorboots").setCreativeTab(TabItemOfWar.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("surgeofwar:hellstonearmorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("surgeofwar:hellstonearmorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("surgeofwar:hellstonearmorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("surgeofwar:hellstonearmorboots", "inventory"));
	}
}
