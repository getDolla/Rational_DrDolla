/*
Team DrDolla - Yikai Wang, Richard Wang
APCS1 Pd9
HW33 -- Do You Even Add, Bro?
2015-11-18
 */

public class Rational{
    private int numerator;
    private int denominator;
    
    public Rational() { //default constructor
	numerator = 0;
	denominator = 1;
    }
    
    public Rational( int num, int dem ) { //custom
	if (dem == 0) {
	    numerator = 0;
	    denominator = 1;
	    System.out.println("Cannot divide by 0");
	}
	else {
	    numerator = num;
	    denominator = dem;
	}
    }

    public String toString() {
	String s1 = "Fraction : "+numerator +"/"+denominator;
	String s2 = "Decimal : "+ (numerator * 1.0 / denominator);
	return s1 +"\n"+ s2;
    }

    public double floatValue() {
	return numerator * 1.0 / denominator;
    }

    public void multiply (Rational r) {
	numerator *= r.numerator;
	denominator *= r.denominator;
    }

    public void divide (Rational r) {
	numerator *= r.denominator;
	denominator *= r.numerator;
    }


    public void add (Rational r) {
	numerator = numerator * r.denominator + r.numerator * denominator;
	denominator = denominator * r.denominator;
    }

    public void subtract (Rational r) {
	numerator = numerator * r.denominator - r.numerator * denominator;
	denominator = denominator * r.denominator;
    }

    
    /*
    public String toString() { // numerator/denominator cuts off decimals
	double dble1 = numerator; //need to convert to double first
	double dble2 = denominator;
	return ( dble1/dble2 )+"";
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
    
    public void add(Rational r) {
	double dble1 = this.floatValue();
	double dble2 = r.floatValue();
	double nwdble = dble1 + dble2;
	
	int decplaces = ( int ) Math.pow( 10, ( nwdble + "" ).length() - 2 );
	int top = ( int ) ( nwdble * decplaces );
	numerator = top;
	denominator = decplaces;
    }

    public void subtract(Rational r) {
	double dble1 = this.floatValue();
	double dble2 = r.floatValue();
	double nwdble = dble1 - dble2;
	
	int decplaces = ( int ) Math.pow( 10, ( nwdble + "" ).length() - 2 );
	int top = ( int ) ( nwdble * decplaces );
	numerator = top;
	denominator = decplaces;
    }    
    */

    public int gcd() {
	int n = numerator;
	int d = denominator;
       	while ((d % n) != 0){
	    d = (d % n);
	    n = d;
	}
	return denominator;
    }


    public void reduce() {
	int gcd = gcd();
	denominator /= gcd;
	numerator /= gcd;

    }
    
    public static void main(String[] args){
	Rational r1 = new Rational(1,5); //rational number 1/5
	Rational r2 = new Rational(1,2); //rational number 1/2
	
	r1.multiply(r2); //Multiplies r1 by r2, changes r1 to 1/10 (0.1)
	System.out.println( r1 );
	System.out.println( r1.denominator );
	
	r2.divide(r1); //Divides r2 by r1, changes r2 to 5/1 (5.0)
	System.out.println( r2 );
	System.out.println( r2.denominator );

	System.out.println(r2.numerator);
	System.out.println(r2.gcd());
	r2.reduce();
	System.out.println( r2.denominator );
	System.out.println(r2.numerator);
    }
}
