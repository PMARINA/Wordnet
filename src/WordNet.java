import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordNet {
	File synsetsFile;
	File hypernymsFile;
	Digraph hypernyms;
	List<Synset> synsets = new ArrayList<Synset>();

	// constructor takes the name of the two input files
	public WordNet(String synsets, String hypernyms) {
		synsetsFile = new File(synsets);
		hypernymsFile = new File(hypernyms);
		parseSynsets();
		parseHypernyms();
	}

	private void parseHypernyms() {
		hypernyms = new Digraph(synsets.size());
		In a = new In(hypernymsFile);
		while (a.hasNextLine()) {
			String ln = a.readLine();
			String[] line = ln.split(",");
			for (int i = 1; i < line.length; i++) {
				hypernyms.addEdge(Integer.parseInt(line[0]), Integer.parseInt(line[i]));
			}
		}
	}

	private void parseSynsets() {
		In a = new In(synsetsFile);
		while (a.hasNextLine()) {
			Synset dfg;
			String defenition = null;
			List<String> terms = new ArrayList<String>();
			int num = -1;
			String[] line = a.readLine().split(",");
			for (int i = 0; i < line.length; i++) {
				if (i == 0) {
					num = Integer.parseInt(line[i]);
				} else if (i == 1) {
					String[] samosa = line[i].split(" ");
					for (int j = 0; j < samosa.length; j++)
						terms.add(samosa[j]);
				} else {
					defenition = line[i];
				}
			}
			dfg = new Synset(num, terms, defenition);
			synsets.add(dfg);
		}
	}

	// all WordNet nouns
	public Iterable<String> nouns() {
		Set<String> nouners = new HashSet<String>();
		for (Synset s : synsets) {
			for (String sa : s.getTerms()) {
				nouners.add(sa);
			}
		}
		return nouners;
	}

	// is the word a WordNet noun?
	public boolean isNoun(String word) {
		if (word == null)
			throw new NullPointerException("word is null in isNoun()");
		Iterable<String> b = nouns();
		for (String s : b) {
			if (word.equals(s))
				return true;
		}
		return false;
	}

	// a synset (second field of synsets.txt) that is a shortest common ancestor
	// of noun1 and noun2 (defined below)
	public String sca(String noun1, String noun2) {
		if (noun1 == null)
			throw new NullPointerException("Noun1 is null in sca(noun1, noun2)");
		if (noun2 == null)
			throw new NullPointerException("Noun2 is null in sca(noun1, noun2)");
		return null;
	}

	// distance between noun1 and noun2 (defined below)
	public int distance(String noun1, String noun2) {
		if (noun1 == null)
			throw new NullPointerException("Noun1 is null in distance(noun1, noun2)");
		if (noun2 == null)
			throw new NullPointerException("Noun2 is null in distance(noun1, noun2)");
		ShortestCommonAncestor a = new ShortestCommonAncestor(hypernyms);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < synsets.size(); i++) {
			for (int j = 0; j < synsets.size(); j++) {
				if (synsets.get(i).contains(noun1) && synsets.get(j).contains(noun2)) {
					if (a.length(i, j) < min)
						min = a.length(i, j);
					System.out.println(a.length(i, j));
				}
			}
		}
		return min;
	}

	// do unit testing of this class
	public static void main(String[] args) {
		WordNet a = new WordNet("Synsets.txt", "Hypernyms.txt");
		System.out.println(a.distance("baggage_car", "bailiffship"));
	}
}