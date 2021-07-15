package party.lemons.rusted_iron.mixin;

import java.util.Optional;
import java.util.function.Consumer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.google.common.collect.BiMap;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.Tag;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import party.lemons.rusted_iron.Rustable;
import party.lemons.rusted_iron.RustedIron;

@Mixin(AxeItem.class)
public class AxeMixin extends MiningToolItem {

	protected AxeMixin(float attackDamage, float attackSpeed, ToolMaterial material, Tag<Block> effectiveBlocks,
			Settings settings) {
		super(attackDamage, attackSpeed, material, effectiveBlocks, settings);
		// TODO Auto-generated constructor stub
	}

	@Inject(method = "useOnBlock", at = @At("HEAD"), cancellable = true)
	public void useOnBlock(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {
		World world = context.getWorld();
		BlockPos blockPos = context.getBlockPos();
		PlayerEntity playerEntity = context.getPlayer();

		BlockState blockState = world.getBlockState(blockPos);
		Optional<BlockState> optional2 = Rustable.getDecreasedOxidationState(blockState);
		Optional<BlockState> optional3 = Optional
				.ofNullable((Block) ((BiMap) RustedIron.WAXED_TO_UNWAXED_IRON_BLOCKS.get()).get(blockState.getBlock()))
				.map((block) -> {
					return block.getStateWithProperties(blockState);
				});
		ItemStack itemStack = context.getStack();

		Optional<BlockState> optional4 = Optional.empty();

		if (optional2.isPresent()) {
			world.playSound(playerEntity, blockPos, SoundEvents.ITEM_AXE_SCRAPE, SoundCategory.BLOCKS, 1.0F, 1.0F);
			world.syncWorldEvent(playerEntity, WorldEvents.BLOCK_SCRAPED, blockPos, 0);
			optional4 = optional2;
		} else if (optional3.isPresent()) {
			world.playSound(playerEntity, blockPos, SoundEvents.ITEM_AXE_WAX_OFF, SoundCategory.BLOCKS, 1.0F, 1.0F);
			world.syncWorldEvent(playerEntity, WorldEvents.WAX_REMOVED, blockPos, 0);
			optional4 = optional3;
		}

		if (optional4.isPresent()) {
			if (playerEntity instanceof ServerPlayerEntity) {
				Criteria.ITEM_USED_ON_BLOCK.test((ServerPlayerEntity) playerEntity, blockPos, itemStack);
			}

			world.setBlockState(blockPos, (BlockState) optional4.get(), Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD);
			if (playerEntity != null) {
				itemStack.damage(1, (LivingEntity) playerEntity, (Consumer) ((p) -> {
					((LivingEntity) p).sendToolBreakStatus(context.getHand());
				}));
			}

			cir.setReturnValue(ActionResult.success(world.isClient));
		}
	}

}
