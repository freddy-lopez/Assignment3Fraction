package fraction;
//What's left to do is the Argument Exceptions and compareTo()and realValue() methods. 
public class Fraction {

	private int Num;
	private int Den;
	private double Value;
	
	public Fraction(int N, int D)
	{
		if(D == 0)
		{
			throw new IllegalArgumentException("The denominator with the value of 0 is not permitted");
		}
		Num = N;
		Den = D;
		//properReduction call
		reduction();
		
	}
	private void reduction() {
		if(Num == 0)
		{
			Den = 1;
			return;
		}
		if(Den < 0)
		{
			Num = -Num;
			Den = -Den;
		}
		int q = GCF(Math.abs(Num), Den);
		Num /= q;
		Den /= q;
		
	}
	//GCF method used for the reduction method
	public int GCF(int num, int den)
	{
		if(num % den == 0)
		{
			return den;
		}
		else if(den % num == 0)
		{
			return num;
		}
		else {
			return GCF(num % den, den % num);
		}
	}
	//Done
	/**
	* @return the Numerater that is Num
	*/
	public int getNum()
	{
		return Num;
	}
	//Done
	/**
	* @return the Denominator that is Den
	*/
	public int getDen()
	{
		return Den;
	}
	//Done
	@Override
	public boolean equals(Object obj)
	{
		Fraction frac = (Fraction)obj;
		if(obj instanceof Fraction)
		{
			if(this.Num == frac.Num && this.Den == frac.Den)
			{
				return true;
			}
			else {
				return false;
			}

		}
		else {
			return false;
		}
	}
	//
	public int compareTo(Object o) 
	{
		Fraction frac = (Fraction)o;
		if(this.Num > frac.Num) {
			return 2;
		}
		else if(this.Num < frac.Num){
			return -1;
		}
		else {
			return 0;
		}
	}
	
	public double realValue() 
	{
		return (double)Num/Den;
	}
	
	
	
	
	//Done
	//GCD method to be used in fraction GCD
	public int GCD(int a, int b)
	{ 
		return b==0 ? a : GCD(b, a%b); 
	}

	//Done
	public Fraction fractionGCD(int n1, int n2){
		int g = GCD(n1,n2);
		n1 = n1/g;
		n2 = n2/g;
		return new Fraction(n1,n2);
	}

	//Done
	public Fraction add(Fraction fraction) {
		if(fraction == null)
			throw new IllegalArgumentException("Cannot perform math operations on a null fraction object!");
		int firstAdd = (this.Num*fraction.Den)+(this.Den*fraction.Num);
		int secondAdd = this.Den*fraction.Den;
		return fractionGCD(firstAdd, secondAdd);
	}
	//Done
	public Fraction multiply(Fraction fraction) {
		if(fraction == null)
			throw new IllegalArgumentException("Cannot perform math operations on a null fraction object!");
		int firstMultiply = this.Num*fraction.Num;
		int secondMultiply = this.Den*fraction.Den;
		return fractionGCD(firstMultiply, secondMultiply);
	}
	

	@Override 
	public String toString(){
		String One = Integer.toString(this.Num); //convert fraction to string
		String Two = Integer.toString(this.Den);
		if (Two == "1"){ //check for whole number
			return One;
		}else{
			String Tog = One + "/" + Two; 
			return Tog;
		}
	}
}
