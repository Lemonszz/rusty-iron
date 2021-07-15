package party.lemons.rusted_iron.mixin;

import java.util.Optional;
import java.util.function.Supplier;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoneycombItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import party.lemons.rusted_iron.RustedIron;

@Mixin(HoneycombItem.class)
public class HoneycombMixin {

	@Inject(method = "useOnBlock", at = @At("HEAD"), cancellable = true)
	private void useOnBlock(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {
		World world = context.getWorld();
		BlockPos blockPos = context.getBlockPos();
		BlockState blockState = world.getBlockState(blockPos);
		cir.setReturnValue((ActionResult) getWaxedStateIron(blockState).map((state) -> {
			PlayerEntity playerEntity = context.getPlayer();
			ItemStack itemStack = context.getStack();
			if (playerEntity instanceof ServerPlayerEntity) {
				Criteria.ITEM_USED_ON_BLOCK.test((ServerPlayerEntity) playerEntity, blockPos, itemStack);
			}

			itemStack.decrement(1);
			world.setBlockState(blockPos, state, Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD);
			world.syncWorldEvent(playerEntity, WorldEvents.BLOCK_WAXED, blockPos, 0);
			return ActionResult.success(world.isClient);
		}).orElse(ActionResult.PASS));
	}

	@Unique
	private static Optional<BlockState> getWaxedStateIron(BlockState state) {
		return Optional.ofNullable((Block) ((BiMap) RustedIron.UNWAXED_TO_WAXED_IRON_BLOCKS.get()).get(state.getBlock()))
				.map((block) -> {
					return block.getStateWithProperties(state);
				});
	}

}
