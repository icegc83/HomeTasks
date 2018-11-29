package ua.hillel.a_sapon.Lesson_2;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 * CLASS ARREY
 * @version 1.0.0.1
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
     * public void Print_N_Greater_Elements_Int(double, int)
     * Print out N casted to int elements which are Greater than defined parameter
     * @param value - defines value higher which we are going to display
     * @param counter - defines number of elements to display which correspond to condition
     */
    public void Print_N_Greater_Elements_Int(double value, int counter) {
        if (this.first_dimension == 0 && this.second_dimension == 0) {
            System.out.println("Array is not initialized");
        } else {
            System.out.printf("Next elements are greater than: %d \n", (int)value);
            int i = 0;
            int y = 0;
            int x = 0;

            while(i < counter && x < this.first_dimension)
            {
                if (this.Arr[x][y] > value) {
                    System.out.print((int)this.Arr[x][y]+"\t");
                    ++i;
                }

                ++y;
                if (y >= this.second_dimension) {
                    y = 0;
                    ++x;
                    System.out.print("\n");
                }
            }
        }

    }

    /**
     * public void Print_N_Elements_Divide_Without_Remainder
     * Print out N casted to int elements for which divide has no remainder
     * @param value - defines value divide on which shouldn't have remainder
     * @param counter - defines number of elements to display which correspond to condition
     */
    public void Print_N_Elements_Divide_Without_Remainder(int value, int counter) {
        if (this.first_dimension == 0 && this.second_dimension == 0) {
            System.out.println("Array is not initialized");
        } else {
            int i = 0;
            int y = 0;
            int x = 0;
            if (counter == -1) {
                counter = this.first_dimension * this.second_dimension;
            }

            while(i < counter && x < this.first_dimension) {
                if ((double)((int)this.Arr[x][y] % value) == 0.0D) {
                    System.out.print((int)this.Arr[x][y]+"\t");
                    ++i;
                } else {
                    System.out.print("_\t");
                }

                ++y;
                if (y >= this.second_dimension) {
                    y = 0;
                    ++x;
                    System.out.print("\n");
                }
            }
        }

    }

    /**
     * void Sort()
     * Sorting out elements of Array in Ascending mode
     * Created to be overridden in future
     */
    void Sort()
    {
        this.SortAsc();
    }

    /**
     * void SortAsc()
     * Sorting out elements of Array in Ascending mode
     */
    void SortAsc() {
        double[] Arrey = new double[this.first_dimension * this.second_dimension];

        int x;
        int y;
        for(x = 0; x < this.first_dimension; ++x) {
            for(y = 0; y < this.second_dimension; ++y) {
                Arrey[x * this.second_dimension + y] = this.Arr[x][y];
            }
        }

        Arrays.sort(Arrey);

        for(x = 0; x < this.first_dimension; ++x) {
            for(y = 0; y < this.second_dimension; ++y) {
                this.Arr[x][y] = Arrey[x * this.second_dimension + y];
            }
        }

    }

    /**
     * void SortDesc()
     * Sorting out elements of Array in Descending mode
     */
    void SortDesc() {
        double[] Arrey = new double[this.first_dimension * this.second_dimension];

        int x;
        int y;
        for(x = 0; x < this.first_dimension; ++x) {
            for(y = 0; y < this.second_dimension; ++y) {
                Arrey[x * this.second_dimension + y] = this.Arr[x][y];
            }
        }

        Arrays.sort(Arrey);

        for(x = 0; x < this.first_dimension; ++x) {
            for(y = 0; y < this.second_dimension; ++y) {
                this.Arr[x][y] = Arrey[this.first_dimension * this.second_dimension - (x * this.second_dimension + y) - 1];
            }
        }

    }

    /**
     * Double Sum()
     * @return double Sum of all elements in the array
     */
    double Sum() {
        double Sum = 0.0D;

        for(int x = 0; x < this.first_dimension; ++x) {
            for(int y = 0; y < this.second_dimension; ++y) {
                Sum += this.Arr[x][y];
            }
        }
        return Sum;
    }

    /**
     * double Average()
     * @return double average value of the array elements
     */
    double Average() {
        return this.Sum() / (double)(this.first_dimension * this.second_dimension);
    }

    /**
     * double GetMax()
     * @return Maximum value among array elements
     */
    double GetMax() {
        double max = 0.0D;

        for(int x = 0; x < this.first_dimension; ++x) {
            for(int y = 0; y < this.second_dimension; ++y) {
                if (max < (double)((int)this.Arr[x][y])) {
                    max = (double)((int)this.Arr[x][y]);
                }
            }
        }
        return max;
    }

    /**
     * double GetMin()
     * @return Minimum value among array elements
     */
    double GetMin() {
        double min = this.GetMax();

        for(int x = 0; x < this.first_dimension; ++x) {
            for(int y = 0; y < this.second_dimension; ++y) {
                if (min > (double)((int)this.Arr[x][y])) {
                    min = (double)((int)this.Arr[x][y]);
                }
            }
        }
        return min;
    }

    /**
     * string MultiplyNotEven(double)
     * @param value - defines value to which array elements shouldn't be even
     * @return String of Multiplicaiton of all not even elements
     */
    String MultiplyNotEven(double value) {
        BigDecimal multiplication  = new BigDecimal(1);
        if (this.first_dimension == 0 && this.second_dimension == 0) {
            System.out.println("Array is not initialized");
        } else {
            for(int x = 0; x < this.first_dimension; ++x) {
                for(int y = 0; y < this.second_dimension; ++y) {
                    if ((double)((int)this.Arr[x][y]) % value != 0.0D) {
                        multiplication = multiplication.multiply(new BigDecimal(Arr[x][y]));
                    }
                }
            }
        }
        return multiplication.toBigInteger().toString();
    }

    /**
     * double GetIndex(double)
     * @param searchfor - element position of which we are trying to find in the array
     * @return position of particular element in the array
     */
    double GetIndex(double searchfor) {
        double pos = -1.0D;

        for(int x = 0; x < this.first_dimension; ++x) {
            for(int y = 0; y < this.second_dimension; ++y) {
                if (this.Arr[x][y] == searchfor) {
                    pos = (double)(x * this.first_dimension + y);
                }
            }
        }
        return pos;
    }

    /**
     * double GetThirdElementIndex()
     * @return Third element position
     */
    double GetThirdElementIndex() {
        return this.GetIndex(this.Arr[0][2]);
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

    /**
     * constructor ARREY(int,int)
     * @param first_dimension - int value which will define first dimension of the array size
     * @param second_dimension - int value which will define second dimension of the array size
     * @param max_rand_value - max possible value for the value of array
     */
    ARREY(int first_dimension, int second_dimension, int max_rand_value) {
        if (first_dimension <= 0) {
            this.first_dimension = 1;
        } else {
            this.first_dimension = first_dimension;
        }

        if (second_dimension <= 0) {
            this.second_dimension = 1;
        } else {
            this.second_dimension = second_dimension;
        }

        this.Arr = new double[this.first_dimension][this.second_dimension];

        for(int x = 0; x < this.first_dimension; ++x) {
            for(int y = 0; y < this.second_dimension; ++y) {
                this.Arr[x][y] = this.getRandNumber(max_rand_value);
            }
        }

    }
}