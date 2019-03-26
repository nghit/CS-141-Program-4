/********************************
 * file: Tran_Diamond.java
 * author: N. Tran
 * class: CS 141 - Programing and Problem Solving
 *
 * assignment: program 4
 * date last modified: 2/13/2017
 *
 * purpose: This program implements Comparable and able to compare diamonds to see which one is the better than the others using its methods.
 ********************************/

public class Tran_Diamond implements Comparable<Tran_Diamond>
{
    private String stockNumber;
    private double carot;
    private String clarity;
    private char color;
    private String cut;
    
    private String[] clarityGrade;
    private char[] colorGrade;
    
    //constructor
    public Tran_Diamond(String stockNumber, double carot, String clarity, char color, String cut)
    {
        this.stockNumber = stockNumber;
        this.carot = carot;
        this.clarity = clarity;
        this.color = color;
        this.cut = cut;
        
        clarityGrade = new String[] {"FL", "IF", "VVS1", "VVS2", "VS1", "VS2", "SI1", "SI2", "I1", "I2", "I3"};
        colorGrade = new char[23];
        
        for(int i = 0; i < colorGrade.length; i++)
        {
            colorGrade[i] = (char) (i + 68);
        }
    }
    
    //getter methods
    public String getStock()
    {
        return stockNumber;
    }
    
    public double getCarot()
    {
        return carot;
    }
    
    public String getClarity()
    {
        return clarity;
    }
    
    public char getColor()
    {
        return color;
    }
    
    public String cut()
    {
        return cut;
    }
    
    //toString method
    public String toString()
    {
        String output;
        output = "stock number: " + stockNumber;
        output += "\ncarot: " + carot;
        output += "\nclarity: " + clarity;
        output += "\ncolor: " + color;
        output += "\ncut: " + cut;
        System.out.println();
        return output;
    }
    
    //compare diamonds and return an appropriate value
    public int compareTo(Tran_Diamond diamond) 
    {
        int[] diamond1 = compareDiamonds(this);
        int[] diamond2 = compareDiamonds(diamond);

        if (this.carot > diamond.getCarot()) {
            return -1;
        } else if (this.carot < diamond.getCarot()) {
            return 1;
        }  else if (diamond1[0] < diamond2[0]) {
            return -1;
        } else if (diamond1[0] > diamond2[0]) {
            return 1;
        } else if (diamond1[1] < diamond2[1]) {
            return -1;
        } else if (diamond1[1] > diamond2[1]) {
            return 1;
        } else {
            return 0;
        }
    }
    
    //helper method for compareTo method
    private int[] compareDiamonds(Tran_Diamond diamond) 
    {
        int clarityValue = clarityGrade.length;
        int colorValue = colorGrade.length / 2;
        
        for (int i = 0; i < clarityGrade.length; i++) 
        {
            if (diamond.getClarity().equals(clarityGrade[i])) 
            {
                clarityValue = i + 1;
            }
        }

        for (int i = 0; i < colorGrade.length; i++) 
        {
            if (diamond.getColor() == colorGrade[i]) 
            {
                colorValue = (i / 2) + 1;
            }
        }
        
        //find max and min values for a diamond
        return new int[]{Math.min(clarityValue, colorValue), Math.max(clarityValue, colorValue)};
    }
}


