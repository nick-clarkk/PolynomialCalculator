public class Term implements Comparable<Term> {
    //Instance variables
    private int mCoefficient;
    private int mExponent;

    //Constants
    private static final int DEFAULT_COEFFICIENT = 1;
    private static final int DEFAULT_EXPONENT = 1;

    public Term() {
        mCoefficient = DEFAULT_COEFFICIENT;
        mExponent = DEFAULT_EXPONENT;
    }

    public Term(int coefficient, int exponent) {
        mCoefficient = coefficient;
        mExponent = exponent;
    }

    public Term(Term otherTerm) {
        if (otherTerm == null)
            return;
        mCoefficient = otherTerm.mCoefficient;
        mExponent = otherTerm.mExponent;
    }

    public Term(String term) {
        //Empty
        if(term.isEmpty()) {
            mCoefficient = 0;
            mExponent = 0;
        }
        //Constant
        else if(!term.contains("x")) {
            mCoefficient = Integer.parseInt(term);
            mExponent = 0;
        }
        //Variable with coefficient and no ^
        else if(!term.contains("^") && term.contains("x")) {
            mExponent = 1;
            if("-x".equals(term))
                mCoefficient = -1;
            else if("+x".equals(term))
                mCoefficient = 1;
            else {
                String coefTerm = term.substring(0, term.length()-1);
                mCoefficient = Integer.parseInt(coefTerm);
            }
        }
        //Variable with ^
        else if(term.contains("^") && term.contains("x")) {
            String coefTerm = term.substring(0, term.indexOf("x"));
            String expoTerm = term.substring(term.indexOf("^")+1, term.length());
            mExponent = Integer.parseInt(expoTerm);
            if("-".equals(coefTerm))
                mCoefficient = -1;
            else if("+".equals(coefTerm))
                mCoefficient = 1;
                //With constant
            else {
                mCoefficient = Integer.parseInt(coefTerm);
            }
        }
    }

    public Term clone() {
        return new Term(mCoefficient, mExponent);
    }

    //Getters and Setters
    public int getCoefficient() {
        return mCoefficient;
    }

    public void setCoefficient(int coefficient) {
        mCoefficient = coefficient;
    }

    public int getExponent() {
        return mExponent;
    }

    public void setExponent(int exponent) {
        mExponent = exponent;
    }

    public void setTerm(int coefficient, int exponent) {
        mCoefficient = coefficient;
        mExponent = exponent;
    }

    public void setAll(int coefficient, int exponent) {
        mCoefficient = coefficient;
        mExponent = exponent;
    }

    public boolean equals(Object obj) {
        if(obj instanceof Term) {
            Term other = (Term) obj;
            return  mCoefficient == other.mCoefficient && mExponent == other.mExponent;
        }
        return false;
    }

    public int compareTo(Term term) {
        if(mExponent > term.mExponent)
            return 1;
        else if(this.mExponent < term.mExponent)
            return -1;
        else
            return 0;
    }

    public String toString() {
        String term = "";
        if(mCoefficient == 0)
            return "";
        else if(mExponent == 0 && mCoefficient > 0)
            return "+" + mCoefficient;
        else if(mExponent == 0 && mCoefficient < 0)
            return "" + mCoefficient;
        else if(mExponent == 1 && mCoefficient == 1)
            return "+x";
        else if(mExponent == 1 && mCoefficient == -1)
            return "-x";
        else if(mExponent == 1 && mCoefficient > 1)
            return "+" + mCoefficient + "x";
        else if(mExponent == 1 && mCoefficient < 0)
            return "" + mCoefficient + "x";
        else if(mCoefficient == 1)
            return "+x^" + mExponent;
        else if(mCoefficient == -1)
            return "-x^" + mExponent;
        else if(mCoefficient > 1)
            return "+" + mCoefficient + "x^" + mExponent;
        else if(mCoefficient < 0) {
            return "" + mCoefficient + "x^" + mExponent;
        }
        return term;
    }


}
