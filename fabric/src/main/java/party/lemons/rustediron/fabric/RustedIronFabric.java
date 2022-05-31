package party.lemons.rustediron.fabric;

import net.fabricmc.api.ModInitializer;
import party.lemons.rustediron.RustedIron;

public class RustedIronFabric implements ModInitializer
{
	@Override
	public void onInitialize()
	{
		RustedIron.init();
	}
}
