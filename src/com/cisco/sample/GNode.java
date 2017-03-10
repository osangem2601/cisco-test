package com.cisco.sample;

import java.util.List;

public interface GNode {
	
	public String getName();

	public GNode[] getChildren();

	public void addChild(GNode n);

	public List<GNode> walkGraph(GNode node);

	public List<List<GNode>> paths(GNode node);

}
