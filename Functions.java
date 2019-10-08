
/**
* Class providing stochastic drift and diffusion
*/
public class Functions{
	
	//hardcoded functions
	public static SdeFunction getDrift()
	{
		SdeFunction a= (t,x)->0.0d;
		return a;
	}
	public static String getDriftForm()
	{
		return "a(t,x) = 0";
	}
	public static SdeFunction getDiffusion()
	{
		SdeFunction b= (t,x)->x*x;
		return b;
	}	
	public static String getDiffForm()
	{
		return "b(x,t) = x*x";
	}
}
