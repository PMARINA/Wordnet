public class ShortestCommonAncestor {
	Digraph d;
   // constructor takes a rooted DAG as argument
   public ShortestCommonAncestor(Digraph G){
	   this.d = G;
   }

   // length of shortest ancestral path between v and w
   public int length(int v, int w){
	   BreadthFirstDirectedPaths a = new BreadthFirstDirectedPaths(d, v);
	   return a.distTo(w);
   }

   // a shortest common ancestor of vertices v and w
   public int ancestor(int v, int w){
	   return 0;
   }

   // length of shortest ancestral path of vertex subsets A and B
   public int length(Iterable<Integer> subsetA, Iterable<Integer> subsetB){
	   int min = Integer.MAX_VALUE;
	   for(Integer i: subsetA){
		   for(Integer j: subsetB){
			   if(length(i,j)<min)min=length(i,j);
		   }
	   }
	   return min;
   }

   // a shortest common ancestor of vertex subsets A and B
   public int ancestor(Iterable<Integer> subsetA, Iterable<Integer> subsetB){
	   return 0;
   }

   // do unit testing of this class
   public static void main(String[] args){
	   
   }
}