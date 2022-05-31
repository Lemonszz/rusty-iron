package party.lemons.rustediron.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import party.lemons.rustediron.block.IronBlockProxy;

import java.util.Random;

@Mixin(Block.class)
public abstract class BlockMixin extends BlockBehaviour
{
	private BlockMixin(Properties properties)
	{
		super(properties);
	}

	@Override
	public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, Random random)
	{
		if((Object)this == Blocks.IRON_BLOCK)
			IronBlockProxy.INSTANCE.onRandomTick(blockState, serverLevel, blockPos, random);
	}

	@Inject(at = @At("HEAD"), method = "isRandomlyTicking", cancellable = true)
	public void isRandomlyTicking(BlockState blockState, CallbackInfoReturnable<Boolean> cbi)
	{
		if((Object)this == Blocks.IRON_BLOCK)
			cbi.setReturnValue(true);
	}
}
