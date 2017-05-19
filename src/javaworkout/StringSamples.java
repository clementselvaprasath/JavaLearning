package javaworkout;
import java.io.*;

public class StringSamples {

	public static void main (String a[]){
		
		String s1 = "";
/*		String str = "pre-certify      receiptserv   https://github.paypal.com/Customers-R/receiptserv     develop";
		String[] s =str.split(" +");
		
		for(int i=0; i<s.length; i++){
			System.out.println(s[i]);
		}*/
		
		//git ls-remote --heads git@github.paypal.com:Payment-Networks-R/ppsraptorbackend.git
		// https://github.paypal.com/Customers-R/receiptserv
		
		
		
		String gitHttp1 = "https://github.paypal.com/Customers-R/receiptserv/";
		String repo1 = gitHttp1.split("https://github.paypal.com/")[1];
		
		System.out.println(" repo1 - "+repo1.replaceAll(".git", ""));
		if (repo1.endsWith("/")){
			System.out.print(repo1.substring(0,repo1.length() - 1));
		}
		
/*		
		String gitHttp = "https://github.paypal.com/Customers-R/receiptserv";
		String branch = "develop";
		
		String repo = gitHttp.split("https://github.paypal.com/")[1];
		System.out.println(repo);
		String gitCommand = "";
		if (!(gitHttp.endsWith(".git"))) {
			System.out.print("git ls-remote --heads git@github.paypal.com:"+repo+".git | grep refs/heads/"+branch);
			gitCommand = "git ls-remote --heads git@github.paypal.com:"+repo+".git | grep refs/heads/"+branch;
		}else if(repo.endsWith("/")){
			System.out.print("git ls-remote --heads git@github.paypal.com:"+repo.substring(0,repo.length()-1)+" | grep refs/heads/"+branch);
			gitCommand = "git ls-remote --heads git@github.paypal.com:"+repo+".git | grep refs/heads/"+branch;
		}else{
			System.out.print("git ls-remote --heads git@github.paypal.com:"+repo+" | grep refs/heads/"+branch);
			gitCommand = "git ls-remote --heads git@github.paypal.com:"+repo+" | grep refs/heads/"+branch;
		}
		String s = null;
		try {
			Process p = Runtime.getRuntime().exec(gitCommand);
			p.waitFor();
			BufferedReader stdInput = new BufferedReader(new
					InputStreamReader(p.getInputStream()));

			BufferedReader stdError = new BufferedReader(new
					InputStreamReader(p.getErrorStream()));

			// read the output from the command
			System.out.println("Here is the standard output of the command:\n");
			while ((s = stdInput.readLine()) != null) {
				System.out.println(s);
			}

		}catch (Exception  e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
            System.exit(-1);
        }*/
	}
}
