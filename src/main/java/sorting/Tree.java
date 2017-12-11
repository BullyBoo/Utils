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

class Tree {

    private Tree left;            // левое и правое поддеревья и ключ
    private Tree right;
    int key;

    interface TreeVisitor {
        void visit(Tree node);
    }

    Tree(int k) {        // конструктор с инициализацией ключа
        key = k;
    }

    /*  insert (добавление нового поддерева (ключа))
        сравнить ключ добавляемого поддерева (К) с ключом корневого узла (X).
        Если K>=X, рекурсивно добавить новое дерево в правое поддерево.
        Если K<X, рекурсивно добавить новое дерево в левое поддерево.
        Если поддерева нет, то вставить на это место новое дерево
    */
    void insert(int newKey) {
        if (newKey < key) {          // по возрастанию
            if (left != null){
                left.insert(newKey);
            } else {
                left = new Tree(newKey);
            }
        } else {
            if (right != null){
                right.insert(newKey);
            } else {
                right = new Tree(newKey);
            }
        }
    }

    /*  traverse (обход)
        Рекурсивно обойти левое поддерево.
        Применить функцию f (печать) к корневому узлу.
        Рекурсивно обойти правое поддерево.
    */
    void traverseIncrease(TreeVisitor visitor) {
        if (left != null)
            left.traverseIncrease(visitor);

        visitor.visit(this);

        if (right != null)
            right.traverseIncrease(visitor);
    }

    void traverseDecrease(TreeVisitor visitor) {
        if (right != null)
            right.traverseDecrease(visitor);

        visitor.visit(this);

        if (left != null)
            left.traverseDecrease(visitor);
    }

}
