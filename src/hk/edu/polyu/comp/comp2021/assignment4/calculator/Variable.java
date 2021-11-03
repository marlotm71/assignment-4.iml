package hk.edu.polyu.comp.comp2021.assignment4.calculator;

/**
 * A variable expression.
 */
public class Variable extends Expression {
    private final String name;

    /**
     * Create a new variable with 'name'.
     * Throw IllegalArgumentException if 'name' is null or empty or 'name' contains other characters
     * than lower case English letters.
     */
    public Variable(String name){
        // Add missing code here
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException();
        }
        for (int i=0; i <name.length();i++){
            if (!Character.isLowerCase(name.charAt(i)) || !Character.isLetter(name.charAt(i))){
                throw new IllegalArgumentException();
            }
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return getName();
    }

    /**
     * Return the value of 'this' as defined in 'env'.
     * Throw IllegalArgumentException if 'env' is null or 'this' is not defined in 'env'.
     */
    public int evaluate(Environment env){
        // Add missing code here
        int value =0;
        if (env==null || !env.hasDefined(this)){
            throw new IllegalArgumentException();
        }
        else{
            value =env.getValue(this);
        }
        return value;
    }


}
