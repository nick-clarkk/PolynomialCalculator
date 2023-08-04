import java.util.LinkedList;
import java.util.ListIterator;
public class Polynomial {

    private LinkedList<Term> polynomial;

    public Polynomial() {
        polynomial = new LinkedList<>();
    }

    public Polynomial(Polynomial other) {
        if(other == null)
            return;
        LinkedList<Term> poly = other.polynomial;
        polynomial = new LinkedList<>();

        for(int i = 0; i < poly.size(); i++) {
            int termCoef = poly.get(i).getCoefficient();
            int termExpo = poly.get(i).getExponent();
            Term term = new Term(termCoef, termExpo);

            polynomial.add(term);
        }
        this.addLikeTerms();
    }

    public void addTerm(Term term) {
        polynomial.add(term);
        addLikeTerms();
    }

    public void add(Polynomial other) {
        LinkedList<Term> poly = other.polynomial;
        for(int i = 0; i < poly.size(); i++) {
            int termCoef = poly.get(i).getCoefficient();
            int termExpo = poly.get(i).getExponent();
            Term term = new Term(termCoef, termExpo);
            polynomial.add(term);
        }
        this.addLikeTerms();
    }

    public int getNumTerms() {
        return polynomial.size();
    }

    public Term getTerm(int index) {
        return polynomial.get(index);
    }

    public void clear() {
        polynomial.clear();
    }

    public void addLikeTerms() {
        LinkedList<Term> polynomial2 = new LinkedList<>();
        while(polynomial.size() > 0) {
            int exponentTerm = polynomial.get(0).getExponent();
            int coefficientSum = polynomial.get(0).getCoefficient();
            polynomial.removeFirst();
            ListIterator<Term> iterator = polynomial.listIterator(0);

            while(iterator.hasNext()) {
                Term term = iterator.next();
                if(exponentTerm == term.getExponent()) {
                    coefficientSum += term.getCoefficient();
                    iterator.remove();
                }
            }
            if(coefficientSum != 0) {
                Term newTerm = new Term(coefficientSum, exponentTerm);
                polynomial2.add(newTerm);
            }
        }

        for(int i = 0; i < polynomial2.size(); i++) {
            for(int j = 1; j < polynomial2.size(); j++) {
                if(polynomial2.get(j-1).getExponent() < polynomial2.get(j).getExponent()) {
                    Term temp = polynomial2.get(j-1);
                    Term higherOrder = polynomial2.get(j);

                    polynomial2.set(j, temp);
                    polynomial2.set(j-1, higherOrder);
                }
            }
        }

        polynomial = polynomial2;
    }

    public String toString() {
        String output = "";
        if(polynomial.isEmpty())
            output = "0";
        else {
            ListIterator iterator = polynomial.listIterator(1);
            Term current = polynomial.getFirst();
            if(current.getCoefficient() > 0)
                output = current.toString().substring(1);
            else
                output = String.format("%s", current);

            while(iterator.hasNext())
                output += " " + iterator.next();

        }
        return output;
    }
}
