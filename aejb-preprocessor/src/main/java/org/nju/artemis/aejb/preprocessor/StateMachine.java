package org.nju.artemis.aejb.preprocessor;

import java.util.LinkedList;
import java.util.List;

public class StateMachine {

	// 开始节点
	private int start;
	// 终止节点
	private int end;
	//抽取出的所有程序状态
	private List states = new LinkedList();
	//所有的跳转事件
	private List<Event> events = new LinkedList<Event>();

	/**
	 * 
	 */
	public StateMachine() {

	}

	/**
	 * @return the start
	 */
	public int getStart() {
		return start;
	}

	/**
	 * @param start
	 *            the start to set
	 */
	public void setStart(int start) {
		this.start = start;
	}

	/**
	 * @return the end
	 */
	public int getEnd() {
		return end;
	}

	/**
	 * @param end
	 *            the end to set
	 */
	public void setEnd(int end) {
		this.end = end;
	}

	/**
	 * @return the states
	 */
	public List getStates() {
		return states;
	}

	/**
	 * @param states
	 *            the states to set
	 */
	public void setStates(List states) {
		this.states = states;
	}

	public int getstate(int head, String event) {
		for (int i = 0; i < events.size(); i++) {
			Event e = events.get(i);
			if (e.getHead() == head && e.getEvent().equals(event))
				return e.getTail();
		}
		return -1;
	}

	public int stateindex(int index) {
		for (int i = 0; i < states.size(); i++) {
			if ((Integer) states.get(i) == index)
				return i;
		}
		return -1;

	}

	public void addState(int state) {
		states.add(state);
	}

	public void deleteState(int state) {
		for (int i = 0; i < states.size(); i++) {
			if ((Integer) states.get(i) == state)
				states.remove(i);
		}
	}

	public void mergeStates(int s1, int s2) {

		int s1_index = states.indexOf(s1);
		states.remove(s1_index);
		for (int i = 0; i < events.size(); i++) {
			Event e = events.get(i);
			if (e.getTail() == s1) {
				e.setTail(s2);
			}/*
			 * else if(e.getHead()==s1){ e.setHead(s2); }
			 */
		}
	}

	public int getStatesCount() {

		return states.size();
	}

	public void addEvent(Event event) {
		events.add(event);
	}

	public void deleteEvent(Event event) {
		for (int i = 0; i < events.size(); i++) {
			if (event.getEvent().equals(events.get(i).getEvent()))
				events.remove(i);
		}
	}

	public List<Event> getEvents() {
		return events;
	}

}
