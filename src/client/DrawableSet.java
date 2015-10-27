package client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import drawable.Drawable;
import drawable.Turtle;

public class DrawableSet {
	private Map<Integer, Drawable> myObjs;
	private List<Integer> myActive;
	
	private DrawingBoard myBoard;
	
	private static Drawable getNewDrawable(DrawingBoard board) {
		return new Turtle(board);
	}

	public DrawableSet(DrawingBoard board) {
		myBoard = board;
		myObjs = new HashMap<>();
		myActive = new ArrayList<>();
	}
	
	public DrawableSet(DrawingBoard board, Map<Integer, Drawable> objs) {
		myBoard = board;
		myObjs = objs;
		myActive = (List<Integer>) objs.keySet();
	}
	
	public void makeFirst() {
		myActive.add(1);
		myObjs.put(1, getNewDrawable(myBoard));
		myObjs.get(1).draw();
	}
	
	public List<Drawable> setActive(List<Integer> actives) {
		myActive = actives;
		
		List<Drawable> toReturn = new ArrayList<>();
		for(int i : myActive) {
			if (!myObjs.containsKey(i)) {
				myObjs.put(i, getNewDrawable(myBoard));
				myObjs.get(i).draw();
			}
			else {
				toReturn.add(myObjs.get(i));
			}
		}
		return toReturn;
	}
	
	public List<Integer> getActiveInt() {
		return myActive;
	}
	
	public List<Drawable> getActiveObjs() {
		List<Drawable> toReturn = new ArrayList<>();
		for (int i : myActive) {
			toReturn.add(myObjs.get(i));
		}
		return toReturn;
	}
	
	public Drawable getLastActive() {
		int last = myActive.get(myActive.size() - 1);
		return myObjs.get(last);
	}
	
	public List<Drawable> getAll() {
		return (List<Drawable>) myObjs.values();
	}
	
	public int getIndex(Drawable obj) {
		for (int i: myObjs.keySet()) {
			if (myObjs.get(i).equals(obj)) {
				return i;
			}
		}
		return -1;
	}
}
