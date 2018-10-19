public class GraphAdjacentTable<E> {
    
   class VNode<E> {
       char name;
       ENode<E> edge;
   }

   class ENode<E> {

       int index;
       E weight;
       ENode<E> edge;
   }

   VNode<E>[] table;
}
