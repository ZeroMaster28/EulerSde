
/**
* @author ZeroMaster28
* @FunctionalInterface for sde functions like a(t,xt)
* or b(t,xt)
*/
public interface SdeFunction
{
    double map(double t,double x);
}
