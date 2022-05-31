package party.lemons.rustediron.mixin;

import com.google.common.collect.BiMap;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoneycombItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import org.checkerframework.checker.units.qual.A;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import party.lemons.rustediron.RustedIron;
import party.lemons.rustediron.block.WeatheringIron;

import java.util.Optional;

@Mixin(AxeItem.class)
public class AxeMixin
{
	@Inject(at = @At("HEAD"), method = "useOn", cancellable = true)
	public void useOn(UseOnContext useOnContext, CallbackInfoReturnable<InteractionResult> cbi)
	{
		Level level = useOnContext.getLevel();
		BlockPos blockPos = useOnContext.getClickedPos();
		Player player = useOnContext.getPlayer();
		BlockState blockState = level.getBlockState(blockPos);
		Optional<BlockState> rustStrip = WeatheringIron.getPrevious(blockState);
		Optional<BlockState> rustWaxStrip = Optional.ofNullable(RustedIron.getWaxMapInv().get(blockState.getBlock())).map((block) -> block.withPropertiesOf(blockState));

		Optional<BlockState> result = Optional.empty();

		if(rustStrip.isPresent())
		{
			level.playSound(player, blockPos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
			level.levelEvent(player, LevelEvent.PARTICLES_SCRAPE, blockPos, 0);
			result = rustStrip;
		}
		else if(rustWaxStrip.isPresent())
		{
			level.playSound(player, blockPos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0F, 1.0F);
			level.levelEvent(player, LevelEvent.PARTICLES_WAX_OFF, blockPos, 0);
			result = rustWaxStrip;
		}

		if (result.isPresent()) {
			ItemStack itemStack = useOnContext.getItemInHand();
			if (player instanceof ServerPlayer) {
				CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, blockPos, itemStack);
			}

			level.setBlock(blockPos, result.get(), Block.UPDATE_ALL_IMMEDIATE);
			if (player != null) {
				itemStack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(useOnContext.getHand()));
			}
			cbi.setReturnValue(InteractionResult.sidedSuccess(level.isClientSide));
		}
	}
}
