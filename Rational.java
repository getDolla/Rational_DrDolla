/*
Team DrDolla - Yikai Wang, Dhruba Roy
APCS1 Pd9
HW32 -- Irrationality Stops Here 
2015-11-17
 */

public class Rational{
    private int numerator;
    private int denominator;

    public Rational() { //default constructor
	numerator = 0;
	denominator = 1;
    }

    public Rational( int num, int dem ) { //custom
	numerator = num;
	denominator = dem;
    }

    public String toString() { // numerator/denominator cuts off decimals
    double dble1 = numerator; //need to convert to double first
	double dble2 = denominator;
	return ( dble1/dble2 ) + "";
    }

    public double floatValue(){
	double precise = Double.parseDouble( this.toString() ); //uses the most precise floating point
    return precise;
    }

    public void multiply(Rational r){
    double dble1 = this.floatValue();
    double dble2 = r.floatValue();
	double nwdble = dble1 * dble2; //gets product

    //ex: 0.1 = 1/10
    int decplaces = ( int ) Math.pow( 10, ( nwdble + "" ).length() - 2 );
    int top = ( int ) ( nwdble * decplaces ); //moves the decimal point after the last digit ( becomes an integer )
    numerator = top;
    denominator = decplaces;
    }

    public void divide(Rational r) { //same as multiply but now we divide
    double dble1 = this.floatValue();
    double dble2 = r.floatValue();
    double nwdble = dble1 / dble2;

    int decplaces = ( int ) Math.pow( 10, ( nwdble + "" ).length() - 2 );
    int top = ( int ) ( nwdble * decplaces );
    numerator = top;
    denominator = decplaces;
    }

    public static void main(String[] args){
	Rational r1 = new Rational(1,5); //rational number 1/5
    Rational r2 = new Rational(1,2); //rational number 1/2

    r1.multiply(r2); //Multiplies r1 by r2, changes r1 to 1/10 (0.1)
    System.out.println( r1 ); 

    r2.divide(r1); //Divides r2 by r1, changes r2 to 5/1 (5.0)
    System.out.println( r2 );
    }
}
