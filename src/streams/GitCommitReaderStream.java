package streams;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class GitCommitReaderStream {

	public static void main(String[] args) {
		//System.out.println(gitCommit());
		System.out.println(gitCommitStream());

	}
	
	
	public static String gitCommitStream(){
		String gitCommand= "git ls-remote --heads git@github.paypal.com:Customers-R/donatenodeweb.git | grep refs/heads/master";
		String scmBranch = "master";
		try{
			Process p = Runtime.getRuntime().exec(gitCommand);
			p.waitFor();
			return new BufferedReader(new InputStreamReader(p.getInputStream())).lines()
					.filter(line -> line.endsWith(scmBranch))
					.map(s->s.split("refs")[0].trim())
					.findFirst().get();
		}catch (Exception  e) {
			System.out.println("exception happened - here's what I know: ");
			e.printStackTrace();
		}
		return "";
	}
	public static String gitCommit(){
		String gitCommand= "git ls-remote --heads git@github.paypal.com:Customers-R/donatenodeweb.git | grep refs/heads/develop";
		String scmBranch = "revert-543-release";
		String s = null;
		try {
			Process p = Runtime.getRuntime().exec(gitCommand);
			p.waitFor();
			BufferedReader stdInput = new BufferedReader(new
					InputStreamReader(p.getInputStream()));

			while ((s = stdInput.readLine()) != null) {
				System.out.println(s);
				if (s.endsWith(scmBranch)){
					//System.out.println("Commit -- "+s.split("refs")[0].trim());
					////logger.debug("Commit : {}", s.split("refs")[0].trim());
					return s.split("refs")[0].trim();
				}
			}

		}catch (Exception  e) {
			System.out.println("exception happened - here's what I know: ");
			e.printStackTrace();
		}
		return "";
	}
	
	
	

}
