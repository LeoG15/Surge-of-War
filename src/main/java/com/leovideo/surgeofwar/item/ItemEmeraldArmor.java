
package com.leovideo.surgeofwar.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import com.leovideo.surgeofwar.creativetab.TabItemOfWar;
import com.leovideo.surgeofwar.ElementsSurgeofwarMod;

@ElementsSurgeofwarMod.ModElement.Tag
public class ItemEmeraldArmor extends ElementsSurgeofwarMod.ModElement {
	@GameRegistry.ObjectHolder("surgeofwar:emeraldarmorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("surgeofwar:emeraldarmorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("surgeofwar:emeraldarmorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("surgeofwar:emeraldarmorboots")
	public static final Item boots = null;
	public ItemEmeraldArmor(ElementsSurgeofwarMod instance) {
		super(instance, 63);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("EMERALDARMOR", "surgeofwar:meraldrmor", 50, new int[]{3, 5, 6, 4}, 9,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 0f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("emeraldarmorhelmet")
				.setRegistryName("emeraldarmorhelmet").setCreativeTab(TabItemOfWar.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("emeraldarmorbody")
				.setRegistryName("emeraldarmorbody").setCreativeTab(TabItemOfWar.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("emeraldarmorlegs")
				.setRegistryName("emeraldarmorlegs").setCreativeTab(TabItemOfWar.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("emeraldarmorboots")
				.setRegistryName("emeraldarmorboots").setCreativeTab(TabItemOfWar.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("surgeofwar:emeraldarmorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("surgeofwar:emeraldarmorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("surgeofwar:emeraldarmorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("surgeofwar:emeraldarmorboots", "inventory"));
	}
}
