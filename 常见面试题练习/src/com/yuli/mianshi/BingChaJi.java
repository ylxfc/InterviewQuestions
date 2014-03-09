package com.yuli.mianshi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BingChaJi {
	/*
	 * 一个Java并查集的练习
	 */
	
	public static void solve1(String[][] a) {
		//遍历元素，elemnts中key值为字符串，value值该字符串所在集合中的编号  
        //集合编号从0开始  
        //其实这个画图出来就是一个邻接表
		Map<String,List<Integer>> elements = new HashMap<String,List<Integer>>();
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				if(elements.get(a[i][j]) == null) {
					List<Integer> list = new ArrayList<Integer>();
					list.add(i);
					elements.put(a[i][j], list);
				}else {
					List<Integer> list = elements.get(a[i][j]);
					list.add(i);
				}
			}
		}
		int[] collections = new int[a.length];	//每个位置对应一个集合
		for(int i=0;i<collections.length;i++) {
			collections[i] = -1;
		}
		//遍历整个集合，将有相同字符串的集合设置成一个数字
		int count = 0;	//计数器，相同值就是一个集合
		for(Iterator<Entry<String,List<Integer>>> it = elements.entrySet().iterator();it.hasNext();) {
			//在同一个list中的集合表明有相同的字符串，因此属于同一个集合  
            List<Integer> list = it.next().getValue();      
            //遍历查找这个list中的集合是否已经和其他集合合并  
            //如果合并了，找出最小的集合编号  
            int min = -2;   
            for(int i=0;i<list.size();i++){  
                if(collections[list.get(i)]!=-1&&(min==-2||collections[list.get(i)]<min)){  
                    min = collections[list.get(i)];  
                }  
            }  
            if(min==-2){//所有集合都没出现过  
                for(int i=0;i<list.size();i++){  
                    collections[list.get(i)] = count;  
                }  
                count++;  
            }else{  
                for(int i=0;i<list.size();i++){  
                    for(int j=0;j<collections.length;j++)  
                        if(collections[j]==collections[list.get(i)]&&collections[j]!=-1)  
                            collections[j] = min;  
                    collections[list.get(i)] = min;  
                }  
            }  
		}
		//根据collections的编号分组将分组中的元素加入对应的位置  
        Map<Integer,Set<String>> results = new HashMap<Integer,Set<String>>();  
        for(int i=0;i<collections.length;i++){  
            Set<String> set;  
            if(results.get(collections[i])==null){  
                results.put(collections[i], new HashSet<String>());  
            }  
            set = results.get(collections[i]);  
            for(int j=0;j<a[i].length;j++){  
                set.add(a[i][j]);  
            }  
        }  
          
        //打印出来  
        for(Iterator<Entry<Integer,Set<String>>> it = results.entrySet().iterator();it.hasNext();){  
            Entry entry = it.next();  
            System.out.print(entry.getKey()+": ");  
            for(Iterator<String> iter = ((Set<String>)entry.getValue()).iterator();iter.hasNext();){  
                System.out.print(iter.next()+" ");  
            }  
            System.out.println();  
        }  
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] a = {  
                {"aaa", "bbb", "ccc"},  
                {"bbb","ddd"},  
                {"eee", "fff"},  
                {"ggg"},  
                {"ddd","hhh"}  
        };  
        solve1(a);  
	}

}
