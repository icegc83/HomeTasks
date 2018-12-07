package ua.hillel.a_sapon.Lesson_3;

public class Lib {
    private char underscore_character='_';
    private int underscore_character_counter=0;
    private char space_character=' ';
    private int space_character_counter=0;
    private char star_character='*';
    private int star_character_counter=0;

    /**
     * public void CountSymbols(String)
     * @param string - string which method should analyse and count for a special symbols
     */
    public void CountSymbols(String string)
    {
        if(string.isEmpty()){
            System.out.println("Input string is an empty one. Nothing to analyse.");
        }
        else{
            for(int i=0;i<string.length();i++){
                if(underscore_character == (string.charAt(i)))
                    underscore_character_counter +=1;
                if(space_character == (string.charAt(i)))
                    space_character_counter +=1;
                if(star_character == (string.charAt(i)))
                    star_character_counter +=1;
            }
            System.out.printf("Calculation results: \n '_' - %d \n ' ' - %d \n '*' - %d \n total symbols amount in string (/n also included) - %d",underscore_character_counter,space_character_counter,star_character_counter,string.length() );
        }
    }

    /**
     * public void Count_Binaries_with_StringUsage(int)
     * method counts binaries with String usage  
     * @param number - int value for which we would like to count 0 and 1 in binary representation
     */
    public void Count_Binaries_with_StringUsage(int number)
    {
        int counter_one=0;
        int counter_zero=0;

        StringBuilder bynary_string = new StringBuilder(Integer.toBinaryString(number));
        for (int i=0;i<bynary_string.length();i++){
            if ('1' == bynary_string.charAt(i) )
                counter_one += 1;
            else
                counter_zero += 1;
        }
        System.out.println("FIRST METHOD - with Integer.toBinaryString");
        System.out.printf("In result we have next binary representation " + bynary_string +"\n, which contains %d of '1' elements and %d of '0' elements \n\n", counter_one, counter_zero);

    }

    /**
     * public void Count_Binaries_with_StringUsage(int)
     * method counts binaries without String usage
     * @param number - int value for which we would like to count 0 and 1 in binary representation
     */
    public void CountBinaries(int number) {

       StringBuilder bynary_string = new StringBuilder();
       StringBuilder second_bynary_string;

       int marker=1;

       if (number<0) {
           number *= (-1);
           marker = (-1);
       }

        while (number > 0) {
            bynary_string.append(number % 2);
            number >>= 1;
        }

        bynary_string.reverse();

        if (marker == -1){
            for(int i=0;i<bynary_string.length();i++){
                if((bynary_string.charAt(i)-'1') == 0){
                    bynary_string.setCharAt(i,'0');
                }
                else{
                    bynary_string.setCharAt(i,'1');
                }
            }

            marker=0;
            int pos = bynary_string.length()-1;

            while ( (marker == 0) && (pos > 0) ){
                if(bynary_string.charAt(pos)-'0' == 1){
                    bynary_string.setCharAt(pos, '0');
                }
                else{
                    bynary_string.setCharAt(pos,'1');
                    marker = 1;
                }
                pos -= 1;
            }
            second_bynary_string = new StringBuilder("1...1" + bynary_string.toString());
        }
        else
        {
            second_bynary_string = new StringBuilder(bynary_string.toString());
        }

        int counter_one = 0;
        int counter_zero = 0;

        for(int i=0;i < second_bynary_string.length(); i++)
        {
            if( (second_bynary_string.charAt(i) - '1') == 0)
            {
                counter_one += 1;
            }
            if( (second_bynary_string.charAt(i) - '0') == 0){
                counter_zero += 1;
            }
        }



        System.out.println("SECOND METHOD - without Integer.toBinaryString");
        System.out.printf("In result we have next binary representation " + second_bynary_string + "\n, which contains n+%d of '1' elements and %d of '0' elements \n\n", counter_one, counter_zero);

    }

}
