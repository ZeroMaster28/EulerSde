import java.util.Random;
import java.io.FileWriter;
import java.io.BufferedWriter;


/** @author ZeroMaster28
 * Class represents approximate solution of SDE
 * of the form dX=a(t,X)dt+b(t,X)dW
 *
 * This approach works due to Euler-Maruyama scheme
 *
 * @version 1.0
 * Gnuplot drawing phase avaiable only on unix-like systems */
public class EulerSde{

    static double T=1.0d;     //interval
    static int N=10000;       //steps
    static boolean isWindows; //OS flag

    /** Sde parameters*/
    static final double x0=1.0d;
    static final SdeFunction a=(s,t)->0;
    static final SdeFunction b=(s,t)->t*t;

    public static void main(String []args){

        if(args!=null)
        {
            //num of steps
            if(args.length==1)
            {
                N=Integer.parseInt(args[0]);
            }
            //interval, steps
            if(args.length==2)
            {
                T=Integer.parseInt(args[0]);
                N=Integer.parseInt(args[1]);
            }
        }
  	double h=T/N;//single step
        double x=x0;
        Random rand=new Random();
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"));
            writer.newLine();
            for(int i=0;i<N+1;i++)
            {
                if(i%1000==0)System.out.println(h*i+":"+x);
                writer.write(h*i+" "+x);
                writer.newLine();
                x=x+a.map(h*i,x)*h+b.map(h*i,x)*rand.nextGaussian()*Math.sqrt(h);
            }
            writer.close();
        }
        catch(Exception ex)
        {
            //
        }
        useGnuplot();
    }

    /**Draws data from file via Gnuplot
     * Plotting_options should contain shell input for gnuplot*/
    static void useGnuplot()
    {

        String homeDirectory = System.getProperty("user.home");
        Process process;
        if (isWindows) {
            //TO-DO implement
        }
        else {
            try{
                process = Runtime.getRuntime().exec("gnuplot < plotting_options -p");
            }
            catch(Exception ex)
            {
                //
            }

        }
    }
    /**
    @FunctionalInterface for sde functions like a(t,xt)
    */
    private interface SdeFunction
    {
        double map(double t,double x);
    }

}
