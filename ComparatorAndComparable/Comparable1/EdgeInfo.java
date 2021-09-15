package ComparatorAndComparable.Comparable1;

public class EdgeInfo implements Comparable<EdgeInfo>{
	private int startnode;
	private int endnode;
	private int edgevalue;
	
	public EdgeInfo(int startnode,int endnode,int edgevalue) {
		this.startnode = startnode;
		this.endnode = endnode;
		this.edgevalue = edgevalue;
	}

	@Override
	public int compareTo(EdgeInfo o) {
		if(this.edgevalue > o.edgevalue) {
			return 1;
		}else if(this.edgevalue == o.edgevalue) {
			if(this.endnode > o.endnode) {
				return 1;
			}else if(this.endnode == o.endnode) {
				return 0;
			}else {
				return -1;
			}
		}else {
			return -1;
		}
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
