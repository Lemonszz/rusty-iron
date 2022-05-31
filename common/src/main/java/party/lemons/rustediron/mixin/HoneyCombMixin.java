package party.lemons.rustediron.mixin;

import com.google.common.collect.BiMap;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoneycombItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import party.lemons.rustediron.RustedIron;

import java.util.Optional;

@Mixin(HoneycombItem.class)
public class HoneyCombMixin
{
	@Inject(at = @At("HEAD"), method = "useOn", cancellable = true)
	public void useOn(UseOnContext useOnContext, CallbackInfoReturnable<InteractionResult> cbi)
	{
		Level level = useOnContext.getLevel();
		BlockPos blockPos = useOnContext.getClickedPos();
		BlockState blockState = level.getBlockState(blockPos);

		Optional<BlockState> state = Optional.ofNullable(RustedIron.getWaxMap().get(blockState.getBlock())).map((block) -> block.withPropertiesOf(blockState));
		InteractionResult result = state.map(bs->{
			Player player = useOnContext.getPlayer();
			ItemStack itemStack = useOnContext.getItemInHand();
			if (player instanceof ServerPlayer) {
				CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, blockPos, itemStack);
			}

			itemStack.shrink(1);
			level.setBlock(blockPos, bs, 11);
			level.levelEvent(player, LevelEvent.PARTICLES_AND_SOUND_WAX_ON, blockPos, 0);
			return InteractionResult.sidedSuccess(level.isClientSide);
		}).orElse(InteractionResult.PASS);

		if(result != InteractionResult.PASS)
			cbi.setReturnValue(result);
	}
}
