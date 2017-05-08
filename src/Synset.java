import java.util.ArrayList;
import java.util.List;

public class Synset {
	private int num;
	private List<String> terms = new ArrayList<String>();
	private String defenition;

	Synset(int i, List<String> t, String d) {
		this.num = i;
		this.terms = t;
		this.defenition = d;
	}

	public String[] getTerms() {
		return this.terms.toArray(new String[0]);
	}

	public int getNum() {
		return this.num;
	}

	public String getDefenition() {
		return this.defenition;
	}

	public boolean contains(String n) {
		return terms.contains(n);
	}
}
