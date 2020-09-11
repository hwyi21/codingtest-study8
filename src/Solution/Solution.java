package Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
	class Game{
		private int stage ;
		private double per;
		

		public Game(int stage, double per) {
			this.stage = stage;
			this.per = per;			
		}

	}
		 
	public Solution() {
		int N = 4;
		int[] stages = {4,4,4,4,4};
		
		solution(N, stages);
	}
	
	public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        List<Game> list = new ArrayList<Game>();
        for(int j=1; j<=N; j++) {
        	int fail = 0;
    		int pass = 0;
        	for(int i=0; i<stages.length; i++) {
        		if(stages[i]>=j) {
        			pass++;
        			if(stages[i]==j) {
        				fail++;
        			}
        		}
        	}
        	double percent = (double)fail/pass;
        	if(pass==0) {
        		percent = (float)fail/0;
        	}
        	System.out.println("스테이지 : " + j+" 실패율 : " + percent);
        	list.add(new Game(j, percent));
        }
		
        Collections.sort(list, new Comparator<Game>() {
        	public int compare(Game g1, Game g2) {
        		if(g1.per!=g2.per) {
        			return -Double.compare(g1.per, g2.per);
        	}else if(g1.per == g2.per) {
        		}if(g1.stage > g2.stage) {
        			return 1;
        	}
                return 0;
            }
		});
        
        
        for(int i=0; i<list.size(); i++) {
        	answer[i] = list.get(i).stage;
        	System.out.println(list.get(i).stage);
        }
        
        return answer;
    }
	
	
	public static void main(String[] args) {
		new Solution();
	}

}
