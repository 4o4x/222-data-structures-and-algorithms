/**
 * A vertex is a node in a graph. It has a label, a weight, and a data field
 */
public class Vertex{
    

    // Declaring a variable called index that is an integer.
    private int index;

    // Declaring a variable called label that is a string.
    private String label;

    // Declaring a variable called weight that is a double.
    private double weight;

    // Declaring a variable called key that is a string.
    private String key;

    // Declaring a variable called vaule that is a string.
    private String vaule;

    
    
    public Vertex(int index) {
        this.index = index;
        weight = 0;
    }

    

    public Vertex(String label, double weight) {
        this.label = label;
        this.weight = weight;
        index = -1;
    }



   
    public Vertex(int index, String label, double weight, String key, String vaule) {
        this.index = index;
        this.label = label;
        this.weight = weight;
        this.key = key;
        this.vaule = vaule;
    }

    /**
     * This function returns the weight of the object.
     * 
     * @return The weight of the object.
     */
    public double getWeight() {
        return weight;
    }
    
    /**
     * This function returns the index of the current node.
     * 
     * @return The index of the current node.
     */
    public int getIndex() {
        return index;
    }

    /**
     * This function sets the index of the current node to the index passed in as a parameter.
     * 
     * @param index The index of the current item in the list.
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * This function returns the label of the current object.
     * 
     * @return The label of the card.
     */
    public String getLabel() {
        return label;
    }

    /**
     * This function sets the label of the current object to the label passed in as a parameter.
     * 
     * @param label The label of the button.
     */
    public void setLabel(String label) {
        this.label = label;
    }
    /**
     * This function sets the weight of the object to the value of the parameter.
     * 
     * @param weight The weight of the edge.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * This function returns the key of the current vertex
     * 
     * @return The key of the vertex.
     */
    public String getKey() {
        return key;
    }

    /**
     * This function sets the key of the object to the key passed in as a parameter
     * 
     * @param key The key of vertex
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * This function returns the value of the variable vaule
     * 
     * @return The value of vertex vaule
     */
    public String getVaule() {
        return vaule;
    }

    /**
     * This function sets the value of the vaule variable
     * 
     * @param vaule The value of the parameter.
     */
    public void setVaule(String vaule) {
        this.vaule = vaule;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + index;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertex other = (Vertex) obj;
        if (index != other.index)
            return false;
        return true;
    }



    @Override
    public String toString() {
        //return "Vertex [label=" + label + "]";
        return label;
    }


    
}
