import java.util.ArrayList;
import java.util.List;

public class Term {
	List<String> defenitions = new ArrayList<String>();
	String noun;

	Term(String n, String s) {
		this.noun = n;
		defenitions.add(s);
	}

	public void addDefenition(String d) {
		defenitions.add(d);
	}

	public String[] getDefenitions() {
		return defenitions.toArray(new String[0]);
	}

	public static void main(String[] args) {
		Term d = new Term("dumbo", "a stupid person");
		d.addDefenition("a cute elephant");
		String[] s = d.getDefenitions();
		for (String a : s)
			System.out.println(a);
	}
}
