/*
 * Copyright (C) 2017 BullyBoo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sorting;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeSorting implements Tree.TreeVisitor{

    private List<Integer> list;

    public BinaryTreeSorting() {

    }

    public void increase(int[] array){
        Tree tree = new Tree(array[0]);

        int size = array.length;

        for(int i = 1; i < size; i++){
            tree.insert(array[i]);
        }

        tree.traverseIncrease(this);
    }

    public void decrease(int[] array){
        Tree tree = new Tree(array[0]);

        int size = array.length;

        for(int i = 1; i < size; i++){
            tree.insert(array[i]);
        }

        tree.traverseDecrease(this);
    }

    public int[] get(){
        int size = list.size();

        int[] array = new int[size];

        for(int i = 0; i < size; i++){
            array[i] = list.get(i);
        }
        return array;
    }

    @Override
    public void visit(Tree node) {
        if(list == null){
            list = new ArrayList<>();
        }
        list.add(node.key);
    }
}
