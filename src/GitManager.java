
public class GitManager {
	String[] init = { "cmd", "/c", "git", "init"}; 
	String[] commit = {"cmd", "/c", "git", "commit", "-m", "first commit"};
	String[] remote = {"cmd", "/c", "git", "remote", "add", "origin" };
	String[] push = {"cmd", "/c", "git", "push", "-u", "origin", "master"};
	
	String Dir = null;
	String remoteSrc = null;
	
    Process process = null;
    
}

/*
echo "# MyGit" >> README.md
git init
git add README.md
git commit -m "first commit"
git remote add origin git@github.com:Leekyungun/MyGit.git
git push -u origin master
*/