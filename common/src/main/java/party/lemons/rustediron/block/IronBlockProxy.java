package party.lemons.rustediron.block;

public class IronBlockProxy implements WeatheringIron
{
	public static IronBlockProxy INSTANCE = new IronBlockProxy();

	@Override
	public IronState getAge()
	{
		return IronState.UNAFFECTED;
	}
}
