import java.io.File;

public class WordNet {
	File synsetsFile;
	File hypernymsFile;
	Digraph synsets;
	Digraph hypernyms;

	// constructor takes the name of the two input files
	public WordNet(String synsets, String hypernyms) {
		synsetsFile = new File(synsets);
		hypernymsFile = new File(hypernyms);
		test();
		parseFiles();
	}

	private void test() {
		In a = new In(synsetsFile);
		while (a.hasNextLine()) {
			String[] line = a.readLine().split(",");
			for (int i = 0; i < line.length; i++)
				if (i == 1) {
					String[] samosa = line[i].split(" ");
					for (int j = 0; j < samosa.length; j++)
						System.out.println(samosa[j]);
				}
				else{
					System.out.println(line[i]);
				}
		}
	}

	// Parse the files and create the synsets and hypernyms
	private void parseFiles() {
		this.synsets = new Digraph(new In(synsetsFile));
		this.hypernyms = new Digraph(new In(hypernymsFile));
	}

	// all WordNet nouns
	public Iterable<String> nouns() {
		return null;

	}

	// is the word a WordNet noun?
	public boolean isNoun(String word) {
		if (word == null)
			throw new NullPointerException("word is null in isNoun()");
		return false;
	}

	// a synset (second field of synsets.txt) that is a shortest common ancestor
	// of noun1 and noun2 (defined below)
	public String sca(String noun1, String noun2) {
		if (noun1 == null)
			throw new NullPointerException("Noun1 is null in sca(noun1, noun2)");
		if (noun2 == null)
			throw new NullPointerException("Noun2 is null in sca(noun1, noun2)");
		return noun2;
	}

	// distance between noun1 and noun2 (defined below)
	public int distance(String noun1, String noun2) {
		if (noun1 == null)
			throw new NullPointerException("Noun1 is null in distance(noun1, noun2)");
		if (noun2 == null)
			throw new NullPointerException("Noun2 is null in distance(noun1, noun2)");
		return 0;
	}

	// do unit testing of this class
	public static void main(String[] args) {
		WordNet a = new WordNet("Synsets.txt", "Hypernyms.txt");
	}
}