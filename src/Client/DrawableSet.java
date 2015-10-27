package Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Drawable.Drawable;
import Drawable.Turtle;

public class DrawableSet {
	private Map<Integer, Drawable> myObjs;
	private List<Integer> myActive;
	
	private DrawingBoard myBoard;
	
	private static Drawable getNewDrawable(DrawingBoard board) {
		return new Turtle(board);
	}

	public DrawableSet(DrawingBoard board, Drawable obj) {
		myBoard = board;
		myObjs = new HashMap<>();
		myObjs.put(1, obj);
		myActive = new ArrayList<>();
		myActive.add(1);
	}
	
	public DrawableSet(DrawingBoard board) {
		this(board, getNewDrawable(board));
	}
	
	public DrawableSet(DrawingBoard board, Map<Integer, Drawable> objs) {
		myBoard = board;
		myObjs = objs;
		myActive = (List<Integer>) objs.keySet();
	}
	
	public List<Drawable> setActive(List<Integer> actives) {
		myActive = actives;
		
		List<Drawable> toReturn = new ArrayList<>();
		for(int i : myActive) {
			if (!myObjs.containsKey(i)) {
				myObjs.put(i, getNewDrawable(myBoard));
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
	
}
