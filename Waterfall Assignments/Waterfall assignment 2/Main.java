import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		double inputValue = 100;
        double [] bucketArray = {0,0,0,0,0,0,0};
		// TODO Auto-generated method stub
		int[][] waterPattern =  {
				{ 0, 0, 0, 0, 0, 0, 0 },
	            { 1, 0, 0, 0, 0, 0, 0 },
	            { 0, 0, 1, 1, 1, 0, 0 },
	            { 0, 0, 0, 0, 0, 0, 0 },
	            { 1, 1, 1, 0, 0, 1, 0 },
	            { 0, 0, 0, 0, 0, 0, 1 },
	            { 0, 0, 0, 0, 0, 0, 0 },
			};
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the position:");
		int position=sc.nextInt() - 1;
		
		bucketArray[position] = inputValue; //{ 0, 0, 0, 100, 0, 0, 0 }

		double [] currCalculated=new double []{0,0,0,0,0,0,0};
		double [] tempCalculated=new double []{0,0,0,0,0,0,0};
		
		double percentageVal;
		
		for(int i=0; i< waterPattern.length;i++) {
			for(int j=0;j<bucketArray.length;j++) {
				if(bucketArray[j]>0) {
					percentagVal=bucketArray[j];
					if(waterPattern[i][j]==1) {

						//Turn Right
						for(int k=j;k<waterPattern.length;k++) {
							if(waterPattern[i][k]==0 && waterPattern[i-1][j+1]!=1) {
								currCalculated[k]=currCalculated[k]+percentageVal/2;
								currCalculated[j]=0;
								break;
							}
						}
						//Turn Left
						for(int k=j;k>=0;k--) {
							if(waterPattern[i][k]==0 && waterPattern[i-1][j-1]!=1) {
								currCalculated[k]=currCalculated[k]+percentageVal/2;
								currCalculated[j]=0;
								break;
							}
						}
						currCalculated[j]=0;
					}
					else {
						currCalculated[j]=percentageVal;
					}
				}
			}
			//bucketArray=currCalculated
			if(!Arrays.equals(tempCalculated,currCalculated)) {
				bucketArray=currCalculated;
				tempCalculated=currCalculated;
			}
			
		}
		
		System.out.println("Result:");
        for (double bucket: bucketArray ) {
            System.out.print(bucket+ ", ");
        }
    }
	
	

    
	

}