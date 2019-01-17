package ua.hillel.a_sapon.lesson1_2;

/**
 * CLASS ARREY
 * @version 1.0.0.0
 * The example class provides methods and structure of two dimensional array
 */

public class ARREY {

    /**
     *  Private parameters:
     *  first_dimension - defines first size of the 2d array.
     *  second_dimension - defines second size of the 2d array.
     *  MaxValue - defines Max possible int value in array. By Default = 100
     */
    private int first_dimension;
    private int second_dimension;
    private double[][] Arr;
    private int MaxValue = 100;

    /**
     * private method getRandSize()
     * @return  int random size for the array if such is not specified
     */
    private int getRandSize() {
        return (int)(Math.random() * 49.0D + 1.0D);
    }

    /**
     * private method getRandNumber()
     * @param range - int value which specifies range in which random value will be generated
     * @return double random value from the specified range
     */
    private double getRandNumber(int range) {
        return Math.random() * (double)range;
    }

    /**
     * public method Print()
     * Printing out array to the screen
     */
    public void Print() {
        if (this.first_dimension == 0 && this.second_dimension == 0) {
            System.out.println("Array is not initialized");
        } else {
            for(int x = 0; x < this.first_dimension; x++) {
                for(int y = 0; y < this.second_dimension; y++) {
                    System.out.print(this.Arr[x][y] + "\t");
                }
                System.out.print("\n");
            }
        }

    }

    /**
     * public method PrintInt()
     * Printing out array to the screen but with cast to int internal values
     */
    public void PrintInt() {
        if (this.first_dimension == 0 && this.second_dimension == 0) {
            System.out.println("Array is not initialized");
        } else {
            for(int x = 0; x < this.first_dimension; ++x) {
                for(int y = 0; y < this.second_dimension; ++y) {
                    System.out.print((int)this.Arr[x][y] + "\t");
                }
                System.out.print("\n");
            }
        }

    }

    /**
     * initial constructor ARREY
     * All values are going to be selected by random way
     * Also array will be filled in with random values but not higher than 100 (MaxValue)
     */
    ARREY() {
        this.first_dimension = this.getRandSize();
        this.second_dimension = this.getRandSize();
        this.Arr = new double[this.first_dimension][this.second_dimension];

        for(int x = 0; x < this.first_dimension; ++x) {
            for(int y = 0; y < this.first_dimension; ++y) {
                this.Arr[x][y] = this.getRandNumber(MaxValue);
            }
        }

    }

    /**
     * constructor ARREY(int)
     * @param dimension - int value which will define 2d array size
     * Also array will be filled in with random values but not higher than 100 (MaxValue)
     */
    ARREY(int dimension) {
        this.second_dimension = this.first_dimension = dimension;
        this.Arr = new double[this.first_dimension][this.second_dimension];

        for(int x = 0; x < this.first_dimension; ++x) {
            for(int y = 0; y < this.first_dimension; ++y) {
                this.Arr[x][y] = this.getRandNumber(MaxValue);
            }
        }

    }

    /**
     * constructor ARREY(int,int)
     * @param dimension - int value which will define 2d array size
     * @param max_rand_value - max possible value for the value of array
     * Also array will be filled in with random values but not higher than max_rand_value
     */
    ARREY(int dimension, int max_rand_value) {
        this.second_dimension = this.first_dimension = dimension;
        this.Arr = new double[this.first_dimension][this.second_dimension];

        for(int x = 0; x < this.first_dimension; ++x) {
            for(int y = 0; y < this.first_dimension; ++y) {
                this.Arr[x][y] = this.getRandNumber(max_rand_value);
            }
        }

    }
}

