import java.io.File; 
import java.util.Scanner; 
import java.io.FileWriter;
import java.io.IOException;
class Solution{

	public static void main(String args[]) throws Exception
	{
		File file = new File("travel_restrictions_input.txt"); 
    	Scanner sc = new Scanner(file);
    	int test = Integer.parseInt(sc.nextLine());
    	int t = test;
    	char res[][];
    	File obj = new File("result.txt");
      	FileWriter result = new FileWriter("result.txt");
      	
    	while(test != 0)
    	{
    		int n = Integer.parseInt(sc.nextLine());
    		res = new char[n][n];
    		String I = sc.nextLine();
    		String O = sc.nextLine();
    		for(int i = 0; i < n; i++)
    		{
    			res[i][i] = 'Y';
    			if(i-1 >=0)
    			{
    				if(O.charAt(i) == 'Y' && I.charAt(i-1) == 'Y')
    					res[i][i-1] = 'Y';
    				else res[i][i-1] = 'N';
    			}
    			if(i+1 < n)
    			{
    				if(O.charAt(i) == 'Y' && I.charAt(i+1) == 'Y')
    					res[i][i+1] = 'Y';
    				else res[i][i+1] = 'N';	
    			}
    		}
    		for(int i = 0; i < n; i++)
    		{
    			for(int j = i+2; j < n; j++)
    			{
    				if(res[i][j-1] == 'Y' && res[j-1][j] == 'Y')
    					res[i][j] = 'Y';
    				else res[i][j] = 'N';
    			}
    			for(int j = i-2; j >= 0; j--)
    			{
    				if(res[i][j+1] == 'Y' && res[j+1][j] == 'Y')
    					res[i][j] = 'Y';
    				else res[i][j] = 'N';
    			}
    		}
      		
      		result.write("Case #" + (t - test + 1) + ":\n");
      		for(int i = 0; i < n; i++)
    		{
	    		for(int j = 0; j < n; j++)
	    		{
	    			//System.out.print(res[i][j]);
	    			result.write(res[i][j]);
	    		}
	    			//System.out.println();
	    		result.write("\n");
    		}
    		/*System.out.println("Case #" + (t - test + 1) + ":");
    		for(int i = 0; i < n; i++)
    		{
    			for(int j = 0; j < n; j++)
    			{
    				System.out.print(res[i][j]);
    			}
    			System.out.println();
    		}*/
    		test--;
    	}
    	result.close();
	}
}