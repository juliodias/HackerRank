# Notes about [Java Visitor Pattern](https://www.hackerrank.com/challenges/java-vistor-pattern/problem):

## Tree Data Structure
A tree is a data structure non linear which store datas in an hierarchichal structure.  

**Root:**    
All Tree has a root element which has a denominated childs.

**Nodes:**  
Set of elements that stores informations.

**Leaf:**  
A node with degree 0 is called leaf.

## Visitor Pattern:
Represent an operation to be performed on the all elements of an data structure. In this case, operations to be performed inside the tree structure.

**Modifications on top source code:**
1. Created some methods like: calculateResultOf, saveValues, saveColors and createEdges to break the code in smaller pices to better understand and improve reuse.

