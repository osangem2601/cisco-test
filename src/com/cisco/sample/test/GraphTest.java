package com.cisco.sample.test;

import java.util.List;

import com.cisco.sample.GNode;
import com.cisco.sample.GNodeImpl;

public class GraphTest {
	

	public static void main(String[] args) {

		GNode a = new GNodeImpl("A");
		GNode b = new GNodeImpl("B");
		GNode c = new GNodeImpl("C");
		GNode d = new GNodeImpl("D");
		GNode e = new GNodeImpl("E");
		GNode f = new GNodeImpl("F");
		GNode g = new GNodeImpl("G");
		GNode h = new GNodeImpl("H");
		GNode i = new GNodeImpl("I");
		GNode j = new GNodeImpl("J");

		a.addChild(b);
		a.addChild(c);
		a.addChild(d);
		
		b.addChild(e);
		b.addChild(f);
		
		c.addChild(g);
		c.addChild(h);
		c.addChild(i);
		
		d.addChild(j);
		

		List<GNode> graphA = a.walkGraph(a);
		
		List<List<GNode>> pathA = a.paths(a);
		
	

		System.out.println("Walk graph from node: A");
		for (int k = 0; k < graphA.size(); k++)
			System.out.print( graphA.get(k).getName() + " "); 

		System.out.println("\n*********");
		System.out.println("Path list from node: A");
		System.out.print(pathA);

	}

}
