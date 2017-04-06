package com.jiaufwei.jsop;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Set;

public class UrlQueue {
	/* 用来存放已经访问过多url */
    private Set<String> visitedSet;
    /* 用来存放未访问过多url */
    private LinkedList<String> unvisitedList;

    public UrlQueue(String[] seeds) {
        visitedSet = new HashSet<>();
        unvisitedList = new LinkedList<>();
        unvisitedList.addAll(Arrays.asList(seeds));
    }

    /**
     * 添加url
     * 
     * @param url
     */
    public void enQueue(String url) {
        if (url != null && !visitedSet.contains(url)) {
            unvisitedList.addLast(url);
        }
    }

    /**
     * 添加url
     * 
     * @param urls
     */
    public void enQueue(Collection<String> urls) {
        for (String url : urls) {
            enQueue(url);
        }
    }

    /**
     * 取出url
     * 
     * @return
     */
    public String deQueue() {
        try {
            String url = unvisitedList.removeFirst();
            while(visitedSet.contains(url)) {
                url = unvisitedList.removeFirst();
            }
            visitedSet.add(url);
            return url;
        } catch (NoSuchElementException e) {
            System.err.println("URL取光了");
        }
        return null;
    }

    /**
     * 得到已经请求过的url的数目
     * 
     * @return
     */
    public int getVisitedCount() {
        return visitedSet.size();
    }
}
