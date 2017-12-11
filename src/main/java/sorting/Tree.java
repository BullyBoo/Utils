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
