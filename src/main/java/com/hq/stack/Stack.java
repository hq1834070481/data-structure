package com.hq.stack;

/**
 * Stack
 *
 * @author 胡强
 * @date 2021/3/4
 * @description TODO
 */
public interface Stack<Item> {

   boolean put(Item item);

   Item pop();

   int size();

   boolean isEmpty();

}
