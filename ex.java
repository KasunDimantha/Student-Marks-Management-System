class ex10 {
    public static void main(String[] args){

       double[] average = {15, 53, 89, 12, 52};

        for (int j = 0; j < average.length; j++) {
            for (int i = 0;  i < average.length-1; i++) {
                if (average[i] < average[i + 1]) {
                    double t = average[i];
                    average[i] = average[i + 1];
                    average[i + 1] = t;
                }
            }
        }
        System.out.print("[ ");
        for (int i = 0; i < average.length; i++) {
            System.out.print(average[i] + ", ");
        } 
        System.out.println("\b\b]");        
   }   
}
