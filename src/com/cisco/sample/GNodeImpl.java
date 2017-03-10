package com.cisco.sample;

import java.util.ArrayList;
import java.util.List;

public class GNodeImpl implements GNode {

	private String name;
	private List<GNode> children = new ArrayList<GNode>();

	public GNodeImpl(String name) {
		if(name==null || name.trim()=="") {
			System.out.println("Null or empty name is not allowed");
			return;
		}
		this.name = name;
	}

	public void addChild(GNode node) {
		if(node==null) {
			System.out.println("Null node is not allowed");
			return;
		}
		children.add(node);
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return name;
	}

	public GNode[] getChildren() {
		GNode[] nodeArray = children.toArray(new GNode[children.size()]); 
		return nodeArray;
	}
	/**
	 * 
	 * return a List containing every GNode in the graph. Each node should appear in the ArrayList exactly once (i.e. no duplicates).
	 */
	public List<GNode> walkGraph(GNode node) {

		List<GNode> walkList = new ArrayList<GNode>();
		List<GNode> childrenNodes = new ArrayList<GNode>();
		childrenNodes.add(node);
		

		while (!childrenNodes.isEmpty()) {

			GNode currentnode = (GNode) childrenNodes.remove(0);

			if (!walkList.contains(currentnode))
				walkList.add(currentnode);
			for(GNode child: currentnode.getChildren())	{
				if(!childrenNodes.contains(child)) childrenNodes.add(child);
			}
		}

		return walkList;

	}

	/**
	 * return a ArrayList of ArrayLists, representing all possible paths through the graph starting at 'node'. 
	 * The ArrayList returned can be thought of as a ArrayList of paths, where each path is represented as an ArrayList of GNodes.
	 */
	public List<List<GNode>> paths(GNode node) {
		
		List<List<GNode>> pathList = new ArrayList<List<GNode>>();
		GNodeImpl currentnode = (GNodeImpl) node;

		if (currentnode.getChildren().length > 0) {
			for (GNode child : currentnode.getChildren()) {

				pathList.addAll(paths(child));

			}
			for (List<GNode> child : pathList) {
				child.add(0, currentnode);
			}

		} else {
			List<GNode> thisnode = new ArrayList<GNode>();
			thisnode.add(currentnode);
			pathList.add(thisnode);
		}

		return pathList;
	}
}