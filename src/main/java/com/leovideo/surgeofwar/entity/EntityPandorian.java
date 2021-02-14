
package com.leovideo.surgeofwar.entity;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.init.Items;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIFollow;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.Minecraft;

import com.leovideo.surgeofwar.item.ItemPandorianKnife;
import com.leovideo.surgeofwar.ElementsSurgeofwarMod;

@ElementsSurgeofwarMod.ModElement.Tag
public class EntityPandorian extends ElementsSurgeofwarMod.ModElement {
	public static final int ENTITYID = 33;
	public static final int ENTITYID_RANGED = 34;
	public EntityPandorian(ElementsSurgeofwarMod instance) {
		super(instance, 241);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class)
				.id(new ResourceLocation("surgeofwar", "pandorian"), ENTITYID).name("pandorian").tracker(64, 3, true).egg(-6427504, -65536).build());
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityArrowCustom.class)
				.id(new ResourceLocation("surgeofwar", "entitybulletpandorian"), ENTITYID_RANGED).name("entitybulletpandorian").tracker(64, 1, true)
				.build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = {Biome.REGISTRY.getObject(new ResourceLocation("surgeofwar:pandora")),};
		EntityRegistry.addSpawn(EntityCustom.class, 8, 3, 4, EnumCreatureType.MONSTER, spawnBiomes);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			RenderBiped customRender = new RenderBiped(renderManager, new ModelBiped(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("surgeofwar:textures/pandorian.png");
				}
			};
			customRender.addLayer(new net.minecraft.client.renderer.entity.layers.LayerBipedArmor(customRender) {
				protected void initArmor() {
					this.modelLeggings = new ModelBiped(0.5f);
					this.modelArmor = new ModelBiped(1);
				}
			});
			return customRender;
		});
		RenderingRegistry.registerEntityRenderingHandler(EntityArrowCustom.class, renderManager -> {
			return new RenderSnowball<EntityArrowCustom>(renderManager, null, Minecraft.getMinecraft().getRenderItem()) {
				public ItemStack getStackToRender(EntityArrowCustom entity) {
					return new ItemStack(Items.ARROW);
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob implements IRangedAttackMob {
		public EntityCustom(World world) {
			super(world);
			setSize(0.6f, 1.8f);
			experienceValue = 0;
			this.isImmuneToFire = true;
			setNoAI(!true);
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(ItemPandorianKnife.block, (int) (1)));
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAIFollow(this, (float) 1, 10, 5));
			this.tasks.addTask(2, new EntityAIWander(this, 1));
			this.tasks.addTask(3, new EntityAILookIdle(this));
			this.tasks.addTask(4, new EntityAIAttackMelee(this, 1.2, false));
			this.targetTasks.addTask(5, new EntityAIHurtByTarget(this, false));
			this.tasks.addTask(1, new EntityAIAttackRanged(this, 1.25D, 20, 10.0F));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.UNDEFINED;
		}

		@Override
		protected Item getDropItem() {
			return null;
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.generic.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source.getImmediateSource() instanceof EntityPlayer)
				return false;
			if (source == DamageSource.LIGHTNING_BOLT)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(35D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3D);
		}

		@Override
		public void setSwingingArms(boolean swingingArms) {
		}

		public void attackEntityWithRangedAttack(EntityLivingBase target, float flval) {
			EntityArrowCustom entityarrow = new EntityArrowCustom(this.world, this);
			double d0 = target.posY + (double) target.getEyeHeight() - 1.1;
			double d1 = target.posX - this.posX;
			double d3 = target.posZ - this.posZ;
			entityarrow.shoot(d1, d0 - entityarrow.posY + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 1.6F, 12.0F);
			this.world.spawnEntity(entityarrow);
		}
	}

	public static class EntityArrowCustom extends EntityTippedArrow {
		public EntityArrowCustom(World a) {
			super(a);
		}

		public EntityArrowCustom(World worldIn, double x, double y, double z) {
			super(worldIn, x, y, z);
		}

		public EntityArrowCustom(World worldIn, EntityLivingBase shooter) {
			super(worldIn, shooter);
		}
	}
}
