package edu.nju.vo;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author lsy 时间轴
 */
public class TimeLineVO {
	/**
	 * key:时间
	 * value:事件
	 */
	private ArrayList<Map<String, String>> timeLine;

	public ArrayList<Map<String, String>> getTimeLine() {
		return timeLine;
	}

	public void setTimeLine(ArrayList<Map<String, String>> timeLine) {
		this.timeLine = timeLine;
	}

//	public static void main(String[] args) {
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("time0", "20130203");
//		map.put("time1", "20130204");
//		Set keys = map.keySet();
//		if (keys != null) {
//			Iterator iterator = keys.iterator();
//			while (iterator.hasNext()) {
//				Object key = iterator.next();
//				Object value = map.get(key);
//				System.out.println(key.toString()+" "+value.toString());
//			}
//		}
//	}
}
