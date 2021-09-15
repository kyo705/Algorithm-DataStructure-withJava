package ComparatorAndComparable.Comparator1;

public class EdgeInfo{
	private int startnode;
	private int endnode;
	private int edgevalue;
	
	public EdgeInfo(int startnode,int endnode,int edgevalue) {
		this.startnode = startnode;
		this.endnode = endnode;
		this.edgevalue = edgevalue;
	}

	public int getStartnode() {
		return startnode;
	}

	public void setStartnode(int startnode) {
		this.startnode = startnode;
	}

	public int getEndnode() {
		return endnode;
	}

	public void setEndnode(int endnode) {
		this.endnode = endnode;
	}

	public int getEdgevalue() {
		return edgevalue;
	}

	public void setEdgevalue(int edgevalue) {
		this.edgevalue = edgevalue;
	}
	
}
